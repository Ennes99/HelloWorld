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
public class Menu {
    private final String[] opciones={"***********************************************\n*            FINAL QUEST - THE GAME           *\n***********************************************", 
                              "Nueva Partida", "Borrar Partida","continuar partida", "Salir"};
    private int opcion;
    private Scanner teclado;
    public final HashMap<String, Juego> partidas;
    
    public Menu(){
        teclado= new Scanner(System.in);
        partidas = new HashMap();
    }
    
    public void aplicarMenu(){
        do{
            printMenu();       
            escogerOpcion();
        } while(opcion==1 || opcion==2 || opcion ==3);  //Cuando elija la opción 3 (que, según printMenu, consigue pasar a escogerOpcion), salte del bucle, 
                                                        //es decir, finaliza el menú == el "juego". Le decimos que repita el bucle en caso de sí procesar la opción (cuando es 1, 2 o 3)
                                                        //para poder volver cuando se quiera al menú principal
    }
    
    private void printMenu(){
        do{
            System.out.print(opciones[0]+"\n\n");
            for(int i=1;i<opciones.length;i++) System.out.println(i+".- "+opciones[i]);
            System.out.print("\nElija opción: ");
            
            try{
            opcion=teclado.nextInt(); //se maneja el posible error que da poner una opcion que no es
            }
            catch(Exception e){
            opcion=0;
            }
            if(opcion<1 || opcion>opciones.length-1) System.out.println("Opción no válida. \n");
            //teclado=new Scanner(System.in);   
        }
        
        while(opcion<1 || opcion>opciones.length-1);    //haz que siga en el mismo menú siempre que no seleccionemos una de las opciones que se dan a escoger
    }                                               
    
    
    /*public int getOpcion(){
        return opcion;
    }*/
    
    private void escogerOpcion(){
        switch(opcion){
            case 1:comenzar();break;        
            case 2:borrar();break;
            case 3: continuar();break;
            case 4: return;
            default: break;
        }
    }
    
    private void comenzar(){
        
        System.out.println("Comenzarás una nueva partida. \"B\" para volver al menú principal.\n Pulsa enter para continuar.\n");
        teclado= new Scanner(System.in);
        if(teclado.nextLine().equalsIgnoreCase("B")) aplicarMenu(); 
        
        if(partidas.size()>=3) {
            System.out.println("Memoria llena. Borra una partida para poder comenzar una nueva.");
            return;
        }
        
        Juego nuevo = new Juego();
        
        String nombrepartida = nuevo.jugarParte1(); //ejecuto jugarParte1 directamente asinándole el valor de retorno a "nombrepartida"
        if(nombrepartida == null) return;
        
        guardar(nombrepartida,nuevo);   //"guardar" es algo ilusorio, el Juego se va guardando solo a medida que se actualizan los datos. Lo que simula el guardado es tenerlo almacenado
                        //en la lista de partidas
                     
        nuevo.jugarParte2();
    }
    
    private void borrar(){
        boolean borrado = false;
        teclado= new Scanner(System.in);
        String aux;
        imprimirPartidas();
        
        System.out.println("\nNombre de la partida: ");
        
        aux=teclado.nextLine();
        
        Iterator<Map.Entry<String, Juego>> it = partidas.entrySet().iterator();
        
        while(it.hasNext()){
            if(it.next().getKey().equals(aux)){
                it.remove();
                borrado = true;
            }
         
        }
        if(borrado) System.out.println("borrado con éxito.");
        else System.out.println("No se ha borrado. Prueba con otro nombre.");
        
    }
    
    
    private void continuar(){
        teclado= new Scanner(System.in);
        String aux;
        imprimirPartidas();
        
        System.out.println("\nNombre de la partida: ");
        aux=teclado.nextLine();
        
        for(String each:partidas.keySet()){
            if(each.equals(aux)) partidas.get(each).jugarParte2();
        }
        
    }
    
    
    private void guardar(String n, Juego j){
        partidas.put(n, j);
    }
    
    private void imprimirPartidas(){
        int i = 0;
        System.out.println("***********************************************\n*            LISTA DE PARTIDAS                *\n***********************************************");     
        
        for(String each: partidas.keySet()){
            System.out.println((i+1)+".- "+each+"\n"); //imprime la partida por su nombre, que, como es el mismo que el del jugador, pongo uno u otro
            i++;
        }
        
    }
    
}
