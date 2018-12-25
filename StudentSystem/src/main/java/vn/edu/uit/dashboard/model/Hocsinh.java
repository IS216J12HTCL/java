package vn.edu.uit.dashboard.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the hocsinh database table.
 * 
 */
@Entity
@NamedQuery(name="Hocsinh.findAll", query="SELECT h FROM Hocsinh h")
public class Hocsinh implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String maHocSinh;

	private String diaChi;

	private String email;

	private byte gioiTinh;

	@Temporal(TemporalType.TIMESTAMP)
	private Date ngayNhapHoc;

	@Temporal(TemporalType.TIMESTAMP)
	private Date ngaySinh;

	private String noiSinh;

	private String tenHocSinh;

	//bi-directional many-to-one association to Bangdiem
	@OneToMany(mappedBy="hocsinh")
	private List<Bangdiem> bangdiems;

	//bi-directional many-to-one association to Chuyenlop
	@OneToMany(mappedBy="hocsinh")
	private List<Chuyenlop> chuyenlops;

	//bi-directional many-to-one association to Phanlop
	@OneToMany(mappedBy="hocsinh")
	private List<Phanlop> phanlops;

	public Hocsinh() {
	}

	public String getMaHocSinh() {
		return this.maHocSinh;
	}

	public void setMaHocSinh(String maHocSinh) {
		this.maHocSinh = maHocSinh;
	}

	public String getDiaChi() {
		return this.diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getGioiTinh() {
		return this.gioiTinh;
	}

	public void setGioiTinh(byte gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Date getNgayNhapHoc() {
		return this.ngayNhapHoc;
	}

	public void setNgayNhapHoc(Date ngayNhapHoc) {
		this.ngayNhapHoc = ngayNhapHoc;
	}

	public Date getNgaySinh() {
		return this.ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getNoiSinh() {
		return this.noiSinh;
	}

	public void setNoiSinh(String noiSinh) {
		this.noiSinh = noiSinh;
	}

	public String getTenHocSinh() {
		return this.tenHocSinh;
	}

	public void setTenHocSinh(String tenHocSinh) {
		this.tenHocSinh = tenHocSinh;
	}

	public List<Bangdiem> getBangdiems() {
		return this.bangdiems;
	}

	public void setBangdiems(List<Bangdiem> bangdiems) {
		this.bangdiems = bangdiems;
	}

	public Bangdiem addBangdiem(Bangdiem bangdiem) {
		getBangdiems().add(bangdiem);
		bangdiem.setHocsinh(this);

		return bangdiem;
	}

	public Bangdiem removeBangdiem(Bangdiem bangdiem) {
		getBangdiems().remove(bangdiem);
		bangdiem.setHocsinh(null);

		return bangdiem;
	}

	public List<Chuyenlop> getChuyenlops() {
		return this.chuyenlops;
	}

	public void setChuyenlops(List<Chuyenlop> chuyenlops) {
		this.chuyenlops = chuyenlops;
	}

	public Chuyenlop addChuyenlop(Chuyenlop chuyenlop) {
		getChuyenlops().add(chuyenlop);
		chuyenlop.setHocsinh(this);

		return chuyenlop;
	}

	public Chuyenlop removeChuyenlop(Chuyenlop chuyenlop) {
		getChuyenlops().remove(chuyenlop);
		chuyenlop.setHocsinh(null);

		return chuyenlop;
	}

	public List<Phanlop> getPhanlops() {
		return this.phanlops;
	}

	public void setPhanlops(List<Phanlop> phanlops) {
		this.phanlops = phanlops;
	}

	public Phanlop addPhanlop(Phanlop phanlop) {
		getPhanlops().add(phanlop);
		phanlop.setHocsinh(this);

		return phanlop;
	}

	public Phanlop removePhanlop(Phanlop phanlop) {
		getPhanlops().remove(phanlop);
		phanlop.setHocsinh(null);

		return phanlop;
	}

}