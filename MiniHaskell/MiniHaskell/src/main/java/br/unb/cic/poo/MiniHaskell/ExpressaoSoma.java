package br.unb.cic.poo.MiniHaskell;

import br.unb.cic.poo.MiniHaskell.visitors.Visitor;

public class ExpressaoSoma extends ExpressaoBinInt {

	public ExpressaoSoma(Expressao lhs, Expressao rhs) {
		super(lhs, rhs);
	}

	@Override
	public Valor avaliar(Integer x, Integer y) {
		return new ValorInteiro(x + y);
	}

	public void aceitar(Visitor v) {
		v.visitar(this);
	}

	
}
