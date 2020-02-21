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
@Transactional // Important, probleme de session sinon
public class SecurityUserService implements UserDetailsService {
	
	@Autowired
	private UserAccountService userAccServ;
	
	@Override
	public UserDetails loadUserByUsername(String username){
		try {
			UserAccount userAccount = userAccServ.findByNickname(username);
			
			Set<GrantedAuthority> rights = findRights(userAccount);
			
			return new User(username, userAccount.getPassword(), rights);
		} catch (NotFoundException e) {
			throw new UsernameNotFoundException("User does not exist", e);
		}
	}
	
	private Set<GrantedAuthority> findRights(UserAccount userAccount) {
		Set<GrantedAuthority> authorities = new HashSet<>();
		
		if (userAccount.getUserRole() != null) {
			UserRole role = userAccount.getUserRole();
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
			
			if (role.getUserRights() != null) {
				role.getUserRights().forEach(right -> authorities.add(new SimpleGrantedAuthority(right.getName())));
			}
		}
		
		return authorities;
	}
	
}
