/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleso;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import static simpleso.SimpleSO.stage;

/**
 * FXML Controller class
 *
 * @author pacw1_000
 */
public class FXMLVideoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ImageView play;
    @FXML
    private ImageView pause;
    
    @FXML
    private MediaPlayer player;
    @FXML
    private MediaView mediaView;
    
    Media m;
    
    List<File> list;
    int i=0,tam;
    @FXML
    private void vplay() throws URISyntaxException{
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar Video");

        // Agregar filtros para facilitar la busqueda
        fileChooser.getExtensionFilters().addAll(
                
                new FileChooser.ExtensionFilter("Mp4", "*.mp4")
        );

        // Obtener la imagen seleccionada
         list = fileChooser.showOpenMultipleDialog(stage);
         tam=list.size();
        // Mostar la imagen
         m = new Media(list.get(i).toURI().toString());
       
        player = new MediaPlayer(m);
        player.setAutoPlay(true);
        player.setCycleCount(MediaPlayer.INDEFINITE);
        mediaView.setMediaPlayer(player);
        player.setOnReady(new Runnable() {
            @Override
            public void run() {
                
            }
        });
        play.setVisible(false);
        pause.setVisible(true);
        
    }
    
    @FXML
    public void antes(){
        if (i>0) {
            i--;
            m = new Media(list.get(i).toURI().toString());
            player = new MediaPlayer(m);
             player.setAutoPlay(true);
             player.setCycleCount(MediaPlayer.INDEFINITE);
            mediaView.setMediaPlayer(player);
            player.setOnReady(new Runnable() {
                @Override
                public void run() {

                }
            });
            play.setVisible(false);
            pause.setVisible(true);
        }
        else{
            i=0;
            m = new Media(list.get(i).toURI().toString());
            player = new MediaPlayer(m);
            player.setAutoPlay(true);
            player.setCycleCount(MediaPlayer.INDEFINITE);
            mediaView.setMediaPlayer(player);
            player.setOnReady(new Runnable() {
                @Override
                public void run() {

                }
            });
            play.setVisible(false);
            pause.setVisible(true);
        }
    }
    
    @FXML
    public void play(){
         play.setVisible(false);
        pause.setVisible(true);
        
        if (this.player != null) {
            
            this.player.play();
            
        }
    }
    @FXML
    public void pause(){
        pause.setVisible(false);
        play.setVisible(true);
        
         if (this.player != null) {
            
            this.player.pause();
            
        }
    }
    
    @FXML
    public void next(){
        if (i<tam-1) {
            i++;
            m = new Media(list.get(i).toURI().toString());
            player = new MediaPlayer(m);
             player.setAutoPlay(true);
             player.setCycleCount(MediaPlayer.INDEFINITE);
            mediaView.setMediaPlayer(player);
            player.setOnReady(new Runnable() {
                @Override
                public void run() {

                }
            });
            play.setVisible(false);
            pause.setVisible(true);
        }
        else{
            i=0;
            m = new Media(list.get(i).toURI().toString());
            player = new MediaPlayer(m);
            player.setAutoPlay(true);
            player.setCycleCount(MediaPlayer.INDEFINITE);
            mediaView.setMediaPlayer(player);
            player.setOnReady(new Runnable() {
                @Override
                public void run() {

                }
            });
            play.setVisible(false);
            pause.setVisible(true);
            }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
