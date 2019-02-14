package br.com.vendas.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.vendas.domain.Fornecedor;
import br.com.vendas.util.HibernateUtil;

public class FornecedoresDAO {

	// Salvar registro
	public void salvar(Fornecedor fornecedor) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();// abre a transa��o
			sessao.save(fornecedor);
			transacao.commit();

		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();// desfaz a transa��o

			}

		} finally {
			sessao.close();
		}

	}

	@SuppressWarnings("unchecked")
	public List<Fornecedor> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Fornecedor> fornecedores = null;

		try {

			Query consulta = sessao.getNamedQuery("Fornecedor.listar");
			fornecedores = consulta.list();

		} catch (RuntimeException ex) {
			throw ex;
		}

		finally {
			sessao.close();
		}

		return fornecedores;

	}
	
	public Fornecedor buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Fornecedor fornecedor = null;

		try {

			Query consulta = sessao.getNamedQuery("Fornecedor.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			fornecedor = (Fornecedor) consulta.uniqueResult();
			
		} catch (RuntimeException ex) {
			throw ex;
		}

		finally {
			sessao.close();
		}

		return fornecedor;

	}

}
