/**
 * 
 */
package br.com.gomes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.Instant;

import org.junit.Test;

import br.com.gomes.dao.CarroDao;
import br.com.gomes.dao.MarcaDao;
import br.com.gomes.dao.CarroDao;
import br.com.gomes.dao.ICarroDao;
import br.com.gomes.dao.IMarcaDao;
import br.com.gomes.dao.ICarroDao;
import br.com.gomes.dao.IAcessorioDao;
import br.com.gomes.dao.AcessorioDao;
import br.com.gomes.domain.Carro;
import br.com.gomes.domain.Marca;
import br.com.gomes.domain.Carro;
import br.com.gomes.domain.Acessorio;

/**
 * @author wendel.gomes
 *
 */
public class AcessorioTest {
	
	private IAcessorioDao acessorioDao;
	
	private ICarroDao carroDao;
	
	private ICarroDao carroDao;
	
	private IMarcaDao marcaDao;
	
	public MatriculaTest() {
		acessorioDao = new AcessorioDao();
		carroDao = new CarroDao();
		carroDao = new CarroDao();
		marcaDao = new MarcaDao();
	}

	@Test
	public void cadastrar() {
		Carro carro = criarCarro("A1");
		Carro carro = criarCarro("A1");
		
		Acessorio acessorio = new Acessorio();
		acessorio.setCodigo("A1");
		acessorio.setDataAcessorio(Instant.now());
		acessorio.setStatus("ATIVA");
		acessorio.setValor(2000d);
		acessorio.setCarro(carro);
		acessorio.setCarro(carro);
		
		carro.setAcessorio(acessorio);
		acessorio = acessorioDao.cadastrar(acessorio);
		
		assertNotNull(acessorio);
		assertNotNull(acessorio.getId());
		
		Acessorio acessorioBD = acessorioDao.buscarPorCodigoCarro(acessorio.getCodigo());
		assertNotNull(acessorioBD);
		assertEquals(acessorio.getId(), acessorioBD.getId());
		
		Acessorio acessorioBDObj = matriculaDao.buscarPorCurso(curso);
		assertNotNull(acessorioBDObj);
		assertEquals(acessorio.getId(), acessorioBDObj.getId());
	}
	
	private Marca criarComputador(String codigo) {
		Marca marca = new Marca();
		marca.setCodigo(codigo);
		marca.setDescricao("Marca 1");
		return marca;
		//return computadorDao.cadastrar(marca);
	}

	private Aluno criarAluno(String codigo) {
		Marca marca = criarMarca("A1");
		Marca marca2 = criarMarca("A2");
		Carro carro = new Carro();
		carro.setCodigo(codigo);
		carro.setNome("Wendel");
		carro.add(marca);
		carro.add(marca2);
		//comp.add(carro);
		//comp2.add(carro);
		return carroDao.cadastrar(carro);
	}

	private Carro criarCurso(String codigo) {
		Carro carro = new Carro();
		carro.setCodigo(codigo);
		carro.setDescricao("CARRO TESTE");
		carro.setNome("Carro");
		return carroDao.cadastrar(carro);
	}
}
