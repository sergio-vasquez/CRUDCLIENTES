package prueba.clientes.tests;

import static org.junit.Assert.*;

import javax.validation.constraints.AssertTrue;

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
public class ClientesObtenerUnoTest {

	
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

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void cuandoObtiene1EntoncesTrue() {
		
		Cliente cli = this.cliDao.findById("17222222").orElse(null);
		
		assertTrue(cli!=null);
		
		
	}
	
	@Test
	public void cuandoNoObtiene1EntoncesFalse() {
		
		boolean obtiene = false;
		Cliente cli = this.cliDao.findById("172222227").orElse(null);
		
		System.out.println("cliente: "+cli);
		
		if (cli!=null) {
			obtiene = true;
		}
		assertFalse(obtiene);
		
		
	}

}
