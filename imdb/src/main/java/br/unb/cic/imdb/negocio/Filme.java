package br.unb.cic.imdb.negocio;

import java.util.ArrayList;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@AttributeOverrides({
@AttributeOverride(name="titulo", column=@Column),
@AttributeOverride(name="anoProducao", column=@Column),
@AttributeOverride(name="genero", column=@Column(name = "genero_id")),
@AttributeOverride(name="autor", column=@Column(name = "autor_id"))
})

public class Filme extends TrabalhoArtistico{
	
	@Column
	int duracao;

	public Filme(){
		
	}
	
	public Filme(String titulo, int ano, Genero genero, Autor autor, int duracao){
		super(titulo, ano, genero, autor);
		this.duracao = duracao;
	}
	
	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public void imprime() {
		System.out.println("Título: " + this.getTitulo());
		System.out.println("Ano: " + this.getAno());
		System.out.println("Diretor: " + this.getAutor().getNome());
		System.out.println("Gênero: " + this.getGenero().getTitulo());
		System.out.println("Duração: " + this.duracao);
		System.out.println("");
	}
	

}
