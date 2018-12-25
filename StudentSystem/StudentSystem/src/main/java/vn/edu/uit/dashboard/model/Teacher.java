package vn.edu.uit.dashboard.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the teacher database table.
 * 
 */
@Entity
@NamedQuery(name="Teacher.findAll", query="SELECT t FROM Teacher t")
public class Teacher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String address;

	private String name;
	
	private String phone;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private byte status;

	//bi-directional many-to-one association to Class
	@OneToMany(mappedBy="teacher")
	private List<Class> clazzs;

	public Teacher() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Class> getClazzs() {
		return this.clazzs;
	}

	public void setClazzs(List<Class> clazzs) {
		this.clazzs = clazzs;
	}

	public Class addClazz(Class clazz) {
		getClazzs().add(clazz);
		clazz.setTeacher(this);

		return clazz;
	}

	public Class removeClazz(Class clazz) {
		getClazzs().remove(clazz);
		clazz.setTeacher(null);

		return clazz;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatusHtml(byte status) {
		return status == 1 ? "<div class=\"tag tag-success\">Hoạt động</div>" : "<div class=\"tag tag-danger\">Đang khoá</div>";
	}
	
	
	public String getYearFormatVN(Date date) {
		if (date == null) {
			date = new Date();
			return (new SimpleDateFormat("yyyy").format(date));
		} else {
			return (new SimpleDateFormat("yyyy").format(date));
		}
	}

	public String getMonthYearFormatVN(Date date) {
		if (date == null) {
			date = new Date();
			return (new SimpleDateFormat("MM/yyyy").format(date));
		} else {
			return (new SimpleDateFormat("MM/yyyy").format(date));
		}
	}

	public String getDateHourFormatVN(Date date) {
		if (date == null) {
			date = new Date();
			return (new SimpleDateFormat("dd/MM/yyyy HH:00").format(date));
		} else {
			return (new SimpleDateFormat("dd/MM/yyyy HH:00").format(date));
		}
	}

	public String getDateFormatVN(Date date) {
		if (date == null) {
			date = new Date();
			return (new SimpleDateFormat("dd/MM/yyyy").format(date));
		} else {
			return (new SimpleDateFormat("dd/MM/yyyy").format(date));
		}
	}

	public String getDatetimeFormatVN(Date date) {
		if (date == null) {
			date = new Date();
			return (new SimpleDateFormat("dd/MM/yyyy HH:mm").format(date));
		} else {
			return (new SimpleDateFormat("dd/MM/yyyy HH:mm").format(date));
		}

	}
	

}