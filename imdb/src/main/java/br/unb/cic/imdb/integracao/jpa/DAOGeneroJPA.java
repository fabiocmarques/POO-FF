package br.unb.cic.imdb.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.imdb.integracao.DAOGenero;
import br.unb.cic.imdb.negocio.Genero;

/**
 * Implementacao da interface DAOGenero usando 
 * a tecnologia JPA, tendo como uma das implementacoes 
 * o Hibernate. 
 * 
 * @author rbonifacio
 */
public class DAOGeneroJPA implements DAOGenero {

	private EntityManager em; 
	
	@Override
	public void salvar(Genero genero) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(genero);
		em.getTransaction().commit();
	}

	@Override
	public List<Genero> recuperaTodos() {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Genero").getResultList();
	}

	@Override
	public Genero recuperaPorTitulo(String titulo) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Genero> generos = em.createQuery("FROM Genero WHERE titulo = :tituloParam").setParameter("tituloParam", titulo).getResultList();
		return generos.size() == 1 ? generos.get(0): null;
	}
}
