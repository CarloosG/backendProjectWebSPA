package com.webSPA.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="canciones")
public class cancion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nombreCancion;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombreCancion() {
		return nombreCancion;
	}
	public void setNombreCancion(String nombreCancion) {
		this.nombreCancion = nombreCancion;
	}
	public String getArtista() {
		return artista;
	}
	public void setArtista(String artista) {
		this.artista = artista;
	}
	public String getAño() {
		return año;
	}
	public void setAño(String año) {
		this.año = año;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}
	@Column(name = "artista")
	private String artista;
	@Column(name = "año")
	private String año;
	@Column(name = "album")
	private String album;
	@Column(name = "calificaion")
	private String calificacion;
	public cancion(){
		
	}
	public cancion(String nombreCancion, String artista, String año, String album, String calificacion) {
		super();
		this.nombreCancion = nombreCancion;
		this.artista = artista;
		this.año = año;
		this.album = album;
		this.calificacion = calificacion;
	}
}
