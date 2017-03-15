/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleso;



import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Valenzuela
 */
public class FXMLDocumentController implements Initializable {
    
    /*putoooooo*/

    @FXML private AnchorPane p_usuario;
    @FXML private AnchorPane p_contrasena;
    @FXML private PasswordField contrasena;
    @FXML private TextField usuario;
    @FXML private Button botonUsuario;
    @FXML private Button botonCandado;
    @FXML private Button salir;
    boolean bandera= false;
    String usuario_="sample";
    String contrasena_="123";
    Image imagen = new Image(getClass().getResourceAsStream("/imagenes/error.png"));
    ImageInput imageInput = new ImageInput(imagen);
    Image imagen2 = new Image(getClass().getResourceAsStream("/imagenes/candadorojo.png"));
    ImageInput imageInput2 = new ImageInput(imagen2);
    
    Image imagen3 = new Image(getClass().getResourceAsStream("/imagenes/cerrarrojo.png"));
    ImageInput imageInput3 = new ImageInput(imagen3);
    
    Image imagen4 = new Image(getClass().getResourceAsStream("/imagenes/cerrar.png"));
    ImageInput imageInput4 = new ImageInput(imagen4);
    
    @FXML
    private void validar(ActionEvent event) {
        if(bandera==false){
            if(usuario.getText().equals(usuario_)){
                p_usuario.setVisible(false);
                p_contrasena.setVisible(true);
                bandera=true;
            }else{
                botonUsuario.setEffect(imageInput);
            }
            usuario.setText("");
        }else{
            if(contrasena.getText().equals(contrasena_)){
                p_usuario.setVisible(false);
                p_contrasena.setVisible(false);
            }else{
                botonCandado.setEffect(imageInput2);
            }
            contrasena.setText("");
        }
        
    }
     @FXML
    private void entered(MouseEvent event) {
        salir.setEffect(imageInput3);
    }
     @FXML
    private void exited(MouseEvent event) {
        salir.setEffect(imageInput4);
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        p_usuario.setVisible(true);
        p_contrasena.setVisible(false);
    }    
    
}
