package br.unb.cic.poo.MiniHaskell;

import br.unb.cic.poo.MiniHaskell.visitors.Visitor;

public class ExpressaoLet implements Expressao {
	
	private String id; 
	private Expressao atribuicao;
	private Expressao corpo;
	
	
	public ExpressaoLet(String id, Expressao atribuicao, Expressao corpo) {
		this.id = id;
		this.atribuicao = atribuicao;
		this.corpo = corpo;
	}

	public Valor avaliar() {
		AmbienteExecucao.getInstance().push();
		AmbienteExecucao.getInstance().declaraVariavel(id, atribuicao);
		Valor res = corpo.avaliar();
		AmbienteExecucao.getInstance().pop();
		return res;
	}
	
	public boolean checarTipo() {
		return atribuicao.checarTipo() && corpo.checarTipo();
	}
	public Tipo tipo() {
		if(checarTipo()) {
			return corpo.tipo();
		}
		return Tipo.ERROR;
	}
	public void aceitar(Visitor v) {
		v.visitar(this);
	}
}
