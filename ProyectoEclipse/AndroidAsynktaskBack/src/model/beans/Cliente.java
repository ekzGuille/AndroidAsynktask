package model.beans;

public class Cliente {

	private int idUsuario;
	private String user;
	private String pass;

	public Cliente() {
	}

	public Cliente(int idUsuario, String user, String pass) {
		this.idUsuario = idUsuario;
		this.user = user;
		this.pass = pass;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
