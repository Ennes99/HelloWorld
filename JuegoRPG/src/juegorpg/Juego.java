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
        Clase queclase;
        Raza queraza;
        String quenombre;
        
        System.out.println("Procederemos a crear tu personaje. Primero, ¿cómo te llamas?: ");
        quenombre= teclado.nextLine();
        
        queraza = setRaza();
        queclase = setClase();
        
        //SUBIR A GITHUB Y HACER ACTUALIZACIONES CON GIT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        
        aniadirJugador(quenombre, queraza, queclase);
        
        //AQUÍ EL RESTO DE JUEGO: CONTEXTO, ENTRAR EN COMBATE, SALIR, GUARDAR
        return quenombre;
    }
    
    
    public void jugarParte2(){
        despedida();
    }
    
    //-----------------------------------------------------------------------------------------------------------------------------------------------------
    
    private Raza setRaza(){
        Raza queraza;
        
        System.out.println("Elige una raza: \nHUMANO -- H \nORCO -- O \nELFO -- E \n");
        respuesta = teclado.nextLine();
        
        switch(respuesta.toUpperCase()){
            case "H": queraza = Raza.HUMANO;break;   //Sé que lo del switch no tiene mucho sentido, únicamente es para darle más "sensación de menú"
            case "O": queraza = Raza.ORCO;break;
            default: queraza = Raza.ELFO;
        }
        return queraza;
    }
    
    
    private Clase setClase(){
        Clase queclase;
        
        System.out.println("Por último, elige una clase: \nESCUDERO -- E \nMAGO -- M \nLADRÓN -- L \n");
        respuesta = teclado.nextLine();
        
        switch(respuesta.toUpperCase()){
            case "E": queclase = new Escudero();break;   //Sé que lo del switch no tiene mucho sentido, únicamente es para darle más "sensación de menú"
            case "M": queclase = new Mago();break;
            default: queclase = new Ladron();
        }
        return queclase;
    }
    
    
    
    private void aniadirJugador(String n, Raza r, Clase c){
        jugadores.add(new Jugador(n, r, c));
    }
    
    
    
    private void despedida(){
        
    }
}