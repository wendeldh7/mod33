/**
 * 
 */
package br.com.gomes.dao;

import br.com.gomes.domain.Carro;
import br.com.gomes.domain.Acessorio;

/**
 * @author wendel.gomes
 *
 */
public interface IAcessorioDao {

	Acessorio cadastrar(Acessorio acessorio);
	
	Acessorio buscarPorCodigoCurso(String codigoCarro);
	
	Acessorio buscarPorCurso(Carro carro);
	
	Acessorio buscarPorCodigoCursoCriteria(String codigoCurso);
	
	Acessorio buscarPorCursoCriteria(Carro carro);

}
