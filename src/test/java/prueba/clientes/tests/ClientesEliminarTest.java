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
public class ClientesEliminarTest {
	
	
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

	
	///cuandoSituaciónEntoncesResultadoEsperado().
	
	
	@Test
	public void cuandoElimina1EntoncesTrue() {
		this.cliDao.deleteById("17222222");
		
		boolean existe = this.cliDao.existsById("17222222");
		
		assertTrue(!existe);
	
	}
	
	
	@Test
	public void cuandoNoElimina1EntoncesFalse() {
		
		boolean eliminado=false;
		
		boolean existe = this.cliDao.existsById("172222221");
		
		
		if (existe) {
			this.cliDao.deleteById("172222221");
			eliminado = true;
		}
		
		assertFalse(eliminado);
	
	}
	
	
	

}
