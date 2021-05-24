package dev.borgod.vicsektamas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import dev.borgod.vicsektamas.model.Role;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
	private UserDetailsService userDetailsService;

	@Autowired
    private PasswordEncoder passwordEncoder;

    @Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
            .authorizeRequests()
            .antMatchers("/login").permitAll()
            .antMatchers("/register/**").permitAll()
            .antMatchers("/api/**").hasAnyRole(Role.MANAGER.toString(), Role.ADMIN.toString(), Role.CUSTOMER.toString())
            .antMatchers("/manager/api/**").hasAnyRole(Role.MANAGER.toString(), Role.ADMIN.toString())
            .antMatchers("/admin/api/**").hasRole(Role.ADMIN.toString())
            .anyRequest().authenticated().and()
            .httpBasic();
    }

    
}
