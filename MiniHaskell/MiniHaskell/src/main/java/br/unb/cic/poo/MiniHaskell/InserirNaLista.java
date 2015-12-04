package br.unb.cic.poo.MiniHaskell;

public class InserirNaLista extends Expressao {
	Lista lista;
	Valor valorInserido;
	
	@Override
	public Valor avaliar() {
		Lista novaLista = new ListaValorada(valorInserido, lista);
		if(novaLista.checarTipo() == false){
			throw new RuntimeException();
		}
		
		return novaLista;
	}

	@Override
	public boolean checarTipo() {
		return lista.checarTipo() && (lista.IsEmptyList() || ((ListaValorada)lista).valor().tipo().equals(valorInserido.tipo()));
	}

	@Override
	public Tipo tipo() {
		return Tipo.LISTA;
	}
}
