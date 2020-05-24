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
public interface Combinable {   //función especial sólo para Pociones y Construccion. Cuando una Pocion se bebe, queda una "botella vacía" que, combinada con un objeto,
                               //puede crear de nuevo la poción
    public Objeto combinarCon(Objeto concual);
    public void eliminarDeMochila();    //cuando se combina un objeto con otro se tienen que destruir ambos para crear el objeto nuevo
}
