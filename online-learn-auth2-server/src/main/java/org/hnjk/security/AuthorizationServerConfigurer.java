package org.hnjk.security;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hnjk.config.PropertiesConfigure;
import org.hnjk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;


/**
 * 认证服务
 * @author zzk
 *
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userDetailsService;
	
	@Autowired
	private TokenStore tokenStore;
	
	@Autowired
	private PropertiesConfigure propertiesConfigure;
	
	@Autowired
	private JwtAccessTokenConverter jwtAccessTokenConverter;
	
    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
        //允许表单认证
        oauthServer.allowFormAuthenticationForClients().tokenKeyAccess("permitAll()").checkTokenAccess("permitAll()");
    }
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		
		InMemoryClientDetailsServiceBuilder builder = clients.inMemory();
		
		for(Map<String, String> client:propertiesConfigure.getClients()) {
			String clientId = client.get("client-id");
			String clientSecret = "{bcrypt}"+new BCryptPasswordEncoder().encode(client.get("client-secret"));
			String[] grantTypes = StringUtils.split(client.get("grant-type"), ",");
			int seconds = Integer.parseInt(StringUtils.isNotBlank(client.get("valid-seconds"))?client.get("valid-seconds"):"60");
			String[] scopes = StringUtils.split(client.get("scopes"), ",");
			int refreshSeconds = Integer.parseInt(StringUtils.isNotBlank(client.get("refresh-seconds"))?client.get("refresh-seconds"):"72000");
			
			builder.withClient(clientId)
	        .authorizedGrantTypes(grantTypes)
	        .scopes(scopes)
	        .accessTokenValiditySeconds(seconds)
	        .refreshTokenValiditySeconds(refreshSeconds)
	        .secret(clientSecret);
		}
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore)
		.accessTokenConverter(jwtAccessTokenConverter)
		.authenticationManager(authenticationManager)
		.userDetailsService(userDetailsService)
		.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
	}
	
}
