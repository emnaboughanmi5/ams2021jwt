package tn.com.sip.ams.models;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class AuthenticationResponse {

    private final String token;
    
    private final String username;
    
    private final Collection<? extends GrantedAuthority> authorities;

	public String getToken() {
		return token;
	}

	public String getUsername() {
		return username;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public AuthenticationResponse(String token, String username, Collection<? extends GrantedAuthority> authorities) {
		this.token = token;
		this.username = username;
		this.authorities = authorities;
	}
}
