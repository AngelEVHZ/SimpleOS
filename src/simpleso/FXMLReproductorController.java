/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleso;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javafx.scene.image.ImageView;
import javazoom.jlgui.basicplayer.BasicPlayerException;


/**
 * FXML Controller class
 *
 * @author pacw1_000
 */
public class FXMLReproductorController implements Initializable {
     @FXML 
     private ImageView play;
     @FXML 
     private ImageView next;
     @FXML 
     private ImageView antes;
     @FXML 
     private ImageView resume;
     @FXML 
     private ImageView open;
    
     @FXML 
     private ImageView pause;
     
     @FXML 
     private Label name;
     
     Player rep = new Player();
    /**
     * Initializes the controller class.
     */
     
     public void selecciona() throws BasicPlayerException{
         rep.abrir();
     }
     
     public void play() throws BasicPlayerException, Exception{
         play.setVisible(false);
         pause.setVisible(true);
         rep.play();
         name.setText(rep.muestra());
     }
     
     public void pausa() throws Exception{
         pause.setVisible(false);
         resume.setVisible(true);
         rep.Pausa();
     }
     
     public void resum() throws Exception{
         resume.setVisible(false);
         pause.setVisible(true);
         rep.Continuar();
     }
     
     public void siguiente() throws Exception{
         play.setVisible(false);
         resume.setVisible(false);
         pause.setVisible(true);
         rep.next();
         name.setText(rep.muestra());
     }
     
     public void anterior() throws Exception{
         play.setVisible(false);
         resume.setVisible(false);
         pause.setVisible(true);
         rep.antes();
         name.setText(rep.muestra());
     }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
