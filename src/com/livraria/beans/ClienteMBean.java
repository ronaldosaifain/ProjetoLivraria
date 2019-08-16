package com.livraria.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.livraria.dao.ClienteDAO;
import com.livraria.models.Cliente;

@ManagedBean
@SessionScoped
public class ClienteMBean {

       private String email;
       private String senha;
       
       private Cliente novo = new Cliente();
		
		private ClienteDAO dao = new ClienteDAO();
		public void incluir() throws Exception {
			dao.inserir(novo);
			novo = new Cliente();
			
			FacesContext.getCurrentInstance().getExternalContext()
	          .redirect("cadastrosucesso.xhtml");			
			
			
		}

		public void Verificar() throws Exception {
		   
			Cliente c = new Cliente();
			c.setEmail(email);
			c.setSenha(senha);
			
		novo = dao.getCliente(c);
	  }
		
		public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


		
		public Cliente getNovo() {
			return novo;
		}

		public void setNovo(Cliente novo) {
			this.novo = novo;
		}	

	
	  
		
		
	
}
