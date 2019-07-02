package prueba.clientes.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import prueba.clientes.modelo.Cliente;
import prueba.clientes.modelo.repositorio.IClienteDAO;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ClientesModificarTest {
	
	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	IClienteDAO cliDao;

	@Before
	public void setUp() throws Exception {
		
		Cliente cli1 = new Cliente("17110109", "sergio", "vasquez", "sergio@hotmail.com", "+560999145");
		this.entityManager.persist(cli1);
		
		Cliente cli2 = new Cliente("17222222", "ricardo", "rañileo", "ricar@hotmail.com", "+5622222");
		this.entityManager.persist(cli2);
		
		Cliente cli3 = new Cliente("17333333", "gustavo", "purran", "gusti@hotmail.com", "+5633333");
		this.entityManager.persist(cli3);
		
		Cliente cli4 = new Cliente("17444444", "javo", "purran", "javo@hotmail.com", "+5644444");
		this.entityManager.persist(cli4);
	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	@Test
	public void cuandoModifica1EntoncesTrue() {
		boolean iguales = false;
		
		Cliente cli = new Cliente("17333333", "seventeen", "jalisco", "jalisco@hotmail.com", "+7777777");
		
		this.cliDao.save(cli);
		
		Cliente cli2 = this.cliDao.findById("17333333").orElse(null);
		
		if (cli2.getNombres().equalsIgnoreCase(cli.getNombres()) && cli2.getApellidos().equalsIgnoreCase(cli.getApellidos())
				&& cli2.getEmail().equalsIgnoreCase(cli.getEmail()) && cli2.getCelular().equalsIgnoreCase(cli.getCelular())) {
			iguales = true;
		}
		
		
		assertTrue("deberian ser iguales", iguales);
		
	
	}
	
	
	@Test
	public void cuandoNoModificaEntoncesFalse() {
		
		boolean modificado = false;
		
		Cliente cli = new Cliente("173333331", "seventeen", "jalisco", "jalisco@hotmail.com", "+7777777");
		
		if (this.cliDao.existsById("173333331")) {
			this.cliDao.save(cli);
			modificado = true;
		} 
		
		
		assertFalse(modificado);
		
		
	
	}
	
	
	
	

}
