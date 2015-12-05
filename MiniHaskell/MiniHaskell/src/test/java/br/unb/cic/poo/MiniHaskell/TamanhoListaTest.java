package br.unb.cic.poo.MiniHaskell;

import junit.framework.TestCase;

public class TamanhoListaTest extends TestCase {
	public void testTamanhoLista(){
		Lista l = new ListaVazia();
		
		TamanhoLista tamLista = new TamanhoLista(l);
		
		ValorInteiro tam = (ValorInteiro)tamLista.avaliar();
		
		assertEquals(tam.getValor(), new Integer(0));
		
		tamLista = new TamanhoLista(new InserirNaLista(new ValorInteiro(3), l));
		
		tam = (ValorInteiro)tamLista.avaliar();
		
		assertEquals(tam.getValor(), new Integer(1));
	}
}
