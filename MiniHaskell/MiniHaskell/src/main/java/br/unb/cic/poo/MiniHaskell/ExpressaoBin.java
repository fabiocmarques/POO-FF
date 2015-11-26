package br.unb.cic.poo.MiniHaskell;

public abstract class ExpressaoBin extends Expressao{
	protected Expressao lhs;
	protected Expressao rhs;
	
	public ExpressaoBin(Expressao lhs, Expressao rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
	
	public Expressao lhs() {
		return lhs;
	}
	
	public Expressao rhs() {
		return rhs;
	}
}
