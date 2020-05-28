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
import entidades.Prestamo;
import jdbc_conexion.Constantes;
/**
 *
 * @author Juan Pablo Amorocho
 */
public class RepositorioPrestamo implements Interfaz.IGestionPrestamo{
    String SQL_INSERT = "INSERT INTO Prestamo (LocalDateTime, Numero) VALUES (?,?)";
    int rowAff;
    public void agregarPrestamo(Prestamo aAgregar)
    {
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
    
    
    
}
