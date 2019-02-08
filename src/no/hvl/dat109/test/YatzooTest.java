package no.hvl.dat109.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import no.hvl.dat109.modell.Spiller;
import no.hvl.dat109.modell.Terning;
import no.hvl.dat109.modell.TerningKopp;
import no.hvl.dat109.modell.Yatzoo;

/**
 * @author Kjetil Dyrland, Vilhelm SKagestad, Thomas Vu, Carsten Ditlev-Simonsen
 *
 */
public class YatzooTest {

	private Yatzoo yatzoo; 
	private Spiller s1;
	private Spiller s2;
	private Spiller s3;
	private Spiller s4;
	
	private Integer e1 = 1;
	private Integer e2 = 2;
	private Integer e3 = 3;
	private Integer e4 = 4;
	private Integer e5 = 5;
	private Integer e6 = 6;
	private Integer e7 = 7;
	private Integer e8 = 8;
	private Integer e9 = 9;
	private Integer e10 = 10;
	private Integer e11 = 11;
	private Integer e12 = 12;
	
	private TerningKopp kopp;
	private List<Terning> l;
	private Terning t;
	
	
	@Before
	public void before () {
		yatzoo = new Yatzoo();
		s1 = new Spiller("s1");
		s2 = new Spiller("s2");
		s3 = new Spiller("s3");
		s4 = new Spiller("s4");
		kopp = new TerningKopp();
		t = new Terning();
		l = new ArrayList<Terning>();
		
		
		
	}
	
	

	@Test
	public void testMax_Score() {
		
		t.setVerdi(1);
		l.add(t);
		l.add(t);
		l.add(t);
		l.add(t);
		l.add(t);
		kopp.setKopp(l);
		yatzoo.regnUtScore(kopp.getKopp());
		assertTrue(yatzoo.isMax_score());

	}
	
	

}
