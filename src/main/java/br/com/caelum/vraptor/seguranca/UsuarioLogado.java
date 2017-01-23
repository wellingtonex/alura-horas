package br.com.caelum.vraptor.seguranca;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.caelum.vraptor.models.Usuario;

@SessionScoped
@Named
public class UsuarioLogado implements Serializable{

	private static final long serialVersionUID = -1155322077008250086L;
	
	private Usuario usuario;

    public void login(Usuario usuario){
        this.usuario = usuario;
    }

    public void logout(){
        this.usuario = null;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public boolean isLogado() {
        return this.usuario != null;
    }
}