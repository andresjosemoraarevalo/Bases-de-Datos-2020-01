/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author andre, AAAAAAAAA
 */
public enum Denominacion {
    //Esto es un comentario.
    QUINIENTOS(500),
    MIL(1000);
    private final int valor;

    private Denominacion(int valor) {
        this.valor = valor;
    }
    
}
