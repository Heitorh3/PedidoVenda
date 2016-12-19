package br.com.model.repository;

import java.util.Optional;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;


import br.com.model.domain.Cliente;
import br.com.model.repository.helper.cliente.ClientesQueries;

@Repository(forEntity = Cliente.class)
public interface ClientesRepository extends EntityRepository<Cliente, Long>, ClientesQueries {

	@Query("select c from Cliente c where c.nome = ?1")
	Optional<Cliente> findByName(String nome);
	
	
	//@Query("select c from Cliente c where c.email = ?1")
	Optional<Cliente> findByEmail(String email);
	
}
