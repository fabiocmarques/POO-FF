package br.unb.cic.imdb.integracao;

/**
 * Um <i>abstract factory</i> para data access 
 * objects. Consultar a referencia em: 
 * 
 * https://en.wikipedia.org/wiki/Abstract_factory_pattern
 * 
 * Note que sempre eh possivel substituir abstract factories 
 * por injecao de dependencia. Uma alternativa mais flexivel, 
 * por outro lado que requer um maior grau de configuracao. 
 * 
 * @author rbonifacio
 */
public abstract class DAOFactory {
	
	public enum DataBase {
		MEMORIA, 
		SQLDB,
		COUCHDB
	}; 
	
	/* essa eh uma classe singleton */
	private static DAOFactory instance;
	
	/* construtor privado, eh um singleton! */
	protected DAOFactory() {} 
		
	public static DAOFactory instance(DataBase impl) {
		if(instance == null) {
			switch(impl) {
			 case SQLDB : instance = new br.unb.cic.imdb.integracao.jpa.DAOFactoryImpl(); break;
			 case COUCHDB : instance = null; break;
			 case MEMORIA: instance = new br.unb.cic.imdb.integracao.memoria.DAOFactoryImpl();
			}
		}
		return instance;
	}
	
	public abstract DAOGenero createDAOGenero();
}
