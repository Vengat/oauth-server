package com.vengat.tuts.oauthserver.domain;

import java.time.ZoneId;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
/**
 * Configuring the authorization server to add custom details to tokens
 * @author vengatramanan
 *
 */
public class CustomTokenEnhancer implements TokenEnhancer {

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		var token = new DefaultOAuth2AccessToken(accessToken);
		Map<String, Object> info = 
				Map.of("generatedInZone", ZoneId.systemDefault().toString());
		token.setAdditionalInformation(info);
		return token;
	}

}
