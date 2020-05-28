/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entidades.Libro;
import java.math.BigDecimal;
import java.util.ArrayList;
import jdbc_conexion.Constantes;
/**
 *
 * @author USER
 */
public class RepositorioLibro implements Interfaz.IGestionLibro {
    
    
    
    public ArrayList<Libro> CargarLibro()
    {
        String GetInfoLibro = "select * from libro";
        Libro aAgregar;
        String ISBN, NombreLibro;
        BigDecimal Precio;
        ArrayList<Libro> catalogo = new ArrayList<>();
        int NumeroImagenes, NumeroVideos, UDisponibles;
    try
    (
    Connection conex = DriverManager.getConnection(Constantes.THINCONN, Constantes.USERNAME, Constantes.PASSWORD);
    PreparedStatement ps = conex.prepareStatement(GetInfoLibro);
    ResultSet rs = ps.executeQuery();
    )
    {
        while (rs.next())
        {
            ISBN = rs.getString("ISBN");
            NombreLibro = rs.getString("NombreLibro");
            Precio = rs.getBigDecimal("precio");
            UDisponibles = rs.getInt("UnidadesDisponibles");
            NumeroImagenes = rs.getInt("NumeroImagenes");
            NumeroVideos = rs.getInt("NumeroVideos");
            aAgregar = new Libro(ISBN,Precio,UDisponibles,NumeroImagenes,NumeroVideos,NombreLibro);
            catalogo.add(aAgregar);
        }
        
    }
    catch (SQLException ex) {
            System.out.println("Error de conexion:" + ex.toString());
            ex.printStackTrace();
        }
    return catalogo;

    }
    
    public void ImprimirDatos()
    {
        ArrayList<Libro> catalogo = this.CargarLibro();
        for (Libro libroCurr : catalogo) {
            System.out.println("Nombre: " + libroCurr.getNombreLibro());
            System.out.println("Precio: " + libroCurr.getPrecioBase());
        }
        
    }

    
    
    
}
