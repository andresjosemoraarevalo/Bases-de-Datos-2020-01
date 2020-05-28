/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc_conexion;

import Interfaz.IGestionPrestamo;
import Repositorios.RepositorioLibro;
import Repositorios.RepositorioPrestamo;
import entidades.Libro;
import entidades.Linea;
import entidades.Prestamo;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class JDBC_Conexion extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
        public static void main(String[] args){
         //LISTO===   
        Date newDate = new Date(Calendar.getInstance().getTime().getTime());
        Prestamo nuevo = new Prestamo (newDate, 0 , 0 , 0, new BigDecimal(0));
        Prestamo prestado = new Prestamo (newDate, 0 , 2 , 0, new BigDecimal(1000));
        RepositorioLibro rl = new RepositorioLibro();
        RepositorioPrestamo r2 = new RepositorioPrestamo();
        ArrayList<Libro> Libr = new ArrayList<Libro>();
        Libro elLibr = new Libro();
        r2.agregarPrestamo(nuevo);
        r2.ImprimirDatos();
        System.out.println("Numero Mayor:" + r2.numeroPrestamoMayor());
        System.out.println("================================");
        r2.actualizarMonedaEnPrestamo(prestado);
        r2.ImprimirDatos();
        
        //LISTO???
        
        
        Libr=rl.CargarLibro();
        if(Libr.isEmpty())
        {
        System.out.println("AAAAAAAA");
        }
        else
        {
        elLibr = Libr.get(0);
       Linea laLinea = new Linea(elLibr, prestado, 3);
       r2.agregarLinea(laLinea);
        
        ArrayList<Linea> arrayLinea = r2.getLineas(0);
        laLinea = arrayLinea.get(0);
        System.out.println("Cantidad: " + laLinea.getCantidadLibros());
        System.out.println("No: " + laLinea.getPrestamoPadre().getNumero());
        r2.borrarLinea(laLinea);
        //rl.ImprimirDatos();
        

        }
        
        
        
    }

    
}