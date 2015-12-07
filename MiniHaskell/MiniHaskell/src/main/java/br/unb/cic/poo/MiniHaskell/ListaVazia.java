package br.unb.cic.poo.MiniHaskell;

import br.unb.cic.poo.MiniHaskell.visitors.Visitor;

public class ListaVazia extends Lista {
	
	@Override
	public boolean IsEmptyList() {
		return true;
	}

	@Override
	public boolean checarTipo() {
		return true;
	}
	
	public void aceitar(Visitor v) {
		v.visitar(this);
	}
	
}
