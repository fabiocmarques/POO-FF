package br.unb.cic.imdb.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.imdb.integracao.DAOTrabArt;
import br.unb.cic.imdb.negocio.Autor;
import br.unb.cic.imdb.negocio.TrabalhoArtistico;;

public class DAOTrabArtJPA implements DAOTrabArt{
	
	private EntityManager em;

	@Override
	public void salvar(TrabalhoArtistico trabalhoArtistico) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(trabalhoArtistico);
		em.getTransaction().commit();
	}

	@Override
	public List<TrabalhoArtistico> recuperaTodos() {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM TrabalhoArtistico").getResultList();
	}

	@Override
	public TrabalhoArtistico recuperaPorNome(String nome) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<TrabalhoArtistico> trabArt = em.createQuery("FROM TrabalhoArtistico WHERE titulo = :nomeParam").setParameter("nomeParam", nome).getResultList();
		return trabArt.size() == 1 ? trabArt.get(0): null;
	}

	@Override
	public List<TrabalhoArtistico> recuperaPorAutor(String autor) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM TrabalhoArtistico WHERE autor = :autorParam").setParameter("autorParam", autor).getResultList();
	}

	@Override
	public List<TrabalhoArtistico> recuperaPorGenero(String genero) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM TrabalhoArtistico WHERE genero = :generoParam").setParameter("generoParam", genero).getResultList();
	}

	@Override
	public List<TrabalhoArtistico> recuperaPorAno(int ano) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM TrabalhoArtistico WHERE ano = :anoParam").setParameter("anoParam", ano).getResultList();
	}

}
