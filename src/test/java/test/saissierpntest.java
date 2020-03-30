package test;



import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import mou.*;
import interpreteur.*;
import actions.*;

public class saissierpntest {
	//MoteurRpns= new MoteurRpn;
	saisieRPN s;
	@Before
	public void setUp() throws Exception {
		s = new saisieRPN();
	}

	@After
	public void tearDown() throws Exception {
		s= new saisieRPN();
	}

	@Test
	public void testSaisiPLUS() throws Exception {
		s.calcul("1");
		s.calcul("2");
		s.calcul("+");
		assertEquals(3, ((saisieRPN) s.moteurRpn).getStack());
	}
	@Test
	public void testSaisiMULT() throws Exception{
		s.calcul("4");
		s.calcul("2");
		s.calcul("*");
		assertEquals(8, ((saisieRPN) s.moteurRpn).getStack());
	}
	
	@Test
	public void testSaisiMINUS() throws Exception {
		s.calcul("7");
		s.calcul("3");
		s.calcul("-");
		assertEquals(4, ((saisieRPN) s.moteurRpn).getStack());
	}
	
	@Test
	public void testSaisiDIVIDE() throws Exception {
		s.calcul("5");
		s.calcul("2");
		s.calcul("/");
		assertEquals(5/2, ((saisieRPN) s.moteurRpn).getStack());
	}

}
