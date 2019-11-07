package com.nepous.security.sever;

import com.nepous.security.core.authentication.FormAuthenticationConfig;
import com.nepous.security.core.authorize.AuthorizeConfigManager;
import com.nepous.security.core.properties.SecurityConstants;
import com.nepous.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.annotation.Resource;

/**
 * 资源服务器配置
 */
@Configuration
@EnableResourceServer
public class NcResourceServerConfig  extends ResourceServerConfigurerAdapter{

    @Resource
    private FormAuthenticationConfig formAuthenticationConfig;

    @Autowired
    private AccessDeniedHandler ncAccessDeniedHandler;
    @Autowired
    private AuthorizeConfigManager authorizeConfigManager;
    @Autowired
    private OAuth2WebSecurityExpressionHandler ncSecurityExpressionHandler;


    @Override
    public void configure(HttpSecurity http) throws Exception {
        formAuthenticationConfig.configure(http);
        http.headers().frameOptions().disable();
        http.headers().frameOptions().disable()
                .and()
                .exceptionHandling().accessDeniedHandler(ncAccessDeniedHandler)
                .and()
                .csrf().disable();
        authorizeConfigManager.config(http.authorizeRequests());
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.expressionHandler(ncSecurityExpressionHandler);
    }


}
