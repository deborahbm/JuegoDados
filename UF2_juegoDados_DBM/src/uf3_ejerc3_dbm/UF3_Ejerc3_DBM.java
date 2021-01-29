/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uf3_ejerc3_dbm;

/**
 *
 * @author Déborah Blas Muñoz
 */
public class UF3_Ejerc3_DBM {
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
    System.out.println ("COMIENZA EL JUEGO DE LOS DADOS. 2 JUGADORES.");
    System.out.println ("GANA EL MÁS RÁPIDO EN LLEGAR A 20.");
        //Construcción objetos
        Juego p1=new Juego();
        Juego p2=new Juego();
              
        //Construcción hilos 
        Thread partida1= new Thread (p1);
        Thread partida2= new Thread (p2);
        
        //Asignación nombres para la ejecución
        partida1.setName("Jugador1");
        partida2.setName("Jugador2");
        
        //Ejecución hilos
        partida1.start();
        partida2.start();
    
    }
}