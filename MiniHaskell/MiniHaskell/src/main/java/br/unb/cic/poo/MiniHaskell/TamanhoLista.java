package br.unb.cic.poo.MiniHaskell;

import br.unb.cic.poo.MiniHaskell.visitors.Visitor;

public class TamanhoLista extends Expressao{
	Expressao listaExp;
	int tam;
	
	public TamanhoLista(Expressao listaExp) {
		this.listaExp = listaExp;
	}
	
	public int getTam(){
		return tam;
	}
	
	@Override
	public Valor avaliar() {
		if(listaExp.avaliar().tipo().equals(Tipo.LISTA)){
			for(Lista lista = (Lista)listaExp.avaliar(); !lista.IsEmptyList(); lista = ((ListaValorada)lista).next()){
				tam++;
			}
			return new ValorInteiro(tam);
		}
		else{
			throw new RuntimeException("Lista inválida em expressao TamanhoLista");
		}
	}

	@Override
	public boolean checarTipo() {
		Valor lista = listaExp.avaliar();
		
		return lista.checarTipo() && lista.tipo().equals(Tipo.LISTA);
	}

	@Override
	public Tipo tipo() {
		if(!checarTipo()){
			return Tipo.ERROR;
		}
		return Tipo.INTEIRO;
	}
	
	public Expressao getListaExp(){
		return listaExp;
	}
	
	public void aceitar(Visitor v) {
		v.visitar(this);
	}
	
}
