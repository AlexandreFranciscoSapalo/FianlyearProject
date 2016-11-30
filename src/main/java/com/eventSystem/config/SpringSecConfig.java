package com.eventSystem.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecConfig extends WebSecurityConfigurerAdapter {

    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        		.antMatchers("/**/favicon.ico") .permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/create-account").permitAll()
                .antMatchers("/static/css").permitAll()
                .antMatchers("/static/js").permitAll()
                .antMatchers("/API/**", "/API/*").permitAll()
                .anyRequest().authenticated()
                .and()
            
            .formLogin()
            	.loginPage("/login").permitAll()
                .defaultSuccessUrl("/login_success",false) 
                .loginProcessingUrl("/login")
                .failureUrl("/login_error").permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .and()
                .exceptionHandling().accessDeniedPage("/access_denied");
        http.csrf().ignoringAntMatchers("/API/**", "/API/*");
        
     
    }
    
 
}
