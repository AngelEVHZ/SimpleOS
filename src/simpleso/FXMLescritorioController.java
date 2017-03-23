/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleso;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

/**
 * FXML Controller class
 *
 * @author Vaio
 */
public class FXMLescritorioController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private void navegador(ActionEvent e){
        try{
            SimpleSO ss = new SimpleSO();
            Parent root = FXMLLoader.load(getClass().getResource("FXMLBrowser.fxml"));
            ss.abrir_ventana(root);
            
        }catch(IOException error){
            System.out.println(error);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
