package br.com.VendasJG.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import br.com.VendasJG.domain.Produto;
import br.com.VendasJG.util.HibernateUtil;

public class ProdutosDAO {
	
	public void salvar(Produto produto) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		
		Transaction transacao = null;
		
		try {
			
			transacao = sessao.beginTransaction(); 
			sessao.save(produto);
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
	public List<Produto> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		
		List<Produto> produto = null;
		
		try {
			
			Query consulta = sessao.getNamedQuery("Produto.listar");
			produto = consulta.list();
			
			
		}catch(RuntimeException ex) {
			
			throw ex;
			
		} finally {
			sessao.close();
		}
		
		return produto;
	}
	
	public Produto buscarPorCodigo(Long codigo){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		
		Produto produto = null;
		
		try {
			
			Query consulta = sessao.getNamedQuery("Produto.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			produto = (Produto) consulta.uniqueResult();
			
			
		}catch(RuntimeException ex) {
			
			throw ex;
			
		} finally {
			sessao.close();
		}
		
		return produto;
	}
	
	public void excluir(Produto produto) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		
		Transaction transacao = null;
		
		try {
			
			transacao = sessao.beginTransaction(); 
			sessao.delete(produto);
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
	
	
	
	
	
	public void editar(Produto produto) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		
		Transaction transacao = null;
		
		try {
			
			transacao = sessao.beginTransaction();
		
			sessao.update(produto);
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
