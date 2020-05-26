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
public class PocionMana extends Pocion{
    
    public PocionMana(){
        nombre = "Poción de maná";
        descripcion = "Recupera 2 PM";
    }
    
    public void efectObjeto(Jugador aquien, Jugador quien){
        int num = azar.nextInt(9)+1;
        
        if(util = true){
        quien.getClase().sumaORestaMana(2);
                                //el enemigo tendrá una mínima posibilidad de atacar dos veces "debido al fuerte olor"
        if(num>=4){
                System.out.println("El fuerte olor de la poción a alentado al enemigo. ¡Ataca dos veces!");
                aquien.menuBatalla();
            }
        inutilizar();
        }
        
        else System.out.println(". . . \n¡No paso nada!");
    }
    
}
