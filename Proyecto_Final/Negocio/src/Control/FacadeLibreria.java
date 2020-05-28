/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Interfaz.IGestionLibro;
import Interfaz.IGestionPrestamo;
import Repositorios.RepositorioLibro;
import Repositorios.RepositorioPrestamo;
import dto.DTOLinea;
import dto.DTOResumen;
import entidades.Libro;
import entidades.Prestamo;
import entidades.Denominacion;
import entidades.Linea;
import entidades.Moneda;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author andre
 */
public class FacadeLibreria implements Interfaz.IFacadeLibreria{
    private List<Libro> catalogo;
    
    private List<Prestamo> prestamos;
    private Prestamo prestamoActual;
    private IGestionLibro gestionLibro;
    private IGestionPrestamo gestionPrestamo;
    private DTOResumen dto;
    private static Constates cons;
    private List<Moneda> monedas;
    public FacadeLibreria() {
        this.gestionLibro=new RepositorioLibro();
        this.gestionPrestamo=new RepositorioPrestamo();
        this.catalogo=new ArrayList<>();
        this.catalogo=this.gestionLibro.CargarLibro();
        this.prestamos = new ArrayList<>();
        this.dto=new DTOResumen();
        this.cons=new Constates();
    }
    public void persisitirPrestamo(){
        this.gestionPrestamo.agregarPrestamo(this.prestamoActual);
    }
    public boolean crearNuevoPrestamo(){
        int contador=0;
        DTOResumen dto=new DTOResumen();
        for (Libro libro : catalogo) {
            if(libro.getUnidadesDisponibles()>0){
                contador++;
            }
        }
        if(contador==0){
            this.dto.setAgregar(true);
            this.dto.setMensaje("No se pudo agregar porque no hay Libros disponibles");
            return false;
        }
        Prestamo p=new Prestamo();
        p.setFecha(java.sql.Date.valueOf(LocalDate.now()));
        int numPrestamo=gestionPrestamo.numeroPrestamoMayor()+1;
        p.setNumero(numPrestamo);
        this.prestamoActual=p;
        this.dto.setAgregar(true);
        this.dto.setMensaje("El prestamo fue creado con exito");
        this.dto.setSaldoMonedas(0);
        this.dto.setCantidadVueltos(0);
        this.dto.setNumeroPrestamo(numPrestamo);
        this.persisitirPrestamo();
        return true;
    }
    
    public Prestamo getPrestamoActual() {
        return prestamoActual;
    }

    public void setPrestamoActual(Prestamo prestamoActual) {
        this.prestamoActual = prestamoActual;
    }

            //TERCERO
    //terminado
    private void crearLinea (){
        Linea linea = new Linea();
        this.prestamoActual.getLineas().add(linea);
    }
    public BigDecimal introducirMoneda(int Cantidad, Denominacion Valor)
    {
        Moneda aAgregar;
        if(Valor == Denominacion.QUINIENTOS)
        {
            aAgregar = new Moneda(Valor);
            monedas.add(aAgregar);
            prestamoActual.añadirACanti500(Cantidad);

        }
        else if(Valor == Denominacion.MIL)
        {
            aAgregar = new Moneda(Valor);
            monedas.add(aAgregar);
            prestamoActual.añadirACanti1000(Cantidad);
        }
        gestionPrestamo.actualizarMonedaEnPrestamo(prestamoActual);
        return (prestamoActual.getMontoTotal());
    }
    public DTOResumen agregarLinea (String libro, int cantidad){
        crearLinea();
        String verificado = verificarLibro(libro);
        Libro objL = null;
        for (Libro libro1 : this.catalogo) 
            if (libro.equals(libro1.getNombreLibro()))
                objL = libro1;
        
        if (verificado==null){
            verificado = verificarExistencias(libro, cantidad);
            if (verificado==null){
                this.prestamoActual.getLineas().get(this.prestamoActual.getLineas().size()-1).setLibroEnPrestamo(objL);
                this.prestamoActual.getLineas().get(this.prestamoActual.getLineas().size()-1).setCantidadLibros(cantidad);
                this.dto.getLineas().add(new DTOLinea());
                this.dto.getLineas().get(this.prestamoActual.getLineas().size()-1).setCantidad(cantidad);
                this.dto.getLineas().get(this.prestamoActual.getLineas().size()-1).setLibro(objL);
                this.dto.getLineas().get(this.prestamoActual.getLineas().size()-1).setSubtotal((int) calcularSubtotal(libro));
                this.dto.getLineas().get(this.prestamoActual.getLineas().size()-1).setTotalLibro((int) calcularTotal(libro));
                this.dto.setAgregar(true);
                
                return dto;
            }
            else{
                dto.setMensaje(dto.getMensaje()+"\n"+verificado);             
            }
        }
        else{
            dto.setMensaje(dto.getMensaje()+"\n"+verificado);
        }
        dto.setAgregar(false);
        return dto;
    }
    
    //terminada
    private String verificarLibro (String libro){  
        for (Libro libro1 : this.catalogo) {
            if (libro.equals(libro1.getNombreLibro())){
                this.prestamoActual.getLineas().get(this.prestamoActual.getLineas().size()-1).setLibroEnPrestamo(libro1);
                return null;
            }
        }
        return "El libro seleccionado no se encuentra en el catalogo";
    }
   
    //terminada
    private String verificarExistencias (String libro, int cantidad){
        for (Libro libro1 : this.catalogo) 
            if (libro.equals(libro1.getNombreLibro()))
                if (libro1.getUnidadesDisponibles()>=cantidad)
                    return null;
        return "El libro seleccionado no cuenta con unidades suficientes para las que está solicitando";
    }
    
    //terminado
    private double calcularLibro(String libro){
        double total;
        for (Libro libro1 : this.catalogo) {
            if (libro.equals(libro1.getNombreLibro())){
                total = libro1.getPrecioBase().doubleValue()+(libro1.getNumeroImagenes()*this.cons.getVALOR_IMAGEN())+(libro1.getNumeroVideos()*cons.getVALOR_VIDEO());                
                return total;
            }
        }        
        return 0;
    }
    
    //terminado
    private double calcularSubtotal (String libro){
        double subtotal;
        for (Libro libro1 : this.catalogo) {
            if (libro.equals(libro1.getNombreLibro())){
                subtotal=calcularLibro(libro)*this.prestamoActual.getLineas().get(this.prestamoActual.getLineas().size()-1).getCantidadLibros();
                return subtotal;
            }      
        }
        return 0;        
    }
    
    private double calcularTotal (String libro){
        double total=0;
         
        for (Linea linea : prestamoActual.getLineas())
            total+=calcularSubtotal(linea.getLibroEnPrestamo().getNombreLibro());
        return total;        
    }
 //----------------------------------------------end of 3rd
    
    public List<Libro> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(List<Libro> catalogo) {
        this.catalogo = catalogo;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public DTOResumen getDto() {
        return dto;
    }

    public void setDto(DTOResumen dto) {
        this.dto = dto;
    }
    
}
