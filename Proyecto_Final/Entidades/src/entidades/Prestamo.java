/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andres Jose Mora, Oscar Andres Pacheco y Juan Pablo Amorocho
 */
public class Prestamo {
    private LocalDateTime fecha;
    private int numero;
    private List<Linea> lineas = new ArrayList<>();
    private List<Moneda> pagoMonedas;

    public Prestamo() {
    }

    public Prestamo(LocalDateTime fecha, int numero) {
        this.fecha = fecha;
        this.numero = numero;
        this.pagoMonedas = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public List<Linea> getLineas() {
        return lineas;
    }

    public void setLineas(List<Linea> lineas) {
        this.lineas = lineas;
    }

    public List<Moneda> getPagoMonedas() {
        return pagoMonedas;
    }

    public void setPagoMonedas(List<Moneda> pagoMonedas) {
        this.pagoMonedas = pagoMonedas;
    }
    
}
