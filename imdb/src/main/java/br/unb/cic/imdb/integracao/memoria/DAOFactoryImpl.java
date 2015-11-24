package br.unb.cic.imdb.integracao.memoria;

import br.unb.cic.imdb.integracao.DAOFactory;
import br.unb.cic.imdb.integracao.DAOGenero;

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
	
}
