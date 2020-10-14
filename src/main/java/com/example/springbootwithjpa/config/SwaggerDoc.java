package com.example.springbootwithjpa.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.nio.file.Path;

/**
 * /**
 *
 * @author 廖聪聪
 * @version 1.0
 * 创建时间 2020/10/14 8:57
 */
@Configuration
@EnableSwagger2
public class SwaggerDoc {

	public Docket createRestApi(){
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.springbootwithjpa"))
				.paths(PathSelectors.any()).build();
	}

	public ApiInfo apiInfo(){
		return new ApiInfoBuilder()
				.title("swagger标题")
				.description("这里是描述")
				.termsOfServiceUrl("http://www.xx.com")
				.contact("yyy")
				.version("1.0").build();
	}
}
