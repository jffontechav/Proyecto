/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espacio_ficha;

/**
 *
 * @author cristian
 */
public class Dado {

    private int resultado;
    private int numeroDeDado;

    public Dado(int numeroDeDado) {
        this.numeroDeDado = numeroDeDado;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public int getNumeroDeDado() {
        return numeroDeDado;
    }

    public void setNumeroDeDado(int numeroDeDado) {
        this.numeroDeDado = numeroDeDado;
    }

    public int lanzarDado() {
        int num1 = 1;
        //numero correcto es 7
        int num2 = 3;

        int numAleatorio = (int) Math.floor(Math.random() * (num1 - num2) + num2);
        this.setResultado(numAleatorio);
        return numAleatorio;

    }

}