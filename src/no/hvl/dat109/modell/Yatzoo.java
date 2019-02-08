package no.hvl.dat109.modell;

import no.hvl.dat109.utsyn.*;

import java.util.ArrayList;

import java.util.List;
import java.util.HashMap;

/**
 * @author Kjetil Dyrland, Vilhelm SKagestad, Thomas Vu, Carsten Ditlev-Simonsen
 *
 */
public class Yatzoo {

	/**
	 * @Objektvariabler
	 */

	private TerningKopp kopp;
	private YatzooUI ui;
	private Boolean spillFerdig;
	private List<Spiller> spillere;
	private Spiller vinner;
	private Integer runde;
	private boolean max_score = false;

	List<Terning> valgteDyr = new ArrayList<Terning>();
	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

	public Yatzoo() {
		this(null);
		this.runde = 1;
		spillere = new ArrayList<Spiller>();
		kopp = new TerningKopp();
		spillFerdig = Boolean.FALSE;
	}

	/**
	 * @param ui
	 */
	public Yatzoo(YatzooUI ui) {
		this.ui = ui;
		this.runde = 1;
		spillere = new ArrayList<Spiller>();
		kopp = new TerningKopp();
		spillFerdig = Boolean.FALSE;
	}

	/**
	 * Tråd som starter spiller
	 * 
	 * @return void
	 */
	public void start() {

		int antallSpillere = ui.lesAntallSpillere();
		for (int i = 0; i < antallSpillere; i++) {
			leggTilSpiller();
		}
		while (!spillFerdig) {

			ui.visRundeRegler(runde);
			spillRunde();

			vinner = finnRundeVinner();
			rundeVinner();
			nyRunde();
			if (runde > 12) {
				spillFerdig = Boolean.TRUE;
			}

		}
		visVinner();

	}

	/**
	 * Finner rundevinneren
	 * 
	 * @return Spiller
	 */
	public Spiller finnRundeVinner() {
		int score = 0;
		Spiller rundeVinner = null;
		for (Spiller s : spillere) {
			if (s.getRundeScore().get(runde - 1) >= score) {
				score = s.getRundeScore().get(runde - 1);
				rundeVinner = s;
			}
		}
		return rundeVinner;
	}

	/**
	 * @return void
	 */
	public void rundeVinner() {
		System.out.println("\t" + vinner.getNavn() + " vant runde " + runde + " med "
				+ vinner.getRundeScore().get(runde - 1) + " score");
	}

	/**
	 * @return void
	 */
	public void visVinner() {
		System.out.println("------------------");
		System.out.println("\t" + vinner.getNavn() + " vant spillet med " + vinner.getSpiller_score() + " score");
	}

	/**
	 * @param spiller
	 * @return boolean
	 */
	public void leggTilSpiller() {

		spillere.add(new Spiller(ui.lesInnSpiller()));

	}

	/**
	 * @return Spiller
	 */
	public Spiller getVinner() {
		return vinner;
	}

	/**
	 * @return int
	 */
	public int antallSpillere() {
		return spillere.size();
	}

	/**
	 * @return Spiller
	 */
	public Spiller finnVinner() {
		Spiller vinner = spillere.get(0);
		for (Spiller s : spillere) {
			if (s.getSpiller_score() > vinner.getSpiller_score()) {
				vinner = s;
			}
		}
		return vinner;
	}

	/**
	 * spiller runde for hver spiller
	 * 
	 * @return void
	 */
	public void spillRunde() {

		for (int i = 0; i < antallSpillere() && spillFerdig == Boolean.FALSE; i++) {

			Spiller s = spillere.get(i);
			max_score = false;

			System.out.println("Det er " + s.getNavn() + " sin tur:");

			valgteDyr = spillTrekk(s);
			int rundeScore = regnUtScore(valgteDyr);

			s.getRundeScore().add(rundeScore);
			s.setSpiller_score(s.getSpiller_score() + rundeScore);

		}

	}

