package br.com.cast.movieangular.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchResultApi {

	@JsonProperty("Title")
	private String titulo;

	@JsonProperty("Year")
	private String ano;

	@JsonProperty("imdbID")
	private String imdbid;

	@JsonProperty("Type")
	private String type;

	@JsonProperty("Poster")
	private String poster;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getImdbid() {
		return imdbid;
	}

	public void setImdbid(String imdbid) {
		this.imdbid = imdbid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

}
