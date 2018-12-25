package vn.edu.uit.dashboard.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the class database table.
 * 
 */
@Entity
@NamedQuery(name="Class.findAll", query="SELECT c FROM Class c")
public class Class implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String code;

	private String name;

	private byte status;

	private int total;

	//bi-directional many-to-one association to SubjectYear
	@ManyToOne
	@JoinColumn(name="year_id")
	private SubjectYear subjectYear;

	//bi-directional many-to-one association to Teacher
	@ManyToOne
	private Teacher teacher;

	//bi-directional many-to-one association to Subclass
	@OneToMany(mappedBy="clazz")
	private List<Subclass> subclasses;

	public Class() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public int getTotal() {
		return this.total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public SubjectYear getSubjectYear() {
		return this.subjectYear;
	}

	public void setSubjectYear(SubjectYear subjectYear) {
		this.subjectYear = subjectYear;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Subclass> getSubclasses() {
		return this.subclasses;
	}

	public void setSubclasses(List<Subclass> subclasses) {
		this.subclasses = subclasses;
	}

	public Subclass addSubclass(Subclass subclass) {
		getSubclasses().add(subclass);
		subclass.setClazz(this);

		return subclass;
	}

	public Subclass removeSubclass(Subclass subclass) {
		getSubclasses().remove(subclass);
		subclass.setClazz(null);

		return subclass;
	}

}