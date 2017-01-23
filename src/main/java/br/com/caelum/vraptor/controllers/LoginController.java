package br.com.caelum.vraptor.controllers;

import javax.inject.Inject;

import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.daos.UsuarioDao;
import br.com.caelum.vraptor.models.Usuario;
import br.com.caelum.vraptor.seguranca.Open;
import br.com.caelum.vraptor.seguranca.UsuarioLogado;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;

public class LoginController {

	private UsuarioDao usuarioDao;
	private UsuarioLogado usuarioLogado;
	private Result result;
	private Validator validator;

	public LoginController() {
	}

	@Inject
	public LoginController(UsuarioDao usuarioDao, UsuarioLogado usuarioLogado,
			Result result, Validator validator) {
		this.usuarioDao = usuarioDao;
		this.usuarioLogado = usuarioLogado;
		this.result = result;
		this.validator = validator;
	}

	@Open
	public void form(){}

	@Post
	@Open
	public void autentica(String login, String senha) {
		Usuario usuario = this.usuarioDao.busca(login, senha);
		if (usuario != null) {
			usuarioLogado.login(usuario);
			result.redirectTo(UsuarioController.class).lista();
		} else {
			validator.add(new SimpleMessage("login_invalido", "Login ou senhas incorretos"));
			validator.onErrorRedirectTo(this).form();
		}
	}
	
	@Open
	public void logout() {
		usuarioLogado.logout();
		result.redirectTo(this).form();
	}
}
