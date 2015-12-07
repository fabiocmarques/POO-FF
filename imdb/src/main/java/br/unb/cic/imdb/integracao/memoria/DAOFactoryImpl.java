package br.unb.cic.imdb.integracao.memoria;

import br.unb.cic.imdb.integracao.DAOAlbum;
import br.unb.cic.imdb.integracao.DAOAutor;
import br.unb.cic.imdb.integracao.DAOFactory;
import br.unb.cic.imdb.integracao.DAOFilme;
import br.unb.cic.imdb.integracao.DAOGenero;
import br.unb.cic.imdb.integracao.DAOTrabArt;

/**
 * Implementacao da classe abstrata DAOFactory 
 * com persistencia em memoria. 
 * 
 * @author rbonifacio
 */
public class DAOFactoryImpl extends DAOFactory {

	public DAOFactoryImpl() {
		super();
	} 
	
	public DAOGenero createDAOGenero() {
		return new DAOGeneroMemoria();
	}

	@Override
	public DAOFilme createDAOFilme() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DAOAlbum createDAOAlbum() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DAOTrabArt createDAOTrabalhoArtistico() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DAOAutor createDAOAutor() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
