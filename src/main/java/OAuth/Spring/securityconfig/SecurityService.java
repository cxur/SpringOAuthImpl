package OAuth.Spring.securityconfig;

public interface SecurityService {
	
	String findLoggedInUserName();
	
	void autoLogin (String userName, String password);

}
