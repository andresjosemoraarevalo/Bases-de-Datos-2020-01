/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.math.BigDecimal;

/**
 *
 * @author Andres Jose Mora, Oscar Andres Pacheco y Juan Pablo Amorocho
 */
public class Libro {
    private String isbn;
    private BigDecimal precioBase;
    private int unidadesDsiponibles;
    private int numeroImagenes;
    private int numeroVideos;
    private String nombreLibro;

    public Libro() {
    }

    public Libro(String isbn, BigDecimal precioBase, int unidadesDsiponibles, int numeroImagenes, int numeroVideos, String nombreLibro) {
        this.isbn = isbn;
        this.precioBase = precioBase;
        this.unidadesDsiponibles = unidadesDsiponibles;
        this.numeroImagenes = numeroImagenes;
        this.numeroVideos = numeroVideos;
        this.nombreLibro = nombreLibro;
    }
    
    public int getNumeroVideos() {
        return numeroVideos;
    }

    public void setNumeroVideos(int numeroVideos) {
        this.numeroVideos = numeroVideos;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public BigDecimal getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(BigDecimal precioBase) {
        this.precioBase = precioBase;
    }

    public int getUnidadesDsiponibles() {
        return unidadesDsiponibles;
    }

    public void setUnidadesDsiponibles(int unidadesDsiponibles) {
        this.unidadesDsiponibles = unidadesDsiponibles;
    }

    public int getNumeroImagenes() {
        return numeroImagenes;
    }

    public void setNumeroImagenes(int numeroImagenes) {
        this.numeroImagenes = numeroImagenes;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }
}
