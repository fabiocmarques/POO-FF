package br.unb.cic.poo.MiniHaskell;

import br.unb.cic.poo.MiniHaskell.visitors.Visitor;

public class ValorBooleano extends ValorParametrizado<Boolean> {
	public ValorBooleano(Boolean valor) {
		super(valor);
	}

	public Tipo tipo() {
		return Tipo.BOOL;
	}

	public void aceitar(Visitor v) {
		v.visitar(this);
	}
}
