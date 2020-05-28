/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entidades.Linea;
import java.util.List;

/**
 *
 * @author andre
 */
public class DTOResumen {
        String mensaje;
        List<DTOLinea> Lineas;
        boolean agregar;
        int totalPrestamo;
        int saldoMonedas;
        int cantidadVueltos; 
}
