package br.unb.cic.imdb.integracao;

import java.util.List;

import br.unb.cic.imdb.negocio.Album;
import br.unb.cic.imdb.negocio.Filme;
import br.unb.cic.imdb.negocio.TrabalhoArtistico;

public interface DAOFilme {
	public void salvar(Filme filme);
	public List<Filme> recuperaTodos();
	public Filme recuperaPorNome(String nome);
	public List<Filme> recuperaPorAutor(String autor);
	public List<Filme> recuperaPorGenero(String genero);
	public List<Filme> recuperaPorAno(int ano);
}
