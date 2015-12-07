package br.unb.cic.poo.MiniHaskell;

import java.util.ArrayList;

import br.unb.cic.poo.MiniHaskell.visitors.SubExpVisitor;
import junit.framework.TestCase;

public class SubExpVisitorTest extends TestCase {

	public void testSubExp() {
		Expressao v3 = new ValorInteiro(3);
		Expressao s1 = new ExpressaoSoma(new ValorInteiro(1), new ValorInteiro(2));
		Expressao s2 = new ExpressaoSoma(s1, v3);
		
		SubExpVisitor v = new SubExpVisitor();
		
		v3.aceitar(v);
		assertEquals(1, v.getTotal());
		
		v.init();
		
		s1.aceitar(v);
		assertEquals(3, v.getTotal());
		
		v.init();
		
		s2.aceitar(v);
		assertEquals(5, v.getTotal());
		
		v.init();
		s1 = new ExpressaoMultiplicacao(v3, v3);
		s1.aceitar(v);
		assertEquals(3, v.getTotal());
		
		v.init();
		s1 = new ExpressaoMaior(v3, v3);
		s1.aceitar(v);
		assertEquals(3, v.getTotal());
		
		v.init();
		s1 = new ExpressaoMenor(v3, v3);
		s1.aceitar(v);
		assertEquals(3, v.getTotal());
		
		v.init();
		s1 = new ExpressaoMaiorOuIgual(v3, v3);
		s1.aceitar(v);
		assertEquals(3, v.getTotal());
		
		v.init();
		s1 = new ExpressaoMenorOuIgual(v3, v3);
		s1.aceitar(v);
		assertEquals(3, v.getTotal());
		
		v.init();
		s1 = new ExpressaoIgual(v3, v3);
		s1.aceitar(v);
		assertEquals(3, v.getTotal());
	}
	
	
	
	public void testFuncoes(){
		Expressao condicao = new ExpressaoIgual(new ValorInteiro(3), new ValorInteiro(2));
		Expressao expthen = new ExpressaoSoma(new ValorInteiro(1), new ValorInteiro(2));
		Expressao expelse = new ExpressaoSoma(new ValorInteiro(3), new ValorInteiro(2));
		Expressao expIf = new IfThenElse(condicao, expthen, expelse);
		
		SubExpVisitor v = new SubExpVisitor();
		
		v.init();
		expIf.aceitar(v);
		assertEquals(10, v.getTotal());
		
		v.init();
		
		Expressao let = new ExpressaoLet("x", new ValorInteiro(3), new ExpressaoSoma(new ExpRef("x"), new ValorInteiro(4)));
		let.aceitar(v);
		System.out.println(v.getTotal());
		assertEquals(5 , v.getTotal());
		
		v.init();
		Expressao expref = new ExpRef("x");
		expref.aceitar(v);
		assertEquals(1,v.getTotal());
		
		v.init();
		ArrayList<Expressao> list = new ArrayList<Expressao>();
		list.add(new ExpressaoSoma(new ValorInteiro(3), new ValorInteiro(3)));
		Expressao func = new AplicacaoDeFuncao("somador", list);
		
		func.aceitar(v);
		assertEquals(4, v.getTotal());
		
	}
	
	
	public void testLista(){
		SubExpVisitor v = new SubExpVisitor();
		
		
		v.init();
		Expressao exp = new ListaVazia();
		exp.aceitar(v);
		assertEquals(1, v.getTotal());
		
		
		
		v.init();
		exp = new ListaValorada(new ValorInteiro(4), new ListaVazia());
		exp.aceitar(v);
		assertEquals(3, v.getTotal());		
		
		
		
		v.init();
		exp = new InserirNaLista(new ValorInteiro(4), new ListaVazia());
		exp.aceitar(v);
		assertEquals(3, v.getTotal());
		
		
		v.init();
		exp = new RecuperaElemento(new ValorInteiro(3), new ListaValorada(new ValorInteiro(4), new ListaVazia()));
		exp.aceitar(v);
		assertEquals(5, v.getTotal());
		
		
		
		v.init();
		exp = new TamanhoLista(new ListaValorada(new ValorInteiro(4), new ListaVazia()));
		exp.aceitar(v);
		assertEquals(4, v.getTotal());
		
		
		v.init();
		exp = new TamanhoLista(new ListaVazia());
		exp.avaliar();
		exp.aceitar(v);
		assertEquals(2, v.getTotal());
		
		
		v.init();
		exp = new ValorElementoLista(new ListaValorada(new ValorInteiro(4), new ListaVazia()));
		exp.avaliar();
		exp.aceitar(v);
		assertEquals(4, v.getTotal());
		
		
		v.init();
		exp = new ValorElementoLista(new ListaVazia());
		exp.avaliar();
		exp.aceitar(v);
		assertEquals(2, v.getTotal());
	}
	
	
	
	
}
