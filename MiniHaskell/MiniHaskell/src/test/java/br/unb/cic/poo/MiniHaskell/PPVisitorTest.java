package br.unb.cic.poo.MiniHaskell;

import br.unb.cic.poo.MiniHaskell.visitors.PrettyPrinter;
import junit.framework.TestCase;

public class PPVisitorTest extends TestCase {

	public void testSubExp() {
		Expressao v3 = new ValorInteiro(3);
		Expressao s1 = new ExpressaoSoma(new ValorInteiro(1), new ValorInteiro(2));
		Expressao s2 = new ExpressaoSoma(s1, v3);
		
		PrettyPrinter v = new PrettyPrinter();
		
		v3.aceitar(v);
		assertEquals("3", v.getRes());
		
		v.init();
		
		s1.aceitar(v);
		System.out.println(v.getRes());
		assertEquals("(1 + 2)", v.getRes());
		
		v.init();
		
		s2.aceitar(v);
		System.out.println(v.getRes());
		assertEquals("((1 + 2) + 3)", v.getRes());
		
	}
}
