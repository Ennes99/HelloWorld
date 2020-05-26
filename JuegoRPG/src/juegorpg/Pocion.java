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
public abstract class Pocion extends Objeto implements Efecto, Combinable{
    protected Random azar;
    protected boolean util;
    
    public Pocion(){
        util = true;
    }
    
    protected void setNombre(String n){
        nombre = n;
    }
    
    protected void setDescripcion(String d){
        descripcion = d;
    }
    
    public abstract void efectObjeto(Jugador aquien, Jugador quien);
    
    protected void inutilizar(){    //se aplica después de usar el efecto de una poción
        setNombre("botella vacía");
        setDescripcion("Puede guardar líquido");
        util = false;
    }
    
    public Objeto combinarCon(Objeto otro){ //tengo que convertir este a tipo Construccion o Pocion, que son los que pueden usar la interfaz Combinable
        Objeto aux;
        Construccion material = null;
        
        if(otro.equals(this)) System.out.println("Dos objetos iguales no se pueden combinar");
        
        else if(otro instanceof Construccion){ 
        material = (Construccion) otro;
        
            if(nombre.equalsIgnoreCase("botella vacía") && (material.getNombre().equalsIgnoreCase("sangre") || material.getNombre().equalsIgnoreCase("mocos"))){
                if(material.getNombre().equalsIgnoreCase("sangre")) aux = new PocionVida();
                else aux = new PocionMana();
                this.eliminarDeMochila();
                material.eliminarDeMochila();
                return aux;
            }
        }
        return null;
         
    }
    
    
    public void eliminarDeMochila(){
        try{
        this.finalize();
        }
        catch(Throwable t){
            System.out.println("ERROR. No se ha podido tirar el objeto");
        }
    }
}

    
