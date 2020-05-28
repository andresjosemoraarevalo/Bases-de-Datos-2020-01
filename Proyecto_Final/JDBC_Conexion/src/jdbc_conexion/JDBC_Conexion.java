/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc_conexion;

import Interfaz.IGestionPrestamo;
import Repositorios.RepositorioLibro;
import Repositorios.RepositorioPrestamo;
import entidades.Prestamo;
import java.math.BigDecimal;
import java.sql.Date;
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
            
        Date newDate = new Date(Calendar.getInstance().getTime().getTime());
        Prestamo nuevo = new Prestamo (newDate, 1 , 0 , 0, new BigDecimal(0));
        Prestamo prestado = new Prestamo (newDate, 1 , 2 , 0, new BigDecimal(1000));
        RepositorioLibro rl = new RepositorioLibro();
        RepositorioPrestamo r2 = new RepositorioPrestamo();
        r2.agregarPrestamo(nuevo);
        r2.ImprimirDatos();
        System.out.println("Numero Mayor:" + r2.numeroPrestamoMayor());
        System.out.println("================================");
        r2.actualizarMonedaEnPrestamo(prestado);
        r2.ImprimirDatos();
        
        //rl.ImprimirDatos();
        
    }

    
}