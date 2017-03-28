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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author Valenzuela
 */
public class FXMLBrowserController implements Initializable {
    @FXML private WebView atom;
     @FXML private TextField url;
     private WebEngine myWebEngine;
    /**
     * Initializes the controller class.
     */
    @FXML
    private void buscar(ActionEvent event) {
      myWebEngine  = atom.getEngine();
      myWebEngine.load(url.getText());
      System.out.println(url.getText());
    
    }
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      myWebEngine  = atom.getEngine();
      myWebEngine.load("https://www.google.com");
          
    }    
    
}
