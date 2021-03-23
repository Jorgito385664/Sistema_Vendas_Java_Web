package br.com.VendasJG.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.VendasJG.DAO.FornecedoresDAO;
import br.com.VendasJG.DAO.FuncionariosDAO;
import br.com.VendasJG.domain.Fornecedor;
import br.com.VendasJG.domain.Funcionario;

public class FuncionarioDAOTest {
	
	@Test
	@Ignore
	public void salvar() {
		
		Funcionario f1 = new Funcionario();
		Funcionario f2 = new Funcionario();
		
		f1.setNome("Pedro Campos");
		f1.setCpf("09014588936");
		f1.setSenha("123");
		f1.setFuncao("Gerente");
		
		f2.setNome("Maria Paula");
		f2.setCpf("08724556916");
		f2.setSenha("1234");
		f2.setFuncao("Gerente");
		
		FuncionariosDAO dao = new FuncionariosDAO();
		
		
		dao.salvar(f1);
		dao.salvar(f2);
	}
	
	@Test
	@Ignore
	public void listar() {
		FuncionariosDAO dao = new FuncionariosDAO();	
		
		List<Funcionario> funcionarios = dao.listar();
		
		for(Funcionario funcionario : funcionarios) {
			System.out.println(funcionario);
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
		FuncionariosDAO dao = new FuncionariosDAO();	
		Funcionario funcionario = dao.buscarPorCodigo(2L);
		
			dao.excluir(funcionario);
		
		
	}
	
	
	

	@Test
	@Ignore
	public void editar() {
		
		FuncionariosDAO dao = new FuncionariosDAO();	
		Funcionario funcionario = dao.buscarPorCodigo(1L);
		funcionario.setNome("Paulo Campos");
		funcionario.setCpf("600.523.854-00");
		funcionario.setSenha("12345678");
		funcionario.setFuncao("Gerente");
		
			dao.editar(funcionario);
		
	}
	

}
