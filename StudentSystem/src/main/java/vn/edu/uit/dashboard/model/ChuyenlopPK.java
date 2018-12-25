package vn.edu.uit.dashboard.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the chuyenlop database table.
 * 
 */
@Embeddable
public class ChuyenlopPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String tuLop;

	@Column(insertable=false, updatable=false)
	private String denLop;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date ngayChuyen;

	public ChuyenlopPK() {
	}
	public String getTuLop() {
		return this.tuLop;
	}
	public void setTuLop(String tuLop) {
		this.tuLop = tuLop;
	}
	public String getDenLop() {
		return this.denLop;
	}
	public void setDenLop(String denLop) {
		this.denLop = denLop;
	}
	public java.util.Date getNgayChuyen() {
		return this.ngayChuyen;
	}
	public void setNgayChuyen(java.util.Date ngayChuyen) {
		this.ngayChuyen = ngayChuyen;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ChuyenlopPK)) {
			return false;
		}
		ChuyenlopPK castOther = (ChuyenlopPK)other;
		return 
			this.tuLop.equals(castOther.tuLop)
			&& this.denLop.equals(castOther.denLop)
			&& this.ngayChuyen.equals(castOther.ngayChuyen);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.tuLop.hashCode();
		hash = hash * prime + this.denLop.hashCode();
		hash = hash * prime + this.ngayChuyen.hashCode();
		
		return hash;
	}
}