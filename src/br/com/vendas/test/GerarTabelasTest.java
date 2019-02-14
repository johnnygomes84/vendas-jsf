package br.com.vendas.test;

import org.junit.Test;

import br.com.vendas.util.HibernateUtil;

public class GerarTabelasTest {

	@Test
	public void gerar(){
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}

}
