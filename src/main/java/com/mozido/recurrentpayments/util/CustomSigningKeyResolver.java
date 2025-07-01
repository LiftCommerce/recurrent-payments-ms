package com.mozido.recurrentpayments.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.SigningKeyResolverAdapter;

import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * Created by Rafael Richards on 06/25.
 */

public class CustomSigningKeyResolver extends SigningKeyResolverAdapter {

	private String publicK;

	public CustomSigningKeyResolver(String publicK){
		this.publicK = publicK;
	}

	@Override
	public Key resolveSigningKey(JwsHeader jwsHeader, Claims claims) {


		String pubKeyPEM = publicK.replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "");

		// Base64 decode the data

		byte[] encodedPublicKey = Base64.getDecoder().decode(pubKeyPEM);

		X509EncodedKeySpec spec = new X509EncodedKeySpec(encodedPublicKey);
		KeyFactory kf;
		try {
			kf = KeyFactory.getInstance("RSA");
			System.out.println(kf.generatePublic(spec));
			return kf.generatePublic(spec);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return null;
	}
}