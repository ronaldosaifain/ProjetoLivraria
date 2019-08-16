package com.livraria.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.livraria.config.AppConnection;
import com.livraria.models.ItemPedido;

public class ItemPedidoDAO {

	
	
	public ItemPedido inserir(ItemPedido c) throws Exception {
	

		String sqlInsert =
			"INSERT INTO Item_pedido (id_pedido, id_livro, valor, quantidade, total) VALUES (? , ? , ?, ?, ?)";
		
		try {
			Connection con = AppConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlInsert);
			
			ps.setInt(1, c.getId_pedido());
			ps.setInt(2, c.getId_livro());
			ps.setFloat(3, c.getValor());
			ps.setInt(4,c.getQuantidade());
			ps.setFloat(5, c.getTotal());
			
					
			int ret = ps.executeUpdate();
			if (ret != 1) {
				throw new Exception("Valor não foi inserido por erro de banco."); 
			}
		} catch (Exception ex) {
			System.err.println("Erro ao obter os dados" + ex);
			throw ex;
		}
		return c;
	}		
	
}
