package br.unb.cic.poo.MiniHaskell;

import br.unb.cic.poo.MiniHaskell.visitors.Visitor;

/**
 * Interface que define as operacoes basicas relacionadas 
 * a manipulacao de expressoes. 
 * 
 * @author rbonifacio
 */
public abstract class Expressao {

	/**
	 * Toda expressao pode ser avaliada, 
	 * retornando um valor correspondente. 
	 * 
	 * @return valor correspondente a expressao
	 */
	public abstract Valor avaliar();
	
	/**
	 * Toda expressao pode estar bem ou mal tipada. 
	 * Expressoes "mal-tipadas" nao deveriam ser avaliadas. 
	 * 
	 * @return <b>true</b> caso a expressao seja bem tipada.
	 */
	public abstract boolean checarTipo();
	
	/**
	 * Retorna o tipo da expressao 
	 * @return .. 
	 */
	public abstract Tipo tipo();
	
	/**
	 * Metodo necessario para que uma expressao 
	 * receba um visitor. 
	 * 
	 * @param v
	 */
	public void aceitar(Visitor v) {
		v.visitar(this);
	}
	
}
