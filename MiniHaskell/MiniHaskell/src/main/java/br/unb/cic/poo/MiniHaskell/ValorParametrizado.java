package br.unb.cic.poo.MiniHaskell;

/**
 * Classe abstrata que possibilita termos valores de 
 * diferentes tipos, de acordo com o parametro T. 
 * 
 * @author rbonifacio
 *
 * @param <T> tipo do valor 
 */
public abstract class ValorParametrizado<T> extends Valor {

	private T valor;
	
	public ValorParametrizado(T valor) {
		this.valor = valor;
	}
	
	public boolean checarTipo() {
		return true;
	}
	
	public T getValor() {
		return valor;
	}
}
