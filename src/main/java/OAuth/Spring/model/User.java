package OAuth.Spring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name="USER")
public class User {

	private Long userId;
	private String firstName;
	private String password;
	private String lastname;
	private String emailAddress;
	private String accountOrigin;
	//private Set<UserRole> userRoles = new HashSet<>();
	//private Set<Roles> roles = new HashSet<>();

	public User() {
	}
	
	
	public User(Long userId, String firstName, String password, String lastname, String emailAddress, String accountOrigin) {
		this.userId = userId;
		this.firstName = firstName;
		this.password = password;
		this.lastname = lastname;
		this.emailAddress = emailAddress;
		this.setAccountOrigin(accountOrigin);
	}
	
//	public User(Long userId, String firstName, String password, String lastname, String emailAddress,
//			Set<UserRole> userRoles) {
//		this.userId = userId;
//		this.firstName = firstName;
//		this.password = password;
//		this.lastname = lastname;
//		this.emailAddress = emailAddress;
//		this.userRoles = userRoles;
//	}




	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_ID")
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	@Column(name="FIRST_NAME", nullable=false, length=20,unique=true)
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name="PASSWORD", nullable=false, length=60)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Column(name="LAST_NAME", nullable=false, length=50)
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy="user")
//	public Set<UserRole> getUserRole() {
//		return userRoles;
//	}
//
//
//	public void setUserRole(Set<UserRole> userRole) {
//		this.userRoles = userRole;
//	}


	@Column(name="EMAIL_ADDRESS",nullable=false,length=50,unique=true)
	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	@Column(name="ACCOUNT_ORIGIN",nullable=false,length=10)
	public String getAccountOrigin() {
		return accountOrigin;
	}


	public void setAccountOrigin(String accountOrigin) {
		this.accountOrigin = accountOrigin;
	}

//	@ManyToMany
//	@JoinTable(name="USER_ROLES", 
//	joinColumns= {@JoinColumn(name="USER_ID")},
//	inverseJoinColumns= {@JoinColumn(name="ROLE_ID")})
//	public Set<Roles> getRoles() {
//		return roles;
//	}
//
//
//	public void setRoles(Set<Roles> roles) {
//		this.roles = roles;
//	}


//	public void addRole(Roles role) {
//        this.roles.add(role);
//        role.getUser().add(this);
//    }
// 
//    public void removeRole(Roles role) {
//    	this.roles.remove(role);
//    	role.getUser().remove(this);
//    }


	
	
	

}
