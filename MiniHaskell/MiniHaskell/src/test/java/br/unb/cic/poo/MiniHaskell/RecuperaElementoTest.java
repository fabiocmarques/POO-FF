package br.unb.cic.poo.MiniHaskell;

import junit.framework.TestCase;

public class RecuperaElementoTest extends TestCase {
	public void testRecuperaElemento(){
		Lista l = new ListaVazia();
		
		InserirNaLista insert = new InserirNaLista(new ValorInteiro(3), l);
		l = (Lista)insert.avaliar();
		insert = new InserirNaLista(new ValorInteiro(4), l);
		l = (Lista)insert.avaliar();
		insert = new InserirNaLista(new ValorInteiro(5), l);
		l = (Lista)insert.avaliar();
		insert = new InserirNaLista(new ValorInteiro(6), l);
		l = (Lista)insert.avaliar();
		
		RecuperaElemento rec = new RecuperaElemento(new ValorInteiro(0), l);
		
		ListaValorada res = (ListaValorada)rec.avaliar();
		
		assertEquals(((ValorInteiro)res.valor()).getValor(), new Integer(6));
		
		rec = new RecuperaElemento(new ValorInteiro(1), l);
		
		res = (ListaValorada)rec.avaliar();
		
		assertEquals(((ValorInteiro)res.valor()).getValor(), new Integer(5));
		
		rec = new RecuperaElemento(new ValorInteiro(2), l);
		
		res = (ListaValorada)rec.avaliar();
		
		assertEquals(((ValorInteiro)res.valor()).getValor(), new Integer(4));
		
		rec = new RecuperaElemento(new ValorInteiro(4), l);
		
		Lista lista = (Lista)rec.avaliar();
		
		assertTrue(lista.IsEmptyList());
	}
}
