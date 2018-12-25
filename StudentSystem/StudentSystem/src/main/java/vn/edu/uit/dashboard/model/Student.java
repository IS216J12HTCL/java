package vn.edu.uit.dashboard.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="`\nday_admission`")
	private Date _dayAdmission;

	private String address;

	@Column(name="birth_place")
	private String birthPlace;

	@Temporal(TemporalType.TIMESTAMP)
	private Date birthday;

	private String code;

	private String email;

	private String gender;

	private String name;

	private byte status;

	//bi-directional many-to-one association to MoveClass
	@OneToMany(mappedBy="student")
	private List<MoveClass> moveClasses;

	//bi-directional many-to-one association to Score
	@OneToMany(mappedBy="student")
	private List<Score> scores;

	//bi-directional many-to-one association to Subclass
	@OneToMany(mappedBy="student")
	private List<Subclass> subclasses;

	public Student() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date get_dayAdmission() {
		return this._dayAdmission;
	}

	public void set_dayAdmission(Date _dayAdmission) {
		this._dayAdmission = _dayAdmission;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthPlace() {
		return this.birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public List<MoveClass> getMoveClasses() {
		return this.moveClasses;
	}

	public void setMoveClasses(List<MoveClass> moveClasses) {
		this.moveClasses = moveClasses;
	}

	public MoveClass addMoveClass(MoveClass moveClass) {
		getMoveClasses().add(moveClass);
		moveClass.setStudent(this);

		return moveClass;
	}

	public MoveClass removeMoveClass(MoveClass moveClass) {
		getMoveClasses().remove(moveClass);
		moveClass.setStudent(null);

		return moveClass;
	}

	public List<Score> getScores() {
		return this.scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}

	public Score addScore(Score score) {
		getScores().add(score);
		score.setStudent(this);

		return score;
	}

	public Score removeScore(Score score) {
		getScores().remove(score);
		score.setStudent(null);

		return score;
	}

	public List<Subclass> getSubclasses() {
		return this.subclasses;
	}

	public void setSubclasses(List<Subclass> subclasses) {
		this.subclasses = subclasses;
	}

	public Subclass addSubclass(Subclass subclass) {
		getSubclasses().add(subclass);
		subclass.setStudent(this);

		return subclass;
	}

	public Subclass removeSubclass(Subclass subclass) {
		getSubclasses().remove(subclass);
		subclass.setStudent(null);

		return subclass;
	}

}