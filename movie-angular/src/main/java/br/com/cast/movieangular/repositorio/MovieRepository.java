package br.com.cast.movieangular.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cast.movieangular.modelo.Movie;
import br.com.cast.movieangular.modelo.Search;

@Repository
public class MovieRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void inserir(Movie movie) {
		em.persist(movie);
	}
	
	public Search buscarFilme(String imdbid) {
		
		StringBuilder qlString = new StringBuilder();
		qlString.append("select s ")
				.append(" from ").append(Search.class.getName()).append(" s ")
				.append(" join fetch s.movie ")
				.append(" WHERE imdbid = :imdbid" );
		
		Query query = em.createQuery(qlString.toString());
		query.setParameter("titulo", imdbid);
		
		try {
			return (Search) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Movie> buscarTudoPorTitulo(String titulo) {
		StringBuilder qlString = new StringBuilder();
		qlString.append(" from ").append(Movie.class.getName())
				.append(" WHERE titulo = :titulo" );
		
		Query query = em.createQuery(qlString.toString());
		query.setParameter("titulo", titulo);
		
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Movie> buscarTudo() {
		StringBuilder qlString = new StringBuilder();
		qlString.append(" from ").append(Search.class.getName());
		
		Query query = em.createQuery(qlString.toString());
		
		return query.getResultList();
	}
		
}
