package com.livraria.beans;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.livraria.dao.LivroDAO;
import com.livraria.dao.PedidoDAO;
import com.livraria.models.Livro;
import com.livraria.models.Pedido;

@ManagedBean
@SessionScoped
public class CarrinhoMBean {
	
	private Pedido novo = new Pedido();
	
	private List<Livro> lista = new ArrayList<>();
	
	private int quantidade = 0;
	
	public float valorTotal = 0;

	public void incluir(int id) throws Exception {
		LivroDAO dao = new LivroDAO();
		
	Livro p = dao.getLivro(id);
		if (p == null) {
			return;
		}
		for (Livro existente : lista) {
			if (existente.getId() == id) {
				int quant = existente.getEstoque();
				existente.setEstoque(quant + 1);
				return;
			}
		}
		p.setEstoque(1);
		lista.add(p);
		quantidade = lista.size();
		valorTotal = 0;
		for (Livro existente : lista) {
			valorTotal += existente.getValor()
					* existente.getEstoque();
			
		}

	}
	
	public void finalizarCompra() throws Exception {
		
		PedidoDAO dao = new PedidoDAO();
		
		novo.setStatus("pendente");
		novo.setItens(lista);
		dao.inserir(novo);		 
		
		novo = new Pedido();
		lista = new ArrayList<>();
		
		quantidade = 0;
		valorTotal = 0;
	}
	
	
	public List<Livro> getLista() {
		return lista;
	}

	public void setLista(List<Livro> lista) {
		this.lista = lista;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Pedido getNovo() {
		return novo;
	}

	public void setNovo(Pedido novo) {
		this.novo = novo;
	}	
}
