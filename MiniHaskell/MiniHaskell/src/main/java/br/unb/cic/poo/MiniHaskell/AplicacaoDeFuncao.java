package br.unb.cic.poo.MiniHaskell;

import java.util.ArrayList;
import java.util.List;

import br.unb.cic.poo.MiniHaskell.visitors.Visitor;

public class AplicacaoDeFuncao extends Expressao{

	private String nome; 
	private List<Expressao> argumentos;
	
	public AplicacaoDeFuncao(String nome,  List<Expressao> argumentos){
		this.nome = nome;
		this.argumentos = argumentos;
	}

	public Valor avaliar() {
		DecFuncao funcao = AmbienteExecucao.getInstance().consultaFuncao(nome);
		//primeiro passo: empilhar o ambiente de execucao
		//associando os argumentos aos parametros formais 
		//da declaracao de funcao. 
		
		ArrayList<Expressao> argumentosAux = new ArrayList<Expressao>();
		
		for(Expressao exp : argumentos){
			argumentosAux.add(exp.avaliar());
		}
		
		AmbienteExecucao.getInstance().push();
		for(int i = 0; i < argumentos.size(); i++) {
			AmbienteExecucao.getInstance().declaraVariavel(funcao.getArgumentos().get(i), argumentosAux.get(i));
		}
		
		//segundo passo: avaliar o corpo da funcao e 
		//desempilhar. 
		
		Valor res = funcao.getCorpo().avaliar();
		AmbienteExecucao.getInstance().pop();
		return res;
	}

	public boolean checarTipo() {
		return !tipo().equals(Tipo.ERROR);
	}

	public Tipo tipo() {
		DecFuncao funcao = AmbienteExecucao.getInstance().consultaFuncao(nome);
		if(funcao == null){
			return Tipo.ERROR;
		}
		return this.avaliar().tipo();
	}

	public void aceitar(Visitor v) {
		// TODO Auto-generated method stub
		
	}

}
