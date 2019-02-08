package no.hvl.dat109.modell;

import java.util.Random;

/**
 * @author Kjetil Dyrland, Vilhelm SKagestad, Thomas Vu, Carsten Ditlev-Simonsen
 *
 */
public class Terning {

	private static final Random RAND = new Random(System.currentTimeMillis());
	private Integer verdi;

	/**
	 * @Constructor
	 */
	public Terning() {
		verdi = RAND.nextInt(6) + 1;

	}

	public void setVerdi(Integer verdi) {
		this.verdi = verdi;
	}

	/**
	 * @return int
	 */
	public int getVerdi() {

		return verdi;
	}

	/**
	 * @return String
	 */
	public String getDyr() {

		String dyret;

		if (verdi == 1) {
			dyret = "løve";
		} else if (verdi == 2) {
			dyret = "slange";
		} else if (verdi == 3) {
			dyret = "panda";
		} else if (verdi == 4) {
			dyret = "gris";
		} else if (verdi == 5) {
			dyret = "elefant";
		} else {
			dyret = "hval";
		}
		return dyret;
	}

}
