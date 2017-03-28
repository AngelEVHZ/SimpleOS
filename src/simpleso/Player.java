/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleso;
import javazoom.jlgui.basicplayer.BasicPlayer;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javafx.stage.FileChooser;
import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jlgui.basicplayer.BasicPlayerListener;
import static simpleso.SimpleSO.stage;
/**
 *
 * @author pacw1_000
 */
public class Player  {
    
    private BasicPlayer reproductor;
    private List <File> canciones;
    private File cancion;
    private int i,lim;
    
    
    public Player(){
        
        reproductor = new BasicPlayer();
        i=0;
    }
    
    public void abrir() throws BasicPlayerException{
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Reproducir....");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Mp3", "*.mp3")
        );
        
        canciones = (List<File>) fileChooser.showOpenMultipleDialog(stage);
        
        
        lim=canciones.size();
        
        
        if (!canciones.isEmpty()) {
            System.out.println(canciones);
            cancion=canciones.get(0);
            reproductor.open(cancion);
        }
    }
    
    public void play() throws BasicPlayerException{
        reproductor.play();
    }
    
    public void Pausa() throws Exception {
      reproductor.pause();
    }

    public void Continuar() throws Exception {
      reproductor.resume();
    }
    
     public void stop() throws Exception {
      reproductor.stop();
    }

    public String muestra() throws Exception {
      String name;
      name=cancion.getName();
      return name;
    }
    
    public void next() throws Exception{
        
        if (i<lim){
            cancion=canciones.get(i++);
            
            reproductor.open(cancion);
            reproductor.play();
        }
        else{
            i=0;
            cancion=canciones.get(0);
            
            reproductor.open(cancion);
            reproductor.play();
        }
        
        
        
        
    }
    public void antes() throws Exception{
        
        if (i>0){
            cancion=canciones.get(i--);
            
            reproductor.open(cancion);
            reproductor.play();
        }
        else{
            i=0;
            cancion=canciones.get(0);
            
            reproductor.open(cancion);
            reproductor.play();
        }
        
        
        
    }

    
    
    
    
    
    
}
