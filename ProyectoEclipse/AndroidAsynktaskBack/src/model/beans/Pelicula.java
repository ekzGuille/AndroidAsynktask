package model.beans;

public class Pelicula {

	private int idPelicula;
	private String titulo;
	private String foto;

	public Pelicula() {
	}

	public Pelicula(int idPelicula, String titulo, String foto) {
		this.idPelicula = idPelicula;
		this.titulo = titulo;
		this.foto = foto;
	}

	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

}
