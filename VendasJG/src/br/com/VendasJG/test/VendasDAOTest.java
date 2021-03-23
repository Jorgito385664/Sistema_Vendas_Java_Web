package br.com.VendasJG.test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;


import br.com.VendasJG.DAO.FuncionariosDAO;

import br.com.VendasJG.DAO.VendasDAO;

import br.com.VendasJG.domain.Funcionario;

import br.com.VendasJG.domain.Vendas;

public class VendasDAOTest {
	
	@Test
	@Ignore
	public void salvar() {
		
		FuncionariosDAO dao = new FuncionariosDAO();	
		Funcionario funcionario = dao.buscarPorCodigo(1L);
		
		//Vendas v1 = new Vendas();
		
		//v1.setHorario(new Date());
		//v1.setValor_total(new BigDecimal(50.00D));
		//v1.setFuncionario(funcionario);
		
		VendasDAO vendasDao = new VendasDAO();
		
		//vendasDao.salvar(v1);
		
		Vendas v2 = new Vendas();
		
		v2.setHorario(new Date());
		v2.setValor_total(new BigDecimal(80.00D));
		v2.setFuncionario(funcionario);
		
	
		
		vendasDao.salvar(v2);
		
		
	}
	
	@Test
	@Ignore
	public void listar() {
		VendasDAO dao = new VendasDAO();	
		
		List<Vendas> vendas = dao.listar();
		
		
			System.out.println(vendas);
		
	}	
	
	
	@Test
	@Ignore
	public void buscarPorCodigo() {
		VendasDAO dao = new VendasDAO();	
		
		Vendas v1 = dao.buscarPorCodigo(1L);
		
		System.out.println(v1);
	}
	
	
	@Test
	@Ignore
	public void excluir() {
		VendasDAO dao = new VendasDAO();	
		Vendas vendas = dao.buscarPorCodigo(2L);
		
			dao.excluir(vendas);
		
		
	}
	

	@Test
	@Ignore
	public void editar() {
		
		FuncionariosDAO fdao = new FuncionariosDAO();	
		Funcionario funcionario = fdao.buscarPorCodigo(1L);
		
		VendasDAO dao = new VendasDAO();
		Vendas v1 = dao.buscarPorCodigo(1L);
		
		v1.setHorario(new Date());
		v1.setValor_total(new BigDecimal(150.00D));
		v1.setFuncionario(funcionario);
		
				
		dao.editar(v1);
	
		
		
	}

}
