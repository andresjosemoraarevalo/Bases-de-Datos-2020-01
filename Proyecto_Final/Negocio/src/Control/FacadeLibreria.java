/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import entidades.Libro;
import entidades.Prestamo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre
 */
public class FacadeLibreria implements Interfaz.IFacadeLibreria{
    private List<Libro> catalogo;
    
    private List<Prestamo> prestamos;
    private Prestamo prestamoActual;

    public FacadeLibreria() {
    }

    public FacadeLibreria(Prestamo prestamoActual) {
        this.catalogo = new ArrayList<>();
        this.prestamos = new ArrayList<>();
        this.prestamoActual = prestamoActual;
    }

    public Prestamo getPrestamoActual() {
        return prestamoActual;
    }

    public void setPrestamoActual(Prestamo prestamoActual) {
        this.prestamoActual = prestamoActual;
    }

    public List<Libro> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(List<Libro> catalogo) {
        this.catalogo = catalogo;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }
    
}
