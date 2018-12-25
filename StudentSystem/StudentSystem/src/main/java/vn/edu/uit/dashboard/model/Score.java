package vn.edu.uit.dashboard.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the score database table.
 * 
 */
@Entity
@NamedQuery(name="Score.findAll", query="SELECT s FROM Score s")
public class Score implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="D15_1")
	private float d151;

	@Column(name="D15_2")
	private float d152;

	@Column(name="D15_3")
	private float d153;

	@Column(name="D1T_1")
	private float d1t1;

	@Column(name="DM_1")
	private float dm1;

	private float dtb;

	//bi-directional many-to-one association to Subject
	@ManyToOne
	private Subject subject;

	//bi-directional many-to-one association to Student
	@ManyToOne
	private Student student;

	//bi-directional many-to-one association to Term
	@ManyToOne
	private Term term;

	public Score() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getD151() {
		return this.d151;
	}

	public void setD151(float d151) {
		this.d151 = d151;
	}

	public float getD152() {
		return this.d152;
	}

	public void setD152(float d152) {
		this.d152 = d152;
	}

	public float getD153() {
		return this.d153;
	}

	public void setD153(float d153) {
		this.d153 = d153;
	}

	public float getD1t1() {
		return this.d1t1;
	}

	public void setD1t1(float d1t1) {
		this.d1t1 = d1t1;
	}

	public float getDm1() {
		return this.dm1;
	}

	public void setDm1(float dm1) {
		this.dm1 = dm1;
	}

	public float getDtb() {
		return this.dtb;
	}

	public void setDtb(float dtb) {
		this.dtb = dtb;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Term getTerm() {
		return this.term;
	}

	public void setTerm(Term term) {
		this.term = term;
	}

}