package br.com.cast.movieangular.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cast.movieangular.modelo.Search;

@Repository
public class MovieRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void inserir(Search search) {
		em.persist(search);
	}
	
	@Transactional
	public void alterar(Search search) {
		em.merge(search);
	}
	
	public Search buscarFilme(String imdbid) {
		
		StringBuilder qlString = new StringBuilder();
		qlString.append("select s ")
				.append(" from ").append(Search.class.getName()).append(" s ")
				.append(" left join fetch s.idfilme ")
				.append(" WHERE s.imdbid = :imdbid" );
		
		Query query = em.createQuery(qlString.toString());
		query.setParameter("imdbid", imdbid);
		
		try {
			return (Search) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Search> buscarTudoPorTitulo(String titulo) {
		StringBuilder qlString = new StringBuilder();
		qlString.append(" from ").append(Search.class.getName())
				.append(" WHERE UPPER(titulo) Like :titulo" );
		
		Query query = em.createQuery(qlString.toString());
		query.setParameter("titulo", "%" + titulo.toUpperCase() + "%");
		
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Search> buscarTudo() {
		StringBuilder qlString = new StringBuilder();
		qlString.append(" from ").append(Search.class.getName());
		
		Query query = em.createQuery(qlString.toString());
		
		return query.getResultList();
	}
		
}
