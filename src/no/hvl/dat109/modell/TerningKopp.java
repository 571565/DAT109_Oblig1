package no.hvl.dat109.modell;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Kjetil Dyrland, Vilhelm SKagestad, Thomas Vu, Carsten Ditlev-Simonsen
 *
 */
public class TerningKopp {

	private final static int ANTALL_TERNINGER = 5;

	private List<Terning> kopp;

	/**
	 * @Constructor
	 */
	public TerningKopp() {
		kopp = new ArrayList<Terning>();
	}

	/**
	 * @return List
	 */
	public List<Terning> getKopp() {
		return kopp;
	}

	/**
	 * @param kopp
	 */
	public void setKopp(List<Terning> kopp) {
		this.kopp = kopp;
	}

	/**
	 * @return void
	 */
	public void kast() {
		while (kopp.size() < ANTALL_TERNINGER) {
			kopp.add(new Terning());
		}
	}

	/**
	 * @return void
	 */
	public void visTerningKopp() {
		Iterator<Terning> iterator = kopp.iterator();

		int i = 1;
		while (iterator.hasNext()) {
			System.out.println("Terning nr " + i + " ble: " + iterator.next().getDyr());
			i++;
		}
		System.out.println("------------------");

	}

}
