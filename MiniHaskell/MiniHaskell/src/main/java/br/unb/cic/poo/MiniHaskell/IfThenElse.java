package br.unb.cic.poo.MiniHaskell;

import br.unb.cic.poo.MiniHaskell.visitors.Visitor;

public class IfThenElse extends Expressao {
	
	private Expressao condicao;
	private Expressao expThen;
	private Expressao expElse;
	
	public IfThenElse(Expressao condicao, Expressao expThen, Expressao expElse) {
		this.condicao = condicao;
		this.expThen = expThen;
		this.expElse = expElse;
	}

	public Valor avaliar() {
		ValorBooleano vb = (ValorBooleano)condicao.avaliar();
		return vb.getValor() ?  expThen.avaliar(): expElse.avaliar();
	}

	public boolean checarTipo() {		
		return condicao.tipo().equals(Tipo.BOOL) 
				&& expThen.tipo().equals(expElse.tipo());
	}

	public Tipo tipo() {
		if(checarTipo()) {
			return expThen.tipo();
		}
		return Tipo.ERROR;
	}

	public void aceitar(Visitor v) {
		v.visitar(this);
	}
	
	public Expressao condicao() {
		return condicao;
	}
	
	public Expressao expThen() {
		return expThen;
	}
	
	public Expressao expElse() {
		return expElse;
	}
}
