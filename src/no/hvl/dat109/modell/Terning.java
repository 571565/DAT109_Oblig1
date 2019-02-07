package no.hvl.dat109.modell;

import java.util.Random;

public class Terning {
	
	private static final Random RAND = new Random(System.currentTimeMillis());
	private Integer verdi;
	
	public Terning () {
		verdi = RAND.nextInt(6) + 1;
		
	}
	
	public int getVerdi() {
		
		return verdi;
	}
	
	public String getDyr() {
		
		String dyret;
		
		if(verdi == 1) {
			dyret = "løve";
		}else if(verdi == 2){
			dyret = "slange";
		}else if(verdi == 3) {
			dyret = "panda";
		}else if(verdi == 4){
			dyret = "gris";
		}else if(verdi == 5) {
			dyret = "elefant";
		}else{
			dyret = "hval";
		}
		return dyret;
	}
	
	
	
	}


