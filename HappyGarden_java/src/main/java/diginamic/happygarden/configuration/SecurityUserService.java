package diginamic.happygarden.configuration;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import diginamic.happygarden.exception.NotFoundException;
import diginamic.happygarden.model.UserAccount;
import diginamic.happygarden.model.UserRole;
import diginamic.happygarden.service.UserAccountService;

@Service
@Transactional
public class SecurityUserService implements UserDetailsService {

	@Autowired
	private UserAccountService userAccServ;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			UserAccount userAccount = userAccServ.findByPseudonyme(username);
			
			Set<GrantedAuthority> rights = findRights(userAccount);
			
			return new User(username, userAccount.getPassword(), rights);
		} catch (NotFoundException e) {
			System.err.println(e.getMessage());
		}
		
		return null;
	}
	
	private Set<GrantedAuthority> findRights(UserAccount userAccount) {
		Set<GrantedAuthority> authorities = new HashSet<>();
		
		if (userAccount.getUserRole() != null) {
			UserRole role = userAccount.getUserRole();
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName().toUpperCase()));
			
			if (role.getUserRights() != null) {
				role.getUserRights().forEach(right -> authorities.add(new SimpleGrantedAuthority(right.getName().toUpperCase())));
			}
		}
		
		return authorities;
	}
	
}
