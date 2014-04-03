package com.manko.example.config;

/**
 * @author Serhiy_Manko
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
class WebMvcConfig extends WebMvcConfigurerAdapter {
	private static final Log LOG = LogFactory.getLog(WebMvcConfig.class);

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		LOG.info(" - - - - - WebMvcConfig configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)");
		configurer.enable();
	}
	
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		LOG.info(" - - - - - WebMvcConfig getInternalResourceViewResolver()");
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		LOG.info(" - - - - - WebMvcConfig addResourceHandlers(ResourceHandlerRegistry registry)");
		registry.addResourceHandler("/css/**").addResourceLocations("WEB-INF/resources/css/").setCachePeriod(31556926);
		registry.addResourceHandler("/img/**").addResourceLocations("WEB-INF/resources/img/").setCachePeriod(31556926);
		registry.addResourceHandler("/js/**").addResourceLocations("WEB-INF/resources/js/").setCachePeriod(31556926);
	}
}