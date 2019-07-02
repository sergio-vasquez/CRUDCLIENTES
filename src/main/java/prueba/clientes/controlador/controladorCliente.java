package prueba.clientes.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import prueba.clientes.modelo.Cliente;
import prueba.clientes.modelo.repositorio.IClienteDAO;

@RestController
public class controladorCliente {
	
	@Autowired
	IClienteDAO cliDao;
	
	
	
	/*GET Listar clientes: http://localhost:8181/clientes
 GET Mostrar un cliente buscando por rut: http://localhost:8181/clientes/{rut}
 GET Mostrar un cliente buscando por nombre: http://localhost:8181/clientes/buscar/{nombre}
 POST Crear un cliente: http://localhost:8181/clientes
 PUT Modificar un cliente: http://localhost:8181/clientes
 DELETE Eliminar un cliente: http://localhost:8181/clientes/{rut}*/
	
	
	@GetMapping("/clientes")
	public List<Cliente> listarClientes(){
		return this.cliDao.findAll();
	}
	
	
	@GetMapping("/clientes/{rut}")
	public Cliente obtenerCliente(@PathVariable String rut) {
		
		return this.cliDao.findById(rut).orElse(new Cliente());
		
	}
	
	
	//////////////////////////////////////
	@GetMapping("/clientes/buscar/{nombres}")
	public Cliente buscarCliente(@PathVariable String nombres) {
		
		return this.cliDao.findByNombres(nombres).get();
		
				
	}
	
	
	
	@PostMapping("/clientes")
	public boolean agregarCliente(@RequestBody Cliente cliente) {
		
		if (!this.cliDao.existsById(cliente.getRut())) {
			
			this.cliDao.save(cliente);
			
			
			if (this.cliDao.existsById(cliente.getRut())) {
				System.out.println("Cliente agregado");
				return true;
			}
		}
		
		
		return false;
	}
	
	
	@PutMapping("/clientes")
	public boolean modificarCliente(@RequestBody Cliente cliente) {
		
		if (this.cliDao.existsById(cliente.getRut())) {
			this.cliDao.save(cliente);
			System.out.println("cliente actualizado");
			return true;
		}
		
		System.out.println("cliente no existe");
		return false;
		
	}
	
	
	@DeleteMapping("/clientes/{rut}")
	public boolean eliminarCliente(@PathVariable String rut) {
		
		if (this.cliDao.existsById(rut)) {
			this.cliDao.deleteById(rut);
			
			
			if (!this.cliDao.existsById(rut)) {
				System.out.println("Cliente eliminado exitosamente");
				return true;
			}
		}
		
		System.out.println("cliente no existe");
		return false;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
