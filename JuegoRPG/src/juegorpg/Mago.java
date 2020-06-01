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
public class Mago extends Clase{
    
    public Mago(){
        super();
        queclase = "MAGO";
    }
    
    public void setCaracteristicas(){ //las características base de un Jugador. Aumentarán con los bonus o los objetos
        super.getCaracteristicas().put("atq", 7);
        super.getCaracteristicas().put("atq_m", 15);
        super.getCaracteristicas().put("def", 7);
        super.getCaracteristicas().put("vel", 10);
        super.getCaracteristicas().put("ps", 30);
        super.getCaracteristicas().put("pm", 5);
        
    }
    
    public Objeto objetoEspecial(String nom, String desc){
        Objeto aux = new Sombrero();
        //crea un objeto único de cada clase, para que luego el jugador lo añada a su bolsa
        return aux;
    }
    
}
