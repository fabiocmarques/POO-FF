package br.unb.cic.poo.MiniHaskell;

import java.util.HashMap;
import java.util.Stack;

public class AmbienteExecucao {

	private Stack<HashMap<String, Expressao>> ambiente;
	private HashMap<String, DecFuncao> funcoes;
	
	private static AmbienteExecucao instance; 
	
	private AmbienteExecucao() {
		ambiente = new Stack<HashMap<String,Expressao>>();
		funcoes = new HashMap<String, DecFuncao>();
	}
	
	public static AmbienteExecucao getInstance() {
		if(instance == null) {
			instance = new AmbienteExecucao();
		}
		return instance;
	}
	
	public void declaraVariavel(String nome, Expressao exp) {
		ambiente.peek().put(nome, exp);
	}
	
	public void declaraFuncao(DecFuncao funcao) {
		funcoes.put(funcao.getNome(), funcao);
	}
	
	public Expressao consultaReferencia(String nome) {
		int top = ambiente.size()-1;
		for(int i = top; i >= 0; i--) {
			if(ambiente.get(i).containsKey(nome)) {
				return ambiente.get(i).get(nome);
			}
		}
		return null;
	}
	
	public DecFuncao consultaFuncao(String nome) {
		return funcoes.get(nome);
	}
 	
	public void push() {
		ambiente.push(new HashMap<String, Expressao>());
	}
	
	public void pop() {
		ambiente.pop();
	}
}
