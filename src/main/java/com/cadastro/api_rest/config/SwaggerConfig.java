package com.cadastro.api_rest.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket cadastroApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.cadastro.api_rest"))
				.paths(PathSelectors.regex("/api.*"))
				.build()
				.apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"Cadastro de Pessoa - API REST",
				"API REST para Cadastro de Pessoas.",
				"1.0",
				"",
				new Contact("Larissa Zanata Morais", "https://www.linkedin.com/in/larissa-zanata-b51469a1/",
						"zanatalarissamorais@gmail.com"),
				"",
				"", new ArrayList<VendorExtension>()
				);
		return apiInfo;
	}
}
