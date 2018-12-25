package vn.edu.uit.dashboard.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String address;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	private String code;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	@Column(name="full_name")
	private String fullName;

	private byte gender;

	private String password;

	private String phone;

	private byte status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	private String username;

	//bi-directional many-to-one association to UserPrivilege
	@OneToMany(mappedBy="user")
	private List<UserPrivilege> userPrivileges;

	//bi-directional many-to-one association to UserRole
	@ManyToOne
	@JoinColumn(name="user_role_id")
	private UserRole userRole;
	
	@ManyToMany(fetch = FetchType.EAGER) 
    @JoinTable(name = "user_privileges", 
      joinColumns = 
        @JoinColumn(name = "user_id", referencedColumnName = "id"),
      inverseJoinColumns = 
        @JoinColumn(name = "privileges_id", referencedColumnName = "id")) 
    private Set<Privilege> privileges = new HashSet<Privilege>();
	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public byte getGender() {
		return this.gender;
	}

	public void setGender(byte gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<UserPrivilege> getUserPrivileges() {
		return this.userPrivileges;
	}

	public void setUserPrivileges(List<UserPrivilege> userPrivileges) {
		this.userPrivileges = userPrivileges;
	}

	public UserPrivilege addUserPrivilege(UserPrivilege userPrivilege) {
		getUserPrivileges().add(userPrivilege);
		userPrivilege.setUser(this);

		return userPrivilege;
	}

	public UserPrivilege removeUserPrivilege(UserPrivilege userPrivilege) {
		getUserPrivileges().remove(userPrivilege);
		userPrivilege.setUser(null);

		return userPrivilege;
	}

	public UserRole getUserRole() {
		return this.userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public Set<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}
	
	public String getRoleEnumName() {
		switch(this.userRole.getRoleEnum()) {
		case ADMIN:
			return "Ban hội đồng quản trị";
		
		case USER:
			return "Nhân viên";
			
		case TEACHER:
			return "Giáo viên";
		default:
			return "Unknow";
		}
	}

}