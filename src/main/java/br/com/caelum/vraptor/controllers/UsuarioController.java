package br.com.caelum.vraptor.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.daos.UsuarioDao;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.models.Usuario;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class UsuarioController {
	
	private UsuarioDao usuarioDao;
	private Result result;
	private Validator validator;
	
	public UsuarioController(){}

	@Inject
	public UsuarioController(UsuarioDao usuarioDao, Result result, Validator validator) {
		this.usuarioDao = usuarioDao;
		this.result = result;
		this.validator = validator;
	}

	public void form(){}
	
	@IncludeParameters
	public void adiciona(@Valid Usuario usuario) {
		validator.onErrorRedirectTo(this).form();
		usuarioDao.adicionar(usuario);
		result.redirectTo(this).lista();
	}
	
	public void  lista() {
		List<Usuario> usuarios = usuarioDao.lista();
		result.include("usuarios", usuarios);
	}
}
