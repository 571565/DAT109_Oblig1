package no.hvl.dat109.utsyn;

import java.util.ArrayList;
import java.util.List;

import no.hvl.dat109.modell.Spiller;
import no.hvl.dat109.modell.Terning;
import no.hvl.dat109.modell.TerningKopp;
import no.hvl.dat109.modell.Yatzoo;

public interface YatzooUI {
	
	// Leser antall spillere fra brukeren
	public Integer lesAntallSpillere();
	
	//Leser inn spillernavn
	public String lesInnSpiller();
	
	
	//Metode for å skrive ut antall spillere
	public void antallSpillere(List<Spiller> spillere);
	
	public void visRundeRegler(int runde);
	public void nesteKast();
	
	public ArrayList<Terning> HvilkeTerningerSkalBeholdes(TerningKopp kast);

}
