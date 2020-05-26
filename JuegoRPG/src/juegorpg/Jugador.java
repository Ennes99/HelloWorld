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
    
    /*public void eliminarDeMochila(Objeto cual){       Si no funciona el finalize, incluir en la interface. La pega es que necesitaría un Jugador como parámetro, y sería algo redundante al llamar
        Iterator<Objeto> it = mochila.iterator();
        Objeto each = it.next();
        
        while(it.hasNext()){
            if(each.getNombre().equalsIgnoreCase(cual.getNombre())){
                it.remove();
                break;
            } 
        }
    }*/
    public void aniadirAMochila(Objeto cual){
        mochila.add(cual);
    }
    
    
    public void usarObjeto(Jugador aquien, Jugador quien){
        Scanner teclado = new Scanner(System.in);
 
        printMochila(); //dos columnas para no ocupar mucho
        String res = "\n"+teclado.nextLine();
        
        for(Objeto cada:mochila){
            
            if(res.equalsIgnoreCase(cada.getNombre()) && cada instanceof Amuleto){
                System.out.println("Ya esta activo.");
                usarObjeto(aquien, quien);
            }
            
            else if(res.equalsIgnoreCase(cada.getNombre()) && cada instanceof Pocion){
                Pocion aux = (Pocion) cada;
                System.out.println("1.- USAR \n2.- COMBINAR");
        
                int opcion = teclado.nextInt();
        
                if(opcion == 1) {
                    aux.efectObjeto(aquien, quien);
                    return; //para que, una vez usado, no siga en el for usando objetos
                }
                
                else if(opcion == 2){
                    System.out.println("Elige un objeto para combinar.");
                    printMochila();
                    res = "\n"+teclado.nextLine();
                    for(Objeto otro:mochila){
                        if(res.equalsIgnoreCase(otro.getNombre())){
                            combinar(aux, otro);
                            return;
                        }
                        else{
                            System.out.println("No se ha encontrado el objeto");
                            usarObjeto(aquien, quien);
                        }
                    } 
                }
            }
            
            else{
                Construccion aux = (Construccion) cada;
                System.out.println("Elige un objeto para combinar.");
                    printMochila();
                    res = "\n"+teclado.nextLine();
                    for(Objeto otro:mochila){
                        if(res.equalsIgnoreCase(otro.getNombre())){
                            combinar(aux, otro);
                            return;
                        }
                        else{
                            System.out.println("No se ha encontrado el objeto");
                            usarObjeto(aquien, quien);
                        }
                    } 
            }
        }
    }
    
    
    public void menuBatalla(){
        //que siempre pueda acceder a sus datos, mochila, etc, además de atacar 
    }
    
    public void printVidaMana(){
        System.out.println(nombre + clase.toStringVidaMana());
    }
    
    private void printMochila(){
        System.out.println("            MOCHILA");
        
        for(int i=0;i<mochila.size()/2;i++){
            if(i!= (mochila.size()/2)) System.out.println(mochila.get(i).toString()+contarObjetos(mochila.get(i))+"              "
                                                                            + ""+mochila.get(mochila.size() - i).toString()+contarObjetos(mochila.get(mochila.size()-i)));
            
            else System.out.println(mochila.get(i).toString());
        }
    }
  
    
    
    private int contarObjetos(Objeto cual){
        int contador=0;
        for(Objeto cada:mochila){
            if(cada.equals(cual)) contador++;
        }
        
        return contador;
    }
    
    
    
    private void combinar(Objeto primero, Objeto segundo){
        
        if(primero instanceof Amuleto || segundo instanceof Amuleto) System.out.println("No se puede combinar");
        
        if(primero instanceof Pocion){
            Pocion aux = (Pocion) primero;
            mochila.add(aux.combinarCon(segundo));
        }
        
        else if(primero instanceof Construccion && !primero.nombre.equalsIgnoreCase(segundo.nombre)){
            Construccion aux = (Construccion) primero;
            mochila.add(aux.combinarCon(segundo));
            
            Object aux2 = clase.getCaracteristicas().get("ps");
            Integer original = (Integer) aux2;
            clase.getCaracteristicas().put("ps", original + 7);
        }
            
    }
    
    
}
