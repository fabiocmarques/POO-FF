package br.unb.cic.poo.MiniHaskell.visitors;

import br.unb.cic.poo.MiniHaskell.ExpressaoLet;
import br.unb.cic.poo.MiniHaskell.ExpressaoSoma;
import br.unb.cic.poo.MiniHaskell.IfThenElse;
import br.unb.cic.poo.MiniHaskell.ValorBooleano;
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
		// TODO Auto-generated method stub
		
	}

}
