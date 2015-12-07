package br.unb.cic.imdb.integracao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.unb.cic.imdb.integracao.jpa.EMFactoryHelper;
import junit.framework.TestCase;

public class FactoryTest extends TestCase{

	public void testFactory() {
		try {
			EntityManager em = EMFactoryHelper.instance().getFactory().createEntityManager();
			em.close();
			EMFactoryHelper.instance().getFactory().close();
			assertTrue(true);
		}
		catch(Throwable t) {
			t.printStackTrace();
			fail(t.getMessage());
		}
	}
}
