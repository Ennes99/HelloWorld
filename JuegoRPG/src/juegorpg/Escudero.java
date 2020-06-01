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
    
    public Escudero(){
        super();
        queclase = "ESCUDERO";
    }
    
    public void setCaracteristicas(){ //las características base de un Jugador. Aumentarán con los bonus o los objetos
        super.getCaracteristicas().put("atq", 8);
        super.getCaracteristicas().put("atq_m", 7);
        super.getCaracteristicas().put("def", 13);
        super.getCaracteristicas().put("vel", 7);
        super.getCaracteristicas().put("ps", 40);
        super.getCaracteristicas().put("pm", 1);
        
    }
    
    
    public Objeto objetoEspecial(String nom, String desc){
        Objeto aux = new Casco();
        //crea un objeto único de cada clase, para que luego el jugador lo añada a su bolsa
        return aux;
    }
    
    
}
