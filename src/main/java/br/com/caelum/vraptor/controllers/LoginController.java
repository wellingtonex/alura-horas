package br.com.caelum.vraptor.controllers;

import br.com.caelum.vraptor.Controller;

@Controller
public class LoginController {

	public void form() {
	}
	
	public void login(String login, String senha) {
		System.err.println("Login: " + login);
		System.err.println("Senha: " + senha);
	}
	
}