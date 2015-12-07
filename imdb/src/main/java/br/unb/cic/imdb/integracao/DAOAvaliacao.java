package br.unb.cic.imdb.integracao;

import br.unb.cic.imdb.negocio.Avaliacao;

public interface DAOAvaliacao {
	public void salvarAvaliacao(Avaliacao avaliacao);
	
	public Avaliacao recuperaAvaliacao(String trabArt);
}
