/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Andres Jose Mora, Oscar Andres Pacheco y Juan Pablo Amorocho
 */
public class Libro {
    private String isbn;
    private double precioBase;
    private int unidadesDsiponibles;
    private int numeroImagenes;
    private int numeroVideos;

    public Libro() {
    }

    public Libro(String isbn, double precioBase, int unidadesDsiponibles, int numeroImagenes, int numeroVideos) {
        this.isbn = isbn;
        this.precioBase = precioBase;
        this.unidadesDsiponibles = unidadesDsiponibles;
        this.numeroImagenes = numeroImagenes;
        this.numeroVideos = numeroVideos;
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

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
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
    
    
}
