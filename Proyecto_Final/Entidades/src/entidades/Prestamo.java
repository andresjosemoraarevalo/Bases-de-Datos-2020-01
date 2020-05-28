/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

/**
 *
 * @author Andres Jose Mora, Oscar Andres Pacheco y Juan Pablo Amorocho
 */
public class Prestamo {
    private Date fecha;
    private int numero;
    private List<Linea> lineas = new ArrayList<>();
    private List<Moneda> pagoMonedas;
    private int CantiQuinientos;
    private int CantiMil;
    private BigDecimal MontoTotal;

    public Prestamo() {
    }

    public Prestamo(Date fecha, int numero, int c1, int c2, BigDecimal mt) {
        this.fecha = fecha;
        this.numero = numero;
        this.pagoMonedas = new ArrayList<>();
        this.CantiQuinientos = c1;
        this.CantiMil = c2;
        this.MontoTotal = mt;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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
    
    public int getCantiMonedas500()
    {
        return this.CantiQuinientos;
    }
    public int getCantiMonedas1000()
    {
        return this.CantiMil;
    }
    public BigDecimal getMontoTotal()
    {
        return this.MontoTotal;
    }
    public void setCantiMonedas500(int canti500)
    {
        this.CantiQuinientos = canti500;
        this.CalcularMontoTotal();
    }
    public void setCantiMonedas1000(int canti1000)
    {
        this.CantiMil = canti1000;
        this.CalcularMontoTotal();
    }
    public void añadirACanti500(int canti500)
    {
        this.CantiQuinientos += canti500;
        this.CalcularMontoTotal();
    }
    public void añadirACanti1000(int canti1000)
    {
        this.CantiMil += canti1000;
        this.CalcularMontoTotal();
    }
    
    private void CalcularMontoTotal()
    {
        this.MontoTotal = BigDecimal.ZERO;
        int Calc500 = this.CantiQuinientos * 500;
        int Calc1000 = this.CantiMil * 1000;
        this.MontoTotal = MontoTotal.add(new BigDecimal(Calc500));
        this.MontoTotal = MontoTotal.add(new BigDecimal(Calc1000));
    }
    
}