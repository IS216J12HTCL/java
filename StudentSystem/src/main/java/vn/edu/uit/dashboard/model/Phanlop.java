package vn.edu.uit.dashboard.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the phanlop database table.
 * 
 */
@Entity
@NamedQuery(name="Phanlop.findAll", query="SELECT p FROM Phanlop p")
public class Phanlop implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PhanlopPK id;

	private int stt;

	//bi-directional many-to-one association to Hocsinh
	@ManyToOne
	@JoinColumn(name="MaHocSinh")
	private Hocsinh hocsinh;

	//bi-directional many-to-one association to Lop
	@ManyToOne
	@JoinColumn(name="MaLop")
	private Lop lop;

	public Phanlop() {
	}

	public PhanlopPK getId() {
		return this.id;
	}

	public void setId(PhanlopPK id) {
		this.id = id;
	}

	public int getStt() {
		return this.stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
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

}