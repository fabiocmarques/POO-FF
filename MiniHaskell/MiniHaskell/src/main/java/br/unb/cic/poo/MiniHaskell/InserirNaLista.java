package br.unb.cic.poo.MiniHaskell;

public class InserirNaLista extends Expressao {
	Expressao listaExp;
	Valor valorInserido;
	
	public InserirNaLista(Valor valor, Expressao listaExp) {
		if(listaExp == null){
			throw new RuntimeException("Erro de lista vazia");
		}
		this.listaExp = listaExp;
		this.valorInserido = valor;
	}
	
	@Override
	public Valor avaliar() {
		Expressao lista = listaExp.avaliar();
		if(lista instanceof Lista){
			Lista novaLista = new ListaValorada(valorInserido, (Lista)lista);
			if(novaLista.checarTipo() == false){
				throw new RuntimeException("Erro ao inserir na lista");
			}
			return novaLista;
		}
		else{
			throw new RuntimeException("Argumento de criação de lista inválido");
		}
	}

	@Override
	public boolean checarTipo() {
		Expressao lista = listaExp.avaliar();
		if(lista.tipo().equals(Tipo.LISTA)){
			return lista.checarTipo() &&
					(((Lista)lista).IsEmptyList() || (valorInserido.tipo().equals(((ListaValorada)lista).valor())));
		}
		else{
			return false;
		}
	}

	@Override
	public Tipo tipo() {
		return Tipo.LISTA;
	}
}
