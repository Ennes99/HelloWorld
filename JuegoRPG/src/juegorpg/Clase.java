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
    protected String queclase;
    private final int vidamax;
    private final int manamax;
    private HashMap<String, Integer> carac_combate; //ataque, ataque mágico, defensa, velocidad, salud y maná -- Me tenía más sentido ponerlo en private, ya que es algo que concierne a todas las clases, no específicamente a cada una
    
        public Clase(){
            carac_combate = new HashMap();
            setCaracteristicas();
            vidamax = carac_combate.get("ps");
            manamax = carac_combate.get("pm");
        }
        
        public int getVida(){
            return carac_combate.get("ps");
        }
        
        public int getMana(){
            return carac_combate.get("pm");
        }
        
        public String getNombreClase(){
            return queclase;
        }
        
        public HashMap getCaracteristicas(){
            return carac_combate;
        }
        
        protected abstract void setCaracteristicas();
        
        //public abstract void ataqueEspecial(); //cada clase tendrá un ataque mágico propio a su disposición (hace diferentes cosas, ataque fuerte, defensa fuerte, etc)
        
        public abstract Objeto objetoEspecial(String nom, String desc); //cada clase empieza con un objeto especial
        
        public void sumaORestaMana(int cuanto){
            if(carac_combate.get("pm") == manamax && cuanto>0){
                System.out.println("Tus PM ya están al máximo.");
            }
            else if(carac_combate.get("pm") != manamax){
                int diferencia = manamax - getMana();
                
                if(cuanto > diferencia){
                carac_combate.put("pm", manamax);
                }
                
                else carac_combate.put("pm", getMana() + cuanto);
            }
            
            else if(cuanto<0 && -1*cuanto>getMana()){
                carac_combate.put("pm", 0);
            }
            
            else carac_combate.put("pm", getMana() + cuanto);
        }
        
        
        
        public void sumaORestaVida(int cuanto){
            if(carac_combate.get("pm") == vidamax && cuanto>0){
                System.out.println("Tus PS ya están al máximo.");
            }
            else if(carac_combate.get("pm") != vidamax){
                int diferencia = vidamax - getVida();
                
                if(cuanto > diferencia){
                carac_combate.put("pm", vidamax);
                }
                
                else carac_combate.put("pm", getVida() + cuanto);
            }
            
            else if(cuanto<0 && -1*cuanto>getVida()){
                carac_combate.put("pm", 0);
            }
            
            else carac_combate.put("pm", getVida() + cuanto);
        }
        
        
        
        public String toString(){
            return queclase+"\n"+carac_combate;
        }
        
        public String toStringVidaMana(){  
            return " - "+carac_combate.get("ps")+"/"+vidamax+"\n   "+carac_combate.get("pm")+"/"+manamax;    //antes del guión vendría el nombre del jugador. Eso ya printear en el jugador.
        }
        
}
