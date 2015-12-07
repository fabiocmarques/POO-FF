package br.unb.cic.poo.MiniHaskell.visitors;

import br.unb.cic.poo.MiniHaskell.ExpressaoIgual;
import br.unb.cic.poo.MiniHaskell.ExpressaoLet;
import br.unb.cic.poo.MiniHaskell.ExpressaoMaior;
import br.unb.cic.poo.MiniHaskell.ExpressaoMaiorOuIgual;
import br.unb.cic.poo.MiniHaskell.ExpressaoMenor;
import br.unb.cic.poo.MiniHaskell.ExpressaoMenorOuIgual;
import br.unb.cic.poo.MiniHaskell.ExpressaoMultiplicacao;
import br.unb.cic.poo.MiniHaskell.ExpressaoSoma;
import br.unb.cic.poo.MiniHaskell.IfThenElse;
import br.unb.cic.poo.MiniHaskell.InserirNaLista;
import br.unb.cic.poo.MiniHaskell.ListaValorada;
import br.unb.cic.poo.MiniHaskell.ListaVazia;
import br.unb.cic.poo.MiniHaskell.RecuperaElemento;
import br.unb.cic.poo.MiniHaskell.TamanhoLista;
import br.unb.cic.poo.MiniHaskell.ValorBooleano;
import br.unb.cic.poo.MiniHaskell.ValorElementoLista;
import br.unb.cic.poo.MiniHaskell.ValorInteiro;

public interface Visitor {
	public void visitar(ExpressaoMaiorOuIgual exp);
	public void visitar(ExpressaoMenorOuIgual exp);
	public void visitar(ExpressaoMaior exp);
	public void visitar(ExpressaoMenor exp);
	public void visitar(ExpressaoIgual exp);
	public void visitar(ExpressaoMultiplicacao exp);
	public void visitar(ValorInteiro exp);
	public void visitar(ValorBooleano exp);
	public void visitar(ExpressaoSoma exp);
	public void visitar(IfThenElse exp);
	public void visitar(ExpressaoLet exp);
	public void visitar(InserirNaLista exp);
	public void visitar(ListaValorada exp);
	public void visitar(ListaVazia exp);
	public void visitar(RecuperaElemento exp);
	public void visitar(TamanhoLista exp);
	public void visitar(ValorElementoLista exp);
	public void init();
}
