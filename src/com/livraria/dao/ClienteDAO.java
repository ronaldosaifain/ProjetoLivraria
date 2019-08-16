package com.livraria.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.livraria.config.AppConnection;
import com.livraria.models.Cliente;

public class ClienteDAO {


	public Cliente inserir(Cliente c) throws Exception {
		String sqlInsert =
			"INSERT INTO cliente (nome, email, senha, ende, cidade, estado, cep, CPF) VALUES (?, ?, ?, ? ,?,?,?,?)";
		
		try {
			Connection con = AppConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sqlInsert);
			ps.setString(1, c.getNome());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getSenha());
			ps.setString(4, c.getEndereco());
			ps.setString(5, c.getCidade());
			ps.setString(6, c.getEstado());
			ps.setInt(7, c.getCep());
			ps.setInt(8, c.getCPF());
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
	
	
	public Cliente getCliente(Cliente c) throws Exception {
		Cliente p = null;
		try {
			Connection con = AppConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(
					"SELECT * FROM cliente where email = ? AND senha = ?");
			stmt.setString(1, c.getEmail());
			stmt.setString(2, c.getSenha());
			  ResultSet rs = stmt.executeQuery();
			  while (rs.next()) {
				  p = new Cliente();
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
	
	
}
