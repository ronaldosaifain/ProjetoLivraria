package com.livraria.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.livraria.config.AppConnection;
import com.livraria.models.ClienteL;

public class ClienteLDAO {

	

	
	public ClienteL getCliente(ClienteL c) throws Exception {
		ClienteL p = null;
		try {
			Connection con = AppConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(
					"SELECT * FROM cliente where email = ? AND senha = ?");
			stmt.setString(1, c.getEmail());
			stmt.setString(2, c.getSenha());
			  ResultSet rs = stmt.executeQuery();
			  while (rs.next()) {
				  p = new ClienteL();
				  p.setId(rs.getInt("id"));
				  p.setNome(rs.getString("nome"));
				  p.setCPF(rs.getInt("Cpf"));
				  p.setEstado(rs.getString("estado"));
				  p.setCidade(rs.getString("cidade"));
				  p.setEndereco(rs.getString("ende"));
				  p.setCep(rs.getInt("cep"));
				  p.setEmail(rs.getString("email"));
				  
			  }
			  stmt.close();
			  rs.close();
		} catch (Exception ex) {
			System.err.println("Erro ao obter os dados:" + ex);
			throw ex;
		}
		return p;
	}	
	
	
	public ClienteL atualizar(ClienteL c) throws Exception {
		String sqlInsert =
			"UPDATE Cliente SET nome = ?, cpf = ?, email = ?, senha=?, ende = ?, cidade = ?, estado = ?, cep = ? where id = ?";
		//valida(c, false);
		try {
			Connection con = AppConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlInsert);
			ps.setString(1, c.getNome());
			ps.setInt(2, c.getCPF());
			ps.setString(3, c.getEmail());
			ps.setString(4, c.getSenha());
			ps.setString(5, c.getEndereco());
			ps.setString(6, c.getCidade());
			ps.setString(7, c.getEstado());
			ps.setInt(8, c.getCep());;
			ps.setInt(9, c.getId());;
			int ret = ps.executeUpdate();
			if (ret != 1) {
				throw new Exception("Valor não foi alterado por erro de banco."); 
			}
		} catch (Exception ex) {
			System.err.println("Erro ao obter os dados" + ex);
			throw ex;
		}
		return c;
	}
	
	
	
}
