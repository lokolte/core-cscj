package com.core.cscj;

import com.core.cscj.properties.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class CoreCscjApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreCscjApplication.class, args);
	}

}
