/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleso;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Valenzuela
 */
public class SimpleSO extends Application {
    static Stage stage;
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLBrowser.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLPaint.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLBrowser.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("escritorio/FXMLescritorio.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void escritorio() throws Exception{
        this.stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLescritorio.fxml"));
        Scene scene = new Scene(root);
        Stage stage = this.stage;
        this.stage = stage;
        stage.setScene(scene);
        stage.setTitle("SimpleSO");
        stage.setFullScreen(true);
        stage.show();
    }
    public void abrir_ventana(Parent root){
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Neutrón");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
