package br.unb.cic.poo.MiniHaskell;

import br.unb.cic.poo.MiniHaskell.visitors.Visitor;

public abstract class Lista extends Valor {
	
	@Override
	public Tipo tipo() {
		return Tipo.LISTA;
	}
	
	public abstract boolean IsEmptyList(); 
	
}
