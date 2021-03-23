package br.com.VendasJG.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import br.com.VendasJG.domain.Funcionario;
import br.com.VendasJG.util.HibernateUtil;

public class FuncionariosDAO {
	
	public void salvar(Funcionario funcionario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		
		Transaction transacao = null;
		
		try {
			
			transacao = sessao.beginTransaction(); 
			sessao.save(funcionario);
			transacao.commit();   //confirma transação
			
		}catch(RuntimeException ex) {
			
			if(transacao != null) {
				transacao.rollback();  // desfaz transação	
			}
			
			throw ex;
			
		} finally {
			sessao.close();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		
		List<Funcionario> funcionario = null;
		
		try {
			
			Query consulta = sessao.getNamedQuery("Funcionario.listar");
			funcionario = consulta.list();
			
			
		}catch(RuntimeException ex) {
			
			throw ex;
			
		} finally {
			sessao.close();
		}
		
		return funcionario;
	}
	
	public Funcionario buscarPorCodigo(Long codigo){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		
		Funcionario funcionario = null;
		
		try {
			
			Query consulta = sessao.getNamedQuery("Funcionario.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			funcionario = (Funcionario) consulta.uniqueResult();
			
			
		}catch(RuntimeException ex) {
			
			throw ex;
			
		} finally {
			sessao.close();
		}
		
		return funcionario;
	}
	
	public void excluir(Funcionario funcionario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		
		Transaction transacao = null;
		
		try {
			
			transacao = sessao.beginTransaction(); 
			sessao.delete(funcionario);
			transacao.commit();   //confirma transação
			
		}catch(RuntimeException ex) {
			
			if(transacao != null) {
				transacao.rollback();  // desfaz transação	
			}
			
			throw ex;
			
		} finally {
			sessao.close();
		}
		
	}
	
	
	
	
	
	public void editar(Funcionario funcionario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		
		Transaction transacao = null;
		
		try {
			
			transacao = sessao.beginTransaction();
		
			sessao.update(funcionario);
			transacao.commit();   //confirma transação
			
		}catch(RuntimeException ex) {
			
			if(transacao != null) {
				transacao.rollback();  // desfaz transação	
			}
			
			throw ex;
			
		} finally {
			sessao.close();
		}
		
	}


}
