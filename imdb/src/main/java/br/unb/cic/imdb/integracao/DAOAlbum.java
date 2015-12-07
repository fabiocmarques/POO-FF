package br.unb.cic.imdb.integracao;

import java.util.List;

import br.unb.cic.imdb.negocio.Album;
import br.unb.cic.imdb.negocio.TrabalhoArtistico;

public interface DAOAlbum {
	public void salvar(Album Album);
	public List<Album> recuperaTodos();
	public Album recuperaPorNome(String nome);
	public List<Album> recuperaPorAutor(String autor);
	public List<Album> recuperaPorGenero(String genero);
	public List<Album> recuperaPorAno(int ano);
}
