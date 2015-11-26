package br.unb.cic.poo.MiniHaskell;

import junit.framework.TestCase;

public class ExpIgualTest extends TestCase {
	public void testSimple(){
		ValorInteiro v1 = new ValorInteiro(10);
		ValorInteiro v2 = new ValorInteiro(10);
		ValorInteiro v3 = new ValorInteiro(20);
		
		ExpressaoIgual exp1 = new ExpressaoIgual(v1, v2);
		
		ValorBooleano res = (ValorBooleano) exp1.avaliar();
		
		assertEquals(res.getValor(), new Boolean(true));
		
		ExpressaoIgual exp2 = new ExpressaoIgual(v1, v3);
		
		res = (ValorBooleano) exp2.avaliar();
		
		assertEquals(res.getValor(), new Boolean(false));
		
		ExpressaoIgual exp3 = new ExpressaoIgual(new ExpressaoSoma(v1, v2), v3);
		
		res = (ValorBooleano) exp3.avaliar();
		
		assertEquals(res.getValor(), new Boolean(true));
	}
}
