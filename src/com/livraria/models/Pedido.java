package com.livraria.models;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido{

	private int id;
	private Date data;
	private float total;
	private String status = "Pendente";
	private String finalizadora;
	private int parcelas = 3;
	private int idCliente;
	private int idLivro;
	private List<Livro> itens = new ArrayList<>();
	
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFinalizadora() {
		return finalizadora;
	}

	public void setFinalizadora(String finalizadora) {
		this.finalizadora = finalizadora;
	}

	public int getParcelas() {
		return parcelas;
	}

	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int id_Livro) {
		this.idLivro = id_Livro;
	}

	public List<Livro> getItens() {
		return itens;
	}

	public void setItens(List<Livro> itens) {
		this.itens = itens;
	}

}
