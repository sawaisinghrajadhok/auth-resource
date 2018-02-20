/**
 * 
 */
package com.example.resources.config.jwt;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

//import com.example.resources.model.User;


/**
 * @author sawai
 *
 */

public class CustomTokenEnhancer implements TokenEnhancer {
	
	@Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String, Object> additionalInfo = new HashMap<>();
        if (authentication != null) {
            /*User user = (User)authentication.getPrincipal();
            additionalInfo.put("firstName", user.getFirstName());
            additionalInfo.put("lastName", user.getLastName());*/
        }
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }
}
