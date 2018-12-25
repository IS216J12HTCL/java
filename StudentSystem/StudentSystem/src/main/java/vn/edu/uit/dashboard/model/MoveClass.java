package vn.edu.uit.dashboard.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the move_class database table.
 * 
 */
@Entity
@Table(name="move_class")
@NamedQuery(name="MoveClass.findAll", query="SELECT m FROM MoveClass m")
public class MoveClass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="from_class")
	private int fromClass;

	@Column(name="move_reason")
	private String moveReason;

	@Column(name="move_score")
	private byte moveScore;

	@Temporal(TemporalType.DATE)
	@Column(name="move_time")
	private Date moveTime;

	@Column(name="to_class")
	private int toClass;

	//bi-directional many-to-one association to Student
	@ManyToOne
	private Student student;

	public MoveClass() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFromClass() {
		return this.fromClass;
	}

	public void setFromClass(int fromClass) {
		this.fromClass = fromClass;
	}

	public String getMoveReason() {
		return this.moveReason;
	}

	public void setMoveReason(String moveReason) {
		this.moveReason = moveReason;
	}

	public byte getMoveScore() {
		return this.moveScore;
	}

	public void setMoveScore(byte moveScore) {
		this.moveScore = moveScore;
	}

	public Date getMoveTime() {
		return this.moveTime;
	}

	public void setMoveTime(Date moveTime) {
		this.moveTime = moveTime;
	}

	public int getToClass() {
		return this.toClass;
	}

	public void setToClass(int toClass) {
		this.toClass = toClass;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}