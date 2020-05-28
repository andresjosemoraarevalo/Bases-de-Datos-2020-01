/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Interfaz.IGestionLibro;
import Interfaz.IGestionPrestamo;
import Repositorios.RepositorioLibro;
import Repositorios.RepositorioPrestamo;
import dto.DTOResumen;
import entidades.Libro;
import entidades.Prestamo;
import entidades.Denominacion;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
    IGestionPrestamo gestionPrestamo;
    DTOResumen dto;

    public FacadeLibreria() {
        this.gestionLibro=new RepositorioLibro();
        this.gestionPrestamo=new RepositorioPrestamo();
        this.catalogo=new ArrayList<>();
        this.catalogo=this.gestionLibro.CargarLibro();
        this.prestamos = new ArrayList<>();
        this.dto=new DTOResumen();
    }
    public boolean crearNuevoPrestamo(){
        int contador=0;
        DTOResumen dto=new DTOResumen();
        for (Libro libro : catalogo) {
            if(libro.getUnidadesDsiponibles()>0){
                contador++;
            }
        }
        if(contador==0){
            return false;
        }
        Prestamo p=new Prestamo();
        p.setFecha(java.sql.Date.valueOf(LocalDate.now()));
        p.setNumero(gestionPrestamo.numeroPrestamoMayor()+1);
        this.prestamoActual=p;
        
        return true;
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
