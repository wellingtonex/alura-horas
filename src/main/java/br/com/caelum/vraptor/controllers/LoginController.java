package br.com.caelum.vraptor.controllers;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.daos.UsuarioDao;
import br.com.caelum.vraptor.models.Usuario;
import br.com.caelum.vraptor.seguranca.Open;
import br.com.caelum.vraptor.seguranca.UsuarioLogado;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class LoginController {
	
	private UsuarioLogado usuarioLogado;
    private UsuarioDao usuarioDao;
    private Validator validator;
    private Result result;

    @Inject
    public LoginController(UsuarioLogado usuarioLogado, UsuarioDao usuarioDao,
            Validator validator, Result result) {
        this.usuarioLogado = usuarioLogado;
        this.usuarioDao = usuarioDao;
        this.validator = validator;
        this.result = result;
    }
    public LoginController() {
    }

	@Open
	public void form() {
	}

	@Open
	@Post
    public void login(String login, String senha){
		System.out.println("Login: " + login);
		System.out.println("Login: " + senha);
        Usuario usuario = usuarioDao.busca(login, senha);
        if(usuario != null){
            usuarioLogado.login(usuario);
            result.redirectTo(IndexController.class).index();
        }else{
            validator.add(new SimpleMessage("login_invalid", "Login ou senha incorretos"));
            validator.onErrorRedirectTo(this).form();
        }
    }

	@Open
	public void logout() {
		usuarioLogado.logout();
        result.redirectTo(this).form();
	}

}