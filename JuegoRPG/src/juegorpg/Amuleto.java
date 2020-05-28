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
public abstract class Amuleto extends Objeto implements Efecto{  //"aquien" siempre será el enemigo, mientras que "quien" el jugador
                                                        //no me queda otra que definir una clase para cada amuleto, aunque estos sean únicos en todo el programa. La cosa es que tienen efectos diferentes.
    public Amuleto(){
        //se definirán en los hijos
    }
    
    
    public abstract void efectObjeto(Jugador aquien, Jugador quien);
        
    
    /*public void potenciar(Jugador quien){  //método previsto solo por si añado otros amuletos
        Object aux = quien.getClase().getCaracteristicas().get("def");
        Integer original = (Integer) aux;
        
        quien.getClase().getCaracteristicas().put("def", original + 2);
    }*/
    
}
