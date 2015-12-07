package br.unb.cic.imdb.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@AttributeOverrides({
@AttributeOverride(name="titulo", column=@Column),
@AttributeOverride(name="anoProducao", column=@Column),
@AttributeOverride(name="genero", column=@Column(name = "genero_id")),
@AttributeOverride(name="autor", column=@Column(name = "autor_id"))
})

public class Album extends TrabalhoArtistico{
	
	@OneToMany(mappedBy = "albumQuePertence")
	private List<Faixa> faixas;

	public Album(){}
	
	public Album(String titulo, int ano, Genero genero, Autor autor){
		super(titulo, ano, genero, autor);
		faixas = new ArrayList<Faixa>();
	}
	
	public List<Faixa> getFaixas() {
		return faixas;
	}

	public void setFaixas(List<Faixa> faixas) {
		this.faixas = faixas;
	}

	public void imprime() {
		System.out.println("Título: " + this.getTitulo());
		System.out.println("Ano: " + this.getAno());
		System.out.println("Artista: " + this.getAutor().getNome());
		System.out.println("Gênero: " + this.getGenero().getTitulo());
		
		System.out.println("\nFaixas\n");
		
		int i = 1;
		for(Faixa faixa : faixas){
			System.out.println(i + " - " + faixa.getTitulo());
		}
		
		System.out.println("");
	}
}
