package com.livraria.beans;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.livraria.dao.ItemPedidoDAO;
import com.livraria.models.ItemPedido;

@ManagedBean
@SessionScoped


public class ItemPedidomMBean {

private ItemPedido novo = new ItemPedido();
	
	private ItemPedidoDAO dao = new ItemPedidoDAO();
	
	public void incluir() throws Exception {
		dao.inserir(novo);
		novo = new ItemPedido();
	}

	public ItemPedido getNovo() {
		return novo;
	}

	public void setNovo(ItemPedido novo) {
		this.novo = novo;
	}	
	
	
	
}
