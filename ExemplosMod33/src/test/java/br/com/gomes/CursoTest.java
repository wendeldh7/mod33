/**
 * 
 */
package br.com.gomes;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.gomes.dao.CarroDao;
import br.com.gomes.dao.ICarroDao;
import br.com.gomes.domain.Carro;

/**
 * @author wendel.gomes
 *
 */
public class CarroTest {

	private ICarroDao carroDao;
	
	public CarroTest() {
		carroDao = new CarroDao();
	}

	@Test
	public void cadastrar() {
		Carro carro = new Carro();
		carro.setCodigo("A1");
		carro.setDescricao("CARRO TESTE");
		carro.setNome("Carro");
		carro = carroDao.cadastrar(carro);
		
		assertNotNull(carro);
		assertNotNull(carro.getId());
	}
}
