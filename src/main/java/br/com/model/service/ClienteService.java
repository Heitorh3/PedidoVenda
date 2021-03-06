package br.com.model.service;

import java.util.Optional;

import javax.inject.Inject;

import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.model.domain.Cliente;
import br.com.model.repository.ClientesRepository;
import br.com.model.service.exception.NomeClienteJaCadastradoException;

public class ClienteService {

	static Logger log = LogManager.getLogger(ClienteService.class);
	
	@Inject
	private ClientesRepository clientes;
	
	@Transactional
	public Cliente salvar(Cliente cliente) throws NomeClienteJaCadastradoException{
		Optional<Cliente> clienteExistente = clientes.findByEmail(cliente.getEmail());

		if(clienteExistente.isPresent() && !clienteExistente.get().equals(cliente)){
			log.error("cliente já cadastrado!");
			throw new NomeClienteJaCadastradoException("Cliente já cadastrado!");
		}
			
		log.info("Salvando o cliente!");
		return clientes.save(cliente);
		
	}
}
