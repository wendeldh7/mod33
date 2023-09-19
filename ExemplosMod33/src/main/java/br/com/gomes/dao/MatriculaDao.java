/**
 * 
 */
package br.com.gomes.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import br.com.gomes.domain.Curso;
import br.com.gomes.domain.Acessorio;

/**
 * @author wendel.gomes
 *
 */
public class AcessorioDao implements IAcessorioDao {

	@Override
	public Acessorio cadastrar(Acessorio acessorio) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(acessorio);
		entityManager.getTransaction().commit();
		 
		entityManager.close();
		entityManagerFactory.close();
		return acessorio;
	}

	@Override
	public Acessorio buscarPorCodigoCurso(String codigoCurso) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT m FROM Acessorio m ");
		sb.append("INNER JOIN Curso c on c = m.carro ");
		sb.append("WHERE c.codigo = :codigoCarro");
		
		entityManager.getTransaction().begin();
		TypedQuery<Matricula> query = 
				entityManager.createQuery(sb.toString(), Acessorio.class);
		query.setParameter("codigoCarro", codigoCarro);
		Matricula acessorio = query.getSingleResult();    
		
		entityManager.close();
		entityManagerFactory.close();
		
		return acessorio;
	}

	@Override
	public Matricula buscarPorCurso(Curso curso) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT m FROM Acessorio m ");
		sb.append("INNER JOIN Carro c on c = m.carro ");
		sb.append("WHERE c = :carro");
		
		entityManager.getTransaction().begin();
		TypedQuery<Acessorio> query = 
				entityManager.createQuery(sb.toString(), Acessorio.class);
		query.setParameter("carro", carro);
		Acessorio acessorio = query.getSingleResult();    
		
		entityManager.close();
		entityManagerFactory.close();
		
		return acessorio;
	}
	
	@Override
	public Matricula buscarPorCodigoCursoCriteria(String codigoCurso) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Acessorio> query = builder.createQuery(Acessorio.class);
		Root<Acessorio> root = query.from(Acessorio.class);
		Join<Object, Object> join = root.join("carro", JoinType.INNER);
		query.select(root).where(builder.equal(join.get("codigo"), codigoCurso));
		
		TypedQuery<Acessorio> tpQuery = 
				entityManager.createQuery(query);
		Acessorio acessorio = tpQuery.getSingleResult();    
		
		entityManager.close();
		entityManagerFactory.close();
		
		return acessorio;
	}

	@Override
	public Acessorio buscarPorCursoCriteria(Carro carro) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("ExemploJPA");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Acessorio> query = builder.createQuery(Acessorio.class);
		Root<Acessorio> root = query.from(Acessorio.class);
		Join<Object, Object> join = root.join("carro", JoinType.INNER);
		query.select(root).where(builder.equal(join, carro));
		
		TypedQuery<Acessorio> tpQuery = 
				entityManager.createQuery(query);
		Acessorio acessorio = tpQuery.getSingleResult();    
		
		entityManager.close();
		entityManagerFactory.close();
		
		return acessorio;
	}

}
