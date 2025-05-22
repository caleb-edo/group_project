//from software architecture sem2 lab3

package com.example;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

public class SecurityConfig {


    // spring security filters
// HttpSecurity is used to configure security details
@Bean
    protected SecurityFilterChain configure(HttpSecurity http, MvcRequestMatcher.Builder mvc) throws Exception {
 http.authorizeRequests(auth ->
                        auth.requestMatchers(mvc.pattern("/")).permitAll()
                                .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                                .anyRequest().authenticated()
                )
         // MvcRequestMatcher.Builder is used to match incoming requests against specified patterns

         .logout(logout ->
                        logout
                                .logoutSuccessUrl("/").deleteCookies("JSESSIONID")
                                .invalidateHttpSession(true))
                .oauth2Client(Customizer.withDefaults())
                .oauth2Login(Customizer.withDefaults());
        return http.build();
    }
    @Bean
    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
        return new MvcRequestMatcher.Builder(introspector);
    }
}
