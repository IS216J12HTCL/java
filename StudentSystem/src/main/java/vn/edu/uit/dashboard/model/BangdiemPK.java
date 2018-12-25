package vn.edu.uit.dashboard.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the bangdiem database table.
 * 
 */
@Embeddable
public class BangdiemPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String maHocSinh;

	private String maHocKy;

	@Column(insertable=false, updatable=false)
	private String maMonHoc;

	@Column(insertable=false, updatable=false)
	private String maLop;

	public BangdiemPK() {
	}
	public String getMaHocSinh() {
		return this.maHocSinh;
	}
	public void setMaHocSinh(String maHocSinh) {
		this.maHocSinh = maHocSinh;
	}
	public String getMaHocKy() {
		return this.maHocKy;
	}
	public void setMaHocKy(String maHocKy) {
		this.maHocKy = maHocKy;
	}
	public String getMaMonHoc() {
		return this.maMonHoc;
	}
	public void setMaMonHoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
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
		if (!(other instanceof BangdiemPK)) {
			return false;
		}
		BangdiemPK castOther = (BangdiemPK)other;
		return 
			this.maHocSinh.equals(castOther.maHocSinh)
			&& this.maHocKy.equals(castOther.maHocKy)
			&& this.maMonHoc.equals(castOther.maMonHoc)
			&& this.maLop.equals(castOther.maLop);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.maHocSinh.hashCode();
		hash = hash * prime + this.maHocKy.hashCode();
		hash = hash * prime + this.maMonHoc.hashCode();
		hash = hash * prime + this.maLop.hashCode();
		
		return hash;
	}
}