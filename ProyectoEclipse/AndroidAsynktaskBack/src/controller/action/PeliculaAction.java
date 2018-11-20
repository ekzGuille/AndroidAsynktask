package controller.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.beans.Pelicula;
import model.dao.beans.PeliculaDAO;

public class PeliculaAction {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String respuesta = "";

		String actionReived = request.getParameter("ACTION");

		String[] actions = actionReived.split("\\.");

		switch (actions[1]) {
		case "list":
			respuesta = findById(request, response);
			break;

		case "listAll":
			respuesta = findAll(request, response);
			break;

		default:
			respuesta = "[]";
		}

		return respuesta;
	}

	private String findById(HttpServletRequest request, HttpServletResponse response) {
		String respuesta = "";
		Pelicula pelicula = null;
		String id = request.getParameter("ID_PELICULA");
		Gson gson = new Gson();

		if (id != null) {
			PeliculaDAO peliculaDAO = new PeliculaDAO();
			pelicula = peliculaDAO.findById(Integer.parseInt(id));
			if (pelicula != null) {
				respuesta = "[" + gson.toJson(pelicula) + "]";
			} else {
				respuesta = "[]";
			}
		}

		return respuesta;
	}

	private String findAll(HttpServletRequest request, HttpServletResponse response) {
		String respuesta = "";
		ArrayList<Pelicula> lstPelicula = null;

		Gson gson = new Gson();

		PeliculaDAO peliculaDAO = new PeliculaDAO();
		lstPelicula = peliculaDAO.findAll();
		if (lstPelicula != null) {
			for (Pelicula pelicula : lstPelicula) {
				respuesta += gson.toJson(pelicula) + ",";
			}
			if (respuesta.endsWith(",")) {
				respuesta = respuesta.substring(0, respuesta.length() - 1);
			}
		}

		return "[" + respuesta + "]";
	}

}
