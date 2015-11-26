package br.unb.cic.poo.MiniHaskell;

import java.util.List;

public class DecFuncao {
	
	private String nome;
	private List<String> argumentos;
	private Expressao corpo;
	
	public DecFuncao(String nome, List<String> argumentos, Expressao corpo) {
		this.nome = nome;
		this.argumentos = argumentos;
		this.corpo = corpo;
	}

	public String getNome() {
		return nome;
	}

	public List<String> getArgumentos() {
		return argumentos;
	}

	public Expressao getCorpo() {
		return corpo;
	}

	
	
}
