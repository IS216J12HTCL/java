package vn.edu.uit.dashboard.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the namhoc database table.
 * 
 */
@Entity
@NamedQuery(name="Namhoc.findAll", query="SELECT n FROM Namhoc n")
public class Namhoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String maNamHoc;

	private String tenNamHoc;

	//bi-directional many-to-one association to Lop
	@OneToMany(mappedBy="namhoc")
	private List<Lop> lops;

	public Namhoc() {
	}

	public String getMaNamHoc() {
		return this.maNamHoc;
	}

	public void setMaNamHoc(String maNamHoc) {
		this.maNamHoc = maNamHoc;
	}

	public String getTenNamHoc() {
		return this.tenNamHoc;
	}

	public void setTenNamHoc(String tenNamHoc) {
		this.tenNamHoc = tenNamHoc;
	}

	public List<Lop> getLops() {
		return this.lops;
	}

	public void setLops(List<Lop> lops) {
		this.lops = lops;
	}

	public Lop addLop(Lop lop) {
		getLops().add(lop);
		lop.setNamhoc(this);

		return lop;
	}

	public Lop removeLop(Lop lop) {
		getLops().remove(lop);
		lop.setNamhoc(null);

		return lop;
	}

}