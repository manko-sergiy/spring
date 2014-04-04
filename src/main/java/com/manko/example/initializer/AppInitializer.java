package com.manko.example.initializer;

/**
 * @author Serhiy_Manko
 */
import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {
	private static Log LOG = LogFactory.getLog(AppInitializer.class);
	private static final String CONFIG_LOCATION = "com.manko.example.config";
	private static final String MAPPING_URL = "/";

	{
		LOG.debug(" - - - - - AppInitializer inited");
		LOG.info(" - - - - - AppInitializer inited");
	}
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		LOG.info(" - - - - - AppInitializer onStartup(ServletContext servletContext)");
		// Create the 'root' Spring application context
		WebApplicationContext context = getContext();
		// Manages the life cycle of the root application context
		servletContext.addListener(new ContextLoaderListener(context));
		// Dispatcher Servlet
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping(MAPPING_URL);
		// Spring security
		DelegatingFilterProxy delegatingFilterProxy = new DelegatingFilterProxy("springSecurityFilterChain");
		FilterRegistration filterChainRegistration = servletContext.addFilter("springSecurityFilterChain", delegatingFilterProxy);
		filterChainRegistration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD), true, "/*");

		servletContext.addFilter("HttpMethodFilter", org.springframework.web.filter.HiddenHttpMethodFilter.class).addMappingForUrlPatterns(null, false, "/**");

		FilterRegistration charEncodingfilterReg = servletContext.addFilter("CharacterEncodingFilter", CharacterEncodingFilter.class);
		charEncodingfilterReg.setInitParameter("encoding", "UTF-8");
		charEncodingfilterReg.setInitParameter("forceEncoding", "true");
		charEncodingfilterReg.addMappingForUrlPatterns(null, false, "/**");
	}

	private AnnotationConfigWebApplicationContext getContext() {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.setConfigLocation(CONFIG_LOCATION);
		return context;
	}

}