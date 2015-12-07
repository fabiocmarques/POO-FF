package br.unb.cic.poo.MiniHaskell;

import br.unb.cic.poo.MiniHaskell.visitors.Visitor;

public class ListaValorada extends Lista {

	private Valor valor;
	private Lista next;
	
	public ListaValorada(Valor valor, Lista next) {
		this.valor = valor;
		this.next = next;
	}
	
	@Override
	public boolean IsEmptyList() {
		return false;
	}

	@Override
	public boolean checarTipo() {
		if(next.checarTipo()){
			return next.IsEmptyList() || ((ListaValorada) next).valor().tipo().equals(valor.tipo());
		}
		
		return false;
	}
	
	public Valor valor(){
		return valor;
	}
	
	public Lista next(){
		return next;
	}

	public void setNext(Lista next){
		this.next = next;
	}
	
	public void setValor(Valor valor){
		this.valor = valor;
	}
	
	public void aceitar(Visitor v) {
		v.visitar(this);
	}
	
	
}
