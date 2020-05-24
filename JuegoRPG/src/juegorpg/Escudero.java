/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegorpg;
/**
 *
 * @author alepa
 */
public class Escudero extends Clase{
    
    public Escudero(String queclase){
        super(queclase);
    }
    
    public void setCaracteristicas(){ //las características base de un Jugador. Aumentarán con los bonus o los objetos
        carac_combate.put("atq", 8);
        carac_combate.put("atq_m", 7);
        carac_combate.put("def", 13);
        carac_combate.put("vel", 7);
        carac_combate.put("ps", 40);
        carac_combate.put("pm", 1);
        
    }
    
    
    public Objeto objetoEspecial(String nom, String desc){
        Objeto aux = new Casco();
        //crea un objeto único de cada clase, para que luego el jugador lo añada a su bolsa
        return aux;
    }
    
    
}
