package br.unb.cic.poo.MiniHaskell;

import java.util.List;

import br.unb.cic.poo.MiniHaskell.visitors.Visitor;

public class AplicacaoDeFuncao implements Expressao{

	private String nome; 
	private List<Expressao> argumentos;
	
	public Valor avaliar() {
		DecFuncao funcao = AmbienteExecucao.getInstance().consultaFuncao(nome);
		//primeiro passo: empilhar o ambiente de execucao
		//associando os argumentos aos parametros formais 
		//da declaracao de funcao. 
		
		AmbienteExecucao.getInstance().push();
		for(int i = 0; i < argumentos.size(); i++) {
			AmbienteExecucao.getInstance().declaraVariavel(funcao.getArgumentos().get(i), argumentos.get(i));
		}
		
		//segundo passo: avaliar o corpo da funcao e 
		//desempilhar. 
		
		Valor res = funcao.getCorpo().avaliar();
		AmbienteExecucao.getInstance().pop();
		return res;
	}

	public boolean checarTipo() {
		// TODO Auto-generated method stub
		return false;
	}

	public Tipo tipo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void aceitar(Visitor v) {
		// TODO Auto-generated method stub
		
	}

}
