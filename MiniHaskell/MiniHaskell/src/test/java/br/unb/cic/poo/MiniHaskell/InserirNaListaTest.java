package br.unb.cic.poo.MiniHaskell;

import junit.framework.TestCase;

public class InserirNaListaTest extends TestCase {
	public void testInsercao(){
		Lista lv = new ListaVazia();
		
		InserirNaLista insert = new InserirNaLista(new ValorInteiro(3), lv);
		
		ListaValorada l1 = (ListaValorada)insert.avaliar();
		
		assertFalse(l1.IsEmptyList());
		
		assertEquals(((ValorInteiro) l1.valor()).getValor(),  new Integer(3));
		
		assertTrue(l1.next().IsEmptyList());
		
		insert = new InserirNaLista(new ValorInteiro(4), l1);
		
		ListaValorada l2 = (ListaValorada)insert.avaliar();
		
		assertFalse(l2.IsEmptyList());
		
		assertEquals(((ValorInteiro) l2.valor()).getValor(),  new Integer(4));
		assertEquals(((ValorInteiro) ((ListaValorada)l2.next()).valor()).getValor(),  new Integer(3));
	}
}
