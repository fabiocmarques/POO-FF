package br.unb.cic.imdb.integracao.jpa;

import br.unb.cic.imdb.integracao.DAOFactory;
import br.unb.cic.imdb.integracao.DAOGenero;

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
}
