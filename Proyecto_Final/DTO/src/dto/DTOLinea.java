/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entidades.Libro;

/**
 *
 * @author andre
 */
public class DTOLinea {
    private Libro libro;
    private int cantidad;
    private int totalLibro;
    private int subtotal;

    public DTOLinea() {
    }

    public DTOLinea(Libro libro, int cantidad, int totalLibro, int subtotal) {
        this.libro = libro;
        this.cantidad = cantidad;
        this.totalLibro = totalLibro;
        this.subtotal = subtotal;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTotalLibro() {
        return totalLibro;
    }

    public void setTotalLibro(int totalLibro) {
        this.totalLibro = totalLibro;
    }
    
}
