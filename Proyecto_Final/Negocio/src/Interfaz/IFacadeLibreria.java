/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import entidades.Libro;
import java.util.List;

/**
 *
 * @author andre
 */
public interface IFacadeLibreria {
    public List<Libro> getCatalogo();
}
