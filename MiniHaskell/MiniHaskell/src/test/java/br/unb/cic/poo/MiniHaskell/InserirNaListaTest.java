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
		
		insert = new InserirNaLista(new ExpressaoSoma(new ValorInteiro(2), new ValorInteiro(2)), l1);
		
		l1 = (ListaValorada)insert.avaliar();
		
		assertFalse(l1.IsEmptyList());
		
		assertEquals(((ValorInteiro) l1.valor()).getValor(),  new Integer(4));
		assertEquals(((ValorInteiro) ((ListaValorada)l1.next()).valor()).getValor(),  new Integer(3));
	}
}
