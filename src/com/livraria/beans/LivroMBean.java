package com.livraria.beans;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.livraria.dao.LivroDAO;
import com.livraria.models.Livro;


@ManagedBean
@SessionScoped
public class LivroMBean {

	
	private String titulo;
	
	private Livro selecionado;
	
		private Livro novo = new Livro();
		
		private LivroDAO dao = new LivroDAO();
		
		public void incluir() throws Exception {
			dao.inserir(novo);
			novo = new Livro();
		}
		
		
		 public String getTitulo() {
				return titulo;
			}

			public void setTitulo(String titulo) {
				this.titulo = titulo;
			}

		public Livro getNovo() {
			return novo;
		}

		public void setNovo(Livro novo) {
			this.novo = novo;
		}			
		
		public List<Livro> getLista() throws Exception {
			return dao.listAll();

		}
		public Livro getSelecionado() {
			return selecionado;
		}

		public void setSelecionado(Livro selecionado) {
			this.selecionado = selecionado;
		}

		public void Buscar() throws Exception {
			   
			Livro c = new Livro();
			c.setTitulo(titulo);
  		    novo = dao.buscarLivro(c);
  		    
  		    if(novo == null) {
  		    	 FacesContext.getCurrentInstance().getExternalContext()
  		          .redirect("nopesquisa.xhtml");
  		    	
  		    } else {
  		    
  		 
  		  FacesContext.getCurrentInstance().getExternalContext()
          .redirect("pesquisa.xhtml");
  		    }
  		  titulo = "";
}
		
}
