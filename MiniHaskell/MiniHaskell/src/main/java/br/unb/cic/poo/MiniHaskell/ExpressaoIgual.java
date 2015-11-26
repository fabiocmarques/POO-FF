package br.unb.cic.poo.MiniHaskell;

public class ExpressaoIgual extends ExpressaoBin {
	
	
	public ExpressaoIgual(Expressao lhs, Expressao rhs) {
		super(lhs, rhs);
	}
	
	@Override
	public Valor avaliar() {
		Valor resLhs = lhs.avaliar();
		Valor resRhs = rhs.avaliar();
		
		if(resLhs instanceof ValorInteiro && resRhs instanceof ValorInteiro){
			return ((ValorInteiro)resLhs).getValor() == ((ValorInteiro)resRhs).getValor() ? new ValorBooleano(true) : new ValorBooleano(false);
		}
		else if(resLhs instanceof ValorBooleano && resRhs instanceof ValorBooleano){
			return ((ValorBooleano)resLhs).getValor().equals(((ValorBooleano)resRhs).getValor()) ? new ValorBooleano(true) : new ValorBooleano(false);
		}
		else
			return null;
	}

	@Override
	public boolean checarTipo() {
		return rhs.tipo().equals(lhs.tipo());
	}

	@Override
	public Tipo tipo() {
		return Tipo.BOOL;
	}

}
