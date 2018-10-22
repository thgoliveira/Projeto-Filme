package br.com.cast.movieangular.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieData {

	@JsonProperty("Title")
	private String titulo;

	@JsonProperty("Year")
	private String ano;

	@JsonProperty("Rated")
	private String avaliado;

	@JsonProperty("Released")
	private String estreia;

	@JsonProperty("Runtime")
	private String duracao;

	@JsonProperty("Genre")
	private String genero;

	@JsonProperty("Director")
	private String diretor;

	@JsonProperty("Writer")
	private String escritor;

	@JsonProperty("Actors")
	private String atores;

	@JsonProperty("Plot")
	private String roteiro;

	@JsonProperty("Language")
	private String linguagem;

	@JsonProperty("Country")
	private String pais;

	@JsonProperty("Awards")
	private String premiacoes;

	@JsonProperty("Poster")
	private String poster;

	@JsonProperty("Ratings")
	private List<MovieRatings> notas;

	@JsonProperty("Metascore")
	private String metascore;

	@JsonProperty("imdbRating")
	private String imdbrating;

	@JsonProperty("imdbVotes")
	private String imdbvotes;

	@JsonProperty("imdbID")
	private String imdbid;

	@JsonProperty("Type")
	private String type;

	@JsonProperty("DVD")
	private String dvd;

	@JsonProperty("BoxOffice")
	private String boxoffice;

	@JsonProperty("Production")
	private String production;

	@JsonProperty("Website")
	private String website;

	@JsonProperty("Response")
	private String response;

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

	public String getAvaliado() {
		return avaliado;
	}

	public void setAvaliado(String avaliado) {
		this.avaliado = avaliado;
	}

	public String getEstreia() {
		return estreia;
	}

	public void setEstreia(String estreia) {
		this.estreia = estreia;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getEscritor() {
		return escritor;
	}

	public void setEscritor(String escritor) {
		this.escritor = escritor;
	}

	public String getAtores() {
		return atores;
	}

	public void setAtores(String atores) {
		this.atores = atores;
	}

	public String getRoteiro() {
		return roteiro;
	}

	public void setRoteiro(String roteiro) {
		this.roteiro = roteiro;
	}

	public String getLinguagem() {
		return linguagem;
	}

	public void setLinguagem(String linguagem) {
		this.linguagem = linguagem;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getPremiacoes() {
		return premiacoes;
	}

	public void setPremiacoes(String premiacoes) {
		this.premiacoes = premiacoes;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public List<MovieRatings> getNotas() {
		return notas;
	}

	public void setNotas(List<MovieRatings> notas) {
		this.notas = notas;
	}

	public String getMetascore() {
		return metascore;
	}

	public void setMetascore(String metascore) {
		this.metascore = metascore;
	}

	public String getImdbrating() {
		return imdbrating;
	}

	public void setImdbrating(String imdbrating) {
		this.imdbrating = imdbrating;
	}

	public String getImdbvotes() {
		return imdbvotes;
	}

	public void setImdbvotes(String imdbvotes) {
		this.imdbvotes = imdbvotes;
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

	public String getDvd() {
		return dvd;
	}

	public void setDvd(String dvd) {
		this.dvd = dvd;
	}

	public String getBoxoffice() {
		return boxoffice;
	}

	public void setBoxoffice(String boxoffice) {
		this.boxoffice = boxoffice;
	}

	public String getProduction() {
		return production;
	}

	public void setProduction(String production) {
		this.production = production;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

}
