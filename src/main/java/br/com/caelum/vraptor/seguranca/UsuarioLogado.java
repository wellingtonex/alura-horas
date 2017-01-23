package br.com.caelum.vraptor.seguranca;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.caelum.vraptor.models.Usuario;

@Named //para conseguir acessar a classe na jsp
@SessionScoped
public class UsuarioLogado implements Serializable{

	private static final long serialVersionUID = -5012421440954128121L;

	private Usuario usuario;
	
	public void login(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void logout(){
		this.usuario = null;
	}
	
	public boolean isLogado() {
		return this.usuario != null;
	}
}
