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
public class Casco extends Amuleto implements Efecto{
  
    public Casco(){
        nombre = "Casco del escudero";
        descripcion = "No te puedes mover en dos turnos, pero tampoco recibes daño, y te curas.\nEl enemigo se daña al atacarte. Gasta 1 PM";        
    }
    
     public void efectObjeto(Jugador aquien, Jugador quien){
        quien.getClase().sumaORestaMana(-1);
        
        System.out.println("Tu armadura se fortalece mucho. No puedes atacar. \n . . . \n¡El enemigo se dañó con tu armadura! Se hace 7 puntos de daño.\nRecuperas 7 puntos de daño");
        
        quien.getClase().sumaORestaVida(7);
        aquien.getClase().sumaORestaVida(-7);
        
        quien.printVidaMana();
        
        System.out.println(". . . \n¡El enemigo se dañó con tu armadura! Se hace 7 puntos de daño.\nRecuperas 7 puntos de daño");
        
        quien.getClase().sumaORestaVida(7);
        aquien.getClase().sumaORestaVida(-7);
    }
}
