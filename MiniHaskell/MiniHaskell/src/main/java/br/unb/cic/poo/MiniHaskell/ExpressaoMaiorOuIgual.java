package br.unb.cic.poo.MiniHaskell;

public class ExpressaoMaiorOuIgual extends ExpressaoBinInt{

	public ExpressaoMaiorOuIgual(Expressao lhs, Expressao rhs) {
		super(lhs, rhs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Valor avaliar(Integer x, Integer y) {
		return new ValorBooleano(x >= y);
	}

}
