/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import entidades.Libro;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public interface IGestionLibro {
    public ArrayList<Libro> CargarLibro();
    //Para probar datos...
    public void ImprimirDatos();
    public void actualizarUnidadesDisponiblesLibro (Libro aActualizar);
    
}
