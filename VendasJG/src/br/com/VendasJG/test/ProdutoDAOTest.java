package br.com.VendasJG.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.VendasJG.DAO.FornecedoresDAO;

import br.com.VendasJG.DAO.ProdutosDAO;
import br.com.VendasJG.domain.Fornecedor;

import br.com.VendasJG.domain.Produto;

public class ProdutoDAOTest {
	@Test
	@Ignore
	public void salvar() {
		
		FornecedoresDAO dao = new FornecedoresDAO();	
		Fornecedor fornecedor = dao.buscarPorCodigo(8L);
		
		//Produto p1 = new Produto();
		Produto p2 = new Produto();
		
		p2.setDescricao("Feijao");
		p2.setPreco(new BigDecimal(9.99D));
		p2.setQuantidade(4);
		p2.setFornecedor(fornecedor);
		
		//p1.setDescricao("Feijão");
		//p1.setPreco(new BigDecimal(5.99D));
		//p1.setQuantidade(10);
		//p1.setFornecedor(fornecedor);
		
		ProdutosDAO produtosDao = new ProdutosDAO();
		
		
		//produtosDao.salvar(p1);
		produtosDao.salvar(p2);
	}
	
	@Test
	@Ignore
	public void listar() {
		ProdutosDAO dao = new ProdutosDAO();	
		
		List<Produto> produtos = dao.listar();
		
		
			System.out.println(produtos);
		
	}	
	
	
	@Test
	@Ignore
	public void buscarPorCodigo() {
		ProdutosDAO dao = new ProdutosDAO();	
		
		Produto p1 = dao.buscarPorCodigo(2L);
		
		System.out.println(p1);
	}
	
	
	@Test
	@Ignore
	public void excluir() {
		ProdutosDAO dao = new ProdutosDAO();	
		Produto produto = dao.buscarPorCodigo(2L);
		
			dao.excluir(produto);
		
		
	}
	

	@Test
	@Ignore
	
	public void editar() {
		
		FornecedoresDAO dao = new FornecedoresDAO();	
		Fornecedor fornecedor = dao.buscarPorCodigo(6L);
		
		ProdutosDAO produtosDao = new ProdutosDAO();
		
		Produto produto = produtosDao.buscarPorCodigo(1L);
		produto.setDescricao("Batata");
		produto.setPreco(new BigDecimal(9.99D));
		produto.setQuantidade(15);
		produto.setFornecedor(fornecedor);
		
		produtosDao.editar(produto);
	
		
		
	}

}
