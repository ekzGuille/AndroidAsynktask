package model.dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.Cliente;

public class UserAction {

	public String execute(HttpServletRequest request, HttpServletResponse response){
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
		Cliente cliente = new Cliente();
		cliente.setUser(request.getParameter("USER"));
		cliente.setPass(request.getParameter("PASS"));
		System.out.println(request.getParameter("USER"));
		System.out.println(request.getParameter("PASS"));
		System.out.println(cliente.toString());
		respuesta = cliente.toString();
		return respuesta;
	}
	
}
