package com.example.restfulwebservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
        throws Exception{
            auth.inMemoryAuthentication()
                    .withUser("kkt219a")
                    .password("{noop}123123")
                    .roles("USER");
        //인코딩 없이 하겠다는 noop
    }
}
