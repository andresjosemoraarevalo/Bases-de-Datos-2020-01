/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Control.FacadeLibreria;
import Interfaz.IFacadeLibreria;
import entidades.Libro;
import java.util.ArrayList;
import java.util.List;
import dto.DTOLinea;

/**
 *
 * @author andre
 */
public class ControlEventosLibreria {
    private IFacadeLibreria interfazLibreria;

    public ControlEventosLibreria() {
        this.interfazLibreria = new FacadeLibreria();
    }

    public ControlEventosLibreria(IFacadeLibreria interfazLibreria) {
        this.interfazLibreria = new FacadeLibreria();
    }
    public List<Libro> cargarLibros(){
        return this.interfazLibreria.getCatalogo();
    }
    public List<String> nombreLibros(){
        List<String> nombreLibros = new ArrayList();
        List<Libro> aux = new ArrayList();
        aux = this.cargarLibros();
        for (Libro libro : aux) {
            nombreLibros.add(libro.getNombreLibro());
        }
        return nombreLibros;
    }
    public DTOLinea agregarLinea (Libro libro, int cantidad){
        //Verificar libro
        
        //Verificar existencia
        
        //Crear linea
        
        //Calcular el valor del libro
        
        //Calcular subtotal de una linea
        
        //calcular el total del prestamo
        
        //Crear DTO resumen
    }
    
}
