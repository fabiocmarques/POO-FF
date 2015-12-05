package br.unb.cic.poo.MiniHaskell;

public class TamanhoLista extends Expressao{
	Lista lista;
	int tam;
	
	public TamanhoLista(Lista lista) {
		this.lista = lista;
	}
	
	@Override
	public Valor avaliar() {
		
	}

	@Override
	public boolean checarTipo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Tipo tipo() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