	public void nyRunde() {
		runde++;
	}

	/**
	 * Velger trekket til neste spiller
	 * 
	 * @param spiller
	 * @return ArrayList<Terning>
	 */
	public List<Terning> spillTrekk(Spiller spiller) {

		int i = 0;
		kopp.setKopp(new ArrayList<Terning>());
		kopp.kast();
		while (i < 2) {

			kopp.visTerningKopp();
			regnUtScore(kopp.getKopp());
			if (max_score)
				return kopp.getKopp();

			if (runde < 7) {
				kopp.setKopp(beholdRiktige(kopp.getKopp()));
				ui.nesteKast();
			} else {
				kopp.setKopp(ui.HvilkeTerningerSkalBeholdes(kopp));
			}
			if (kopp.getKopp().size() >= 5) {
				return kopp.getKopp();
			}

			i++;
			kopp.kast();
		}

		kopp.visTerningKopp();
		return kopp.getKopp();

	}

	/**
	 * FInner antall like dyr for hvert kast
	 * 
	 * @param kopp
	 * @return
	 */
	public HashMap<Integer, Integer> antallLikeAvHver(List<Terning> kopp) {

		HashMap<Integer, Integer> antallLike = new HashMap<Integer, Integer>();
		int[] hjelpe = kopp.stream().mapToInt(x -> x.getVerdi()).toArray();
		for (Integer t : hjelpe) {
			Integer j = antallLike.get(t);
			antallLike.put(t, (j == null) ? 1 : j + 1);
		}
		return antallLike;

	}

	/**
	 * Beholder dyr i runde 1-6
	 * 
	 * @param kopp
	 * @return
	 */
	public List<Terning> beholdRiktige(List<Terning> kopp) {
		ArrayList<Terning> beholdes = new ArrayList<Terning>();
		for (Terning t : kopp) {
			if (runde == t.getVerdi()) {
				beholdes.add(t);
			}
		}
		return beholdes;
	}

	/**
	 * Regner ut score for hvert kast
	 * 
	 * @param kopp
	 * @return int
	 */
	public int regnUtScore(List<Terning> kopp) {

		int score = 0;

		for (Terning t : kopp) {

			if (runde == t.getVerdi() && runde < 7) {
				score++;
			}
			if (score >= 5) {
				max_score = true;
			}
		}
		hm = antallLikeAvHver(kopp);
		if (runde == 7) {
			if (hm.size() <= 3 && hm.containsValue(3)) {
				score = 3;
				max_score = true;
			}
		} else if (runde == 8) {
			if (hm.size() <= 2 && hm.containsValue(4)) {
				score = 4;
				max_score = true;
			}
		} else if (runde == 9) {
			if ((hm.size() == 2 || hm.size() == 3) && hm.containsValue(2)) {
				score = 4;
				max_score = true;
			}
		} else if (runde == 10 && hm.size() == 2 && hm.containsValue(3)) {
			score = 5;
			max_score = true;
		} else if (runde == 11 && hm.size() == 5) {
			score = 5;
			max_score = true;

		} else if (runde == 12 && hm.size() == 1) {
			score = 10;
			max_score = true;
		}

		return score;

	}

	public List<Spiller> getSpillere() {
		return spillere;
	}

	public void setSpillere(List<Spiller> spillere) {
		this.spillere = spillere;
	}

	public Integer getRunde() {
		return runde;
	}

	public void setRunde(Integer runde) {
		this.runde = runde;
	}

	public boolean isMax_score() {
		return max_score;
	}

	public void setMax_score(boolean max_score) {
		this.max_score = max_score;
	}

	public void setVinner(Spiller vinner) {
		this.vinner = vinner;
	}

	public TerningKopp getKopp() {
		return kopp;
	}

	public void setKopp(TerningKopp kopp) {
		this.kopp = kopp;
	}

}
