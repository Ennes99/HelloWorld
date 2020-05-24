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
public class Construccion extends Objeto implements Combinable{ //Sangre o mocos, que, si se combinan con botellas, crean pociones. Si se juntan ellos mismos...
                            //Su particularidad es, precisamente, que solo sirve para combinarse
    public Construccion(String n, String d){
        if(!n.equalsIgnoreCase("sangre") || !n.equalsIgnoreCase("mocos")) nombre = "sangre";
        nombre = n;
        descripcion = "se puede combinar con otro objeto"; //
    }
    
    public Objeto combinarCon(Objeto otro){
        Pocion aux;
        
        if(otro.equals(this)){
            System.out.println("Dos objetos iguales no se pueden combinar");
            return null;
        }
            
        else if(otro instanceof Pocion){ 
            aux = (Pocion) otro;
            return aux.combinarCon(this);
        }
        
        else if(otro.getNombre().equalsIgnoreCase("sangre") && nombre.equalsIgnoreCase("mocos")){
            System.out.println("Mezclas sangre y mocos mágicos, obteniendo una sustancia extraña. Te la comes y... ¡Tu vida ha aumentado 2 PS");
            return null;
        }
        
        else{   //sería la opción de que "otro" fuera un Amuleto. Se incrementa su bonus en 1
        System.out.println("Al combinar "+nombre+" con tu "+otro.getNombre()+", este se vuelve más resistente. Ganas un poco de defensa.");
        return null;
        }
        
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
