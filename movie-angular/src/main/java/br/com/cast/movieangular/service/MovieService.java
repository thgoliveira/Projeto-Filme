package br.com.cast.movieangular.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.movieangular.api.MovieClient;
import br.com.cast.movieangular.api.MovieData;
import br.com.cast.movieangular.api.MovieRatings;
import br.com.cast.movieangular.api.SearchApi;
import br.com.cast.movieangular.api.SearchResultApi;
import br.com.cast.movieangular.dto.MovieDataDto;
import br.com.cast.movieangular.modelo.Movie;
import br.com.cast.movieangular.modelo.Search;
import br.com.cast.movieangular.repositorio.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieClient mClient;
	
	@Autowired
	private MovieRepository mRepository;
	
	
	
	public MovieDataDto getUmFilme(String imdbid) {
		
		Search mBusca = mRepository.buscarFilme(imdbid);
		MovieDataDto resposta = new MovieDataDto();
		
		if (mBusca == null) {
			MovieData mData = mClient.getUmFilme(imdbid);
			MovieDataDto mdDto = new MovieDataDto();
			mdDto.setTitulo(mData.getTitulo());
			mdDto.setAno(mData.getAno());
			mdDto.setEstreia(mData.getEstreia());
			mdDto.setDuracao(mData.getDuracao());
			mdDto.setGenero(mData.getGenero());
			mdDto.setDiretor(mData.getDiretor());
			mdDto.setEscritor(mData.getEscritor());
			mdDto.setAtores(mData.getAtores());
			mdDto.setRoteiro(mData.getRoteiro());
			mdDto.setPremiacoes(mData.getPremiacoes());
			mdDto.setPoster(mData.getPoster());
			mdDto.setImdbrating(mData.getImdbrating());
			mdDto.setImdbid(imdbid);
			mdDto.setType(mData.getType());
			mdDto.setProduction(mData.getProduction());
			
			resposta = mdDto;
			
			Search search = new Search();
			search.setTitulo(mdDto.getTitulo());
			search.setAno(mdDto.getAno());
			search.setImdbid(mdDto.getImdbid());
			search.setPoster(mdDto.getPoster());
			search.setType(mdDto.getType());
			
			Movie movie = new Movie();
			movie.setAtores(mdDto.getAtores());
			movie.setDiretor(mdDto.getDiretor());
			movie.setDuracao(mdDto.getDuracao());
			movie.setEscritor(mdDto.getEscritor());
			movie.setEstreia(mdDto.getEstreia());
			movie.setGenero(mdDto.getGenero());
			movie.setImdbrating(mdDto.getImdbrating());
			movie.setPremiacoes(mdDto.getPremiacoes());
			movie.setProduction(mdDto.getProduction());
			movie.setRoteiro(mdDto.getRoteiro());
			
			search.setMovie(movie);
			
			mRepository.inserir(search);
		} else {
			resposta = paraDto(titulo, mBusca);			
		}
		return resposta;
	}
	
	public List<MovieDataDto> getFilmes(String titulo) {
		
		List<MovieDataDto> data = new ArrayList<>();		
		
		Map<String, MovieDataDto> map = new HashMap<>();
		SearchApi buscar = mClient.getVariosFilmes(titulo);
		
		for (SearchResultApi srApi : buscar.getSearch()) {
			MovieDataDto mdDto = new MovieDataDto();
			mdDto.setTitulo(srApi.getTitulo());
			mdDto.setAno(srApi.getAno());
			mdDto.setImdbid(srApi.getImdbid());
			mdDto.setType(srApi.getType());
			
			if (srApi.getPoster().equals("N/A")) {
				mdDto.setPoster("../../assets/img/image-not-found.jpg");
			} else {
				mdDto.setPoster(srApi.getPoster());
			}
			
			map.put(titulo, mdDto);
			data.add(mdDto);
		}
		
		return data;
	}
	
	public List<MovieDataDto> getTodosBanco(){
		
		List<MovieDataDto> mdDtos = new ArrayList<>();
		List<Search> movies = mRepository.buscarTudo();
		
		for (Search movie : movies) {
			MovieDataDto mdDto = new MovieDataDto();
			mdDto.setTitulo(movie.getTitulo());
			mdDto.setAno(movie.getAno());
 			mdDto.setImdbid(movie.getImdbid());
			mdDto.setType(movie.getType());
			if (movie.getPoster().equals("N/A")) {
				mdDto.setPoster("../../assets/img/image-not-found.jpg");
			} else {
				mdDto.setPoster(movie.getPoster());
			}
			mdDtos.add(mdDto);
		}
		return mdDtos;
	}
	
	

			
//  --> Conversores
	

	
	
}
