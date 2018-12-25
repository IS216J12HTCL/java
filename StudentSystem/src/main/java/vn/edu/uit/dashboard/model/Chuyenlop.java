package vn.edu.uit.dashboard.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the chuyenlop database table.
 * 
 */
@Entity
@NamedQuery(name="Chuyenlop.findAll", query="SELECT c FROM Chuyenlop c")
public class Chuyenlop implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ChuyenlopPK id;

	private byte chuyenBangDiem;

	private String lyDoChuyen;

	//bi-directional many-to-one association to Hocsinh
	@ManyToOne
	@JoinColumn(name="MaHocSinh")
	private Hocsinh hocsinh;

	//bi-directional many-to-one association to Lop
	@ManyToOne
	@JoinColumn(name="TuLop")
	private Lop lop1;

	//bi-directional many-to-one association to Lop
	@ManyToOne
	@JoinColumn(name="DenLop")
	private Lop lop2;

	public Chuyenlop() {
	}

	public ChuyenlopPK getId() {
		return this.id;
	}

	public void setId(ChuyenlopPK id) {
		this.id = id;
	}

	public byte getChuyenBangDiem() {
		return this.chuyenBangDiem;
	}

	public void setChuyenBangDiem(byte chuyenBangDiem) {
		this.chuyenBangDiem = chuyenBangDiem;
	}

	public String getLyDoChuyen() {
		return this.lyDoChuyen;
	}

	public void setLyDoChuyen(String lyDoChuyen) {
		this.lyDoChuyen = lyDoChuyen;
	}

	public Hocsinh getHocsinh() {
		return this.hocsinh;
	}

	public void setHocsinh(Hocsinh hocsinh) {
		this.hocsinh = hocsinh;
	}

	public Lop getLop1() {
		return this.lop1;
	}

	public void setLop1(Lop lop1) {
		this.lop1 = lop1;
	}

	public Lop getLop2() {
		return this.lop2;
	}

	public void setLop2(Lop lop2) {
		this.lop2 = lop2;
	}

}