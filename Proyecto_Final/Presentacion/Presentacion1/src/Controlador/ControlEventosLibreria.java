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

/**
 *
 * @author andre
 */
public class ControlEventosLibreria {
    private IFacadeLibreria interfazLibreria;

    public ControlEventosLibreria() {
    }

    public ControlEventosLibreria(IFacadeLibreria interfazLibreria) {
        this.interfazLibreria = new FacadeLibreria();
    }
    public List<Libro> cargarLibros(){
        return this.interfazLibreria.getCatalogo();
    }
}
