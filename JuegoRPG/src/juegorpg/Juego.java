/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegorpg;
import java.util.*;
/**
 *
 * @author alepa
 */
public class Juego {
    private Scanner teclado;
    private String respuesta;
    private ArrayList<Jugador> jugadores;
    
    public Juego(){
        jugadores = new ArrayList();
    }
    
    public ArrayList<Jugador> getJugadores(){
        return jugadores;
    }
    
    public Jugador getJugadorPorNombre(String n){
        Jugador aux = null;
        
        for(Jugador cada:jugadores){
            if(cada.getNombre().equals(n)){
                aux = cada;
                
            }
        }
        return aux;
    }
    
    public String jugarParte1(){                //ESTE, Y JUEGO2, SERÁN LOS ÚLTIMOS MÉTODOS EN HACERSE
        System.out.println("Procederemos a crear tu personaje. Primero, ¿cómo te llamas?: ");
        String quenombre= teclado.nextLine();
        System.out.println("Elige una raza: ");
        String queraza = teclado.nextLine();
        System.out.println("Por último, elige una clase: \nESCUDERO -- E \nMAGO -- M \nLADRÓN -- L \n");
        respuesta = teclado.nextLine();
        
        Clase queclase;
        
        switch(respuesta.toUpperCase()){
            case "E": queclase = new Escudero();break;   //Sé que lo del switch no tiene mucho sentido, únicamente es para darle más "sensación de menú"
            case "M": queclase = new Mago();break;
            case "L": queclase = new Ladron();break;
        }   //SUBIR A GITHUB Y HACER ACTUALIZACIONES CON GIT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        
        aniadirJugador(quenombre, queraza, queclase);
        
        return quenombre;
    }
    
    public void jugarParte2(){
        despedida();
    }
    
    private void aniadirJugador(String n){
        jugadores.add(new Jugador(n));
    }
    
    private void despedida(){
        
    }
}
