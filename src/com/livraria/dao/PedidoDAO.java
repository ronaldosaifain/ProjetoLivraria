package com.livraria.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.livraria.config.AppConnection;
import com.livraria.models.Livro;
import com.livraria.models.Pedido;


public class PedidoDAO {
	
	
	
	public Pedido inserir(Pedido c) throws Exception {
		
		String sqlInsert =
			"INSERT INTO pedido (data, id_cliente, total, status, finalizadora, parcelas) VALUES (now(), ?, ?, ?, ?, ?)";
	
		Connection con = AppConnection.getConnection();
		try {
			
		//	con.setAutoCommit(false);
			
			PreparedStatement ps = con.prepareStatement(sqlInsert);
            ps.setInt(1,  c.getIdCliente());
			ps.setFloat(2, c.getTotal());
			ps.setString(3,c.getStatus());
			ps.setString(4, c.getFinalizadora());
			ps.setInt(5, c.getParcelas());
		    int ret = ps.executeUpdate();
		    
		    String sqlMAX =
					"SELECT max(id_pedido) FROM PEDIDO";
		    ps = con.prepareStatement(sqlMAX);
		    ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				c.setId(rs.getInt(1));
			}
		    
			if (ret != 1) {
				throw new Exception("Valor não foi inserido por erro de banco."); 
		 	}
			for(Livro l : c.getItens()) {
				
				sqlInsert = "INSERT INTO item_pedido (id_pedido, id_livro, quantidade, valor)VALUES (?,?,?,?)";
				ps = con.prepareStatement(sqlInsert);
				ps.setInt(1, c.getId());
				ps.setInt(2, l.getId());
				ps.setInt(3, l.getEstoque());
				ps.setFloat(4, l.getValor());
				ps.executeUpdate();
			}
		 	 //con.commit();
		} catch (Exception ex) {
			// con.rollback();
			System.err.println("Erro ao obter os dados" + ex);
			throw ex;
		}
		return c;		
	   }	
	
	     
	    public void inserirItem() throws Exception {	    	
	    	Connection con = AppConnection.getConnection();
	    	
	    	
	    	String sqlInsert1 =
	 				"INSERT INTO item_pedido (id_pedido) SELECT max(id_pedido) FROM PEDIDO";
	 		  PreparedStatement pss = con.prepareStatement(sqlInsert1);
	 		 pss.executeUpdate();
	 		 
	    	
	 	}
		
	    
	public Pedido getPedido(int id) throws Exception {
		Pedido p = null;
		try {
			Connection con = AppConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(
					"SELECT * FROM pedido where id_livro = ?");
			     stmt.setInt(1, id);
			  ResultSet rs = stmt.executeQuery();
			  while (rs.next()) {
				  p = new Pedido();
				  p.setData(new java.util.Date(rs.getDate("Data").getTime()));
				  p.setTotal(rs.getFloat("Total"));
				  p.setStatus(rs.getString("status"));
				  p.setFinalizadora(rs.getString("finalizadora"));
				  p.setParcelas(rs.getInt("parcelas"));
			  }
			  stmt.close();
			  rs.close();
		} catch (Exception ex) {
			System.err.println("Erro ao obter os dados:" + ex);
			throw ex;
		}
		
		return p;
		
	}
	
	
	public List<Pedido> exibirPedido(Pedido id) throws Exception {
		
		ArrayList<Pedido> list = new ArrayList<>();
		Pedido p = null;
		try {
			Connection con = AppConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(
					"SELECT * FROM pedido where id_cliente = ?");
			     stmt.setInt(1, id.getIdCliente());
			  ResultSet rs = stmt.executeQuery();
			  while (rs.next()) {
				  p = new Pedido();
				  p.setData(new java.util.Date(rs.getDate("Data").getTime()));
				  p.setTotal(rs.getFloat("Total"));
				  p.setStatus(rs.getString("status"));
				  p.setFinalizadora(rs.getString("finalizadora"));
				  p.setParcelas(rs.getInt("parcelas"));
				  list.add(p);
			  }
			  stmt.close();
			  rs.close();
		} catch (Exception ex) {
			System.err.println("Erro ao obter os dados:" + ex);
			throw ex;
		}
		
		return list;
		
	}
	
	
	public Pedido IdPedido(int id) throws Exception {
		Pedido p = null;
		try {
			Connection con = AppConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(
					"SELECT id_pedido FROM pedido where id_pedido = ?");
			stmt.setInt(1, id);
			  ResultSet rs = stmt.executeQuery();
			  while (rs.next()) {
				  p = new Pedido();
				  p.setId(rs.getInt("id_pedido"));
				 
				  
			  }
			  stmt.close();
			  rs.close();
		} catch (Exception ex) {
			System.err.println("Erro ao obter os dados:" + ex);
			throw ex;
		}
		return p;
	}
	
			
}
	
