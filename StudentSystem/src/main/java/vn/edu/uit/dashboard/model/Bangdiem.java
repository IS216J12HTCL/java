package vn.edu.uit.dashboard.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bangdiem database table.
 * 
 */
@Entity
@NamedQuery(name="Bangdiem.findAll", query="SELECT b FROM Bangdiem b")
public class Bangdiem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="D15_1")
	private double d151;

	@Column(name="D15_2")
	private double d152;

	@Column(name="D15_3")
	private double d153;

	@Column(name="D15_4")
	private double d154;

	@Column(name="D1T_1")
	private double d1t1;

	@Column(name="D1T_2")
	private double d1t2;

	@Column(name="DM_1")
	private double dm1;

	@Column(name="DM_2")
	private double dm2;

	private double dtb;

	private double DThi;

	//bi-directional many-to-one association to Hocsinh
	@ManyToOne
	@JoinColumn(name="MaHocSinh")
	private Hocsinh hocsinh;

	//bi-directional many-to-one association to Lop
	@ManyToOne
	@JoinColumn(name="MaLop")
	private Lop lop;

	//bi-directional many-to-one association to Monhoc
	@ManyToOne
	@JoinColumn(name="MaMonHoc")
	private Monhoc monhoc;

	public Bangdiem() {
	}

	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public double getD151() {
		return this.d151;
	}

	public void setD151(double d151) {
		this.d151 = d151;
	}

	public double getD152() {
		return this.d152;
	}

	public void setD152(double d152) {
		this.d152 = d152;
	}

	public double getD153() {
		return this.d153;
	}

	public void setD153(double d153) {
		this.d153 = d153;
	}

	public double getD154() {
		return this.d154;
	}

	public void setD154(double d154) {
		this.d154 = d154;
	}

	public double getD1t1() {
		return this.d1t1;
	}

	public void setD1t1(double d1t1) {
		this.d1t1 = d1t1;
	}

	public double getD1t2() {
		return this.d1t2;
	}

	public void setD1t2(double d1t2) {
		this.d1t2 = d1t2;
	}

	public double getDm1() {
		return this.dm1;
	}

	public void setDm1(double dm1) {
		this.dm1 = dm1;
	}

	public double getDm2() {
		return this.dm2;
	}

	public void setDm2(double dm2) {
		this.dm2 = dm2;
	}

	public double getDtb() {
		return this.dtb;
	}

	public void setDtb(double dtb) {
		this.dtb = dtb;
	}

	public double getDThi() {
		return this.DThi;
	}

	public void setDThi(double DThi) {
		this.DThi = DThi;
	}

	public Hocsinh getHocsinh() {
		return this.hocsinh;
	}

	public void setHocsinh(Hocsinh hocsinh) {
		this.hocsinh = hocsinh;
	}

	public Lop getLop() {
		return this.lop;
	}

	public void setLop(Lop lop) {
		this.lop = lop;
	}

	public Monhoc getMonhoc() {
		return this.monhoc;
	}

	public void setMonhoc(Monhoc monhoc) {
		this.monhoc = monhoc;
	}

}