/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;
import entidades.Linea;
import entidades.Moneda;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entidades.Prestamo;
import java.sql.Date;
import java.util.ArrayList;
import jdbc_conexion.Constantes;
/**
 *
 * @author Juan Pablo Amorocho
 */
public class RepositorioPrestamo implements Interfaz.IGestionPrestamo{
    
    public void agregarPrestamo(Prestamo aAgregar)
    {
        String SQL_INSERT = "INSERT INTO Prestamo (LocalDateTime, Numero) VALUES (?,?)";
        int rowAff;
        if(aAgregar != null)
        {
        try(
          Connection conex = DriverManager.getConnection(Constantes.THINCONN, Constantes.USERNAME, Constantes.PASSWORD);
          PreparedStatement ps = conex.prepareStatement(SQL_INSERT);    
          )
          {
          ps.setDate(1,aAgregar.getFecha());
          ps.setInt(2,aAgregar.getNumero());
          rowAff = ps.executeUpdate();
              
          }
        catch (SQLException ex) {
            System.out.println("Error de conexion:" + ex.toString());
            ex.printStackTrace();
        }   
       }
    }
    
    public ArrayList<Prestamo> getPrestamo()
    {
        ArrayList<Prestamo> Resultado = new ArrayList<>();
        String GetInfoPrestamo = "select * from Prestamo";
        Prestamo aAgregar;
        Date LocalDateTime;
        int Numero;
        
        try(Connection conex = DriverManager.getConnection(Constantes.THINCONN, Constantes.USERNAME, Constantes.PASSWORD);
    PreparedStatement ps = conex.prepareStatement(GetInfoPrestamo);
    ResultSet rs = ps.executeQuery();)
        {
          while (rs.next())
        {
            LocalDateTime = rs.getDate("LocalDateTime");
            Numero = rs.getInt("Numero");
            aAgregar = new Prestamo(LocalDateTime, Numero);
            Resultado.add(aAgregar);
        }  
        }
        catch (SQLException ex) {
            System.out.println("Error de conexion:" + ex.toString());
            ex.printStackTrace();
        }
        return Resultado;
    }
    
    public void agregarLinea(Linea aAgregar)
    {
         String SQL_INSERT = "INSERT INTO Linea (ISBN_libro, Numero_Prestamo) VALUES (?,?)";
         String ISBN_libro;
         int Numero_Prestamo, rowAff, Cantidad;
        ISBN_libro = aAgregar.getLibroEnPrestamo().getIsbn();
        Numero_Prestamo = aAgregar.getPrestamoPadre().getNumero();
        Cantidad = aAgregar.getCantidadLibros();
            try(
          Connection conex = DriverManager.getConnection(Constantes.THINCONN, Constantes.USERNAME, Constantes.PASSWORD);
          PreparedStatement ps = conex.prepareStatement(SQL_INSERT);)
                {
                    ps.setString(1, ISBN_libro);
                    ps.setInt(2, Numero_Prestamo);
                    ps.setInt(3, Cantidad);
                    rowAff = ps.executeUpdate();
                }
            catch (SQLException ex) {
            System.out.println("Error de conexion:" + ex.toString());
            ex.printStackTrace();
        }
    }
    
    public void agregarMoneda(Moneda aAgregar)
    {
        //PENDING...
    }
    
    
    
}