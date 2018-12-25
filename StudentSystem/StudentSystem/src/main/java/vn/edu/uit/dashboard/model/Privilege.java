package vn.edu.uit.dashboard.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the privileges database table.
 * 
 */
@Entity
@Table(name="privileges")
@NamedQuery(name="Privilege.findAll", query="SELECT p FROM Privilege p")
public class Privilege implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String code;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	private String description;

	private String name;

	private byte status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

	//bi-directional many-to-one association to Organization
	@ManyToOne
	private Organization organization;

	//bi-directional many-to-one association to UserPrivilege
	@OneToMany(mappedBy="privilege")
	private List<UserPrivilege> userPrivileges;

	public Privilege() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public List<UserPrivilege> getUserPrivileges() {
		return this.userPrivileges;
	}

	public void setUserPrivileges(List<UserPrivilege> userPrivileges) {
		this.userPrivileges = userPrivileges;
	}

	public UserPrivilege addUserPrivilege(UserPrivilege userPrivilege) {
		getUserPrivileges().add(userPrivilege);
		userPrivilege.setPrivilege(this);

		return userPrivilege;
	}

	public UserPrivilege removeUserPrivilege(UserPrivilege userPrivilege) {
		getUserPrivileges().remove(userPrivilege);
		userPrivilege.setPrivilege(null);

		return userPrivilege;
	}

}