package no.hvl.dat109.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import no.hvl.dat109.modell.TerningKopp;

public class TerningKoppTest {
	
	private TerningKopp test;
	
	@Before
	public void before() {
		test = new TerningKopp();
	}
	

	@Test
	public void Test() {
		test.kast();
		assertEquals(5, test.getKopp().size());
	}

}
