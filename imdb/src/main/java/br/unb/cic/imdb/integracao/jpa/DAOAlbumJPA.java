package br.unb.cic.imdb.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.imdb.integracao.DAOAlbum;
import br.unb.cic.imdb.negocio.Album;
import br.unb.cic.imdb.negocio.Autor;
import br.unb.cic.imdb.negocio.Faixa;
import br.unb.cic.imdb.negocio.Genero;
import br.unb.cic.imdb.negocio.IMDBFacade;
import br.unb.cic.imdb.negocio.TrabalhoArtistico;
import br.unb.cic.imdb.util.ContextoID;

public class DAOAlbumJPA implements DAOAlbum{

	private EntityManager em;

	@Override
	public void salvar(Album album) {
		IMDBFacade facade = ContextoID.instance().facade();
		
		try{
			facade.recuperaAutorPorNome(album.getAutor().getNome());
		}	
		catch(IllegalArgumentException ex){
			facade.salvarAutor(album.getAutor());
		}
		
		try{
			facade.recuperarGeneroPorTitulo(album.getGenero().getTitulo());
		}	
		catch(IllegalArgumentException ex){
			facade.adicionaGenero(album.getGenero());
		}
	
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(album);
		em.getTransaction().commit();
	}

	@Override
	public List<Album> recuperaTodos() {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Album").getResultList();
	}

	@Override
	public Album recuperaPorNome(String nome) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Album> trabArt = em.createQuery("FROM Album WHERE titulo = :nomeParam").setParameter("nomeParam", nome).getResultList();
		return trabArt.size() == 1 ? trabArt.get(0): null;
	}

	@Override
	public List<Album> recuperaPorAutor(String autor) {
		IMDBFacade facade = ContextoID.instance().facade();
		Autor autorObj = facade.recuperaAutorPorNome(autor);
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Album WHERE autor = :autorParam").setParameter("autorParam", autorObj).getResultList();
	}

	@Override
	public List<Album> recuperaPorGenero(String genero) {
		IMDBFacade facade = ContextoID.instance().facade();
		Genero generoObj = facade.recuperarGeneroPorTitulo(genero);
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Album WHERE genero = :generoParam").setParameter("generoParam", generoObj).getResultList();
	}

	@Override
	public List<Album> recuperaPorAno(int ano) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		return em.createQuery("FROM Album WHERE ano = :anoParam").setParameter("anoParam", ano).getResultList();
	}

}
