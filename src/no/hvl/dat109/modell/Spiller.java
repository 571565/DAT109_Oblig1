package no.hvl.dat109.modell;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kjetil Dyrland, Vilhelm SKagestad, Thomas Vu, Carsten Ditlev-Simonsen
 *
 */
public class Spiller {
	private Integer spiller_id;
	private String navn;
	private List<Integer> rundeScore;
	public Integer spiller_score;

	/**
	 * @constructor
	 * @param navn
	 */
	public Spiller(String navn) {
		this.navn = navn;
		rundeScore = new ArrayList<Integer>();
		spiller_score = 0;
	}

	public List<Integer> getRundeScore() {
		return rundeScore;
	}

	public void setRundeScore(List<Integer> rundeScore) {
		this.rundeScore = rundeScore;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public Integer getSpiller_id() {
		return spiller_id;
	}

	public void setSpiller_id(Integer spiller_id) {
		this.spiller_id = spiller_id;
	}

	public Integer getSpiller_score() {
		return spiller_score;
	}

	public void setSpiller_score(Integer spiller_score) {
		this.spiller_score = spiller_score;
	}

}
