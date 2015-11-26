package br.unb.cic.poo.MiniHaskell;

import junit.framework.TestCase;

public class ExpressaoSomaTest extends TestCase {

	public void testExpSoma() {
		Expressao v10 = new ValorInteiro(10);
		Expressao v15 = new ValorInteiro(15);
		Expressao soma = new ExpressaoSoma(v10, v15);
		
		ValorInteiro res = (ValorInteiro)soma.avaliar();
		
		assertEquals(new Integer(25), res.getValor());
		
		soma = new ExpressaoSoma(soma, v15);
		res = (ValorInteiro)soma.avaliar();
		
		assertEquals(new Integer(40), res.getValor());
	}
	
	public void testExpSomaErroTipo() {
		Expressao vTrue = new ValorBooleano(true);
		Expressao v10   = new ValorInteiro(10);
		Expressao soma = new ExpressaoSoma(vTrue, v10);
		
		try {
			Valor res = soma.avaliar();
			fail();
		}
		catch(RuntimeException e) {
			assertTrue(true);
		}
	}
}
