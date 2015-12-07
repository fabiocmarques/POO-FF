package br.unb.cic.imdb.integracao;

import br.unb.cic.imdb.negocio.Usuario;

public interface DAOUsuario {
	public Usuario recuperaUsuario(String login);
	public void salvaUsuario(Usuario usuario);
}
