package br.com.VendasJG.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;


import br.com.VendasJG.DAO.ItemDAO;
import br.com.VendasJG.DAO.ProdutosDAO;
import br.com.VendasJG.DAO.VendasDAO;

import br.com.VendasJG.domain.Item;
import br.com.VendasJG.domain.Produto;
import br.com.VendasJG.domain.Vendas;

public class ItemDAOTest {

	@Test
	@Ignore
	public void salvar() {
		
		ProdutosDAO dao = new ProdutosDAO();	
		Produto produto = dao.buscarPorCodigo(1L);
		
		VendasDAO vendasDao = new VendasDAO();	
		Vendas vendas = vendasDao.buscarPorCodigo(1L);
		
		
		Item i1 = new Item();
		
		i1.setQuantidade(8);
		i1.setValor_parcial(new BigDecimal(49.99D));
		i1.setProduto(produto);
		i1.setVendas(vendas);
		
		ItemDAO itemDao = new ItemDAO();
		
		itemDao.salvar(i1);
	}
	
	@Test
	@Ignore
	public void listar() {
		ItemDAO dao = new ItemDAO();	
		
		List<Item> item = dao.listar();
		
		
			System.out.println(item);
		
	}	
	
	
	@Test
	@Ignore
	public void buscarPorCodigo() {
		ItemDAO dao = new ItemDAO();	
		
		Item i1 = dao.buscarPorCodigo(2L);
		
		System.out.println(i1);
	}
	
	
	@Test
	@Ignore
	public void excluir() {
		ItemDAO dao = new ItemDAO();	
		Item item = dao.buscarPorCodigo(2L);
		
			dao.excluir(item);
		
		
	}
	

	@Test
	@Ignore
	public void editar() {
		
		ProdutosDAO dao = new ProdutosDAO();	
		Produto produto = dao.buscarPorCodigo(1L);
		
		VendasDAO vendasDao = new VendasDAO();	
		Vendas vendas = vendasDao.buscarPorCodigo(1L);
		
		
		ItemDAO itemDao = new ItemDAO();
		
		Item item = itemDao.buscarPorCodigo(1L);
		item.setQuantidade(10);
		item.setValor_parcial(new BigDecimal(59.99D));
		item.setProduto(produto);
		item.setVendas(vendas);
		
		itemDao.editar(item);
	
		
		
	}

}
