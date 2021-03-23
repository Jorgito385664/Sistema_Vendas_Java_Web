package br.com.VendasJG.test;

import org.junit.Test;

import br.com.VendasJG.util.HibernateUtil;

public class GerarTabelasTest {
	
	@Test
	public void gerar() {
	HibernateUtil.getSessionFactory();
	HibernateUtil.getSessionFactory().close();
	}
}
