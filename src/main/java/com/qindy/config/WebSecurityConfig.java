package com.qindy.config;

import com.qindy.service.LoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by ibm on 2017/5/19.
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    /**
     *
     * @return
     */
    @Bean
    UserDetailsService loginService(){
        return new LoginService();
    }

    /**
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(loginService());
    }

    /**
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .permitAll()
                .and()
                .logout().permitAll();

    }

    /**
     *
     * @param web
     * @throws Exception

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }
     */
}
