package br.unb.cic.imdb.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.imdb.integracao.DAOFilme;
import br.unb.cic.imdb.negocio.Autor;
import br.unb.cic.imdb.negocio.Filme;
import br.unb.cic.imdb.negocio.Genero;
import br.unb.cic.imdb.negocio.IMDBFacade;
import br.unb.cic.imdb.negocio.TrabalhoArtistico;
import br.unb.cic.imdb.util.*;

public class DAOFilmeJPA implements DAOFilme {


	private EntityManager em;

	@Override
	public void salvar(Filme filme) {
		IMDBFacade facade = ContextoID.instance().facade();
		
		try{
			facade.recuperaAutorPorNome(filme.getAutor().getNome());
		}	
		catch(IllegalArgumentException ex){
			facade.salvarAutor(filme.getAutor());
		}
		
		try{
			facade.recuperarGeneroPorTitulo(filme.getGenero().getTitulo());
		}	
		catch(IllegalArgumentException ex){
			facade.adicionaGenero(filme.getGenero());
		}
		
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(filme);
		em.getTransaction().commit();
	}

	@Override
	public List<Filme> recuperaTodos() {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Filme").getResultList();
	}

	@Override
	public Filme recuperaPorNome(String nome) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Filme> trabArt = em.createQuery("FROM Filme WHERE titulo = :nomeParam").setParameter("nomeParam", nome).getResultList();
		return trabArt.size() == 1 ? trabArt.get(0): null;
	}

	@Override
	public List<Filme> recuperaPorAutor(String autor) {
		IMDBFacade facade = ContextoID.instance().facade();
		Autor autorObj = facade.recuperaAutorPorNome(autor);
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Filme WHERE autor = :autorParam").setParameter("autorParam", autorObj).getResultList();
	}

	@Override
	public List<Filme> recuperaPorGenero(String genero) {
		IMDBFacade facade = ContextoID.instance().facade();
		Genero generoObj = facade.recuperarGeneroPorTitulo(genero);
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Filme WHERE genero = :generoParam").setParameter("generoParam", generoObj).getResultList();
	}

	@Override
	public List<Filme> recuperaPorAno(int ano) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Filme WHERE ano = :anoParam").setParameter("anoParam", ano).getResultList();
	}
}
