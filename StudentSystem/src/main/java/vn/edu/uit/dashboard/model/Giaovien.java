package vn.edu.uit.dashboard.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the giaovien database table.
 * 
 */
@Entity
@NamedQuery(name="Giaovien.findAll", query="SELECT g FROM Giaovien g")
public class Giaovien implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String maGiaoVien;

	private String tenGiaoVien;

	//bi-directional many-to-one association to Lop
	@OneToMany(mappedBy="giaovien")
	private List<Lop> lops;

	//bi-directional one-to-one association to Nguoidung
	@OneToOne(mappedBy="giaovien")
	private Nguoidung nguoidung;

	public Giaovien() {
	}

	public String getMaGiaoVien() {
		return this.maGiaoVien;
	}

	public void setMaGiaoVien(String maGiaoVien) {
		this.maGiaoVien = maGiaoVien;
	}

	public String getTenGiaoVien() {
		return this.tenGiaoVien;
	}

	public void setTenGiaoVien(String tenGiaoVien) {
		this.tenGiaoVien = tenGiaoVien;
	}

	public List<Lop> getLops() {
		return this.lops;
	}

	public void setLops(List<Lop> lops) {
		this.lops = lops;
	}

	public Lop addLop(Lop lop) {
		getLops().add(lop);
		lop.setGiaovien(this);

		return lop;
	}

	public Lop removeLop(Lop lop) {
		getLops().remove(lop);
		lop.setGiaovien(null);

		return lop;
	}

	public Nguoidung getNguoidung() {
		return this.nguoidung;
	}

	public void setNguoidung(Nguoidung nguoidung) {
		this.nguoidung = nguoidung;
	}

}