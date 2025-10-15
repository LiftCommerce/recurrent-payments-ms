package com.mozido.recurrentpayments.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Rafael Richards on 06/25.
 */

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info().title("RECURRENT-PAYMENTS-MS")
                        .description("DESCRIPTION OF THE API")
                        .version("API VERSION")
                        .termsOfService("TERMS OF SERVICE URL")
                        .contact(new Contact().name("NAME").url("URL").email("EMAIL"))
                        .license(new License().name("LICENSE").url("LICENSE URL")));
    }
}