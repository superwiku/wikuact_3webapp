package org.meruvian.yama.webapi.config;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import io.swagger.models.Info;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
	@Bean
	public BeanConfig beanConfig() {
		Info info = new Info();
		info.setTitle("yama-pos");
		info.setVersion("2.0.0.Beta3-SNAPSHOT");
		
		BeanConfig config = new BeanConfig();
		config.setVersion("0.0.1-SNAPSHOT");
		config.setTitle("yama-pos");
		config.setInfo(info);
	    config.setResourcePackage("org.meruvian.yama.webapi");
		config.setScan(true);		
		return config;
	}

	@Bean
	public ApiListingResource apiListingResource() {
		return new ApiListingResource();
	}
	
	@Bean
	public SwaggerSerializers swaggerSerializers() {
		return new SwaggerSerializers();
	}

}