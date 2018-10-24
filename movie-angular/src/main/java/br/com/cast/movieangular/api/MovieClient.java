package br.com.cast.movieangular.api;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.cast.movieangular.dto.MovieDataDto;
import br.com.cast.movieangular.service.MovieService;

@Component
public class MovieClient {
	
	private static final String URL_BUSCA_FILME = "http://www.omdbapi.com/?i={imdbid}&apikey={appid}";
	private static final String URL_BUSCA_FILMES = "http://www.omdbapi.com/?s={titulo}&apikey={appid}";
	private static final String APPID = "3ae1cd3a";
	private RestTemplate client;
	private MovieService mService;
	
	public MovieClient(RestTemplateBuilder builder) {
		this.client = builder.build();
	}
	
	public MovieData getUmFilme(String imdbid) {
		MovieData mData = this.client.getForObject(URL_BUSCA_FILME, MovieData.class, imdbid, APPID);
		return mData;
	}
	
	public SearchApi getVariosFilmes(String titulo) {
		SearchApi search = this.client.getForObject(URL_BUSCA_FILMES, SearchApi.class, titulo, APPID);
		return search;
	}
	
	public List<MovieDataDto> getTodosDoBanco() {
		List<MovieDataDto> mdDto = mService.getTodosBanco();
		return mdDto;
	}
	
	

}
