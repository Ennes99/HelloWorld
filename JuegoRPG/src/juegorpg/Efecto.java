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
public interface Efecto {
    public void efectObjeto(Jugador aquien, Jugador quien); //En algunos casos necesitaré quién usa el objeto y hacia quién, porque puede tener efectos para ambos
                                                                        //ejemplo: el efecto del sombrero del mago (método privado en Amuleto)
}
