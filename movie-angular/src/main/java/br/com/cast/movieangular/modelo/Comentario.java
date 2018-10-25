package br.com.cast.movieangular.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "comentario")
public class Comentario {

	@Id
	@SequenceGenerator(sequenceName = "comentario_id_seq", name = "gerador_comentario_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gerador_comentario_seq")
	private Integer id;

	@Column(length = 2000)
	private String texto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idusuario")
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "filme")
	private Search idfilme;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Search getIdfilme() {
		return idfilme;
	}

	public void setIdfilme(Search idfilme) {
		this.idfilme = idfilme;
	}

}
