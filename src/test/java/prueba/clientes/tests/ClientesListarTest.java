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
public class ClientesListarTest {

	@Autowired
	TestEntityManager entityManager;

	@Autowired
	IClienteDAO cliDao;

	@Before
	public void setUp() throws Exception {

		

	}

	@After
	public void tearDown() throws Exception {
	}

	/// cuandoModifica1EntoncesTrue()

	@Test
	public void cuandoListarCantidadEs4() {
		
		Cliente cli1 = new Cliente("17110109", "sergio", "vasquez", "sergio@hotmail.com", "+560999145");
		this.entityManager.persist(cli1);

		Cliente cli2 = new Cliente("17222222", "ricardo", "rañileo", "ricar@hotmail.com", "+5622222");
		this.entityManager.persist(cli2);

		Cliente cli3 = new Cliente("17333333", "gustavo", "purran", "gusti@hotmail.com", "+5633333");
		this.entityManager.persist(cli3);

		Cliente cli4 = new Cliente("17444444", "javo", "purran", "javo@hotmail.com", "+5644444");
		this.entityManager.persist(cli4);

		int cantidad = this.cliDao.findAll().size();

		assertTrue("cantidad deberia ser 4 pero es: " + cantidad, cantidad == 4);

	}

	
	
	@Test
	public void cuandoListar1CantidadEs_1() {
		
		
		Cliente cli4 = new Cliente("17444444", "javo", "purran", "javo@hotmail.com", "+5644444");
		this.entityManager.persist(cli4);

		int cantidad = this.cliDao.findAll().size();

		assertTrue("cantidad deberia ser 1 pero es: " + cantidad, cantidad == 1);

	}
	
	
	@Test
	public void cuandoListaVaciaCantidadEs_0() {
		

		int cantidad = this.cliDao.findAll().size();

		assertTrue("cantidad deberia ser 0 pero es: " + cantidad, cantidad == 0);

	}

}
