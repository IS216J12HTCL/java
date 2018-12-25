package vn.edu.uit.dashboard.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the term database table.
 * 
 */
@Entity
@NamedQuery(name="Term.findAll", query="SELECT t FROM Term t")
public class Term implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private byte term;

	private int year;

	//bi-directional many-to-one association to Score
	@OneToMany(mappedBy="term")
	private List<Score> scores;

	public Term() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getTerm() {
		return this.term;
	}

	public void setTerm(byte term) {
		this.term = term;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<Score> getScores() {
		return this.scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}

	public Score addScore(Score score) {
		getScores().add(score);
		score.setTerm(this);

		return score;
	}

	public Score removeScore(Score score) {
		getScores().remove(score);
		score.setTerm(null);

		return score;
	}

}