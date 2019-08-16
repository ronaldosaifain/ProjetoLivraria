package com.livraria.beans;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.livraria.dao.PedidoDAO;
import com.livraria.models.Pedido;

@ManagedBean
@SessionScoped

public class PedidoMBean {

	private int id;
	
	 PedidoDAO dao = new PedidoDAO();
	
	 Pedido novo = new Pedido();
	
	 public void buscarPedidos() throws Exception{
			
			Pedido p = new Pedido();
	
			p.setIdCliente(id);
			dao.exibirPedido(p);
			
		} 
	 
	 
	public List<Pedido> getLista() throws Exception{
		
		Pedido p = new Pedido();
		p.setIdCliente(id);
		return dao.exibirPedido(p);
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pedido getNovo() {
		return novo;
	}

	
	
	
}
