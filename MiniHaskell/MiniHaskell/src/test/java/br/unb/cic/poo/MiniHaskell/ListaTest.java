package br.unb.cic.poo.MiniHaskell;

import junit.framework.TestCase;

public class ListaTest extends TestCase {
	public void testLista(){
		Lista lv = new ListaVazia();
		
		assertTrue(lv.IsEmptyList());
		
		Lista l1 = new ListaValorada(new ValorInteiro(3), lv);
		
		assertFalse(l1.IsEmptyList());
		
		ListaValorada l2 = new ListaValorada(new ValorInteiro(2), l1);
		
		assertEquals(((ValorParametrizado<Integer>) l2.valor()).getValor(), new Integer(2));
		
		assertTrue(l2.checarTipo());
		
		ListaValorada l3 = new ListaValorada(new ValorBooleano(true), l2);
		
		assertEquals( ((ValorBooleano) l3.valor()).getValor(), new Boolean(true));
		
		assertFalse(l3.checarTipo());
		
	}
}
