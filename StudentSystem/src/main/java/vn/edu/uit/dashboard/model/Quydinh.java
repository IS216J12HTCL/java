package vn.edu.uit.dashboard.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the quydinh database table.
 * 
 */
@Entity
@NamedQuery(name="Quydinh.findAll", query="SELECT q FROM Quydinh q")
public class Quydinh implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String khoa;

	private String giaTri;

	public Quydinh() {
	}

	public String getKhoa() {
		return this.khoa;
	}

	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}

	public String getGiaTri() {
		return this.giaTri;
	}

	public void setGiaTri(String giaTri) {
		this.giaTri = giaTri;
	}

}