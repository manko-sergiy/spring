package com.manko.example.config;

/**
 * @author Serhiy_Manko
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebSecurity
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity
@EnableGlobalAuthentication
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private static final Log LOG = LogFactory.getLog(SecurityConfig.class);

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		LOG.info(" - - - - - SecurityConfig configureGlobal(AuthenticationManagerBuilder auth)");
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER").and().withUser("admin").password("s3cret").roles("ADMIN");
	}
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		LOG.info(" - - - - - SecurityConfig configure(AuthenticationManagerBuilder auth)");
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER").and().withUser("admin").password("s3cret").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		LOG.info(" - - - - - SecurityConfig configure(HttpSecurity http)");
		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN").antMatchers("/**").hasRole("USER").anyRequest().authenticated().and().formLogin().and().httpBasic();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		LOG.info(" - - - - - SecurityConfig configure(WebSecurity web)");
		web.ignoring().antMatchers("/img/**", "/css/**", "/js/**");
	}

}