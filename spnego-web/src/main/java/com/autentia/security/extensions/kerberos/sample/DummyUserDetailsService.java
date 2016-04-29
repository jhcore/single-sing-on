package com.autentia.security.extensions.kerberos.sample;


import org.springframework.dao.DataAccessException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class DummyUserDetailsService implements UserDetailsService {

	
	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		return new User(username, "tutorial", true, true,true,true, AuthorityUtils.createAuthorityList("ROLE_USER"));
	}

}
