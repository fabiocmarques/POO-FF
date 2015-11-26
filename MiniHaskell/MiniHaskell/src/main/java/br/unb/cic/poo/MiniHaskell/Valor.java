package br.unb.cic.poo.MiniHaskell;

/**
 * Classe abstrata que representa a nocao de um valor 
 * na linguagem de programacao MiniHaskell. 
 * 
 * @author rbonifacio
 */
public abstract class Valor implements Expressao {
	public Valor avaliar() {
		return this;
	}
}
