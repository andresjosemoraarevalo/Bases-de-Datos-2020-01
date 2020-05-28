/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantalla;

import Controlador.ControlEventosLibreria;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import java.net.URL;
import javafx.util.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import Pantalla.PantallaKiosco;
import dto.DTOResumen;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import javax.swing.text.TableView;
/**
 *
 * @author andre
 */
public class FXMLDocumentController implements Initializable {
    private ControlEventosLibreria contro = new ControlEventosLibreria();
    @FXML
    private Label label;
    @FXML
    private Label fecha;
    @FXML
    private ComboBox<String> listaLibros;
    @FXML
    private ComboBox<Integer> listaMonedas;
    @FXML
    private Button BotonNuevoPrestamo;
    @FXML
    private Label vueltosLabel;
    @FXML
    private Label saldoDisponibleLabel;
    @FXML
    private Label numeroPrestamo;
    @FXML
    private TableView tablaPrestamo;
    @FXML
    private TextField cantidadLibros;
    @FXML
    private TextField cantidadMonedas;
    @FXML
    private Button botonAgregarMonedas;
    @FXML
    private Button botonTerminarPrestamo;
    @FXML
    private Button botonGenerarReporte;
    @FXML
    private Button botonBuscar;
    @FXML
    private TextField buscarNumeroPrestamo;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        /*LocalDateTime localDate = LocalDateTime.now();//For reference
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/LLLL/yyyy hh:mm a");
        String formattedString = localDate.format(formatter);
        this.fecha.setText(formattedString);*/
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm");
        fecha.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
        
        
        listaLibros.getItems().addAll(FXCollections.observableList(contro.nombreLibros()));
        listaMonedas.getItems().addAll(500, 1000);
    }    
    @FXML
    private void nuevoPrestamo(ActionEvent event) {
        DTOResumen dto =contro.crearNuevoPrestamo();
        if(dto.isAgregar()){
            JOptionPane.showMessageDialog(null, dto.getMensaje());
            this.vueltosLabel.setText("$ "+Integer.toString(dto.getCantidadVueltos()));
            this.saldoDisponibleLabel.setText("$ "+Integer.toString(dto.getSaldoMonedas()));
            this.numeroPrestamo.setText(Integer.toString(dto.getNumeroPrestamo()));
        }else{
            JOptionPane.showMessageDialog(null,dto.getMensaje(),"Error al agregar",JOptionPane.WARNING_MESSAGE); 
        }
    }
    private void Clear(){
        this.numeroPrestamo.setText(null);
        this.saldoDisponibleLabel.setText(null);
        this.vueltosLabel.setText(null);
        
    }
}
