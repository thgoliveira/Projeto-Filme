package br.com.cast.movieangular.api;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MovieClient {
	
	private static final String URL_BUSCA_FILMES = "http://www.omdbapi.com/?t={titulo}&apikey={appid}";
	private static final String APPID = "3ae1cd3a";
	private RestTemplate client;
	
	public MovieClient(RestTemplateBuilder builder) {
		this.client = builder.build();
	}
	
	public MovieData getUmFilme(String titulo) {
		MovieData mData = this.client.getForObject(URL_BUSCA_FILMES, MovieData.class, titulo, APPID);
		return mData;
	}

}
