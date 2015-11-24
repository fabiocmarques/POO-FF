package br.unb.cic.imdb.negocio;

import br.unb.cic.imdb.util.ContextoID;
import junit.framework.TestCase;

public class IMDBFacadeTest extends TestCase {

	public void testeAdicionaGenero() {
		try {
			IMDBFacade facade = ContextoID.instance().facade();
		
			Genero novoGenero = new Genero("Rock", "Ok... bem melhor!"); 
		
			int quantidadeGeneros = facade.recuperarGeneros().size();
		
			facade.adicionaGenero(novoGenero);
		
			Genero resultadoConsulta = facade.recuperarPorTitulo("Rock");
		
			assertEquals(quantidadeGeneros+1, facade.recuperarGeneros().size());
			assertNotNull(resultadoConsulta);		
		}
		catch(Throwable t) {
			t.printStackTrace();
			fail();
		}
	}
}
