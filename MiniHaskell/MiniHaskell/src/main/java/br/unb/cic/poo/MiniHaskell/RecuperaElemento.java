package br.unb.cic.poo.MiniHaskell;

public class RecuperaElemento extends Expressao {
	Expressao listaExp;
	Expressao index;
	int posElemento;
	
	int posCorrente;
	Lista lista;
	
	public RecuperaElemento(Expressao index, Expressao listaExp) {
		this.listaExp = listaExp;
		this.index = index;
		this.posCorrente = 0;
	}
	
	@Override
	public Valor avaliar() {
		lista = (Lista)listaExp.avaliar();
		posElemento = ((ValorInteiro)index.avaliar()).getValor();
		return procuraElemento();
	}
	
	public Valor procuraElemento(){
		if(lista.IsEmptyList()){
			return new ListaVazia();
		}
		else if(posCorrente == posElemento){
			return lista;
		}
		else{
			this.lista = ((ListaValorada)lista).next();
			this.posCorrente++;
			return this.procuraElemento();
		}
	}

	@Override
	public boolean checarTipo() {
		return listaExp.avaliar().tipo().equals(Tipo.LISTA) && listaExp.avaliar().checarTipo() && index.avaliar().tipo().equals(Tipo.INTEIRO);
	}

	@Override
	public Tipo tipo() {
		return checarTipo() ? Tipo.LISTA : Tipo.ERROR;
	}

}
