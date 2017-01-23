package br.com.caelum.vraptor.controllers;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.seguranca.Open;

@Controller
public class IndexController {

	@Open
    public void index(){}
}