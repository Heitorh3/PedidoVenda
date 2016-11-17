package br.com.model.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.model.domain.Teste;

@Named
@ViewScoped
public class UsuariosManager {

	@Inject
	private Teste teste;
	
	public double getPreco(){
		return teste.calcularPreco(12, 44.55);
	}
	
}
