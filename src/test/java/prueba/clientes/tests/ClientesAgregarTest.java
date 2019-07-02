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
public class ClientesAgregarTest {
	
	
	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	IClienteDAO cliDao;
	

	@Before
	public void setUp() throws Exception {
		
		/*Equipo equipo = new Equipo("cobreloa",38,"calama","fantasma figueroa");
		this.entityManager.persist(equipo);*/
		
		
		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	
	
	
	@Test
	public void cuandoInsertaEntoncesTrue() {
		
		Cliente cli1 = new Cliente("17110109", "sergio", "vasquez", "sergio@hotmail.com", "+560999145");
		
		this.cliDao.save(cli1);
		
		boolean existe = this.cliDao.existsById(cli1.getRut());
		
		assertTrue(existe);
		
		
		
	}
	


}
