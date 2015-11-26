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
		
		Expressao condParada2 = new ExpressaoMenorOuIgual(new ExpRef("n"), new ValorInteiro(1));
		
		List<Expressao> argRec = new ArrayList<Expressao>();
		argRec.add(new ExpressaoSoma(new ExpRef("n"), new ValorInteiro(-1)));
		
		AplicacaoDeFuncao chamadaRec = new AplicacaoDeFuncao("Fatorial", argRec);
		
		Expressao exp = new IfThenElse(condParada2, new ValorInteiro(1), new ExpressaoMultiplicacao(new ExpRef("n"), chamadaRec));
		
		DecFuncao decFuncao = new DecFuncao("Fatorial", args, exp);
		
		AmbienteExecucao.getInstance().declaraFuncao(decFuncao);
		
		List<Expressao> param = new ArrayList<Expressao>();
		param.add(new ValorInteiro(5));
		
		AplicacaoDeFuncao app1 = new AplicacaoDeFuncao("Fatorial", param);
		
		ValorInteiro res = (ValorInteiro) app1.avaliar();
		
		assertEquals(res.getValor(), new Integer(120));
	}
}
