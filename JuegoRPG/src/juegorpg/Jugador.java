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
    private ArrayList<Objeto> mochila;  //podría haber hecho una clase para mochila, pero no tenía gran cosa aparte del ArrayList
    
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
                System.out.println("Se activa desde el menú de combate.");  //para darle más "singularidad" al amuleto
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
                            if(!nombre.contains("enemigo")){
                                System.out.println("No se ha encontrado el objeto");
                                usarObjeto(aquien, quien);
                            }
                        }
                    } 
                }
            }
            
            else if(res.equalsIgnoreCase(cada.getNombre()) && cada instanceof Construccion){
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
                            if(!nombre.contains("enemigo")){
                                System.out.println("No se ha encontrado el objeto");
                                usarObjeto(aquien, quien);
                            }
                        }
                    } 
            }
        }
    }
    
    
    public void menuBatalla(Jugador enemigo){  //pensaba hacer una clase entera para ello, pero me pareció muy poca cosa 
        Random azar = new Random();
         int num;
        
        if(nombre.contains("enemigo")){ //aquí defino qué hace el enemigo en la batalla. Como él no tendrá un menú, es "controlado por la máquina", lo pongo aparte.
            atacar(enemigo);
            System.out.println("¡El enemigo te ha atacado y has perdido salud!");
            num = azar.nextInt();
            
            if(clase.getVida() < 6 && num <3){
                clase.sumaORestaVida(5);
                System.out.println(". . . \nEl enemigo está bajo de salud, ¡Se ha bebido una poción");
            }
        }
         
        else{
            Scanner teclado = new Scanner(System.in);
            System.out.println("      ¡A PELEAR!\n   1.-Atacar\n   2.-Mochila\n   3.-Amuleto");
            num = teclado.nextInt();
            
            if(num == 1) atacar(enemigo);
            else if(num == 2) usarObjeto(enemigo, this);
            else if(num == 3) activarAmuleto(enemigo);
            else{
                System.out.println("Opción no válida");
                menuBatalla(enemigo);
            }
        } 
    }
    
    public void menuReposo(){
        Scanner teclado = new Scanner(System.in);
        int num=0;
        
        System.out.println("      MENÚ\n   1.-ver Jugador\n   2.-Mochila\n \n\n(Con cualquier otro número irás a la sala directamente)");
        num = teclado.nextInt();
            
        if(num == 1) System.out.println(toString());
        else if(num == 2){
            usarObjeto(null, this);
            menuReposo();
        }
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
    
    
    private void atacar(Jugador aquien){  //los objetos se podrían (ya veré si lo hago o no) usar tanto dentro del combate como fuera. Atacar, sólo para la batalla. Por eso es private.
        Object aux = clase.getCaracteristicas().get("atq");
        Object aux2 = aquien.getClase().getCaracteristicas().get("def");
        Random azar = new Random();
        
        Integer miataque = (Integer) aux;
        Integer sudefensa = (Integer) aux2;
        
        System.out.println(". . .\n");
        
        if(miataque > sudefensa){
            aquien.getClase().sumaORestaVida(-(miataque - sudefensa));
            System.out.println("¡El enemigo pierde vida!");
        }
        else{
            int num = azar.nextInt(9)+1;
            if(num >= 6){
                aquien.getClase().sumaORestaVida(-2);
                System.out.println("Atacas al enemigo, pero no le haces mucho daño...");
            }
            
            else System.out.println("¡El enemigo ha bloqueado el ataque!");
        }
    }
    
    
    private void activarAmuleto(Jugador aquien){
        for(Objeto cada:mochila){
            if(this.getClase().getNombreClase().equalsIgnoreCase("ladrón") && cada.getNombre().equalsIgnoreCase("brazalete del ladrón")){
              Amuleto aux = (Amuleto) cada;
              aux.efectObjeto(aquien, this);
            }
            
            if(this.getClase().getNombreClase().equalsIgnoreCase("mago") && cada.getNombre().equalsIgnoreCase("sombrero del mago")){
              Amuleto aux = (Amuleto) cada;
              aux.efectObjeto(aquien, this);
            }
            
            if(this.getClase().getNombreClase().equalsIgnoreCase("escudero") && cada.getNombre().equalsIgnoreCase("casco del escudero")){
              Amuleto aux = (Amuleto) cada;
              aux.efectObjeto(aquien, this);
            }
        }
    }
    
    
    private void printMochila(){
        System.out.println("            MOCHILA");
        
        for(int i=0;i<mochila.size();i++){
           System.out.println(mochila.get(i).toString()+"   x"+contarObjetos(mochila.get(i)));
        }
    }
  
    
    
    private int contarObjetos(Objeto cual){
        int contador=0;
        for(Objeto cada:mochila){
            if(cada.equals(cual)) contador++;
        }
        
        return contador;
    }
    
    public void printVidaMana(){
        System.out.println(nombre + clase.toStringVidaMana());
    }
    
    public String toString(){
        String aux="";
        for(Object cada:clase.getCaracteristicas().keySet()){
            if(aux.equals("")) aux+="   "+cada+" / "+clase.getCaracteristicas().get(cada);
            else aux+="\n                    "+cada+" / "+clase.getCaracteristicas().get(cada);
        }
        return "nombre: "+nombre+"\nraza: "+raza+"\nclase: "+clase+"\nCaracterísticas: "+aux;
    }
    
}
