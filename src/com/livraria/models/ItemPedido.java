package com.livraria.models;

public class ItemPedido {
private int id_livro;
private int id_pedido;
private float valor;
private int quantidade;
private float total;


public int getId_pedido() {
	return id_pedido;
}
public void setId_pedido(int id_pedido) {
	this.id_pedido = id_pedido;
}

public float getValor() {
	return valor;
}
public void setValor(float valor) {
	this.valor = valor;
}
public int getQuantidade() {
	return quantidade;
}
public void setQuantidade(int quantidade) {
	this.quantidade = quantidade;
}
public float getTotal() {
	return total;
}
public void setTotal(float total) {
	this.total = total;
}
public int getId_livro() {
	return id_livro;
}
public void setId_livro(int id_livro) {
	this.id_livro = id_livro;
}



	
	
	
}
