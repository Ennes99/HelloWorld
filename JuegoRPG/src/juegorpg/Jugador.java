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
public class Jugador {
    private String nombre;
    private Raza raza;
    private Clase clase;
    private HashMap<String, ArrayList<Objeto>> mochila; //el valor String haría referencia a los "bolsillos" de la mochila: pociones, amuletos, etc
    
    public Jugador(String n, Raza r, Clase c){
        nombre = n;
        raza = r;
        clase = c;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    
}
