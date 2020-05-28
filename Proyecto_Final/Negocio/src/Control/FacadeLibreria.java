/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Interfaz.IGestionLibro;
import Repositorios.RepositorioLibro;
import entidades.Libro;
import entidades.Prestamo;
import entidades.Denominacion;
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
    IGestionLibro gestionLibro;

    public FacadeLibreria() {
        this.gestionLibro=new RepositorioLibro();
        this.catalogo=new ArrayList<>();
        this.catalogo=this.gestionLibro.CargarLibro();
        this.prestamos = new ArrayList<>();
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
