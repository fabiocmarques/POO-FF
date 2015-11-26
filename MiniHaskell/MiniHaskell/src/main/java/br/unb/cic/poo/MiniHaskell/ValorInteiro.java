package br.unb.cic.poo.MiniHaskell;

import br.unb.cic.poo.MiniHaskell.visitors.Visitor;

public class ValorInteiro extends ValorParametrizado<Integer>{
	public ValorInteiro(Integer valor) {
		super(valor);
	}

	public Tipo tipo() {
		return Tipo.INTEIRO;
	}

	public void aceitar(Visitor v) {
		v.visitar(this);
	}
		
}
