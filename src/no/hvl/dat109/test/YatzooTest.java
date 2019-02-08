package no.hvl.dat109.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import no.hvl.dat109.modell.Terning;
import no.hvl.dat109.modell.TerningKopp;
import no.hvl.dat109.modell.Yatzoo;

/**
 * @author Kjetil Dyrland, Vilhelm SKagestad, Thomas Vu, Carsten Ditlev-Simonsen
 *
 */
public class YatzooTest {

	private Yatzoo yatzoo;

	private TerningKopp kopp;
	private List<Terning> l;
	private Terning t1;
	private Terning t2;

	@Before
	public void before() {

		yatzoo = new Yatzoo();
		kopp = new TerningKopp();
		t1 = new Terning();
		t2 = new Terning();
		l = new ArrayList<Terning>();

	}

	@Test
	public void testMax_Score() {

		t1.setVerdi(1);
		l.add(t1);
		l.add(t1);
		l.add(t1);
		l.add(t1);
		l.add(t1);
		kopp.setKopp(l);
		yatzoo.regnUtScore(kopp.getKopp());
		assertTrue(yatzoo.isMax_score());

	}

	@Test
	public void testAntallLike() {
		t1.setVerdi(1);
		l.add(t1);
		l.add(t1);
		l.add(t1);
		t2.setVerdi(2);
		l.add(t2);
		l.add(t2);
		assertTrue(yatzoo.antallLikeAvHver(l).containsValue(3));
		assertTrue(yatzoo.antallLikeAvHver(l).containsValue(2));

	}

	@Test
	public void testRegnUtScore() {
		t1.setVerdi(1);
		l.add(t1);
		l.add(t1);
		l.add(t1);
		t2.setVerdi(2);
		l.add(t2);
		l.add(t2);
		assertEquals(3, yatzoo.regnUtScore(l));

	}

}
