/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleso;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import static simpleso.SimpleSO.stage;

/**
 * FXML Controller class
 *
 * @author pacw1_000
 */
public class FXMLVisorimgController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ImageView img;
    int i=0,tam;
    List<File> list;
    
    @FXML
    public void verImagen(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar Imagen");

        // Agregar filtros para facilitar la busqueda
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );

        // Obtener la imagen seleccionada
         list = fileChooser.showOpenMultipleDialog(stage);
         tam=list.size();
        // Mostar la imagen
        if (!list.isEmpty()) {
            Image image = new Image("file:" + list.get(i).getAbsolutePath());
            
            
            
            img.setImage(image);
            
            
            
            
            
        }
        
    }
    
    @FXML
    public void next(){
        if (i<tam-1) {
            i++;
            Image image = new Image("file:" + list.get(i).getAbsolutePath());
            img.setImage(image);   
        }
        else{
            i=0;
            Image image = new Image("file:" + list.get(i).getAbsolutePath());
            img.setImage(image);
        }
        
    }
    
    @FXML
    public void antes(){
        if (i>0) {
            i--;
            Image image = new Image("file:" + list.get(i).getAbsolutePath());
            img.setImage(image);   
        }
        else{
            i=0;
            Image image = new Image("file:" + list.get(i).getAbsolutePath());
            img.setImage(image);
        }
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
    }    
    
}
