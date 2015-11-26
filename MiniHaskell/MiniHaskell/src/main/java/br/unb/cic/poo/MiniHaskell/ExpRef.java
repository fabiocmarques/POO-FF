package br.unb.cic.poo.MiniHaskell;

import br.unb.cic.poo.MiniHaskell.visitors.Visitor;

public class ExpRef implements Expressao {
	private String id;
	
	public ExpRef(String id) {
		this.id = id;
	}

	public Valor avaliar() {
		Expressao exp = AmbienteExecucao.getInstance().consultaReferencia(id);
		
		return exp.avaliar();
	}

	public boolean checarTipo() {
		return !tipo().equals(Tipo.ERROR);
	}

	public Tipo tipo() {
		Expressao exp = AmbienteExecucao.getInstance().consultaReferencia(id);
		if(exp == null) {
			return Tipo.ERROR;
		}
		return exp.tipo();
	}

	public void aceitar(Visitor v) {
		//TODO: pendente a implementacao.
	} 

}
