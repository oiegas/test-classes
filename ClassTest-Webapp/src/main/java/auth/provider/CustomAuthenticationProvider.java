package auth.provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.domain.User;
import com.service.providers.UserService;
import com.service.providers.UserServiceImplementation;
import com.utils.LoginUtils;

@Component("customAuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private UserService userService = new UserServiceImplementation();

	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {

		String name = authentication.getName().toString();
		String password = authentication.getCredentials().toString();
		getUserByUsername(name);
		if (isUserValid(authentication)) {
			System.out.println(name + "  -- " + password);
			List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
			grantedAuths.add(new SimpleGrantedAuthority(userService
					.getRole(authentication.getName())));
			Authentication auth = new UsernamePasswordAuthenticationToken(name,
					password, grantedAuths);
			return auth;
		} else {
			return null;
		}
	}

	private void getUserByUsername(String name) {
		User user = userService.searchUserByName(name);
		LoginUtils.setUserLogedIn(user);
	}

	private boolean isUserValid(Authentication authentication) {

		return this.userService.verifyLogin(authentication.getName(),
				authentication.getCredentials().toString());

	}

	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}