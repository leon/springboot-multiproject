package se.radley.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;
import se.radley.domain.model.User;
import se.radley.domain.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DomainUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userOpt = userRepository.findByLogin(username);

		User user = userOpt.orElseThrow(() -> new UsernameNotFoundException("Username not found: " + username));

		List<GrantedAuthority> auth = AuthorityUtils.createAuthorityList("ROLE_USER");
		if (user.isAdmin()) {
			auth = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
		}
		String password = user.getPassword();

		return new org.springframework.security.core.userdetails.User(username, password, auth);
	}
}
