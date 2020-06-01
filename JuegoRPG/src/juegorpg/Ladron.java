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
public class Ladron extends Clase{
    
    public Ladron(){
        super();
        queclase = "LADRÓN";
    }
    
    public void setCaracteristicas(){ //las características base de un Jugador. Aumentarán con los bonus o los objetos
        super.getCaracteristicas().put("atq", 10);
        super.getCaracteristicas().put("atq_m", 8);
        super.getCaracteristicas().put("def", 7);
        super.getCaracteristicas().put("vel", 15);
        super.getCaracteristicas().put("ps",35);
        super.getCaracteristicas().put("pm", 3);
        
    }
    
    public Objeto objetoEspecial(String nom, String desc){
        Objeto aux = new Brazalete();
        //crea un objeto único de cada clase, para que luego el jugador lo añada a su bolsa
        return aux;
    }
    
}
