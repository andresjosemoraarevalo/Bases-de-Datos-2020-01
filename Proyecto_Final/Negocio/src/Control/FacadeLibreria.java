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
import dto.DTOLinea;
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
    private IGestionLibro gestionLibro;
    private IGestionPrestamo gestionPrestamo;
    private DTOResumen dto;

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
            this.dto.setAgregar(true);
            this.dto.setMensaje("No se pudo agregar porque no hay Libros disponibles");
            return false;
        }
        Prestamo p=new Prestamo();
        p.setFecha(java.sql.Date.valueOf(LocalDate.now()));
        int numPrestamo=gestionPrestamo.numeroPrestamoMayor()+1;
        p.setNumero(numPrestamo);
        this.prestamoActual=p;
        this.dto.setAgregar(true);
        this.dto.setMensaje("El prestamo fue creado con exito");
        this.dto.setSaldoMonedas(0);
        this.dto.setCantidadVueltos(0);
        this.dto.setNumeroPrestamo(numPrestamo);
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

    public DTOResumen getDto() {
        return dto;
    }

    public void setDto(DTOResumen dto) {
        this.dto = dto;
    }
    
}
