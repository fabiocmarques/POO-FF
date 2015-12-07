package br.unb.cic.imdb.integracao.jpa;

import javax.persistence.EntityManager;

import br.unb.cic.imdb.integracao.DAOFaixa;
import br.unb.cic.imdb.negocio.Faixa;

public class DAOFaixaJPA implements DAOFaixa{
	EntityManager em;
	
	@Override
	public void salvaFaixa(Faixa faixa) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(faixa);
		em.getTransaction().commit();	
	}

}
