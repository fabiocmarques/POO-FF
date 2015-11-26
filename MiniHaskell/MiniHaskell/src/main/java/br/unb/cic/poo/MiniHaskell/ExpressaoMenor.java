package br.unb.cic.poo.MiniHaskell;

public class ExpressaoMenor extends ExpressaoBinInt{

	public ExpressaoMenor(Expressao lhs, Expressao rhs) {
		super(lhs, rhs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Valor avaliar(Integer x, Integer y) {
		return new ValorBooleano(x < y);
	}

}
