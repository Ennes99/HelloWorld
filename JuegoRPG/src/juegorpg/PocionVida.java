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
public class PocionVida extends Pocion{
    
    public PocionVida(){
        nombre = "Poción de vida";
        descripcion = "Recupera 15 PS";
    }
    
    public void efectObjeto(Jugador aquien, Jugador quien){
        int num = azar.nextInt(9)+1;
        
        if(util = true){
        quien.getClase().sumaORestaVida(15);
                    //el enemigo tendrá una mínima posibilidad de no atacar en el turno "debido al atrayente olor"
        if(num>=4){
            System.out.println("El enemigo se ha encandilado con el dulce aroma de la poción ¡Su velocidad se reduce un poco!");
            Object aux = aquien.getClase().getCaracteristicas().get("vel");
            
            Integer original = (Integer) aux;
            
            aquien.getClase().getCaracteristicas().put("vel", original - 5);
        }
        
        else System.out.println(". . . \n¡No pasó nada!");
        }
    }
    
}
