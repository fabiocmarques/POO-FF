package br.unb.cic.imdb.negocio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Faixa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String titulo;
	
	@Column
	private int duracao;
	
	@ManyToOne
	private Album albumQuePertence;
	
	public Faixa(){}
	
	public Faixa(String titulo, int duracao, Album albumQuePertence){
		this.titulo = titulo;
		this.duracao = duracao;
		this.albumQuePertence = albumQuePertence;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}



	public Album getAlbumQuePertence() {
		return albumQuePertence;
	}



	public void setAlbumQuePertence(Album albumQuePertence) {
		this.albumQuePertence = albumQuePertence;
	}
}
