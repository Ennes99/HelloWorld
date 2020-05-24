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
public class Sombrero extends Objeto implements Efecto{
    
    public Sombrero(){
        nombre = "Sombrero del mago";
        descripcion = "Ataque telequinético. Derriba al enemigo: le causa gran daño y lo aturde 1 turno. Consume 2 PM";
    }
    
    
    public void efectObjeto(Jugador aquien, Jugador quien){ //recordar que este actúa sobre el enemigo (otro Jugador), pero también sobre la persona, ya que quita PM
        quien.getClase().sumaORestaMana(-2);
        System.out.println("¡"+quien.getNombre()+" usó la telequinesis!¡Ha derribado al enemigo!");
        aquien.getClase().sumaORestaVida(-12);
        quien.combate();
    }


}
