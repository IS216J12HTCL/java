package vn.edu.uit.dashboard.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the phanlop database table.
 * 
 */
@Embeddable
public class PhanlopPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String maHocSinh;

	@Column(insertable=false, updatable=false)
	private String maLop;

	public PhanlopPK() {
	}
	public String getMaHocSinh() {
		return this.maHocSinh;
	}
	public void setMaHocSinh(String maHocSinh) {
		this.maHocSinh = maHocSinh;
	}
	public String getMaLop() {
		return this.maLop;
	}
	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PhanlopPK)) {
			return false;
		}
		PhanlopPK castOther = (PhanlopPK)other;
		return 
			this.maHocSinh.equals(castOther.maHocSinh)
			&& this.maLop.equals(castOther.maLop);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.maHocSinh.hashCode();
		hash = hash * prime + this.maLop.hashCode();
		
		return hash;
	}
}