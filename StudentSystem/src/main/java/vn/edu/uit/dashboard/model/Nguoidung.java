package vn.edu.uit.dashboard.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the nguoidung database table.
 * 
 */
@Entity
@NamedQuery(name="Nguoidung.findAll", query="SELECT n FROM Nguoidung n")
public class Nguoidung implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String maND;

	private String matKhau;

	private String tenDNhap;

	private byte trangThai;

	//bi-directional one-to-one association to Giaovien
	@OneToOne
	@JoinColumn(name="MaND")
	private Giaovien giaovien;

	//bi-directional many-to-one association to Loainguoidung
	@ManyToOne
	@JoinColumn(name="MaLoaiND")
	private Loainguoidung loainguoidung;

	public Nguoidung() {
	}

	public String getMaND() {
		return this.maND;
	}

	public void setMaND(String maND) {
		this.maND = maND;
	}

	public String getMatKhau() {
		return this.matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getTenDNhap() {
		return this.tenDNhap;
	}

	public void setTenDNhap(String tenDNhap) {
		this.tenDNhap = tenDNhap;
	}

	public byte getTrangThai() {
		return this.trangThai;
	}

	public void setTrangThai(byte trangThai) {
		this.trangThai = trangThai;
	}

	public Giaovien getGiaovien() {
		return this.giaovien;
	}

	public void setGiaovien(Giaovien giaovien) {
		this.giaovien = giaovien;
	}

	public Loainguoidung getLoainguoidung() {
		return this.loainguoidung;
	}

	public void setLoainguoidung(Loainguoidung loainguoidung) {
		this.loainguoidung = loainguoidung;
	}

}