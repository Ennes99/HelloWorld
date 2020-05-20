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
    
    public Objeto(String n, String d){
        nombre = n.toUpperCase();
        descripcion = d;
    }
}
