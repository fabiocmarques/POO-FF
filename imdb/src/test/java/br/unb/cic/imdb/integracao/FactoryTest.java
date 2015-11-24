package br.unb.cic.imdb.integracao;

import javax.persistence.EntityManagerFactory;

import br.unb.cic.imdb.integracao.jpa.EMFactoryHelper;
import junit.framework.TestCase;

public class FactoryTest extends TestCase{

	public void testFactory() {
		try {
			EntityManagerFactory factory = EMFactoryHelper.instance().getFactory();
			assertTrue(true);
		}
		catch(Throwable t) {
			fail(t.getMessage());
		}
	}
}
