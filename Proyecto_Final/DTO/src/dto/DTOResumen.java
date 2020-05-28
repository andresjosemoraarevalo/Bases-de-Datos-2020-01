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
    private String mensaje;
    private List<DTOLinea> Lineas;
    private boolean agregar;
    private int totalPrestamo;
    private int saldoMonedas;
    private int cantidadVueltos; 
    private int numeroPrestamo;
    public DTOResumen() {
    }

    public DTOResumen(String mensaje, List<DTOLinea> Lineas, boolean agregar, int totalPrestamo, int saldoMonedas, int cantidadVueltos) {
        this.mensaje = mensaje;
        this.Lineas = Lineas;
        this.agregar = agregar;
        this.totalPrestamo = totalPrestamo;
        this.saldoMonedas = saldoMonedas;
        this.cantidadVueltos = cantidadVueltos;
    }

    public int getCantidadVueltos() {
        return cantidadVueltos;
    }

    public void setCantidadVueltos(int cantidadVueltos) {
        this.cantidadVueltos = cantidadVueltos;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<DTOLinea> getLineas() {
        return Lineas;
    }

    public void setLineas(List<DTOLinea> Lineas) {
        this.Lineas = Lineas;
    }

    public boolean isAgregar() {
        return agregar;
    }

    public void setAgregar(boolean agregar) {
        this.agregar = agregar;
    }

    public int getTotalPrestamo() {
        return totalPrestamo;
    }

    public void setTotalPrestamo(int totalPrestamo) {
        this.totalPrestamo = totalPrestamo;
    }

    public int getSaldoMonedas() {
        return saldoMonedas;
    }

    public void setSaldoMonedas(int saldoMonedas) {
        this.saldoMonedas = saldoMonedas;
    }

    public int getNumeroPrestamo() {
        return numeroPrestamo;
    }

    public void setNumeroPrestamo(int numeroPrestamo) {
        this.numeroPrestamo = numeroPrestamo;
    }
    
    
}
