package model.beans;

public class Cliente {

	private int idUsuario;
	private String email;
	private String pass;

	public Cliente() {
	}

	public Cliente(int idUsuario, String email, String pass) {
		this.idUsuario = idUsuario;
		this.email = email;
		this.pass = pass;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
