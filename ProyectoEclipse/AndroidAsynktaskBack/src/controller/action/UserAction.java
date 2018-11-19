package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.beans.Cliente;
import model.dao.beans.ClienteDAO;

public class UserAction {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String respuesta = "";

		String actionReived = request.getParameter("ACTION");

		String[] actions = actionReived.split("\\.");

		switch (actions[1]) {
		case "login":
			respuesta = login(request, response);
			break;

		}

		return respuesta;
	}

	private String login(HttpServletRequest request, HttpServletResponse response) {
		String respuesta = "";
		Cliente cliente = null;
		String user = request.getParameter("USER");
		String pass = request.getParameter("PASS");

		Gson gson = new Gson();

		respuesta = "" + user + " " + pass;
		if (user != null && pass != null) {
			ClienteDAO clienteDAO = new ClienteDAO();
			cliente = clienteDAO.findByNamePass(user, pass);
			if (cliente != null) {
				respuesta = "[" + gson.toJson(cliente) + "]";
			} else {
				respuesta = "no se ha encontrado";
			}
		}

		return respuesta;
	}

}
