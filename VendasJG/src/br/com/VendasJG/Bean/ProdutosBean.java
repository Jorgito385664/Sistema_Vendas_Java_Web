package br.com.VendasJG.Bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.VendasJG.DAO.FornecedoresDAO;
import br.com.VendasJG.DAO.ProdutosDAO;
import br.com.VendasJG.domain.Fornecedor;
import br.com.VendasJG.domain.Produto;
import br.com.VendasJG.util.JSFUtil;

@ManagedBean(name = "MBProdutos")
@ViewScoped
public class ProdutosBean {
	
	private Produto produto;

	private ArrayList<Produto>itens;
	private ArrayList<Produto>itensFiltrados;
	private String acao;
	private Long codigo;
	private List<Fornecedor>listaFornecedor;
	
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public String getAcao() {
		return acao;
	}
	
	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Produto getProduto() {
		
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public ArrayList<Produto> getItens() {
		return itens;
	}
	public void setItens(ArrayList<Produto> itens) {
		this.itens = itens;
	}
	public ArrayList<Produto> getItensFiltrados() {
		return itensFiltrados;
	}
	public void setItensFiltrados(ArrayList<Produto> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public List<Fornecedor> getListaFornecedor() {
		return listaFornecedor;
	}

	public void setListaFornecedor(List<Fornecedor> listaFornecedor) {
		this.listaFornecedor = listaFornecedor;
	}
//@PostConstruct
public void prepararPesquisa() {
	try {
		ProdutosDAO fdao = new ProdutosDAO();
		itens = (ArrayList<Produto>) fdao.listar();
		
	}catch(RuntimeException e) {
		JSFUtil.adicionarMensagemErro("ex.getMessage()");
		e.printStackTrace();
	}
}

public void carregarCadastro() {
	
	try {
		
		
		
		if(codigo != null) {
				
			ProdutosDAO fdao = new ProdutosDAO();
			
			produto = fdao.buscarPorCodigo(codigo);
		}
		else { 
			produto = new Produto();
		}
		
		FornecedoresDAO dao = new FornecedoresDAO();
		listaFornecedor = dao.listar();
		

		
	}catch(RuntimeException e) {
		JSFUtil.adicionarMensagemErro("ex.getMessage()");
		e.printStackTrace();
	}
}



public void Novo() {
	produto = new Produto();
}

	public void salvar() {
		try {
			ProdutosDAO fdao = new ProdutosDAO();
			fdao.salvar(produto);
			
			produto = new Produto();



			JSFUtil.adicionarMensagemSucesso("Produto salvo com sucesso");

		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}

public void excluir() {
	try {
		ProdutosDAO fdao = new ProdutosDAO();
		fdao.excluir(produto);
		
		JSFUtil.adicionarMensagemSucesso("Produto exclu�do com sucesso!");
		
	}catch(RuntimeException e) {
		JSFUtil.adicionarMensagemErro("ex.getMessage()");
		e.printStackTrace();
	}
}
//
public void editar() {
	try {
		ProdutosDAO fdao = new ProdutosDAO();
		fdao.editar(produto);
		
		JSFUtil.adicionarMensagemSucesso("Produto editado com sucesso");
		
	}catch(RuntimeException e) {
		JSFUtil.adicionarMensagemErro("ex.getMessage()");
		e.printStackTrace();
	}
}


}
