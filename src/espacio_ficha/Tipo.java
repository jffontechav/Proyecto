/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espacio_ficha;

/**
 *
 * @author USUARIO
 */
public class Tipo {
    private int id;
    private int estado;
    private int numero;

    public Tipo(int id, int estado,int numero) {
        this.id = id;
        this.estado = estado;
        //usado para determinar si va a subir por la torre
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
