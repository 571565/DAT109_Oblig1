package no.hvl.dat109.utsyn;

import no.hvl.dat109.modell.Yatzoo;
import no.hvl.dat109.modell.Spiller;

import java.util.List;
import java.util.Scanner;


public class Tekstgrensesnitt implements YatzooUI {
	
	private Scanner tast;
	
	public Tekstgrensesnitt () {
		tast = new Scanner(System.in);
	}
	
	public Integer lesAntallSpillere() {
		System.out.print("\tOppgi antall spillere: ");
		return tast.nextInt();
	}
	
	public String lesInnSpiller() {
		System.out.print("\tOppgi navn på spiller: ");
		return tast.next();
	}
	
	public void vinner(Yatzoo yatzoo) {
		System.out.println("\t" + yatzoo.getVinner().getNavn() + " vant denne runden!");
	}
	
	public void antallSpillere(List<Spiller> spillere) {
		System.out.println("\n\tAntall spillere " + spillere.size());
	}

}
