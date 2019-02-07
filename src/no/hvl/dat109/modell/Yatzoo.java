package no.hvl.dat109.modell;

import no.hvl.dat109.utsyn.*;
import no.hvl.dat109.modell.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Yatzoo {


	private TerningKopp kopp;
	private static Integer n = 0;
	private YatzooUI ui;
	private Boolean spillFerdig;
	private List<Spiller> spillere;
	private Spiller vinner;
	private Integer runde;
	private boolean max_score = false;

	ArrayList<Terning> valgteDyr = new ArrayList<Terning>();
	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

	public Yatzoo() {
		this(null);
		this.runde = 1;
		spillere = new ArrayList<Spiller>();
		kopp = new TerningKopp();
		spillFerdig = Boolean.FALSE;
	}

	public Yatzoo(YatzooUI ui) {
		this.ui = ui;
		this.runde = 1;
		spillere = new ArrayList<Spiller>();
		kopp = new TerningKopp();
		spillFerdig = Boolean.FALSE;
	}

	public void start() {
		while (!spillFerdig) {
			ui.visRundeRegler(runde);
			spillRunde();
			if (spillFerdig == Boolean.TRUE) {
				visVinner();
			}
			vinner = finnVinner();
			rundeVinner();
			runde++;
			
		}
		
		
	}
	

	public void rundeVinner() {
		System.out.println("\t" + vinner.getNavn() + " vant runde "+ runde + " med " + vinner.getRundeScore().get(runde - 1) + " score");
	}
	
	public void visVinner() {
		System.out.println("\t" + vinner.getNavn() + "vant spillet med " + vinner.getSpiller_score() + " score");
	}
	
	
	
	public boolean leggTilSpiller(Spiller spiller) {
		return spillere.add(spiller);
	}

	public Spiller getVinner() {
		return vinner;
	}

	public int antallSpillere() {
		return spillere.size();
	}
	
	public Spiller finnVinner() {
		Spiller vinner = spillere.get(0);
		for (Spiller s : spillere) {
			if (s.getSpiller_score() > vinner.getSpiller_score()) {
				vinner = s;
			}
		}
		return vinner;
	}

	// antall spillere må lages,
	public void spillRunde() {
		
		if (runde > 12) {
			spillFerdig = Boolean.TRUE;
		}

		for (int i = 0; i < antallSpillere() && spillFerdig == Boolean.FALSE; i++) {
			
			Spiller s = spillere.get(i);
			max_score = false;
			
			valgteDyr = spillTrekk(s);
			int rundeScore = regnUtScore(valgteDyr);
			
			s.getRundeScore().add(rundeScore);
			s.setSpiller_score(s.getSpiller_score() + rundeScore);
			
			
		}
		
		
	}

	public ArrayList<Terning> spillTrekk(Spiller spiller) {


		int i = 0;
		kopp.setKopp(new ArrayList<Terning>());
		kopp.kast();
		while (i < 2) {
			
			kopp.visTerningKopp();
			kopp.setKopp(ui.HvilkeTerningerSkalBeholdes(kopp));
			if (kopp.getKopp().size() >= 5) {
				return kopp.getKopp();
			}
			regnUtScore(kopp.getKopp());
			if (max_score)
				return kopp.getKopp();
			i++;
			kopp.kast();
		}
		
		kopp.visTerningKopp();
		return kopp.getKopp();

	}
	
	public HashMap<Integer, Integer> antallLikeAvHver (ArrayList<Terning> kopp) {
		
		HashMap<Integer, Integer> antallLike = new HashMap<Integer, Integer>();
		int[] hjelpe = kopp.stream().mapToInt(x -> x.getVerdi()).toArray();
		for (Integer t : hjelpe) {
			Integer j = antallLike.get(t); 
            antallLike.put(t, (j == null) ? 1 : j + 1);
		}
		return antallLike;
	
		
	}

	public int regnUtScore(ArrayList<Terning> kopp) {
			
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
				if (hm.size() <=2 && hm.containsValue(4)) {
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

		

// må si hva scoren ble, og få tilbud om å kaste igjen hvis han ikke har kastet 3 ganger allerede

}

}
