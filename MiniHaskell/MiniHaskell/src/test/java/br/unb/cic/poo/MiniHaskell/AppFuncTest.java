package br.unb.cic.poo.MiniHaskell;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class AppFuncTest extends TestCase {
	public void testSimpleFunc(){
		List<String> args = new ArrayList<String>();
		args.add("x");
		args.add("y");
		
		ExpressaoSoma exp1 = new ExpressaoSoma(new ExpRef("x"), new ExpRef("y"));
		ExpressaoSoma exp2 = new ExpressaoSoma(exp1, new ValorInteiro(10));
		
		DecFuncao decFuncao = new DecFuncao("simpleFunc", args, exp2);
		
		AmbienteExecucao.getInstance().declaraFuncao(decFuncao);
		
		List<Expressao> parametros = new ArrayList<Expressao>();
		parametros.add(new ValorInteiro(5));
		parametros.add(new ValorInteiro(6));
		
		AplicacaoDeFuncao appSimpleFunc = new AplicacaoDeFuncao("simpleFunc", parametros);
		
		ValorInteiro res = (ValorInteiro)appSimpleFunc.avaliar();
		
		assertEquals(res.getValor(), new Integer(21));
	}
	
	public void testFuncaoFatorial(){
		List<String> args = new ArrayList<String>();
		args.add("n");
	}
}
