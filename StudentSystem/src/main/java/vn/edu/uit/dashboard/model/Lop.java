package vn.edu.uit.dashboard.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lop database table.
 * 
 */
@Entity
@NamedQuery(name="Lop.findAll", query="SELECT l FROM Lop l")
public class Lop implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String maLop;

	private byte maKhoiLop;

	private int siSo;

	private String tenLop;

	//bi-directional many-to-one association to Bangdiem
	@OneToMany(mappedBy="lop")
	private List<Bangdiem> bangdiems;

	//bi-directional many-to-one association to Chuyenlop
	@OneToMany(mappedBy="lop1")
	private List<Chuyenlop> chuyenlops1;

	//bi-directional many-to-one association to Chuyenlop
	@OneToMany(mappedBy="lop2")
	private List<Chuyenlop> chuyenlops2;

	//bi-directional many-to-one association to Giaovien
	@ManyToOne
	@JoinColumn(name="MaGiaoVien")
	private Giaovien giaovien;

	//bi-directional many-to-one association to Namhoc
	@ManyToOne
	@JoinColumn(name="MaNamHoc")
	private Namhoc namhoc;

	//bi-directional many-to-one association to Phanlop
	@OneToMany(mappedBy="lop")
	private List<Phanlop> phanlops;

	public Lop() {
	}

	public String getMaLop() {
		return this.maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}

	public byte getMaKhoiLop() {
		return this.maKhoiLop;
	}

	public void setMaKhoiLop(byte maKhoiLop) {
		this.maKhoiLop = maKhoiLop;
	}

	public int getSiSo() {
		return this.siSo;
	}

	public void setSiSo(int siSo) {
		this.siSo = siSo;
	}

	public String getTenLop() {
		return this.tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public List<Bangdiem> getBangdiems() {
		return this.bangdiems;
	}

	public void setBangdiems(List<Bangdiem> bangdiems) {
		this.bangdiems = bangdiems;
	}

	public Bangdiem addBangdiem(Bangdiem bangdiem) {
		getBangdiems().add(bangdiem);
		bangdiem.setLop(this);

		return bangdiem;
	}

	public Bangdiem removeBangdiem(Bangdiem bangdiem) {
		getBangdiems().remove(bangdiem);
		bangdiem.setLop(null);

		return bangdiem;
	}

	public List<Chuyenlop> getChuyenlops1() {
		return this.chuyenlops1;
	}

	public void setChuyenlops1(List<Chuyenlop> chuyenlops1) {
		this.chuyenlops1 = chuyenlops1;
	}

	public Chuyenlop addChuyenlops1(Chuyenlop chuyenlops1) {
		getChuyenlops1().add(chuyenlops1);
		chuyenlops1.setLop1(this);

		return chuyenlops1;
	}

	public Chuyenlop removeChuyenlops1(Chuyenlop chuyenlops1) {
		getChuyenlops1().remove(chuyenlops1);
		chuyenlops1.setLop1(null);

		return chuyenlops1;
	}

	public List<Chuyenlop> getChuyenlops2() {
		return this.chuyenlops2;
	}

	public void setChuyenlops2(List<Chuyenlop> chuyenlops2) {
		this.chuyenlops2 = chuyenlops2;
	}

	public Chuyenlop addChuyenlops2(Chuyenlop chuyenlops2) {
		getChuyenlops2().add(chuyenlops2);
		chuyenlops2.setLop2(this);

		return chuyenlops2;
	}

	public Chuyenlop removeChuyenlops2(Chuyenlop chuyenlops2) {
		getChuyenlops2().remove(chuyenlops2);
		chuyenlops2.setLop2(null);

		return chuyenlops2;
	}

	public Giaovien getGiaovien() {
		return this.giaovien;
	}

	public void setGiaovien(Giaovien giaovien) {
		this.giaovien = giaovien;
	}

	public Namhoc getNamhoc() {
		return this.namhoc;
	}

	public void setNamhoc(Namhoc namhoc) {
		this.namhoc = namhoc;
	}

	public List<Phanlop> getPhanlops() {
		return this.phanlops;
	}

	public void setPhanlops(List<Phanlop> phanlops) {
		this.phanlops = phanlops;
	}

	public Phanlop addPhanlop(Phanlop phanlop) {
		getPhanlops().add(phanlop);
		phanlop.setLop(this);

		return phanlop;
	}

	public Phanlop removePhanlop(Phanlop phanlop) {
		getPhanlops().remove(phanlop);
		phanlop.setLop(null);

		return phanlop;
	}

}