package br.unb.cic.poo.MiniHaskell.visitors;

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

public class PrettyPrinter implements Visitor {

	String res = "";
	
	public String getRes() {
		return res;
	}
	
	public void visitar(ValorInteiro exp) {
		res += exp.getValor();
	}

	public void visitar(ValorBooleano exp) {
		res += exp.getValor();
	}

	public void visitar(ExpressaoSoma exp) {
		res += "(";
		exp.lhs().aceitar(this);
		res += " + ";
		exp.rhs().aceitar(this);
		res += ")";
	}

	public void visitar(IfThenElse exp) {
		res += "if(";
		exp.condicao().aceitar(this);
		res += ")";
		res += " then {";
		exp.expThen().aceitar(this);
		res += " } else {";
		exp.expElse().aceitar(this);
		res += "}";
	}

	public void init() {
		res = "";
	}

	public void visitar(ExpressaoLet exp) {
		res += "let ";
		res += exp.getId();
		res += " ";
		exp.getAtribuicao().aceitar(this);
		res += " in ";
		exp.getCorpo().aceitar(this);;		
	}


	public void visitar(ExpressaoMultiplicacao exp) {
		res += "(";
		exp.lhs().aceitar(this);
		res += " * ";
		exp.rhs().aceitar(this);
		res += ")";
	}


	public void visitar(ExpressaoMaiorOuIgual exp) {
		res += "(";
		exp.lhs().aceitar(this);
		res += " >= ";
		exp.rhs().aceitar(this);
		res += ")";
		
	}

	public void visitar(ExpressaoMenorOuIgual exp) {
		res += "(";
		exp.lhs().aceitar(this);
		res += " <= ";
		exp.rhs().aceitar(this);
		res += ")";
		
	}

	public void visitar(ExpressaoMaior exp) {
		res += "(";
		exp.lhs().aceitar(this);
		res += " > ";
		exp.rhs().aceitar(this);
		res += ")";		
	}

	public void visitar(ExpressaoMenor exp) {
		res += "(";
		exp.lhs().aceitar(this);
		res += " < ";
		exp.rhs().aceitar(this);
		res += ")";
	}

	public void visitar(ExpressaoIgual exp) {
		res += "(";
		exp.lhs().aceitar(this);
		res += "==";
		exp.rhs().aceitar(this);
		res += ")";		
	}
	

	public void visitar(InserirNaLista exp) {
		res += " [";
		exp.getValorInserido().aceitar(this);;
		res += "] ";		
	}
	
	

	public void visitar(ListaValorada exp) {
		res += " [";
		exp.valor().aceitar(this);;
		res += "] ";
		exp.next().aceitar(this);		
	}
	
	

	public void visitar(ListaVazia exp) {
		res += " [null] ";
		
	}

	public void visitar(RecuperaElemento exp) {
		res += "Elemento na posição ";
		exp.getIndex().aceitar(this);
		res += " : ";
		exp.avaliar().aceitar(this);
	}

	public void visitar(TamanhoLista exp) {
		res += "Tamanho da lista: "+ exp.getTam();
		
	}

	public void visitar(ValorElementoLista exp) {
		res += "Valor do elemento: ";
		exp.avaliar().aceitar(this);
	}

}
