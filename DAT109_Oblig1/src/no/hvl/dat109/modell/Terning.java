package no.hvl.dat109.modell;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.List;
import java.util.Arrays;
import java.util.*;

public class Terning {
	
	private static final Random RAND = new Random(System.currentTimeMillis());
	private Integer verdi;
	private String dyret;
	static ArrayList<String> dyr = new ArrayList<String>();
	
	
	public Terning () {
		
	}
	
	public void trill() {
		verdi = RAND.nextInt(6) + 1;
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
	
	public void setDyr(String dyret) {
		this.dyret = dyret;
		
	}
	public static void main(String[] args) {
		final Terning terning;
		terning = new Terning();
		terning.trill();
		
		
		terning.trill();
		dyr.add(terning.getDyr());
		terning.trill();
		dyr.add(terning.getDyr());
		terning.trill();
		dyr.add(terning.getDyr());
		terning.trill();
		dyr.add(terning.getDyr());
		terning.trill();
		dyr.add(terning.getDyr());
		
		
	
	}
	}


