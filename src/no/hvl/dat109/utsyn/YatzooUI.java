package no.hvl.dat109.utsyn;

import java.util.List;

import no.hvl.dat109.modell.Spiller;
import no.hvl.dat109.modell.Terning;
import no.hvl.dat109.modell.TerningKopp;

/**
 * @author Kjetil Dyrland, Vilhelm SKagestad, Thomas Vu, Carsten Ditlev-Simonsen
 *
 */
public interface YatzooUI {

	/**
	 * @return Integer
	 */
	public Integer lesAntallSpillere();

	/**
	 * @return String
	 */
	public String lesInnSpiller();

	/**
	 * @param spillere
	 * @return void
	 */
	public void antallSpillere(List<Spiller> spillere);

	/**
	 * @param runde
	 * @return void
	 */
	public void visRundeRegler(int runde);

	/**
	 * @return void
	 */
	public void nesteKast();

	/**
	 * @param kast
	 * @return ArrayList
	 */
	public List<Terning> HvilkeTerningerSkalBeholdes(TerningKopp kast);

}
