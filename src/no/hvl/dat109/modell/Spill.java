package no.hvl.dat109.modell;

import no.hvl.dat109.utsyn.Tekstgrensesnitt;

public class Spill {

	public static void main(String[] args) {
		
		Tekstgrensesnitt tg = new Tekstgrensesnitt();
		Yatzoo spill = new Yatzoo(tg);
		
		Spiller s1 = new Spiller("Kjetil");
		
		spill.leggTilSpiller(s1);
		
		spill.start();
		
		
		
		

	}

}
