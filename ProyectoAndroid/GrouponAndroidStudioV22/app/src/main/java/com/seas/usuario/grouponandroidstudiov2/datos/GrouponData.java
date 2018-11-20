package com.seas.usuario.grouponandroidstudiov2.datos;


import com.seas.usuario.grouponandroidstudiov2.beans.Cliente;
import com.seas.usuario.grouponandroidstudiov2.beans.Pelicula;

import java.util.ArrayList;


public class GrouponData {
    private static Cliente cliente;
    private static ArrayList<Pelicula> lstPelicula;
    private static Pelicula peliculaSeleccionada;

    public static Cliente getCliente() {
        return cliente;
    }

    public static void setCliente(Cliente cliente) {
        GrouponData.cliente = cliente;
    }

    public static ArrayList<Pelicula> getLstPelicula() {
        return lstPelicula;
    }

    public static void setLstPelicula(ArrayList<Pelicula> lstPelicula) {
        GrouponData.lstPelicula = lstPelicula;
    }

    public static Pelicula getPeliculaSeleccionada() {
        return peliculaSeleccionada;
    }

    public static void setPeliculaSeleccionada(Pelicula peliculaSeleccionada) {
        GrouponData.peliculaSeleccionada = peliculaSeleccionada;
    }
}
