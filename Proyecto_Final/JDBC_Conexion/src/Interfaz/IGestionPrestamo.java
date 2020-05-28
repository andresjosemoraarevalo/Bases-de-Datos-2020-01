/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import entidades.Linea;
import entidades.Prestamo;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public interface IGestionPrestamo {
   public void agregarPrestamo(Prestamo aAgregar);
   public ArrayList<Prestamo> getPrestamo();
   public void agregarLinea(Linea aAgregar);
   public void actualizarMonedaEnPrestamo(Prestamo aActualizar);
    public int numeroPrestamoMayor();
   public void borrarLinea(Linea aBorrar);
   public void terminarPrestamo();
   //Para Pruebas...
    public void ImprimirDatos();

}