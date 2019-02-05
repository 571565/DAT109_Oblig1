package no.hvl.dat109.modell;

public class Spiller {
	private Integer spiller_id;
	private String navn;
	public Integer spiller_score;
	
	public Spiller() {
		
	}
	public Spiller(String navn) {
		this.navn = navn;
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
