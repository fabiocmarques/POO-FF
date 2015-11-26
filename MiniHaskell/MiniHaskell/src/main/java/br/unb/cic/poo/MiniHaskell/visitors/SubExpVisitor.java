package br.unb.cic.poo.MiniHaskell.visitors;

import br.unb.cic.poo.MiniHaskell.ExpressaoLet;
import br.unb.cic.poo.MiniHaskell.ExpressaoSoma;
import br.unb.cic.poo.MiniHaskell.IfThenElse;
import br.unb.cic.poo.MiniHaskell.ValorBooleano;
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
		// TODO Auto-generated method stub
		
	}

}
