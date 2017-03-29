/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleso;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.stage.FileChooser;
import javafx.stage.Window;



/**
 * FXML Controller class
 *
 * @author pacw1_000
 */
public class FXMLBlockController implements Initializable {
     private File archivo;
    
    int i;
    
    FileChooser.ExtensionFilter restricciones;
     
    
    
    String lecturaTemp;
    
    String[] escrituraTemp;
    
    private final FileChooser selectorArchivos = new FileChooser();
   
    Window scene;
    
    FileReader lector_;
    
    BufferedReader lector;
    
    FileWriter escritor;
    
    @FXML
    private TextArea txarea;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void tLetra(){
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Ionic Block");
        dialog.setHeaderText("Cambiar Tamaño de Letra");
        dialog.setContentText("Tamaño:");

        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
            if (result.isPresent()){
                txarea.setStyle("-fx-font-size:"+result.get()+";");
            }

    }
    @FXML
     private void cLetra(){
        List<String> choices = new ArrayList<>();
        choices.add("black");
        choices.add("red");
        choices.add("yellow");
        choices.add("blue");

        ChoiceDialog<String> dialog = new ChoiceDialog<>("black", choices);
        dialog.setTitle("Ionic Block");
        dialog.setHeaderText("Selecciona el Color de Letra");
        dialog.setContentText("Color:");

        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
            if (result.isPresent()){
                txarea.setStyle("-fx-text-fill:"+result.get()+";");
            }

    }
    
    
    
    @FXML
    private void openFile(){
        selectorArchivos.setTitle("Seleccionar Arhivo");
         restricciones = new FileChooser.ExtensionFilter("Archivos de texto(*.txt)", "*.txt");
        selectorArchivos.getExtensionFilters().add(restricciones);
         try{
            archivo = selectorArchivos.showOpenDialog(scene);
            
            if( archivo.getName().endsWith(".txt") == true && archivo != null ){
            
            
            try{
                lector_ = new FileReader(archivo);
                lector = new BufferedReader(lector_);

                txarea.clear();

                while((lecturaTemp = lector.readLine()) != null) {
                    txarea.insertText(txarea.getLength(), lecturaTemp + "\n");
                }
                txarea.deletePreviousChar();

                lector_.close();
                lector.close();
            }
            catch(Exception ex){
                
            }
        }
        }
         
        catch(Exception ex){
            
        }
        
        
    }
    @FXML
    private void saveFile(){
         selectorArchivos.setTitle("Guardar Arhivo");
         restricciones = new FileChooser.ExtensionFilter("Archivos de texto(*.txt)", "*.txt");
        selectorArchivos.getExtensionFilters().add(restricciones);
        try{
            archivo = selectorArchivos.showSaveDialog(scene);
            if( archivo.getName().endsWith(".txt") == true  && archivo != null ){
           
            
                try{
                    escritor = new FileWriter(archivo);
                    escrituraTemp = txarea.getText().split("\\n");

                    for(i=0; i < escrituraTemp.length; i++){
                        escritor.write(escrituraTemp[i]);
                        if(i != escrituraTemp.length - 1)
                            escritor.write(System.lineSeparator());
                    }

                    escritor.close();
                }
                catch(Exception ex){
                   
                }
            }
        }
        catch(Exception ex){
            
        }
        
        
    }
    
}
