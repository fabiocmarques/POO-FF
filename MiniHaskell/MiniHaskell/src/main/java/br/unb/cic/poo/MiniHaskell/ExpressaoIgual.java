package br.unb.cic.poo.MiniHaskell;

import br.unb.cic.poo.MiniHaskell.visitors.Visitor;

public class ExpressaoIgual extends ExpressaoBin {
	
	
	public ExpressaoIgual(Expressao lhs, Expressao rhs) {
		super(lhs, rhs);
	}
	
	@Override
	public Valor avaliar() {
		Valor resLhs = lhs.avaliar();
		Valor resRhs = rhs.avaliar();
		
		if(resLhs.tipo().equals(Tipo.INTEIRO) && resRhs.tipo().equals(Tipo.INTEIRO)){
			return new ValorBooleano(((ValorInteiro)resLhs).getValor().equals(((ValorInteiro)resRhs).getValor()));
		}
		else if(resLhs.tipo().equals(Tipo.BOOL) && resRhs.tipo().equals(Tipo.BOOL)){
			return new ValorBooleano(((ValorBooleano)resLhs).getValor().equals(((ValorBooleano)resRhs).getValor()));
		}
		else
			throw new RuntimeException("Tipos não são equivalentes");
	}

	@Override
	public boolean checarTipo() {
		return rhs.tipo().equals(lhs.tipo());
	}

	@Override
	public Tipo tipo() {
		return checarTipo() ? Tipo.BOOL : Tipo.ERROR;
	}
	
	public void aceitar(Visitor v) {
		v.visitar(this);
	}

}
