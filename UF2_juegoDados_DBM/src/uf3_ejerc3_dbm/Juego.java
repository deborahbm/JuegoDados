/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uf3_ejerc3_dbm;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Déborah Blas Muñoz
 */
public class Juego implements Runnable{

    //Declaración de variables y propiedades
    private static int puntuacion1=0;
    private static int puntuacion2=0;
    private int dado; // no se declara static para que los valores sean independientes a cada jugador.
    private static int meta=0;
     
    //Constructores
    Juego(){
    }
    
    Juego (int puntuacion1, int puntuacion2, int dado){
        Juego.puntuacion1=puntuacion1;
        Juego.puntuacion2=puntuacion2;
        this.dado=dado;
    }
    
    //Sincronización con meta para evitar que entren a la vez
    public synchronized void Meta (int valor1,int jugador){
        if (meta<20){
            if (jugador==1){
                    if (puntuacion2<puntuacion1){
                    meta=puntuacion1;
                    if (meta>=20){
                        System.out.println("El jugador 1 ha llegado a la meta");
                    }                   
                }    
            }else{
                if (puntuacion1<puntuacion2){
                    meta=puntuacion2;
                    if (meta>=20){
                        System.out.println("El jugador 2 ha llegado a la meta");
                    }                   
                }    
            }
        }
    }
    
         
    //Método ejecutable
    @Override
    public void run (){
    
        //Mientras meta sea menor a 20
        while (meta<20){
         
            try {
                
                if ("Jugador1".equals(Thread.currentThread().getName())){
                    //Extraer un número aleatorio
                    setDado();
                    //Actualizar casilla
                    puntuacion1=dado+getPuntuacion1();
                    //Mostrar el número del dado y la casilla actual
                    System.out.println(Thread.currentThread()+" El dado ha sacado: "+dado+". Puntuación total: "+ getPuntuacion1());
                    Meta(puntuacion1,1);
                    Thread.sleep(1500);
                } 
                if ("Jugador2".equals(Thread.currentThread().getName())){
                    //Extraer un número aleatorio
                    setDado();
                    //Actualizar casilla
                    puntuacion2=dado+getPuntuacion2();
                    //Mostrar el número del dado y la casilla actual
                    System.out.println(Thread.currentThread()+" El dado ha sacado: "+dado+". Puntuación total: "+ getPuntuacion2());
                    Meta(puntuacion2,2);
                    Thread.sleep(1000);
                }
           
            } catch (InterruptedException ex) {
                Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    //Accesores para las propiedades
    public static int getPuntuacion1() {
        return puntuacion1;
    }

    public static void setPuntuacion1(int puntuacion1) {
        Juego.puntuacion1 = puntuacion1;
    }

    public static int getPuntuacion2() {
        return puntuacion2;
    }

    public static void setPuntuacion2(int puntuacion2) {
        Juego.puntuacion2 = puntuacion2;
    }

    public int getDado() {
        return dado;
    }

    public void setDado() {
        this.dado = (int)(Math.random()*6+1);
    }

    
    
}
