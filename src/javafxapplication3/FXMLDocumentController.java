/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import javafx.scene.canvas.Canvas;
import java.awt.Graphics;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Usuario
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private ColorPicker eligecolor;
    
    @FXML
    private TextField tamaño;
    
    @FXML
    private Button pincel;
    
    boolean brush=false;
    
    GraphicsContext pinceluso;
    
    @FXML
    private Canvas canvas;
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        pinceluso=canvas.getGraphicsContext2D();
        canvas.setOnMouseDragged(e->{
            double size=Double.parseDouble(tamaño.getText());
            double x=e.getX()-size/2;
            double y=e.getY()-size/2;
            
            
            if (brush && !tamaño.getText().isEmpty()){
                pinceluso.setFill(eligecolor.getValue());
                pinceluso.fillRoundRect(x, y, size, size, size, size);
            }
            
            
        });
        
        // TODO
    }    
    
    @FXML
    public void pincel(ActionEvent e){
        brush=true;
    }
}
