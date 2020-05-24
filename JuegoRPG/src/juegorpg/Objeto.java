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
public class Objeto {
    protected String nombre;
    protected String descripcion;
    
    public Objeto(){
        //los atributos se definirán en cada clase;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    //public abstract void efectObjeto(); --- como interface, ya que los Objetos de tipo Construccion no lo usan, pese a ser Objetos
    
    @Override
    public boolean equals(Object otro){             //los redefino por si acaso tenga que buscar objetos por comparación en la mochila
        if(!(otro instanceof Objeto)) return false;
        Objeto aux = (Objeto) otro;
        
        if(nombre.equals(aux.getNombre()) && descripcion.equals(aux.getDescripcion())) return true;
        return false;
    }
    
    @Override
    public int hashCode(){
        return nombre.hashCode()*7 + descripcion.hashCode()*9;
    }
    
    @Override
    public String toString(){
        return nombre.toUpperCase()+"\n"+"descripcion";
    }
}
