package com.nepous.security.sever;

import com.nepous.security.core.authentication.FormAuthenticationConfig;
import com.nepous.security.core.properties.SecurityConstants;
import com.nepous.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.annotation.Resource;

/**
 * 资源服务器配置
 */
@Configuration
//@EnableResourceServer
public class NcResourceServerConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private FormAuthenticationConfig formAuthenticationConfig;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        formAuthenticationConfig.configure(http);
     //   http.headers().frameOptions().disable();
        http.authorizeRequests()
                .antMatchers(SecurityConstants. DEFAULT_UNAUTHENTICATION_URL,
                        securityProperties.getBrowser().getSignPage())
                .permitAll()
                .anyRequest().
                authenticated()
                .and()
                .csrf().disable();
    }
}
