package prueba.clientes.modelo.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import prueba.clientes.modelo.Cliente;

@Repository
public interface IClienteDAO extends JpaRepository<Cliente, String>{
	
	
	
	Optional<Cliente> findByNombres(String nombres);

}
