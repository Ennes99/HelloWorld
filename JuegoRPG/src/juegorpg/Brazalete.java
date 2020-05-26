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
public class Brazalete extends Objeto implements Efecto{
    
    public Brazalete(){
        nombre = "Brazalete del ladrón";
        descripcion = "Posibilidad de atacar dos veces por turno, consumiendo 1 PM";      
    }
    
    public void efectObjeto(Jugador aquien, Jugador quien){
        quien.getClase().sumaORestaMana(-1);
        
           System.out.println(". . . \nTe mueves a gran velocidad. ¡Tienes dos turnos para atacar!");
           quien.menuBatalla();
           quien.menuBatalla();
    }
}
    

