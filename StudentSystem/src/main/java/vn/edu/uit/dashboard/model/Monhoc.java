package vn.edu.uit.dashboard.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the monhoc database table.
 * 
 */
@Entity
@NamedQuery(name="Monhoc.findAll", query="SELECT m FROM Monhoc m")
public class Monhoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String maMonHoc;

	private int heSo;

	private int soTiet;

	private String tenMonHoc;

	private int trangThai;

	//bi-directional many-to-one association to Bangdiem
	@OneToMany(mappedBy="monhoc")
	private List<Bangdiem> bangdiems;

	public Monhoc() {
	}

	public String getMaMonHoc() {
		return this.maMonHoc;
	}

	public void setMaMonHoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
	}

	public int getHeSo() {
		return this.heSo;
	}

	public void setHeSo(int heSo) {
		this.heSo = heSo;
	}

	public int getSoTiet() {
		return this.soTiet;
	}

	public void setSoTiet(int soTiet) {
		this.soTiet = soTiet;
	}

	public String getTenMonHoc() {
		return this.tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

	public int getTrangThai() {
		return this.trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public List<Bangdiem> getBangdiems() {
		return this.bangdiems;
	}

	public void setBangdiems(List<Bangdiem> bangdiems) {
		this.bangdiems = bangdiems;
	}

	public Bangdiem addBangdiem(Bangdiem bangdiem) {
		getBangdiems().add(bangdiem);
		bangdiem.setMonhoc(this);

		return bangdiem;
	}

	public Bangdiem removeBangdiem(Bangdiem bangdiem) {
		getBangdiems().remove(bangdiem);
		bangdiem.setMonhoc(null);

		return bangdiem;
	}

}