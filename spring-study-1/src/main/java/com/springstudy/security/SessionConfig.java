package com.springstudy.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.beans.BeanProperty;

@Configuration
@EnableWebSecurity
public class SessionConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/", "viewStudent").permitAll().anyRequest().authenticated().and()
                .formLogin().loginPage("/login").permitAll().and().logout().permitAll();
    }

    @Bean
    @Override


    public UserDetailsSerivice userDetailsSerivice() {
        UserDetails user = user.withDefaultPasswordEncoder().username("user").password("kigali").roles("admin").build();
        return new InMemoryUserDetailsdManager(user);
    }
}
//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.withDefaultPasswordEncoder().username("user").password("kigali").roles("admin").build();
//        return new InMemoryUserDetailsManager(user);
//    }