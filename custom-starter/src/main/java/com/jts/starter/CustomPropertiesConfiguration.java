package com.jts.starter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@AutoConfiguration
@EnableConfigurationProperties(CustomProperties.class)
public class CustomPropertiesConfiguration {

    Logger log = LoggerFactory.getLogger(CustomPropertiesConfiguration.class);

    CustomProperties properites;

    CustomPropertiesConfiguration(CustomProperties customProperties){
        log.info("Conguring starter with properties, {}", customProperties);
        this.properites = customProperties;
    }
    @Bean
    CustomRestClient customRestClient(RestClient restClient) {
        return new CustomRestClient(restClient);
    }


    @Bean("externalRestClient")
    RestClient restClient(RestClient.Builder builder) {
        return builder.baseUrl(properites.baseUrl())
                .build();
    }


}
