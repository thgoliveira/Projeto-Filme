package br.com.cast.movieangular.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.movieangular.api.MovieClient;
import br.com.cast.movieangular.api.MovieData;
import br.com.cast.movieangular.api.MovieRatings;
import br.com.cast.movieangular.dto.MovieDataDto;
import br.com.cast.movieangular.modelo.Movie;
import br.com.cast.movieangular.repositorio.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieClient mClient;
	
	@Autowired
	private MovieRepository mRepository;

	public MovieDataDto getUmFilme(String titulo) {
		
		Movie mBusca = mRepository.buscarFilme(titulo);
		MovieDataDto resposta = new MovieDataDto();
		
		
		if (mBusca == null) {
			MovieData mData = mClient.getUmFilme(titulo);
			resposta = fromApi(titulo, mData);
			Movie movie = paraEntidade(resposta);
			mRepository.inserir(movie);
		} else {
			resposta = paraDto(titulo, mBusca);			
		}
		return resposta;
	}

			
//  --> Conversores
	
	/**
	 * Metodo que converte uma Api em Dto
	 * @param mData
	 * @return
	 */
	private MovieDataDto fromApi(String titulo, MovieData mData) {
		MovieDataDto mdDto = new MovieDataDto();
		
		mdDto.setTitulo(titulo);
		mdDto.setAno(mData.getAno());
		mdDto.setAvaliado(mData.getAvaliado());
		mdDto.setEstreia(mData.getEstreia());
		mdDto.setDuracao(mData.getDuracao());
		mdDto.setGenero(mData.getGenero());
		mdDto.setDiretor(mData.getDiretor());
		mdDto.setEscritor(mData.getEscritor());
		mdDto.setAtores(mData.getAtores());
		mdDto.setRoteiro(mData.getRoteiro());
		mdDto.setLinguagem(mData.getLinguagem());
		mdDto.setPais(mData.getPais());
		mdDto.setPremiacoes(mData.getPremiacoes());
		mdDto.setPoster(mData.getPoster());
		
		for (MovieRatings resultado : mData.getNotas()) {
			mdDto.setFonte(resultado.getFonte());
			mdDto.setValor(resultado.getValor());
		}
		
		mdDto.setMetascore(mData.getMetascore());
		mdDto.setImdbrating(mData.getImdbrating());
		mdDto.setImdbvotes(mData.getImdbvotes());
		mdDto.setImdbid(mData.getImdbid());
		mdDto.setType(mData.getType());
		mdDto.setDvd(mData.getDvd());
		mdDto.setBoxoffice(mData.getBoxoffice());
		mdDto.setProduction(mData.getProduction());
		mdDto.setWebsite(mData.getWebsite());
		mdDto.setResponse(mData.getResponse());
		
		
		return mdDto;
	}
	
	/**
	 * Metodo para converter Dto em Entidade
	 * @param mdDto
	 * @return
	 */
	private Movie paraEntidade(MovieDataDto mdDto) {
		Movie movie = new Movie();
		movie.setTitulo(mdDto.getTitulo());
		movie.setAno(mdDto.getAno());
		movie.setAvaliado(mdDto.getAvaliado());
		movie.setEstreia(mdDto.getEstreia());
		movie.setDuracao(mdDto.getDuracao());
		movie.setGenero(mdDto.getGenero());
		movie.setDiretor(mdDto.getDiretor());
		movie.setEscritor(mdDto.getEscritor());
		movie.setAtores(mdDto.getAtores());
		movie.setRoteiro(mdDto.getRoteiro());
		movie.setLinguagem(mdDto.getLinguagem());
		movie.setPais(mdDto.getPais());
		movie.setPremiacoes(mdDto.getPremiacoes());
		movie.setPoster(mdDto.getPoster());
		movie.setFonte(mdDto.getFonte());
		movie.setValor(mdDto.getValor());
		movie.setMetascore(mdDto.getMetascore());
		movie.setImdbrating(mdDto.getImdbrating());
		movie.setImdbvotes(mdDto.getImdbvotes());
		movie.setImdbid(mdDto.getImdbid());
		movie.setType(mdDto.getType());
		movie.setDvd(mdDto.getDvd());
		movie.setBoxoffice(mdDto.getBoxoffice());
		movie.setProduction(mdDto.getProduction());
		movie.setWebsite(mdDto.getWebsite());
		movie.setResponse(mdDto.getResponse());
		
		return movie;
	}
	
	
	/**
	 * Metodo que converte uma entidade em dto
	 * @param movie
	 * @return
	 */
	private MovieDataDto paraDto(String titulo, Movie movie) {
		MovieDataDto mdDto = new MovieDataDto();
		mdDto.setId(movie.getId());
		mdDto.setTitulo(titulo);
		mdDto.setAno(movie.getAno());
		mdDto.setAvaliado(movie.getAvaliado());
		mdDto.setEstreia(movie.getEstreia());
		mdDto.setDuracao(movie.getDuracao());
		mdDto.setGenero(movie.getGenero());
		mdDto.setDiretor(movie.getDiretor());
		mdDto.setEscritor(movie.getEscritor());
		mdDto.setAtores(movie.getAtores());
		mdDto.setRoteiro(movie.getRoteiro());
		mdDto.setLinguagem(movie.getLinguagem());
		mdDto.setPais(movie.getPais());
		mdDto.setPremiacoes(movie.getPremiacoes());
		mdDto.setPoster(movie.getPoster());
		mdDto.setFonte(movie.getFonte());
		mdDto.setValor(movie.getValor());
		mdDto.setMetascore(movie.getMetascore());
		mdDto.setImdbrating(movie.getImdbrating());
		mdDto.setImdbvotes(movie.getImdbvotes());
		mdDto.setImdbid(movie.getImdbid());
		mdDto.setType(movie.getType());
		mdDto.setDvd(movie.getDvd());
		mdDto.setBoxoffice(movie.getBoxoffice());
		mdDto.setProduction(movie.getProduction());
		mdDto.setWebsite(movie.getWebsite());
		mdDto.setResponse(movie.getResponse());
		
		return mdDto;
	}
	
	
}
