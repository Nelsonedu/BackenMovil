/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.backendmovil2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.header.writers.ReferrerPolicyHeaderWriter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.web.cors.CorsConfiguration;

/**
 *
 * @author macbookpro
 */
@SpringBootApplication
public class Backendmovil2 {

    public static void main(String[] args) {
        SpringApplication.run(Backendmovil2.class, args);
    }
    @EnableWebSecurity
    @Configuration
    class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .csrf().disable()
                    .cors().configurationSource(
                            request -> {
                                CorsConfiguration cors = new CorsConfiguration();
                                cors.setAllowedMethods(
                                        Arrays.asList(
                                                HttpMethod.GET.name(),
                                                HttpMethod.POST.name()
                                        ));
                                cors.applyPermitDefaultValues();
                                return cors;
                            }).and()
                    .authorizeRequests()
                    .antMatchers(HttpMethod.POST, "/person/*").permitAll()
                    .antMatchers(HttpMethod.GET, "/person/*").permitAll()
                    .mvcMatchers(HttpMethod.OPTIONS, "/**").denyAll()
                    .mvcMatchers(HttpMethod.PUT, "/**").denyAll()
                    .mvcMatchers(HttpMethod.DELETE, "/**").denyAll()
                    .mvcMatchers(HttpMethod.PATCH, "/**").denyAll()
                    .mvcMatchers(HttpMethod.HEAD, "/**").denyAll()
                    .mvcMatchers(HttpMethod.TRACE, "/**").denyAll()
                    .mvcMatchers(HttpMethod.GET, "/**").denyAll()
                    .anyRequest().authenticated()
                    .and().headers().xssProtection()
                    .and().cacheControl()
                    .and().contentTypeOptions()
                    .and().httpStrictTransportSecurity()
                    .includeSubDomains(true).maxAgeInSeconds(31536000)
                    .and().frameOptions().sameOrigin()
                    .addHeaderWriter(
                            new StaticHeadersWriter("X-Content-Security-Policy",
                                    "script-src 'self'"))
                    .addHeaderWriter(
                            new XFrameOptionsHeaderWriter(
                                    XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
                    .referrerPolicy(ReferrerPolicyHeaderWriter.ReferrerPolicy.SAME_ORIGIN);
        }

        @Bean
        public ObjectMapper objectMapper() {
            ObjectMapper mapper = new ObjectMapper();
            Hibernate5Module hibernate5Module = new Hibernate5Module();
            hibernate5Module.configure(Hibernate5Module.Feature.FORCE_LAZY_LOADING, false);
            mapper.registerModule(hibernate5Module);
            return mapper;
        }
    }
}
