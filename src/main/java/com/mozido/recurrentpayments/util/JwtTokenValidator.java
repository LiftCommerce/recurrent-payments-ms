package com.mozido.recurrentpayments.util;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import com.mozido.recurrentpayments.exception.ControllerException;
import com.mozido.recurrentpayments.model.Language;
import com.mozido.recurrentpayments.model.MozidoToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static com.mozido.recurrentpayments.exception.ErrorResponses.INVALID_SESSION_TOKEN;
import static com.mozido.recurrentpayments.exception.ErrorResponses.SESSION_EXPIRED;


/**
 * Class validates a given token by using the secret configured in the
 * application
 */

@Component
public class JwtTokenValidator {


    static Logger logger = LoggerFactory.getLogger(JwtTokenValidator.class);

    /**
     * Tries to parse specified String as a JWT token. If successful, returns Skin
     * object with username, id and role prefilled (extracted from token). If
     * unsuccessful (token is invalid or not containing all required user
     * properties), simply returns null.
     *
     * @param token
     *            the JWT token to parse
     * @return the Skin object extracted from specified token or null if a token is
     *         invalid.
     * @throws Exception
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public static MozidoToken parseToken(String token, String pubKeyPEM) throws ControllerException {
        MozidoToken mozidoToken = null;

        token = token.replace("Bearer ","");
        token = token.replace("bearer ","");

        try {

            byte[] encodedPublicKey = Base64.getDecoder().decode(pubKeyPEM);

            X509EncodedKeySpec spec = new X509EncodedKeySpec(encodedPublicKey);
            KeyFactory kf = KeyFactory.getInstance("RSA");
            //below line check if the public key is valid
            kf.generatePublic(spec);

            CustomSigningKeyResolver signingKeyResolver = new CustomSigningKeyResolver(pubKeyPEM);
            Claims body = Jwts.parserBuilder()
                    .setSigningKeyResolver(signingKeyResolver)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            //logger.debug("Token body is " + body);
            mozidoToken = new MozidoToken(body);


        } catch (ExpiredJwtException expiredJwtException) {
            logger.error(expiredJwtException.getMessage());
            throw new ControllerException(SESSION_EXPIRED, Language.ENGLISH);
        } catch (JwtException | NoSuchAlgorithmException | InvalidKeySpecException | ClassCastException exception) {
            logger.error(exception.getMessage());
            throw new ControllerException(INVALID_SESSION_TOKEN, Language.ENGLISH);
        }
        return mozidoToken;
    }

}
