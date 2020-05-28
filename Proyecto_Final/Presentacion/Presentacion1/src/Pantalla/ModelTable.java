/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantalla;

/**
 *
 * @author andre
 */
public class ModelTable {
    private String libro;
    private int cantidad;
    private int precioLibro;

    public ModelTable() {
    }

    public ModelTable(String libro, int cantidad, int precioLibro) {
        this.libro = libro;
        this.cantidad = cantidad;
        this.precioLibro = precioLibro;
    }

    public int getPrecioLibro() {
        return precioLibro;
    }

    public void setPrecioLibro(int precioLibro) {
        this.precioLibro = precioLibro;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
