package br.unb.cic.poo.MiniHaskell;

public abstract class ExpressaoBinInt extends ExpressaoBin {

	public ExpressaoBinInt(Expressao lhs, Expressao rhs) {
		super(lhs, rhs);
	}

	public Valor avaliar() {
		Valor x = lhs.avaliar();
		Valor y = rhs.avaliar();
		if ((x instanceof ValorInteiro) && (y instanceof ValorInteiro)) {

			Integer x1 = ((ValorInteiro) x).getValor();
			Integer y1 = ((ValorInteiro) y).getValor();

			return avaliar(x1, y1);
		} else {
			throw new RuntimeException("erro de tipos");
		}
	}
	
	public boolean checarTipo() {
		if(lhs.tipo().equals(Tipo.INTEIRO) && rhs.tipo().equals(Tipo.INTEIRO)) {
			return true;
		}
		return false;
	}

	public Tipo tipo() {
		if(checarTipo()) {
			return Tipo.INTEIRO;
		}
		return Tipo.ERROR;
	}
	
	public abstract Valor avaliar(Integer x, Integer y);
}