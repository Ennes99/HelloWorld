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
public class Jugador {
    private String nombre;
    private Raza raza;
    private Clase clase;
    private ArrayList<Objeto> mochila;
    
    public Jugador(String n, Raza r, Clase c){
        nombre = n;
        raza = r;
        clase = c;
        mochila = new ArrayList();
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public ArrayList getMochila(){
        return mochila;
    }
    
    public Raza getRaza(){
        return raza;
    }
    
    public Clase getClase(){
        return clase;
    }
    
    public void eliminarDeMochila(Objeto cual){
        Iterator<Objeto> it = mochila.iterator();
        Objeto each = it.next();
        
        while(it.hasNext()){
            if(each.getNombre().equalsIgnoreCase(cual.getNombre())){
                it.remove();
                break;
            } 
        }
    }
    
    
    public void usarObjeto(){
        Scanner teclado = new Scanner(System.in);
 
        System.out.println("            MOCHILA");
        printMochila(); //dos columnas para no ocupar mucho
        String aux = "\n"+teclado.nextLine();    
        
    }
    
    
    public void combate(){
        //menuBatalla -> otra clase. La última, lo juro
    }
    
    public void printVidaMana(){
        System.out.println(nombre + clase.toStringVidaMana());
    }
    
    private void printMochila(){
        //usar contador de objetos
    }
    
    private void contarObjetos(Objeto cual){
        
    }
    
    private void combinar(Objeto primero, Objeto segundo){
        if(primero instanceof Pocion){
            Pocion aux = (Pocion) primero;
            mochila.add(aux.combinarCon(segundo));
        }
        
        else if(primero instanceof Construccion){
            Construccion aux = (Construccion) primero;
            if(segundo instanceof Pocion) mochila.add(aux.combinarCon(segundo));
            
            else if(segundo instanceof Amuleto){
                aux.combinarCon(segundo); //este es el caso en el que "segundo" es un Amuleto. Esta combinación no devuelve un objeto, por tanto, no lo añadimos a la mochila
                Object aux2 = clase.getCaracteristicas().get("def");
                Integer original = (Integer) aux2;
                clase.getCaracteristicas().put("def", original + 2);
            }
            
            else{
                aux.combinarCon(segundo); 
                Object aux2 = clase.getCaracteristicas().get("ps");
                Integer original = (Integer) aux2;
                clase.getCaracteristicas().put("ps", original + 7);
            }
        }
        
        else{
            if(segundo instanceof Construccion) ((Construccion) segundo).combinarCon(primero);
            else System.out.println("No se puede combinar");
        }
    }
    
}
