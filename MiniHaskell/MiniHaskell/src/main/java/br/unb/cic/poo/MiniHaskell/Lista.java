package br.unb.cic.poo.MiniHaskell;

public abstract class Lista extends Valor {
	
	@Override
	public Tipo tipo() {
		return Tipo.LISTA;
	}
	
	public abstract boolean IsEmptyList();
	
}
