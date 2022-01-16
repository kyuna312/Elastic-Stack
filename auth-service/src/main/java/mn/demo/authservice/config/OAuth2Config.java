package mn.demo.authservice.config;

import mn.demo.authservice.bean.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
    //private TokenStore tokenStore = new InMemoryTokenStore();
    private final String NOOP_PASSWORD_ENCODE = "{noop}";

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("sdaAds*@#d!sa");
        return converter;
    }

    @Bean
    public JwtTokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Autowired
    private Environment env;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        // TODO persist clients details

        // @formatter:off
        clients.inMemory()
                .withClient("mobile")
                .authorizedGrantTypes("refresh_token", "password", "client_credentials")
                .scopes("app")
                .and()
                .withClient("notification-service")
                .secret("NOTIFICATION_SERVICE_PASSWORD")
                .authorizedGrantTypes("refresh_token", "password", "client_credentials")
                .scopes("server")
                .and()
                .withClient("app-service")
                .secret("11")
                .authorizedGrantTypes("refresh_token", "password", "client_credentials")
                .scopes("server")
                .and()
                .withClient("payment-service")
                .secret("11!SAsafda!d")
                .authorizedGrantTypes("refresh_token", "password", "client_credentials")
                .scopes("server");
        // @formatter:on
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(jwtTokenStore())
                .authenticationManager(authenticationManager)
                .userDetailsService(customUserDetailsService)
                .accessTokenConverter(jwtAccessTokenConverter());
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
}
