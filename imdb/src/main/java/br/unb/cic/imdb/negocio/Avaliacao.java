package br.unb.cic.imdb.negocio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Avaliacao {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String comentario;

	@Column
	private Classificacao classificacao;
	
	@ManyToOne
	private TrabalhoArtistico trabalhoAvaliado;
	
	@ManyToOne
	private Usuario usuario;
	
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Classificacao getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(Classificacao classificacao) {
		this.classificacao = classificacao;
	}

	public TrabalhoArtistico getTrabalhoAvaliado() {
		return trabalhoAvaliado;
	}

	public void setTrabalhoAvaliado(TrabalhoArtistico trabalhoAvaliado) {
		this.trabalhoAvaliado = trabalhoAvaliado;
	}

	public long getId() {
		return id;
	}
	
	public Avaliacao(){
		
	}
	
	public Avaliacao(String comentario, Classificacao classificacao, TrabalhoArtistico trabalhoAvaliado, Usuario usuario){
		this.classificacao = classificacao;
		this.comentario = comentario;
		this.trabalhoAvaliado = trabalhoAvaliado;
		this.usuario = usuario;
	}
	public enum Classificacao{
		ZERO ,UM, DOIS, TRES, QUATRO, CINCO;
	};
	
	public Avaliacao(String comentario, Classificacao classificacao){
		this.comentario = comentario;
		this.classificacao = classificacao;
		
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	
	
}
