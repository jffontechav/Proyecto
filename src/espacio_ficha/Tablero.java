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
public class Tablero {
    //lo separe para colocal el exterior del tablero y las torres donde se gana
    
    private Casilla casilla1[][];
    private Ficha ficha[];

    public Tablero(Casilla[][] casilla1, Ficha[] ficha) {
        this.casilla1 = casilla1;
        this.ficha = ficha;
    }

    public Casilla[][] getCasilla1() {
        return casilla1;
    }

    public void setCasilla1(Casilla[][] casilla1) {
        this.casilla1 = casilla1;
    }

    public Ficha[] getFicha() {
        return ficha;
    }

    public void setFicha(Ficha[] ficha) {
        this.ficha = ficha;
    }
    

//    este metodo se usa para determinar la posicion de una casilla en el arreglo de casillas
    public int determinar_posicion(Casilla [] c, Ficha f){
        //solo se usa si la ficha esta dentro de el arreglo de casillas
        int posicion=0;
        for (Casilla c1 : c) {
            if (c1.getCantidad().contains(f)) {
                posicion = c1.getCamino();
                break;
            } else {
            }
        }
        return posicion;
    }
    //para salir de la carcel
    public boolean liberar(int dado1, int dado2,Ficha f){
        boolean salir;
        if (dado1 == dado2) {
            switch (f.getTipo().getId()) {
                //caso refiere al jugador, porque cada carcel sale a una casilla específica
                //colocar luego todos los jugadores con sus respectivas salidas
                case 1:
                    salir=true;
                    f.setCasilla(this.casilla1[1][2]);
                    break;
                default:
                    salir=true;
                    f.setCasilla(this.casilla1[1][6]);
                    break;
            }
        } else {
            salir=false;
        }
        return salir;
    }
    public void determinarSiPasaPorSeguroTorre(int movimiento, Ficha f){
        
    }
    public void mover(int movimiento, Ficha f){
        int posicion = this.determinar_posicion(this.casilla1[1], f);
        if (this.casilla1[2][f.getCasilla().getCamino()] == null) {
            //movimiento normal
            movimiento += posicion;
            this.casilla1[1][posicion].getCantidad().remove(f);
            if (movimiento <= (casilla1.length - 1)) {
                this.casilla1[1][movimiento].getCantidad().add(f);
                f.setCasilla(this.casilla1[1][movimiento]);
            } else {
                movimiento = movimiento - (casilla1.length);
                this.casilla1[1][movimiento].getCantidad().add(f);
                f.setCasilla(this.casilla1[1][movimiento]);
            }
        } else {
            //movimiento en torres
            switch (f.getTipo().getId()) {
                case 1:
                    //revisar el numero por el que se mide el movimiento
                    if (movimiento > (5 - (f.getCasilla().getCamino() - 100))) {
                        //no mover
                    } else // en caso de que este en el seguro de la torre 
                        if (f.getCasilla().getCamino() < 100) {
                        this.casilla1[1][posicion].getCantidad().remove(f);
                        this.casilla1[movimiento][5].getCantidad().add(f);
                        f.setCasilla(this.casilla1[movimiento][5]);

                    } else {
                        this.casilla1[1][posicion - 100].getCantidad().remove(f);
                        this.casilla1[movimiento][5].getCantidad().add(f);
                        f.setCasilla(this.casilla1[movimiento][5]);
                    }
                    break;
                default:
                    break;
            }
        }

    }
    /*
    public void comer(Casilla c, Ficha f){
        for (int i = 0; i < c.getCantidad().size(); i++) {
            Ficha comprobante=(Ficha) c.getCantidad().get(i);
            if (comprobante.getTipo()!=f.getTipo()) {
            casilla1[0][0].getCantidad().add(c.getCantidad().get(i));
            c.getCantidad().remove(i);
            }  
        }
         
    }
*/
     
}
