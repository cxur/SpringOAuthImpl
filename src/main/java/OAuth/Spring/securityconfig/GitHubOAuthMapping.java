package OAuth.Spring.securityconfig;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;

public class GitHubOAuthMapping extends UserOauthData {

	public GitHubOAuthMapping(Map<String, Object> dataAttributes) {
		super(dataAttributes);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return dataAttributes.get("id").toString();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return dataAttributes.get("name").toString();
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return dataAttributes.get("email").toString();
	}

	@Override
	public String getImageURL() {
		// TODO Auto-generated method stub
		return dataAttributes.get("avatar_url").toString();
	}

	@Override
	public Map<String, Object> getAttributes() {
		// TODO Auto-generated method stub
		return dataAttributes;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

}
