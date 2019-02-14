package br.com.vendas.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.vendas.DAO.FornecedoresDAO;
import br.com.vendas.domain.Fornecedor;

public class FornecedorDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		
		Fornecedor f1 = new Fornecedor();		
		f1.setDescricao("Fornecedor D");
		
		FornecedoresDAO fdao = new FornecedoresDAO();
		fdao.salvar(f1);
		
	}
	
	@Test
	@Ignore
	public void listar(){
	
		FornecedoresDAO fdao = new FornecedoresDAO();
		List<Fornecedor> fornecedores = fdao.listar();
		
		for(Fornecedor fornecedor : fornecedores){
			System.out.println(fornecedor);
		}
		
	}
	
	@Test
	public void buscarPorCodigo(){
	
		FornecedoresDAO fdao = new FornecedoresDAO();
		Fornecedor f1 = fdao.buscarPorCodigo(3L);
		
			System.out.println(f1);

		
	}

}
