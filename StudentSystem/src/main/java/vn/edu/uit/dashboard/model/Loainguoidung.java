package vn.edu.uit.dashboard.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the loainguoidung database table.
 * 
 */
@Entity
@NamedQuery(name="Loainguoidung.findAll", query="SELECT l FROM Loainguoidung l")
public class Loainguoidung implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String maLoaiND;

	private String tenLoaiND;

	//bi-directional many-to-one association to Nguoidung
	@OneToMany(mappedBy="loainguoidung")
	private List<Nguoidung> nguoidungs;

	public Loainguoidung() {
	}

	public String getMaLoaiND() {
		return this.maLoaiND;
	}

	public void setMaLoaiND(String maLoaiND) {
		this.maLoaiND = maLoaiND;
	}

	public String getTenLoaiND() {
		return this.tenLoaiND;
	}

	public void setTenLoaiND(String tenLoaiND) {
		this.tenLoaiND = tenLoaiND;
	}

	public List<Nguoidung> getNguoidungs() {
		return this.nguoidungs;
	}

	public void setNguoidungs(List<Nguoidung> nguoidungs) {
		this.nguoidungs = nguoidungs;
	}

	public Nguoidung addNguoidung(Nguoidung nguoidung) {
		getNguoidungs().add(nguoidung);
		nguoidung.setLoainguoidung(this);

		return nguoidung;
	}

	public Nguoidung removeNguoidung(Nguoidung nguoidung) {
		getNguoidungs().remove(nguoidung);
		nguoidung.setLoainguoidung(null);

		return nguoidung;
	}

}