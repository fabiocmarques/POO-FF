package br.unb.cic.poo.MiniHaskell.visitors;

import br.unb.cic.poo.MiniHaskell.AplicacaoDeFuncao;
import br.unb.cic.poo.MiniHaskell.ExpRef;
import br.unb.cic.poo.MiniHaskell.Expressao;
import br.unb.cic.poo.MiniHaskell.ExpressaoIgual;
import br.unb.cic.poo.MiniHaskell.ExpressaoLet;
import br.unb.cic.poo.MiniHaskell.ExpressaoMaior;
import br.unb.cic.poo.MiniHaskell.ExpressaoMaiorOuIgual;
import br.unb.cic.poo.MiniHaskell.ExpressaoMenor;
import br.unb.cic.poo.MiniHaskell.ExpressaoMenorOuIgual;
import br.unb.cic.poo.MiniHaskell.ExpressaoMultiplicacao;
import br.unb.cic.poo.MiniHaskell.ExpressaoSoma;
import br.unb.cic.poo.MiniHaskell.IfThenElse;
import br.unb.cic.poo.MiniHaskell.InserirNaLista;
import br.unb.cic.poo.MiniHaskell.ListaValorada;
import br.unb.cic.poo.MiniHaskell.ListaVazia;
import br.unb.cic.poo.MiniHaskell.RecuperaElemento;
import br.unb.cic.poo.MiniHaskell.TamanhoLista;
import br.unb.cic.poo.MiniHaskell.ValorBooleano;
import br.unb.cic.poo.MiniHaskell.ValorElementoLista;
import br.unb.cic.poo.MiniHaskell.ValorInteiro;

public class SubExpVisitor implements Visitor{

	private int total = 0;
	
	public void init() {
		total = 0;
	}
	
	public void visitar(ValorInteiro exp) {
		total += 1; 
	}

	public void visitar(ValorBooleano exp) {
		total += 1; 
	}
	

	public void visitar(ExpressaoSoma exp) {
		total += 1;
		exp.lhs().aceitar(this);
		exp.rhs().aceitar(this);
	}

	public void visitar(IfThenElse exp) {
		total += 1;
		exp.condicao().aceitar(this);
		exp.expThen().aceitar(this);
		exp.expElse().aceitar(this);
	}
	
	public int getTotal() {
		return total;
	}

	public void visitar(ExpressaoLet exp) {
		total += 1;
		exp.getAtribuicao().aceitar(this);
		exp.getCorpo().aceitar(this);		
	}

	public void visitar(ExpressaoMultiplicacao exp) {
		total += 1;
		exp.lhs().aceitar(this);
		exp.rhs().aceitar(this);		
	}

	public void visitar(ExpressaoMaiorOuIgual exp) {
		total += 1;
		exp.lhs().aceitar(this);
		exp.rhs().aceitar(this);	
	}

	public void visitar(ExpressaoMenorOuIgual exp) {
		total += 1;
		exp.lhs().aceitar(this);
		exp.rhs().aceitar(this);	
	}

	public void visitar(ExpressaoMaior exp) {
		total += 1;
		exp.lhs().aceitar(this);
		exp.rhs().aceitar(this);
	}

	public void visitar(ExpressaoMenor exp) {
		total += 1;
		exp.lhs().aceitar(this);
		exp.rhs().aceitar(this);	
		
	}

	public void visitar(ExpressaoIgual exp) {
		total += 1;
		exp.lhs().aceitar(this);
		exp.rhs().aceitar(this);	
	}

	public void visitar(InserirNaLista exp) {
		total += 1;
		exp.getListaExp().aceitar(this);
		exp.getValorInserido().aceitar(this);
		
	}

	public void visitar(ListaValorada exp) {
		total += 1;
		exp.valor().aceitar(this);
		exp.next().aceitar(this);
		
	}

	public void visitar(ListaVazia exp) {
		total += 1;
		
	}

	public void visitar(RecuperaElemento exp) {
		total += 1;
		exp.getListaExp().aceitar(this);
		exp.getIndex().aceitar(this);		
	}
	

	public void visitar(TamanhoLista exp) {
		total += 1;
		exp.getListaExp().aceitar(this);
		
	}

	public void visitar(ValorElementoLista exp) {
		total += 1;
		exp.getListaExp().aceitar(this);
		
	}

	public void visitar(ExpRef exp) {
		total += 1;
		
	}


	public void visitar(AplicacaoDeFuncao exp) {
		total += 1;
		for(Expressao expr : exp.getArgumentos())
			expr.aceitar(this);
	}
}
