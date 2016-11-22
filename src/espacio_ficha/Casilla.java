/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espacio_ficha;

import java.util.*;

/**
 *
 * @author USUARIO
 */
public class Casilla {
    private ArrayList cantidad;
    private Tipo tipo;
    private Ficha[] ficha;
//    colocado para poder deteminar posicion de la ficha
    private int camino;

    public int getCamino() {
        return camino;
    }

    public void setCamino(int camino) {
        this.camino = camino;
    }

    public Casilla(Ficha[] ficha, Tipo tipo) {
        this.ficha = ficha;
        this.tipo = tipo;
    }
    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Ficha[] getFicha() {
        return ficha;
    }

    public void setFicha(Ficha[] ficha) {
        this.ficha = ficha;
    }
    public ArrayList getCantidad() {
        return cantidad;
    }

    public void setCantidad(ArrayList cantidad) {
        this.cantidad = cantidad;
    }
}
