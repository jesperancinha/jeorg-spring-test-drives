package org.jesperancinha.std.flash48.userservice.oauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class Flash48AuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {

    private static final String CLIENT_ID = "flash48-client";
    private static final String CLIENT_SECRET = "flash48";
    private static final String GRANT_TYPE_PASSWORD = "password";
    private static final String AUTHORIZATION_CODE = "authorization_code";
    private static final String REFRESH_TOKEN = "refresh_token";
    private static final String SCOPE_READ = "read";
    private static final String SCOPE_WRITE = "write";
    private static final String TRUST = "trust";
    private static final int VALID_FOREVER = -1;

    private final AuthenticationManager authManager;

    private final PasswordEncoder passwordEncoder;

    private final TokenStore tokenStore;

    public Flash48AuthorizationServerConfigurer(AuthenticationManager authManager, TokenStore tokenStore, PasswordEncoder passwordEncoder) {
        this.authManager = authManager;
        this.tokenStore = tokenStore;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
            .withClient(CLIENT_ID)
            .secret(passwordEncoder.encode(CLIENT_SECRET))
            .authorizedGrantTypes(GRANT_TYPE_PASSWORD, AUTHORIZATION_CODE, REFRESH_TOKEN)
            .scopes(SCOPE_READ, SCOPE_WRITE, TRUST)
            .accessTokenValiditySeconds(VALID_FOREVER)
            .refreshTokenValiditySeconds(VALID_FOREVER);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.tokenStore(tokenStore)
            .authenticationManager(authManager)
            .allowedTokenEndpointRequestMethods();
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
        oauthServer.passwordEncoder(passwordEncoder)
            .allowFormAuthenticationForClients();
    }

}