package OAuth.Spring.securityconfig;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import OAuth.Spring.model.User;
import OAuth.Spring.repository.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User userInfo = new User();
		userInfo = userRepository.findByEmailAddress(username);

		if (userInfo == null) {
			System.out.println("USER NOT FOUND");
		}

//		Set<UserRole> userRoleList = userInfo.getUserRole();
//		List<Roles> rolesList = new ArrayList<Roles>();
//		for (UserRole userRole : userRoleList) {
//			rolesList.add(userRole.getRoles());
//		}

//		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//		for (Roles role : rolesList) {
//			grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
//		}

//		return new org.springframework.security.core.userdetails.User(userInfo.getEmailAddress(),
//				userInfo.getPassword(), grantedAuthorities);
		return new org.springframework.security.core.userdetails.User(userInfo.getEmailAddress(),
				userInfo.getPassword(),null);

	}

}
