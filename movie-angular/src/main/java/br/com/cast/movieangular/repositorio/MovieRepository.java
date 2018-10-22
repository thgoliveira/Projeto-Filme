package br.com.cast.movieangular.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cast.movieangular.modelo.Movie;

@Repository
public class MovieRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void inserir(Movie movie) {
		em.persist(movie);
	}
	
	public Movie buscarFilme(String titulo) {
		
		StringBuilder qlString = new StringBuilder();
		qlString.append(" from ").append(Movie.class.getName())
				.append(" WHERE titulo = :titulo" );
		
		Query query = em.createQuery(qlString.toString());
		query.setParameter("titulo", titulo);
		
		try {
			return (Movie) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
		
}
