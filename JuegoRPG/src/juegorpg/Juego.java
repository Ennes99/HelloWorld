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
public class Juego {
    private Scanner teclado;
    private String respuesta;
    private ArrayList<Jugador> jugadores;
    
    public Juego(){
        jugadores = new ArrayList();
    }
    
    public ArrayList<Jugador> getJugadores(){
        return jugadores;
    }
    
    public Jugador getJugadorPorNombre(String n){
        Jugador aux = null;
        
        for(Jugador cada:jugadores){
            if(cada.getNombre().equals(n)){
                aux = cada;
                
            }
        }
        return aux;
    }
    
    public String jugarParte1(){                //ESTE, Y JUEGO2, SERÁN LOS ÚLTIMOS MÉTODOS EN HACERSE
        teclado = new Scanner(System.in);
        Clase queclase;
        Raza queraza;
        String quenombre;
        
        System.out.println("Procederemos a crear tu personaje. Primero, ¿cómo te llamas?: ");
        quenombre= teclado.nextLine();
        
        queraza = setRaza();
        queclase = setClase(queraza);
        
        aniadirJugador(quenombre, queraza, queclase);
        Jugador prota = jugadores.get(0);
        
        System.out.println("Te encuentras en la mazmorra de Alduin. Tras llegar hasta lo más alto de la más alta torre, tienes que \n"
                + "atravesar la sala del consejero del emperador para poder llegar hasta este malvado. Antes de enfrentarte a él, reúnes provisiones\n"
                + ". . . \n"+prota.getNombre()+" ha añadido una poción de salud, de maná y un frasco de mocos de trol a su bolsa.");
        
        prota.aniadirAMochila(new PocionVida());
        prota.aniadirAMochila(new PocionMana());
        prota.aniadirAMochila(new Construccion("mocos"));
        
        System.out.println("Estás a punto de entrar en la sala. Dispones de unos momentos para prepararte:\n\n");
        do{
        prota.menuReposo();
        System.out.println("\n¿Has acabado?(s/n)\n");
        respuesta = teclado.nextLine();
        }while(respuesta.equalsIgnoreCase("n"));
        
        aniadirJugador("enemigo1", Raza.ORCO, new Mago());
        Jugador enemigo1 = jugadores.get(1);
        enemigo1.aniadirAMochila(new PocionVida());
        enemigo1.aniadirAMochila(new PocionVida());
        
        System.out.println("Te sientes preparado/a para entrar en la sala y estás lleno/a de determinación. Entras...el consejero, un orco mago, te estaba esperando.\n¡A combatir!");
        
        int batalla = combate(prota, enemigo1);
        
        if(batalla == 0){
            System.out.println("Fin del juego. Eres un manta.");
            return null;
        }
        else{
            System.out.println("El consejero ha muerto. Recoges sangre y mocos de su cadáver (¿Servirán junto con las botellas vacías?).\n \n. . . \nDespués"
                    + "de caminar un rato, llegas a la sala del emperador.\nSystem.out.println(\"Estás a punto de entrar en la sala. Dispones de unos momentos para prepararte:");
            prota.aniadirAMochila(new Construccion("mocos"));
            prota.aniadirAMochila(new Construccion("sangre"));
            prota.menuReposo();
            
            return quenombre;
        }                   
    }  
    
    
    
    public void jugarParte2(){
        aniadirJugador("enemigo2", Raza.ORCO, new Mago());
        Jugador prota = jugadores.get(0);
        Jugador enemigo2 = jugadores.get(2);
        enemigo2.aniadirAMochila(new PocionVida());
        enemigo2.aniadirAMochila(new PocionVida());
        
        System.out.println("Te sientes preparado/a para entrar en la sala y estás lleno/a de determinación. El emperador te espera y, sin \ndirigirte la palbra, ataca. \n ¡A combatir!");
        int batalla = combate(prota, enemigo2);
        
        if(batalla == 0){
            System.out.println("Fin del juego. Eres un manta.");
        }
        
        else System.out.println("¡EL EMPERADOR HA MUERTO! ¡EL REINO ES LIBRE DE TIRANÍA!\nHas ganado");
    }
    
    //-----------------------------------------------------------------------------------------------------------------------------------------------------
    
