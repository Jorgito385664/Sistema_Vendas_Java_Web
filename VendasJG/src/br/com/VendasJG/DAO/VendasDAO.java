package br.com.VendasJG.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import br.com.VendasJG.domain.Vendas;
import br.com.VendasJG.util.HibernateUtil;

public class VendasDAO {
	
	public Long salvar(Vendas vendas) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		
		Transaction transacao = null;
		Long codigo = null;
		
		try {
			
			transacao = sessao.beginTransaction(); 
			codigo = (Long)sessao.save(vendas);
			transacao.commit();   //confirma transação
			
		}catch(RuntimeException ex) {
			
			if(transacao != null) {
				transacao.rollback();  // desfaz transação	
			}
			
			
			
		} finally {
			sessao.close();
		}
		
		return codigo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Vendas> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		
		List<Vendas> vendas = null;
		
		try {
			
			Query consulta = sessao.getNamedQuery("Vendas.listar");
			vendas = consulta.list();
			
			
		}catch(RuntimeException ex) {
			
			throw ex;
			
		} finally {
			sessao.close();
		}
		
		return vendas;
	}
	
	public Vendas buscarPorCodigo(Long codigo){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		
		Vendas vendas = null;
		
		try {
			
			Query consulta = sessao.getNamedQuery("Vendas.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			vendas = (Vendas) consulta.uniqueResult();
			
			
		}catch(RuntimeException ex) {
			
			throw ex;
			
		} finally {
			sessao.close();
		}
		
		return vendas;
	}
	
	public void excluir(Vendas vendas) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		
		Transaction transacao = null;
		
		try {
			
			transacao = sessao.beginTransaction(); 
			sessao.delete(vendas);
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
	
	
	
	
	
	public void editar(Vendas vendas) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		
		Transaction transacao = null;
		
		try {
			
			transacao = sessao.beginTransaction();
		
			sessao.update(vendas);
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
