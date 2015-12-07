package br.unb.cic.imdb.integracao.jpa;

import br.unb.cic.imdb.integracao.DAOAlbum;
import br.unb.cic.imdb.integracao.DAOAutor;
import br.unb.cic.imdb.integracao.DAOFactory;
import br.unb.cic.imdb.integracao.DAOFilme;
import br.unb.cic.imdb.integracao.DAOGenero;
import br.unb.cic.imdb.integracao.DAOTrabArt;

/**
 * Implementacao da classe abstrata DAOFactory 
 * com persistencia via JPA. 
 * 
 * @author rbonifacio
 */
public class DAOFactoryImpl extends DAOFactory {
	@Override
	public DAOGenero createDAOGenero() {
		return new DAOGeneroJPA();
	}

	@Override
	public DAOFilme createDAOFilme() {
		return new DAOFilmeJPA();
	}

	@Override
	public DAOAlbum createDAOAlbum() {
		return new DAOAlbumJPA();
	}

	@Override
	public DAOTrabArt createDAOTrabalhoArtistico() {
		return new DAOTrabArtJPA();
	}

	@Override
	public DAOAutor createDAOAutor() {
		return new DAOAutorJPA();
	}
}
