package com.nepous.security.core.authentication;

import com.nepous.security.core.properties.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class FormAuthenticationConfig {
    
    /**
     * The Pc authentication success handler.
     */
    protected final AuthenticationSuccessHandler ncAuthenticationSuccessHandler;

    /**
     * The Pc authentication failure handler.
     */
    protected final AuthenticationFailureHandler ncAuthenticationFailureHandler;


    /**
     * Instantiates a new Form authentication config.
     *
     * @param ncAuthenticationSuccessHandler the nc authentication success handler
     * @param ncAuthenticationFailureHandler the nc authentication failure handler
     */
    @Autowired
    public FormAuthenticationConfig(AuthenticationSuccessHandler ncAuthenticationSuccessHandler, AuthenticationFailureHandler ncAuthenticationFailureHandler) {
        this.ncAuthenticationSuccessHandler = ncAuthenticationSuccessHandler;
        this.ncAuthenticationFailureHandler = ncAuthenticationFailureHandler;
    }
    /**
     * configure
     * throws Exception
     */
    public void configure(HttpSecurity http) throws Exception{
        http.formLogin()
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                .loginProcessingUrl(SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_FORM)
                .successHandler(ncAuthenticationSuccessHandler)
                .failureHandler(ncAuthenticationFailureHandler);
    }
}
