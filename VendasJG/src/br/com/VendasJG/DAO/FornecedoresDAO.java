package br.com.VendasJG.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.VendasJG.domain.Fornecedor;
import br.com.VendasJG.util.HibernateUtil;

public class FornecedoresDAO {
	public void salvar(Fornecedor fornecedor) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		
		Transaction transacao = null;
		
		try {
			
			transacao = sessao.beginTransaction(); 
			sessao.save(fornecedor);
			transacao.commit();   //confirma transa��o
			
		}catch(RuntimeException ex) {
			
			if(transacao != null) {
				transacao.rollback();  // desfaz transa��o	
			}
			
			throw ex;
			
		} finally {
			sessao.close();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Fornecedor> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		
		List<Fornecedor> fornecedores = null;
		
		try {
			
			Query consulta = sessao.getNamedQuery("Fornecedor.listar");
			fornecedores = consulta.list();
			
			
		}catch(RuntimeException ex) {
			
			throw ex;
			
		} finally {
			sessao.close();
		}
		
		return fornecedores;
	}
	
	public Fornecedor buscarPorCodigo(Long codigo){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		
		Fornecedor fornecedor = null;
		
		try {
			
			Query consulta = sessao.getNamedQuery("Fornecedor.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			fornecedor = (Fornecedor) consulta.uniqueResult();
			
			
		}catch(RuntimeException ex) {
			
			throw ex;
			
		} finally {
			sessao.close();
		}
		
		return fornecedor;
	}
	
	public void excluir(Fornecedor fornecedor) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		
		Transaction transacao = null;
		
		try {
			
			transacao = sessao.beginTransaction(); 
			sessao.delete(fornecedor);
			transacao.commit();   //confirma transa��o
			
		}catch(RuntimeException ex) {
			
			if(transacao != null) {
				transacao.rollback();  // desfaz transa��o	
			}
			
			throw ex;
			
		} finally {
			sessao.close();
		}
		
	}
	
	
	
	
	
	public void editar(Fornecedor fornecedor) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		
		Transaction transacao = null;
		
		try {
			
			transacao = sessao.beginTransaction();
		
			sessao.update(fornecedor);
			transacao.commit();   //confirma transa��o
			
		}catch(RuntimeException ex) {
			
			if(transacao != null) {
				transacao.rollback();  // desfaz transa��o	
			}
			
			throw ex;
			
		} finally {
			sessao.close();
		}
		
	}

}
