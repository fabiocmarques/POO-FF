package br.unb.cic.imdb.integracao.memoria;

import java.util.ArrayList;
import java.util.List;

import br.unb.cic.imdb.integracao.DAOGenero;
import br.unb.cic.imdb.negocio.Genero;

/**
 * Implementacao do DAOGenero em memoria. Util 
 * particularmente para as situacoes em que queremos 
 * testar individualmente as classes, sem a necessidade 
 * de manipular uma base de dados. 
 * 
 * @author rbonifacio
 */
public class DAOGeneroMemoria implements DAOGenero {

	//nessa simulacao, todos os generos sao mantidos em uma lista
	private List<Genero> generos;
	
	public DAOGeneroMemoria() {
		generos = new ArrayList<>();
	}
	
	@Override
	public void salvar(Genero genero) {
		generos.add(genero);
	}

	@Override
	public List<Genero> recuperaTodos() {
		return generos;
	}

	@Override
	public Genero recuperaPorTitulo(String titulo) {
		//simplificar usando uma expressao Lambda. 
		for(Genero genero : generos) {
			if(genero.getTitulo().equals(titulo)) {
				return genero;
			}
		}
		return null;
		//Usando expressoes Lambda. 
		//List<Genero> res = generos.stream().filter(g -> g.getTitulo().equals(titulo)).collect(Collectors.toList());
		//return res.size() == 1 ? res.get(0) : null;
	}
}
