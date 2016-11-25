/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espacio_ficha;

import Excepciones.ExcepcionA;
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
    //solo se usa en las casillas "externas"
    public int PasaPorSeguroTorre(int movimiento, Ficha f){
        int mov=movimiento;
        for (int i = f.getCasilla().getCamino()+1; i < movimiento; i++) {
            System.out.println("i "+i);
            //se determina asi porque el "numero" de la casilla de torre es igual al "id" de la ficha que lo puede subir
            if (this.casilla1[1][i].getTipo().getNumero()==f.getTipo().getId()) {
                f.getCasilla().getCantidad().remove(f);
                this.casilla1[1][i].getCantidad().add(f);
                f.setCasilla(this.casilla1[1][i]);
                mov=movimiento-i+1;
                i=movimiento;
            } else {
            }
        }
        return mov;
    }
    
    /*throw en caso de que la ficha se pase de la torre con el movimiento y asi se evita que el programa 
    muera se quito un if que cumplia esta funcion ya que la excepcion cumple mejor esta funcion*/
    public void mover(int movimiento, Ficha f) throws ExcepcionA {
        int posicion = this.determinar_posicion(this.casilla1[1], f);
        if (f.getCasilla().getCamino() < 100 && f.getCasilla().getTipo().getNumero() == 0) {
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
                    /*revisar el numero por el que se mide el movimiento
                    en caso de que este en el seguro de la torre*/ 
                    if (f.getCasilla().getCamino() < 100) {
                        this.casilla1[1][posicion].getCantidad().remove(f);
                        //por el lugar donde empieza
                        this.casilla1[movimiento + 1][4].getCantidad().add(f);
                        f.setCasilla(this.casilla1[movimiento + 1][4]);
                    } else {
                        /*99 sale de la diferencia entre el "camino" especifico del jugador y el hecho de que
                        tiene que estar mas abajo que la fila 1 (fial 0, fila 1, ...)
                        el cuatro sale de la columna en la que esta la torre del jugador*/
                        this.casilla1[f.getCasilla().getCamino() - 99][4].getCantidad().remove(f);
                        this.casilla1[movimiento + f.getCasilla().getCamino() - 99][4].getCantidad().add(f);
                        f.setCasilla(this.casilla1[movimiento + f.getCasilla().getCamino() - 99][4]);
                    }
                    break;
                default:
                    break;
            }
        }
    }
    /* no funciona porque el metodo ".get(i)   int i" obtendra un objeto "object" y no una ficha
    revisar como obtener un objeto en especifico en un arraylist si se quiere usar el metodo de abajo para comer
    public void comer(Casilla c, Ficha f){
        //solo se usara en las casillas "externas"
        for (int i = 0; i < c.getCantidad().size(); i++) {
            Ficha comprobante=(Ficha) c.getCantidad().get(i);
            //un caso por cada jugador diferente
            if (comprobante.getTipo().getId()!=f.getTipo().getId()) {
                switch(comprobante.getTipo().getId()){
                    case 1:
                        //se anda la ficha enemiga a su carcel
                        casilla1[0][2].getCantidad().add(c.getCantidad().get(i));
                        c.getCantidad().remove(i);
                        break;
                        //ultimo jugador
                    default:
                        casilla1[0][6].getCantidad().add(c.getCantidad().get(i));
                        c.getCantidad().remove(i);
                        break;
                }
            }  
        }
    }
*/
}
