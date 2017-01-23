package br.com.caelum.vraptor.controllers;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.daos.HoraLancadaDao;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.models.HoraLancada;
import br.com.caelum.vraptor.seguranca.UsuarioLogado;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class HoraLancadaController {

    private HoraLancadaDao horaLancadaDao;

    private Validator validator;

    private Result result;

    private UsuarioLogado usuarioLogado;

    @Inject
    public HoraLancadaController(HoraLancadaDao horaLancadaDao,
            Validator validator, Result result, UsuarioLogado usuarioLogado) {
        this.horaLancadaDao = horaLancadaDao;
        this.validator = validator;
        this.result = result;
        this.usuarioLogado = usuarioLogado;
    }

    public HoraLancadaController() {}

    public void form(){
    	System.out.println("Chamou form HoraLancadaController");
    }

    @IncludeParameters
    public void adiciona(@Valid HoraLancada horaLancada){
        validator.onErrorRedirectTo(this).form();
        horaLancada.setUsuario(usuarioLogado.getUsuario());
        horaLancadaDao.adiciona(horaLancada);
        result.redirectTo(this).lista();
    }

    public void lista(){
        result.include("horas", horaLancadaDao.lista());
    }
}