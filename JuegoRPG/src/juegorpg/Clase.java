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
public abstract class Clase {
    private final String queclase;
    private int bonus = 0;    //podrá variar con los objetos
    protected HashMap<String, Integer> carac_combate; //ataque, ataque mágico, defensa, velocidad, salud y maná
    
        public Clase(String c){
            queclase = c.toUpperCase();
            bonus=3;
            setCaracteristicas();
        }
        
        public String getClase(){
            return queclase;
        }
        
        public int getBonus(){
            return bonus;
        }
        
        public void setBonus(int b){
            bonus = b;
        }
        
        protected abstract void setCaracteristicas();
        
        //public abstract void ataqueEspecial(); //cada clase tendrá un ataque mágico propio a su disposición (hace diferentes cosas, ataque fuerte, defensa fuerte, etc)
        
        public abstract Objeto objetoEspecial(String nom, String desc); //cada clase empieza con un objeto especial
        
        public String toString(){
            return ""+queclase;
        }
        
}
