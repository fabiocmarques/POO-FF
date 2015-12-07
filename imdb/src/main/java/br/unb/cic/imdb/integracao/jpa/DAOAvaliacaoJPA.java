package br.unb.cic.imdb.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.imdb.integracao.DAOAvaliacao;
import br.unb.cic.imdb.negocio.Autor;
import br.unb.cic.imdb.negocio.Avaliacao;
import br.unb.cic.imdb.negocio.IMDBFacade;
import br.unb.cic.imdb.negocio.TrabalhoArtistico;
import br.unb.cic.imdb.util.ContextoID;

public class DAOAvaliacaoJPA implements DAOAvaliacao{
	EntityManager em;
	
	@Override
	public void salvarAvaliacao(Avaliacao avaliacao) {
		
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(avaliacao);
		em.getTransaction().commit();
	}

	@Override
	public Avaliacao recuperaAvaliacao(String trabArt) {
		IMDBFacade facade = ContextoID.instance().facade();

		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Avaliacao> aval = em.createQuery("FROM Avaliacao WHERE trabalhoAvaliado = :nomeParam").setParameter("nomeParam", trabArt).getResultList();
		return aval.size() == 1 ? aval.get(0): null;
	}

}
