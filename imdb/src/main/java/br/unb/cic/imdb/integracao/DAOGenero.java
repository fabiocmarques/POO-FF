package br.unb.cic.imdb.integracao;

import java.util.List;

import br.unb.cic.imdb.negocio.Genero;

/**
 * Define os metodos para manipular um 
 * Genero na camad de persistencia. 
 * 
 * @author rbonifacio
 */
public interface DAOGenero {
	public void salvar(Genero genero);
	public List<Genero> recuperaTodos();
	public Genero recuperaPorTitulo(String titulo);
}
