package br.unb.cic.imdb.integracao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import br.unb.cic.imdb.negocio.Filme;
import br.unb.cic.imdb.negocio.Usuario;

public class DAOUsuarioJPA implements br.unb.cic.imdb.integracao.DAOUsuario {

	EntityManager em;
	
	@Override
	public Usuario recuperaUsuario(String login) {
		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		List<Usuario> usuarios = em.createQuery("FROM Usuario WHERE login = :nomeParam").setParameter("nomeParam", login).getResultList();
		return usuarios.size() == 1 ? usuarios.get(0): null;
	}

	@Override
	public void salvaUsuario(Usuario usuario) {

		em = EMFactoryHelper.instance().getFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();

	}

}
