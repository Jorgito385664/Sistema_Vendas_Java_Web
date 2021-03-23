package br.com.VendasJG.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.VendasJG.DAO.FornecedoresDAO;
import br.com.VendasJG.domain.Fornecedor;

public class FornecedorDAOTest {
	@Test
	@Ignore
	public void salvar() {
		
		Fornecedor f3 = new Fornecedor();
		Fornecedor f4 = new Fornecedor();
		f3.setDescricao("Pedro Campos");
		f4.setDescricao("Mauro Santos");
		
		FornecedoresDAO dao = new FornecedoresDAO();
		
		
		dao.salvar(f3);
		dao.salvar(f4);
	}
	
	@Test
	@Ignore
	public void listar() {
		FornecedoresDAO dao = new FornecedoresDAO();	
		
		List<Fornecedor> fornecedores = dao.listar();
		
		for(Fornecedor fornecedor : fornecedores) {
			System.out.println(fornecedor);
		}
	}	
	
	
	@Test
	@Ignore
	public void buscarPorCodigo() {
		FornecedoresDAO dao = new FornecedoresDAO();	
		
		Fornecedor f1 = dao.buscarPorCodigo(2L);
		Fornecedor f2 = dao.buscarPorCodigo(4L);
		
		
			System.out.println(f1);
			System.out.println(f2);
	}
	
	@Test
	@Ignore
	public void excluir() {
		FornecedoresDAO dao = new FornecedoresDAO();	
		Fornecedor fornecedor = dao.buscarPorCodigo(5L);
		
			dao.excluir(fornecedor);
		
		
	}
	
	
	

	@Test
	@Ignore
	
	public void editar() {
		
		FornecedoresDAO dao = new FornecedoresDAO();	
		Fornecedor fornecedor = dao.buscarPorCodigo(6L);
		fornecedor.setDescricao("Paulo Campos");
		
			dao.editar(fornecedor);
		
	}
	
}