    private Raza setRaza(){
        Raza queraza;
        
        System.out.println("Elige una raza: \nHUMANO -- H \nORCO -- O \nELFO -- E \n");
        respuesta = teclado.nextLine();
        
        switch(respuesta.toUpperCase()){
            case "H": queraza = Raza.HUMANO;break;   //Sé que lo del switch no tiene mucho sentido, únicamente es para darle más "sensación de menú"
            case "O": queraza = Raza.ORCO;break;
            default: queraza = Raza.ELFO;
        }
        return queraza;
    }
    
    
    private Clase setClase(Raza r){     //defino el mismo switch para los tres casos de razas: haz la selección en bucle hasta que la respuesta sea la clase correcta.
        Clase queclase = null;
        
        if(r == Raza.HUMANO){
        do{
        System.out.println("Por último, elige una clase: \nESCUDERO -- E \nMAGO -- M \nLADRÓN -- L \n");
        respuesta = teclado.nextLine();
        
        switch(respuesta.toUpperCase()){
            case "E": queclase = new Escudero();break;
            case "L": queclase = new Ladron();break;
            default: System.out.println("Esa clase no es válida para tu raza.\n");
        }}
        while(!respuesta.equalsIgnoreCase("E") && !respuesta.equalsIgnoreCase("L"));
        
        }
        
        if(r == Raza.ORCO){
        do{
        System.out.println("Por último, elige una clase: \nESCUDERO -- E \nMAGO -- M \nLADRÓN -- L \n");
        respuesta = teclado.nextLine();
        
        switch(respuesta.toUpperCase()){
            case "E": queclase = new Escudero();break;
            case "M": queclase = new Mago();break;
            default: System.out.println("Esa clase no es válida para tu raza.\n"); break;
        }}
        while(!respuesta.equalsIgnoreCase("E") && !respuesta.equalsIgnoreCase("M"));
        
        }
        
        if(r == Raza.ELFO){
        do{
        System.out.println("Por último, elige una clase: \nESCUDERO -- E \nMAGO -- M \nLADRÓN -- L \n");
        respuesta = teclado.nextLine();    
        switch(respuesta.toUpperCase()){
            case "M": queclase = new Escudero();break;
            case "L": queclase = new Ladron();break;
            default: System.out.println("Esa clase no es válida para tu raza.\n");
        }}
        while(!respuesta.equalsIgnoreCase("M") && !respuesta.equalsIgnoreCase("L"));
        
        }
        return queclase;
    }
    
    
    private void aniadirJugador(String n, Raza r, Clase c){
        jugadores.add(new Jugador(n, r, c));
    }
    
    
    //IMPORTANTE TURNOS: los objetos también podrán llamar a jugador.atacar() / enemigo.atacar(), para cuando tengan el efecto de que el jugador
                            //o enemigo ataque más de una vez / se quede sin atacar (en esencia, es lo mismo, salvo por cambiar quién ataca dos veces)
     //EN LOS COMBATES, FINALIZAR CADA TURNO DICIENDO LA VIDA DE CADA UNO Y MANÁ DEL JUGADOR
    
    private int combate(Jugador quien, Jugador enemigo){
        int num_rondas = 1;
        System.out.println("¡"+enemigo.getNombre()+" quiere pelear!");
        
        do{
        System.out.println("------------------------ronda "+num_rondas+"------------------------");
            
        quien.menuBatalla(enemigo);
        
        enemigo.menuBatalla(quien);
        
        System.out.println("-----------------------------------------------------------\n                 "
                           +quien.getNombre()+quien.getClase().toStringVidaMana()+"\n                 "+enemigo.getClase().toStringVidaMana());
        num_rondas++;
        } while(!(quien.getClase().getVida()<0) || !(enemigo.getClase().getVida()<0));
        
        if(quien.getClase().getVida() < 0){
            System.out.println("\n Has perdido...¿Quieres reiniciar el combate? (S/N)");
            respuesta = teclado.nextLine();
            
            if(respuesta.equalsIgnoreCase("s")) return combate(quien, enemigo);
            else return 0;
        }
        
        else{
            System.out.println("\n ¡¡Has ganado!!");
            return 1;
        }
    }
    
}
