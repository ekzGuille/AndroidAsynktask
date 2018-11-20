package com.seas.usuario.grouponandroidstudiov2.beans;

import com.seas.usuario.grouponandroidstudiov2.tools.IPGetter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Pelicula {

    private int idPelicula;
    private String peliculaName;
    private String urlImagen;

    private final static String ID_PELICULA = "idPelicla";
    private final static String TITULO = "titulo";
    private final static String FOTO = "foto";

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getPeliculaName() {
        return peliculaName;
    }

    public void setPeliculaName(String peliculaName) {
        this.peliculaName = peliculaName;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }


    public static ArrayList<Pelicula> getArrayListFromJSon(JSONArray datos) {
        ArrayList<Pelicula> lista = null;
        Pelicula pelicula = null;
        try {
            if (datos != null && datos.length() > 0) {
                lista = new ArrayList<Pelicula>();
            }
            for (int i = 0; i < datos.length(); i++) {
                JSONObject json_data = datos.getJSONObject(i);
                pelicula = new Pelicula();
                pelicula.setIdPelicula(json_data.getInt(ID_PELICULA));
                pelicula.setPeliculaName(json_data.getString(TITULO));
                pelicula.setUrlImagen(json_data.getString(FOTO));
                lista.add(pelicula);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lista;

    }

}
