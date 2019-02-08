package no.hvl.dat109.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import no.hvl.dat109.modell.TerningKopp;

/**
 * @author Kjetil Dyrland, Vilhelm SKagestad, Thomas Vu, Carsten Ditlev-Simonsen
 *
 */
public class TerningKoppTest {

	private TerningKopp test;

	@Before
	public void before() {
		test = new TerningKopp();
	}

	@Test
	public void testKast() {
		test.kast();
		assertEquals(5, test.getKopp().size());
	}

	@Test
	public void testNyttKast() {
		test.kast();
		test.getKopp().remove(4);
		assertEquals(4, test.getKopp().size());
		test.kast();
		assertEquals(5, test.getKopp().size());
	}

}
