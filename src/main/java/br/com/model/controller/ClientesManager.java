package br.com.model.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.model.domain.Cliente;
import br.com.model.domain.Endereco;
import br.com.model.service.ClienteService;
import br.com.model.service.exception.NomeClienteJaCadastradoException;

@Named("clientesManager")
@ViewScoped
public class ClientesManager implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private ClienteService service;
	
	private List<Cliente> clientes = new ArrayList<>();
	
	private Cliente clienteEdicao = new Cliente();
	
	private Endereco enderecoEdicao;

	public ClientesManager() {
		List<Endereco> enderecosJoao = new ArrayList<>();
		enderecosJoao.addAll(Arrays.asList(
				new Endereco("Rua José Fonseca", "1000", "Centro", "Uberlândia"),
				new Endereco("Av. Cesário Alvim", "12", "Brasil", "Belo Horizonte"),
				new Endereco("Av. Afonso Pena", "1280", "Centro", "Uberaba")));
		Cliente joao = new Cliente();
		joao.setNome("Jão de deus");
		joao.setEnderecos(enderecosJoao);
		clientes.add(joao);
		
		clienteEdicao.setEnderecos(enderecosJoao);
	}
	
	public void salvar(){
		try {
			service.salvar(clienteEdicao);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente salvo com sucesso!"));
		} catch (NomeClienteJaCadastradoException e) {
			e.printStackTrace();
		}
	}
	
	public void novoEndereco() {
		enderecoEdicao = new Endereco();
	}
	
	public String novoCliente() {
		clienteEdicao = new Cliente();
		return "CadastroCliente?faces-redirect=true";
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente getClienteEdicao() {
		return clienteEdicao;
	}

	public void setClienteEdicao(Cliente clienteEdicao) {
		this.clienteEdicao = clienteEdicao;
	}

	public Endereco getEnderecoEdicao() {
		return enderecoEdicao;
	}

	public void setEnderecoEdicao(Endereco enderecoEdicao) {
		this.enderecoEdicao = enderecoEdicao;
	}

}
