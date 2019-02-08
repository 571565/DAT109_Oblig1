package no.hvl.dat109.modell;

import no.hvl.dat109.utsyn.Tekstgrensesnitt;

/**
 * @author kjetildyrland
 * @main
 */
public class Spill {

	public static void main(String[] args) {
		
		Tekstgrensesnitt tg = new Tekstgrensesnitt();
		Yatzoo spill = new Yatzoo(tg);
		
	
		
		spill.start();
		
		
		
		

	}

}
