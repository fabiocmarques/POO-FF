package br.unb.cic.imdb.negocio;

public class Avaliacao {
	private String comentario;
	private Classificacao classificacao;
	
	private enum Classificacao{
		ZERO ,UM, DOIS, TRES, QUATRO, CINCO;
	};
	
	public Avaliacao(String comentario, Classificacao classificacao){
		this.comentario = comentario;
		this.classificacao = classificacao;
		
	}	
	
}
