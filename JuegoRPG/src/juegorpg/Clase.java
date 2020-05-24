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
    protected HashMap<String, Integer> carac_combate; //ataque, ataque mágico, defensa, velocidad, salud y maná
    
        public Clase(String c){
            queclase = c.toUpperCase();
            setCaracteristicas();
        }
        
        public String getClase(){
            return queclase;
        }
        
        public HashMap getCaracteristicas(){
            return carac_combate;
        }
        
        protected abstract void setCaracteristicas();
        
        //public abstract void ataqueEspecial(); //cada clase tendrá un ataque mágico propio a su disposición (hace diferentes cosas, ataque fuerte, defensa fuerte, etc)
        
        public abstract Objeto objetoEspecial(String nom, String desc); //cada clase empieza con un objeto especial
        
        public void sumaORestaMana(int cuanto){
            int maximo;
            int mana = carac_combate.get("pm");
         
            switch(queclase){
                case "MAGO": maximo = 5;
                case "ESCUDERO": maximo = 1;
                default: maximo = 2;
            }
            
            if(carac_combate.get("pm") == maximo && cuanto>0){
                System.out.println("Tus PM ya están al máximo.");
            }
            else if(carac_combate.get("pm") != maximo){
                int diferencia = maximo - mana;
                
                if(cuanto > diferencia){
                carac_combate.put("pm", maximo);
                }
                
                else carac_combate.put("pm", mana + cuanto);
            }
            
            else if(cuanto<0 && -1*cuanto>mana){
                carac_combate.put("pm", 0);
            }
            
            else carac_combate.put("pm", mana + cuanto);
        }
        
        
        
        public void sumaORestaVida(int cuanto){
            int maximo;
            int vida = carac_combate.get("ps");
            
            switch(queclase){
                case "MAGO": maximo = 30;
                case "ESCUDERO": maximo = 40;
                default: maximo = 35;
            }
            
            if(carac_combate.get("pm") == maximo && cuanto>0){
                System.out.println("Tus PS ya están al máximo.");
            }
            else if(carac_combate.get("pm") != maximo){
                int diferencia = maximo - vida;
                
                if(cuanto > diferencia){
                carac_combate.put("pm", maximo);
                }
                
                else carac_combate.put("pm", vida + cuanto);
            }
            
            else if(cuanto<0 && -1*cuanto>vida){
                carac_combate.put("pm", 0);
            }
            
            else carac_combate.put("pm", vida + cuanto);
        }
        
        public String toString(){
            return queclase+"\n"+carac_combate;
        }
        
        public String toStringVidaMana(){
            int maximo;
            
            switch(queclase){
                case "MAGO": maximo = 30;
                case "ESCUDERO": maximo = 40;
                default: maximo = 35;
            }
            
            return " - "+carac_combate.get("ps")+"/"+maximo;    //antes del guión vendría el nombre del jugador. Eso ya printear en el jugador.
        }
        
}
