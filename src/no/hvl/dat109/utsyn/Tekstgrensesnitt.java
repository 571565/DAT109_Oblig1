package no.hvl.dat109.utsyn;

import no.hvl.dat109.modell.Spiller;
import no.hvl.dat109.modell.Terning;
import no.hvl.dat109.modell.TerningKopp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tekstgrensesnitt implements YatzooUI {

	private Scanner tast;
	private ArrayList<String> dyr;

	/**
	 * @Constructor
	 */
	public Tekstgrensesnitt() {
		tast = new Scanner(System.in);
		dyr = new ArrayList<String>();
		dyr.add("løve");
		dyr.add("slange");
		dyr.add("panda");
		dyr.add("gris");
		dyr.add("elefant");
		dyr.add("hval");

	}

	public Integer lesAntallSpillere() {
		System.out.print("\tOppgi antall spillere: ");
		int nextInt = tast.nextInt();
		tast.nextLine();
		return nextInt;
		
	}

	public String lesInnSpiller() {
		System.out.print("\tOppgi navn på spiller: ");
		return tast.nextLine();
	}

	public void visRundeRegler(int runde) {
		System.out.println("------------------");
		System.out.print("Det er runde " + runde + " , det er om å gjøre å finne: ");
		if (runde < 7) {
			if (runde < 3)
				System.out.println(dyr.get(runde - 1) + "r");
			else
				System.out.println(dyr.get(runde - 1) + "er");
		} else if (runde == 7) {
			System.out.println("3 like av hvilket som helst par");
		} else if (runde == 8) {
			System.out.println("4 like av hvilket som helst par");
		} else if (runde == 9) {
			System.out.println("2 like par");
		} else if (runde == 10) {
			System.out.println("3 like og 2 like");
		} else if (runde == 11) {
			System.out.println("5 ulike");
		} else if (runde == 12) {
			System.out.println("5 like");
		}
		System.out.println("------------------");
	}

	public void antallSpillere(List<Spiller> spillere) {
		System.out.println("\n\tAntall spillere " + spillere.size());
	}

	public void nesteKast() {
		System.out.println("Trykk enter for å kaste en gang til");
		tast.nextLine();
	}

	public List<Terning> HvilkeTerningerSkalBeholdes(TerningKopp kopp) {

		System.out.println("Hvilke terninger vil du beholde? Tast 0 for ferdig");

		ArrayList<Terning> beholdes = new ArrayList<Terning>();
		List<Terning> kast = kopp.getKopp();

		while (beholdes.size() < 5) {
			int readInt = tast.nextInt();
			tast.nextLine();
			if (readInt == 0)
				return beholdes;
			System.out.println("Du beholdt terning nummer: " + readInt);
			beholdes.add(kast.get(readInt - 1));

		}
		return beholdes;

	}

}
