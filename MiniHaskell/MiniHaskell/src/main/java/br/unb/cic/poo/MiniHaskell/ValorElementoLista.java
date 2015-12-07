package br.unb.cic.poo.MiniHaskell;

import br.unb.cic.poo.MiniHaskell.visitors.Visitor;

public class ValorElementoLista extends Expressao {
	Expressao listaExp;
	
	public ValorElementoLista(Expressao listaExp) {
		this.listaExp = listaExp;
	}
	
	public Expressao getListaExp(){
		return listaExp;
	}
	
	@Override
	public Valor avaliar() {
		Lista lista = (Lista) listaExp.avaliar(); 
		
		if(lista.IsEmptyList())
			return new ListaVazia();
		else
			return ((ListaValorada)lista).valor();
	}

	@Override
	public boolean checarTipo() {
		return listaExp.avaliar().tipo().equals(Tipo.LISTA);
	}

	@Override
	public Tipo tipo() {
		Lista lista = (Lista) listaExp.avaliar();
		return lista.IsEmptyList() ? Tipo.LISTA : ((ListaValorada)lista).valor().tipo();
	}
	
	public void aceitar(Visitor v) {
		v.visitar(this);
	}

}
