package br.unb.cic.imdb.integracao.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Padrao recorrente para obter entity managers 
 * em aplicacoes que usam o Hibernate. 
 * 
 * @author rbonifacio
 */
public class EMFactoryHelper {

    private EntityManagerFactory factory;
    private static EMFactoryHelper instance;
    
    private EMFactoryHelper() {
       factory = Persistence.createEntityManagerFactory("imdb");
    }
    
    public static EMFactoryHelper instance() {
    		if(instance == null) {
    			instance = new EMFactoryHelper();
    		}
    		return instance;
    }
    
    public EntityManagerFactory getFactory() {
        return factory;
    }

}