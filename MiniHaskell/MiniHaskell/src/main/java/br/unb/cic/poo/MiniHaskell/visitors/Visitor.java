package br.unb.cic.poo.MiniHaskell.visitors;

import br.unb.cic.poo.MiniHaskell.ExpressaoLet;
import br.unb.cic.poo.MiniHaskell.ExpressaoSoma;
import br.unb.cic.poo.MiniHaskell.IfThenElse;
import br.unb.cic.poo.MiniHaskell.ValorBooleano;
import br.unb.cic.poo.MiniHaskell.ValorInteiro;

public interface Visitor {
	public void visitar(ValorInteiro exp);
	public void visitar(ValorBooleano exp);
	public void visitar(ExpressaoSoma exp);
	public void visitar(IfThenElse exp);
	public void visitar(ExpressaoLet exp);
	public void init();
}
