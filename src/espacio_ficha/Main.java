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
 * @version 2.3
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    
    
    
public static void main(String[] args) {
        // TODO code application logic here
        
        java.util.Scanner teclado= new java.util.Scanner(System.in);
        
        //definicion del tipo de ficha y casilla base
        Tipo tf1= new Tipo(1,0,0);
        Tipo tf2= new Tipo(2,0,0);
        //casilla normal
        Tipo tc1= new Tipo(0,0,0);
        //casilla seguro normal
        Tipo tc2= new Tipo(1,0,0);
        //casillas seguro de torre
        Tipo tc2_1= new Tipo(1,0,1);
        Tipo tc2_2= new Tipo(1,0,2);
        //casilla de carcel
        Tipo tc3= new Tipo(2,0,0);
        //casilla de llegada
        Tipo tc4= new Tipo(3,0,0);
        
        //fichas 1=jugador 1 ...
        Ficha[] f1 = new Ficha[2];
        f1[0]= new Ficha(tf1);
        f1[1]= new Ficha(tf1);
        Ficha[] f2 = new Ficha[2];
        f2[0]= new Ficha(tf2);
        f2[1]= new Ficha(tf2);
        
        //se necesita especificar cada una en especifico para que se puedan modificar individualmente
        ArrayList<Ficha> list1 = new ArrayList<>();
        ArrayList<Ficha> list2 = new ArrayList<>();
        ArrayList<Ficha> list3 = new ArrayList<>();
        ArrayList<Ficha> list4 = new ArrayList<>();
        ArrayList<Ficha> list5 = new ArrayList<>();
        ArrayList<Ficha> list6 = new ArrayList<>();
        ArrayList<Ficha> list7 = new ArrayList<>();
        ArrayList<Ficha> list8 = new ArrayList<>();
        ArrayList<Ficha> list9 = new ArrayList<>();
        
        ArrayList<Ficha> listcarcel1 = new ArrayList<>();
        ArrayList<Ficha> listcarcel2 = new ArrayList<>();
        
        ArrayList<Ficha> listtorre1_1 = new ArrayList<>();
        ArrayList<Ficha> listtorre1_2 = new ArrayList<>();
        ArrayList<Ficha> listtorre1_3 = new ArrayList<>();
        ArrayList<Ficha> listtorre1_4 = new ArrayList<>();
        
        ArrayList<Ficha> listtorre2_1 = new ArrayList<>();
        ArrayList<Ficha> listtorre2_2 = new ArrayList<>();
        ArrayList<Ficha> listtorre2_3 = new ArrayList<>();
        ArrayList<Ficha> listtorre2_4 = new ArrayList<>();
        
        
        //casillas "externas"
        Casilla c1 = new Casilla(null,tc1);
        Casilla c2 = new Casilla(null,tc1);
        Casilla c3 = new Casilla(null,tc1);
        Casilla c4 = new Casilla(null,tc1);
        //casilla de torre de entrada jagador 1
        Casilla c5 = new Casilla(null,tc2_1);
        Casilla c6 = new Casilla(null,tc1);
        Casilla c7 = new Casilla(null,tc1);
        Casilla c8 = new Casilla(null,tc1);
        //casilla de torre de entrada jagador 2
        Casilla c9 = new Casilla(null,tc2_2);
        Casilla[] c_1 = {c1,c2,c3,c4,c5,c6,c7,c8,c9}; 
        c_1[0].setCantidad(list1);
        c_1[1].setCantidad(list2);
        c_1[2].setCantidad(list3);
        c_1[3].setCantidad(list4);
        c_1[4].setCantidad(list5);
        c_1[5].setCantidad(list6);
        c_1[6].setCantidad(list7);
        c_1[7].setCantidad(list8);
        c_1[8].setCantidad(list9);
        
        //casillas carcel
        //se les dara el tipo 3 para diferenciarlas rapidamente
        Casilla carcel1=new Casilla(null,tc3);
        carcel1.setCantidad(listcarcel1);
        //prueba con numeros negativos para distinguir las carceles
        carcel1.setCamino(-1);
        Casilla carcel2=new Casilla(null,tc3);
        carcel2.setCantidad(listcarcel2);
        carcel1.setCamino(-2);
        //agregar luego la forma completa
        Casilla[] carcel ={null,null,carcel1,null,null,null,carcel2,null,null};
        
        //casillas torre
        //torre1
        Casilla ct1_1 = new Casilla(null,tc1);
        ct1_1.setCantidad(listtorre1_1);
        //camino en centenas para separarlo de las casillas normales
        ct1_1.setCamino(101);
        Casilla ct1_2 = new Casilla(null,tc1);
        ct1_2.setCantidad(listtorre1_2);
        ct1_2.setCamino(102);
        Casilla ct1_3 = new Casilla(null,tc1);
        ct1_3.setCantidad(listtorre1_3);
        ct1_3.setCamino(103);
        Casilla ct1_4 = new Casilla(null,tc4);
        ct1_4.setCantidad(listtorre1_4);
        ct1_4.setCamino(104);
        //torre 2
        Casilla ct2_1 = new Casilla(null,tc1);
        ct2_1.setCantidad(listtorre2_1);
        ct2_1.setCamino(201);
        Casilla ct2_2 = new Casilla(null,tc1);
        ct2_2.setCantidad(listtorre2_2);
        ct2_2.setCamino(202);
        Casilla ct2_3 = new Casilla(null,tc1);
        ct2_3.setCantidad(listtorre2_3);
        ct2_3.setCamino(203);
        Casilla ct2_4 = new Casilla(null,tc4);
        ct2_4.setCantidad(listtorre2_4);
        ct2_4.setCamino(204);
        
        //determina la posicion de la casilla en el arreglo para facilitar varias operaciones
        for (int i = 0; i < c_1.length; i++) {
        c_1[i].setCamino(i);
    }
        //creacion de la matriz de fichas que contendra el tablero
        Casilla c[][]= new Casilla[6][9];
        c[0]=carcel;
        c[1]=c_1;
        c[2][4]=ct1_1;
        c[3][4]=ct1_2;
        c[4][4]=ct1_3;
        c[5][4]=ct1_4;
        
        c[2][8]=ct2_1;
        c[3][8]=ct2_2;
        c[4][8]=ct2_3;
        c[5][8]=ct2_4;
        
        //aca se crea la situación inicial
        c[1][0].getCantidad().add(f1[0]);
        c_1[1].getCantidad().add(f1[1]);
        f1[0].setCasilla(c[1][0]);
        f1[1].setCasilla(c_1[1]);
        
        c_1[2].getCantidad().add(f2[0]);
        c_1[2].getCantidad().add(f2[1]);
        f2[0].setCasilla(c_1[2]);
        f2[1].setCasilla(c_1[2]);
        //creacion del tablero
        Tablero tablero = new Tablero(c,f1);
            //el primer turno es el del jugador 1
            int turno=1;
            //variable que determinara el ganador
            int victoria=0;
            while(victoria==0){
                
                System.out.println("Turno jugador "+ turno);
                System.out.println("");
                System.out.println("Escoja la ficha a mover");
                int eleccion=teclado.nextInt();
                int movimiento;
                //cambiar luego por switch con tantos casos como jugadores
                if (turno ==1) {
                    switch(eleccion){
                    case 1:System.out.println("Digite las casillas a mover");
                    movimiento = teclado.nextInt();
                    //revisar luego como usar la excepcion personalizada para sacar el mensaje
                    try{
                        //si esta en la carcel
                        if (f1[0].getCasilla().getCamino()<0) {
                            //implementacion cuando se trabaje con dados
                        } else
                        /*no necesita comprobar si pasa por seguro si ya esta en torre o en su seguro
                        se puede dejar el 100 en la comprobacion de todos los jugadores porque todos los demas caminos de
                        sus torres tambien son mayores que 100*/
                        if (f1[0].getCasilla().getTipo().getNumero()==f1[0].getTipo().getId()||f1[0].getCasilla().getCamino()>100) {
                            tablero.mover(movimiento, f1[0]);
                        } else {
                            /*el metodo retorna un entero porque no puede mover la ficha directamente asi que si pone la ficha 
                            en el seguro de su torre tiene que moverse lo que quede hacia arriba*/
                            tablero.mover(tablero.PasaPorSeguroTorre(movimiento, f1[0]), f1[0]);
                        }
                    }catch (Exception e){
                        System.out.println("No se puede mover la ficha tanto");
                    }  
                    System.out.println("Casilla donde termino la ficha: "+(f1[0].getCasilla().getCamino()+1));
                        break;
                    case 2:System.out.println("Digite las casillas a mover");
                    movimiento = teclado.nextInt();
                    try{
                        if (f1[1].getCasilla().getCamino()<0) {
                            //implementacion cuando se trabaje con dados
                        } else if (f1[1].getCasilla().getTipo().getNumero()==f1[1].getTipo().getId()
                                ||f1[1].getCasilla().getCamino()>100) {
                            tablero.mover(movimiento, f1[1]);
                        } else {
                            tablero.mover(tablero.PasaPorSeguroTorre(movimiento, f1[1]), f1[1]);
                        }
                    }catch (Exception e){
                        System.out.println("No se puede mover la ficha tanto");
                    }
                    System.out.println("Casilla donde termino la ficha: "+(f1[1].getCasilla().getCamino()+1));
                        break;
                    default:System.out.println("Eleccion inaceptable");
                        break;
                    }
                    
                } else {
                    switch(eleccion){
                    case 1:System.out.println("Digite las casillas a mover");
                    movimiento = teclado.nextInt();
                    try{
                        if (f2[0].getCasilla().getCamino()<0) {
                            //implementacion cuando se trabaje con dados
                        } else if (f2[0].getCasilla().getTipo().getNumero()==f2[0].getTipo().getId()
                                ||f2[0].getCasilla().getCamino()>100) {
                            tablero.mover(movimiento, f2[0]);
                        } else {
                            tablero.mover(tablero.PasaPorSeguroTorre(movimiento, f2[0]), f2[0]);
                        }
                    }catch (Exception e){
                        System.out.println("No se puede mover la ficha tanto");
                    }
                        System.out.println("Casilla donde termino la ficha: "+(f2[0].getCasilla().getCamino()+1));
                        break;
                    case 2:System.out.println("Digite las casillas a mover");
                    movimiento = teclado.nextInt();
                    try{
                        if (f2[1].getCasilla().getCamino()<0) {
                            //implementacion cuando se trabaje con dados
                        } else if (f2[1].getCasilla().getTipo().getNumero()==f2[1].getTipo().getId()
                                ||f2[1].getCasilla().getCamino()>100) {
                            tablero.mover(movimiento, f2[0]);
                        } else {
                            tablero.mover(tablero.PasaPorSeguroTorre(movimiento, f2[1]), f2[1]);
                        }
                    }catch (Exception e){
                        System.out.println("No se puede mover la ficha tanto");
                    }
                    System.out.println("Casilla donde termino la ficha: "+(f2[1].getCasilla().getCamino()+1));
                        break;
                    default:System.out.println("Eleccion inaceptable");
                        break;
                    }
                }
                //condicion de victoria
                if (c_1[8].getCantidad().contains(f1[0])&&c_1[8].getCantidad().contains(f1[1])) {
                    
                   c_1[8].getCantidad().get(0);
                    System.out.println("El ganador es el jugador "+ turno);
                    victoria=1;
                } else {
                }
                //colocar turno diferente al numero del ultimo jugador
                if (turno!=2) {
                    turno++;
                } else {
                    turno=1;
                }
                
            }
            


       
        

        
        
        
    }
    
}
