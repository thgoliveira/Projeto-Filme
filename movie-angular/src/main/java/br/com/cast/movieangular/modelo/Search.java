package br.com.cast.movieangular.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "search")
public class Search {

	@Id
	@SequenceGenerator(sequenceName = "search_id_seq", name = "gerador_search_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gerador_search_seq")
	private Integer id;

	private String titulo;
	private String ano;
	private String imdbid;
	private String type;
	private String poster;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idfilme")
	private Movie idfilme;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Movie getIdfilme() {
		return idfilme;
	}

	public void setIdfilme(Movie idfilme) {
		this.idfilme = idfilme;
	}

}
