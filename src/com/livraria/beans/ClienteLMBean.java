package com.livraria.beans;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.livraria.dao.ClienteLDAO;
import com.livraria.models.ClienteL;

@ManagedBean
@SessionScoped
public class ClienteLMBean {

	private String email;
    private String senha;
	
    
    
	private ClienteL novo = new ClienteL();
	
	private ClienteLDAO dao = new ClienteLDAO();
     
	public void atualizar() throws Exception {
		dao.atualizar((novo));
		novo = new ClienteL();
		
		
		FacesContext.getCurrentInstance().getExternalContext()
          .redirect("index.xhtml");
		
	}
	
	public void Verificar() throws Exception {
		
	
		ClienteL c = new ClienteL();
		c.setEmail(email);
		c.setSenha(senha);
	    novo = dao.getCliente(c);
	      
	   
	    if (novo == null) {
	    	 FacesContext.getCurrentInstance().getExternalContext()
	          .redirect("nologin.xhtml");
	      	
	    } else {
	    	 FacesContext.getCurrentInstance().getExternalContext()
	          .redirect("paginaCliente.xhtml");
	    	
	    }
	    
	    email = "";
	    senha = "";
	    
	    
  }
	
	
	public ClienteL getNovo() {
		return novo;
	}


	public void setNovo(ClienteL novo) {
		this.novo = novo;
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
	
}
