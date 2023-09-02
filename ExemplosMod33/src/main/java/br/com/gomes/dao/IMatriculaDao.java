/**
 * 
 */
package br.com.gomes.dao;

import br.com.gomes.domain.Curso;
import br.com.gomes.domain.Matricula;

/**
 * @author wendel.gomes
 *
 */
public interface IMatriculaDao {

	Matricula cadastrar(Matricula mat);
	
	Matricula buscarPorCodigoCurso(String codigoCurso);
	
	Matricula buscarPorCurso(Curso curso);
	
	Matricula buscarPorCodigoCursoCriteria(String codigoCurso);
	
	Matricula buscarPorCursoCriteria(Curso curso);

}
