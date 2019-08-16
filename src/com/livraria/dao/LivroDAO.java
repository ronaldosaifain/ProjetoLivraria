package com.livraria.dao;

	
	import java.sql.Connection;
	import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.livraria.config.AppConnection;
import com.livraria.models.Livro;

	public class LivroDAO {


		public Livro inserir(Livro c) throws Exception {
			String sqlInsert =
				"INSERT INTO cliente (nome, email, senha, endereco, cidade, estado, cep) VALUES (?, ?, ?, ? ,?,?,?)";
			//valida(pessoa, true);
			try {
				Connection con = AppConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sqlInsert);
				ps.setString(1, c.getTitulo());
				ps.setFloat(2, c.getValor());
				ps.setInt(3,c.getEstoque());
				
				
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
		
		public Livro getLivro(int id) throws Exception {
			Livro p = null;
			try {
				Connection con = AppConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(
						"SELECT * FROM livro where id_livro = ?");
				stmt.setInt(1, id);
				  ResultSet rs = stmt.executeQuery();
				  while (rs.next()) {
					  p = new Livro();
					  p.setId(rs.getInt("id_livro"));
					  p.setTitulo(rs.getString("titulo"));
					  p.setValor(rs.getFloat("valor"));
					  p.setEstoque(rs.getInt("estoque"));
				  }
				  stmt.close();
				  rs.close();
			} catch (Exception ex) {
				System.err.println("Erro ao obter os dados:" + ex);
				throw ex;
			}
			return p;
		}
		
		public List<Livro> listAll() throws Exception {
			ArrayList<Livro> list = new ArrayList<>();

			try {
				Connection con = AppConnection.getConnection();
				Statement stmt = con.createStatement();
				  ResultSet rs = stmt.executeQuery(
				          "SELECT * from Livro");
				      
				          
				  while (rs.next()) {
				     Livro p = new Livro();
				     p.setId(rs.getInt("id_livro"));
					  p.setTitulo(rs.getString("titulo"));
					  p.setValor(rs.getFloat("valor"));
					  p.setEstoque(rs.getInt("estoque"));
					
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

		public Livro buscarLivro(Livro c) throws Exception {
			Livro p = null;
			try {
				Connection con = AppConnection.getConnection();
				PreparedStatement stmt = con.prepareStatement(
						"SELECT * FROM livro where titulo = ?");
				stmt.setString(1, c.getTitulo());
				  ResultSet rs = stmt.executeQuery();
				  while (rs.next()) {
					  p = new Livro();
					  p.setTitulo(rs.getString("titulo"));
					  p.setValor(rs.getFloat("valor"));
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
	
	
	
	
