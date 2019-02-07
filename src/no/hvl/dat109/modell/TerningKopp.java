package no.hvl.dat109.modell;

import java.util.ArrayList;
import java.util.Iterator;

public class TerningKopp {
	
	private final static int ANTALL_TERNINGER = 5;
	
	private ArrayList<Terning> kopp;
	
	
	public TerningKopp() {
		kopp = new ArrayList<Terning>();
	}
	
	
	public ArrayList<Terning> getKopp() {
		return kopp;
	}

	public void setKopp(ArrayList<Terning> kopp) {
		this.kopp = kopp;
	}

	public void kast() {
		while (kopp.size() < ANTALL_TERNINGER) {
			kopp.add(new Terning());
		}
	}
	
	public void visTerningKopp() {
		Iterator<Terning> iterator = kopp.iterator();
		int i = 1;
		while (iterator.hasNext()) {
			System.out.println("Terning nr " + i + " ble: " + iterator.next().getDyr());
			i++;
		}
		
	}
	

}
