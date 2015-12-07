package br.unb.cic.imdb.negocio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.derby.tools.sysinfo;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_TRABALHO_ARTISTICO")
public class TrabalhoArtistico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column
	private String titulo;
	
	@Column
	private int ano;
	
	@ManyToOne
	private Genero genero;
	
	@ManyToOne
	private Autor autor;
	
	@OneToMany(mappedBy = "trabalhoAvaliado")
	private List<Avaliacao> avaliacoes;

	public void mostrarComentarios(){
		for(Avaliacao avaliacao : avaliacoes){
			if(avaliacao.getClassificacao().equals(Avaliacao.Classificacao.ZERO)){
				System.out.println("Avaliacao de " + avaliacao.getUsuario().getLogin() + " - ");
			}
			else if(avaliacao.getClassificacao().equals(Avaliacao.Classificacao.UM)){
				System.out.println("Avaliacao de " + avaliacao.getUsuario().getLogin() + " - *");
			}
			else if(avaliacao.getClassificacao().equals(Avaliacao.Classificacao.DOIS)){
				System.out.println("Avaliacao de " + avaliacao.getUsuario().getLogin() + " - **");
			}
			else if(avaliacao.getClassificacao().equals(Avaliacao.Classificacao.TRES)){
				System.out.println("Avaliacao de " + avaliacao.getUsuario().getLogin() + " - ***");
			}
			else if(avaliacao.getClassificacao().equals(Avaliacao.Classificacao.QUATRO)){
				System.out.println("Avaliacao de " + avaliacao.getUsuario().getLogin() + " - ****");
			}
			else if(avaliacao.getClassificacao().equals(Avaliacao.Classificacao.CINCO)){
				System.out.println("Avaliacao de " + avaliacao.getUsuario().getLogin() + " - *****");
			}
			
			System.out.println("\nComentario de " + avaliacao.getUsuario().getLogin() + " sobre " + this.titulo + ":");
			System.out.println("\t" + avaliacao.getComentario());
			System.out.println("\n-----------------------------------------");
			
		}
	}
	
	public Long getId() {
		return id;
	}

	public TrabalhoArtistico(){
		
	}
	
	public TrabalhoArtistico(String titulo, int ano, Genero genero, Autor autor){
		this.titulo = titulo;
		this.ano = ano;
		this.genero = genero;
		this.autor = autor;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

}
