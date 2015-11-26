package br.unb.cic.imdb.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.imdb.integracao.DAOAutor;
import br.unb.cic.imdb.negocio.Autor;

public class DAOAutorJPA implements DAOAutor{
	
	private EntityManager em;

	@Override
	public void salvar(Autor autor) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(autor);
		em.getTransaction().commit();
	}

	@Override
	public List<Autor> recuperaTodos() {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Autor").getResultList();
	}

	@Override
	public Autor recuperaPorNome(String nome) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Autor> autor = em.createQuery("FROM Autor WHERE nome = :nomeParam").setParameter("nomeParam", nome).getResultList();
		return autor.size() == 1 ? autor.get(0): null;
	}

}
