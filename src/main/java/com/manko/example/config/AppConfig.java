package com.manko.example.config;

/**
 * @author Serhiy_Manko
 */
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

@Configuration
@ComponentScan(basePackages = "com.manko.example")
class AppConfig {
    private static final Log LOG = LogFactory.getLog(AppConfig.class);

    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
	LOG.info(" - - - - - AppConfig simpleMappingExceptionResolver()");
	SimpleMappingExceptionResolver simpleMEResolver = new SimpleMappingExceptionResolver();
	Properties mappings = new Properties();
	mappings.put("org.springframework.web.servlet.PageNotFound", "p404");
	mappings.put("org.springframework.dao.DataAccessException",
		"dataAccessFailure");
	mappings.put("org.springframework.transaction.TransactionException",
		"dataAccessFailure");
	simpleMEResolver.setExceptionMappings(mappings);
	return simpleMEResolver;
    }
}