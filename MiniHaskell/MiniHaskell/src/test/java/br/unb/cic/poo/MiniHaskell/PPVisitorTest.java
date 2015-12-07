package br.unb.cic.poo.MiniHaskell;

import java.util.ArrayList;

import br.unb.cic.poo.MiniHaskell.visitors.PrettyPrinter;
import junit.framework.TestCase;

public class PPVisitorTest extends TestCase {

	public void testSimplePP() {
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
	
	public void testPPMultiplicacao(){
			Expressao v3 = new ValorInteiro(3);
			Expressao s1 = new ExpressaoMultiplicacao(new ValorInteiro(1), new ValorInteiro(2));
			Expressao s2 = new ExpressaoMultiplicacao(s1, v3);
			
			PrettyPrinter v = new PrettyPrinter();
			
			v3.aceitar(v);
			assertEquals("3", v.getRes());
			
			v.init();
			
			s1.aceitar(v);
			System.out.println(v.getRes());
			assertEquals("(1 * 2)", v.getRes());
			
			v.init();
			
			s2.aceitar(v);
			System.out.println(v.getRes());
			assertEquals("((1 * 2) * 3)", v.getRes());
			
	}
	
	
	public void testPPComparacao(){
		Expressao v3 = new ValorInteiro(3);
		Expressao v2 = new ValorInteiro(2);
		Expressao verdadeiro = new ValorBooleano(true);
		Expressao falso = new ValorBooleano(false);
		Expressao compara = new ExpressaoMaior(v3, v2);
		
		PrettyPrinter v = new PrettyPrinter();
		
		v3.aceitar(v);
		assertEquals("3", v.getRes());
		
v.init();
		
		v2.aceitar(v);
		assertEquals("2", v.getRes());
		
v.init();
		
		compara.aceitar(v);
		System.out.println(v.getRes());
		assertEquals("(3 > 2)", v.getRes());
		
v.init();
		
		compara = new ExpressaoMenor(v3, v2);
		
		compara.aceitar(v);
		System.out.println(v.getRes());
		assertEquals("(3 < 2)", v.getRes());
		
v.init();
		
		compara = new ExpressaoMaiorOuIgual(v3, v2);
		
		compara.aceitar(v);
		System.out.println(v.getRes());
		assertEquals("(3 >= 2)", v.getRes());
		
v.init();
		
		compara = new ExpressaoMenorOuIgual(v3, v2);
		
		compara.aceitar(v);
		System.out.println(v.getRes());
		assertEquals("(3 <= 2)", v.getRes());
		
		
v.init();
		
		compara = new ExpressaoIgual(v3, v2);
		
		compara.aceitar(v);
		System.out.println(v.getRes());
		assertEquals("(3 == 2)", v.getRes());
		
v.init();
		
		compara = new ExpressaoIgual(verdadeiro, falso);
		
		compara.aceitar(v);
		System.out.println(v.getRes());
		assertEquals("(true == false)", v.getRes());	
		
	}
	
	
	public void testFunc() {
		Expressao condicao = new ExpressaoIgual(new ValorInteiro(3), new ValorInteiro(2));
		Expressao expthen = new ExpressaoSoma(new ValorInteiro(1), new ValorInteiro(2));
		Expressao expelse = new ExpressaoSoma(new ValorInteiro(3), new ValorInteiro(2));
		Expressao expIf = new IfThenElse(condicao, expthen, expelse);
		
		PrettyPrinter v = new PrettyPrinter();
		
		v.init();
		
		expIf.aceitar(v);
		System.out.println(v.getRes());
		assertEquals("if((3 == 2)) then {(1 + 2) } else {(3 + 2)}", v.getRes());
		
		v.init();
		
		Expressao let = new ExpressaoLet("x", new ValorInteiro(3), new ExpressaoSoma(new ExpRef("x"), new ValorInteiro(4)));
		let.aceitar(v);
		System.out.println(v.getRes());
		assertEquals("let x = 3 in (x + 4)" , v.getRes());
		
		v.init();
		let = new ExpRef("x");
		let.aceitar(v);
		assertEquals("x", v.getRes());
		
		v.init();
		ArrayList<Expressao> list = new ArrayList<Expressao>();
		list.add(new ExpressaoSoma(new ValorInteiro(3), new ValorInteiro(3)));
		Expressao func = new AplicacaoDeFuncao("somador", list);
		
		func.aceitar(v);
		assertEquals("somador ( (3 + 3)) ", v.getRes());
		
		
	}
	
	
	public void testListas(){
		PrettyPrinter v = new PrettyPrinter();
		
		
		v.init();
		Expressao exp = new ListaVazia();
		exp.aceitar(v);
		assertEquals("[null] ", v.getRes());
		
		
		
		v.init();
		exp = new ListaValorada(new ValorInteiro(4), new ListaVazia());
		exp.aceitar(v);
		assertEquals(" [4] [null] ", v.getRes());		
		
		
		
		v.init();
		exp = new InserirNaLista(new ValorInteiro(4), new ListaVazia());
		exp.aceitar(v);
		assertEquals(" [4] ", v.getRes());
		
		v.init();
		exp = new RecuperaElemento(new ValorInteiro(3), new ListaValorada(new ValorInteiro(4), new ListaVazia()));
		exp.aceitar(v);
		assertEquals("Elemento na posição 3 : [null] ", v.getRes());
		
		
		v.init();
		exp = new TamanhoLista(new ListaValorada(new ValorInteiro(4), new ListaVazia()));
		exp.avaliar();
		exp.aceitar(v);
		assertEquals("Tamanho da lista: 1", v.getRes());
		
		
		v.init();
		exp = new TamanhoLista(new ListaVazia());
		exp.avaliar();
		exp.aceitar(v);
		assertEquals("Tamanho da lista: 0", v.getRes());
		
		
		
		v.init();
		exp = new ValorElementoLista(new ListaValorada(new ValorInteiro(4), new ListaVazia()));
		exp.avaliar();
		exp.aceitar(v);
		assertEquals("Valor do elemento: 4", v.getRes());
		
		
		v.init();
		exp = new ValorElementoLista(new ListaVazia());
		exp.avaliar();
		exp.aceitar(v);
		assertEquals("Valor do elemento: [null] ", v.getRes());
		
		
	}
	
	
	
	
}
