package br.unb.cic.imdb.integracao;

import java.util.List;

import br.unb.cic.imdb.negocio.TrabalhoArtistico;

public interface DAOTrabArt {
	public void salvar(TrabalhoArtistico trabalhoArtistico);
	public List<TrabalhoArtistico> recuperaTodos();
	public TrabalhoArtistico recuperaPorNome(String nome);
	public List<TrabalhoArtistico> recuperaPorAutor(String autor);
	public List<TrabalhoArtistico> recuperaPorGenero(String genero);
	public List<TrabalhoArtistico> recuperaPorAno(int ano);
}
