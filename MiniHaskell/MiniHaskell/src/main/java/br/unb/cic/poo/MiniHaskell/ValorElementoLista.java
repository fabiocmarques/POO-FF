package br.unb.cic.poo.MiniHaskell;

public class ValorElementoLista extends Expressao {
	Expressao listaExp;
	
	public ValorElementoLista(Expressao listaExp) {
		this.listaExp = listaExp;
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

}
