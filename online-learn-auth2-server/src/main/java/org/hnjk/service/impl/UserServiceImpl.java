package org.hnjk.service.impl;

import java.util.HashMap;
import java.util.Map;
import org.hnjk.service.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String finalPassword = "{bcrypt}"+bCryptPasswordEncoder.encode("123456");
        String finalPassword2 = "{bcrypt}"+bCryptPasswordEncoder.encode("1234567");
        
        UserDetails userDetail = User.withUsername("user_1").password(finalPassword).authorities("USER").build();
        UserDetails userDetail2 = User.withUsername("user_2").password(finalPassword2).authorities("USER").build();
        
        Map<String, UserDetails> users = new HashMap<String, UserDetails>();
        users.put(userDetail.getUsername().toLowerCase(), userDetail);
        users.put(userDetail2.getUsername().toLowerCase(), userDetail2);
        
        UserDetails user = users.get(username.toLowerCase());

		if (user == null) {
			throw new UsernameNotFoundException(username);
		}

		return new User(user.getUsername(), user.getPassword(), user.isEnabled(),
				user.isAccountNonExpired(), user.isCredentialsNonExpired(),
				user.isAccountNonLocked(), user.getAuthorities());
	}

}
