/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleso;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author Valenzuela
 */
public class FXMLPaintController implements Initializable {
        @FXML private Canvas papel;
        @FXML private Button coloractual;
        @FXML private Label l_trazo;
        private GraphicsContext gc;
        private Color color;
        private double posx;
        private double posy;
        private int trazo=5;
        
        Image cuadro = new Image(getClass().getResourceAsStream("/imagenes/paint/c_negro.png"));
        
        ImageInput c_negro = new ImageInput(cuadro);
        
        Image cuadro2 = new Image(getClass().getResourceAsStream("/imagenes/paint/c_azul.png"));
        ImageInput c_azul = new ImageInput(cuadro2);
        
        Image cuadro3 = new Image(getClass().getResourceAsStream("/imagenes/paint/c_rojo.png"));
        ImageInput c_rojo = new ImageInput(cuadro3);
        
          Image cuadro4 = new Image(getClass().getResourceAsStream("/imagenes/paint/c_amarillo.png"));
        ImageInput c_amarillo = new ImageInput(cuadro4);
        
          Image cuadro5 = new Image(getClass().getResourceAsStream("/imagenes/paint/c_verde.png"));
        ImageInput c_verde = new ImageInput(cuadro5);
        
        Image cuadro6 = new Image(getClass().getResourceAsStream("/imagenes/paint/c_morado.png"));
        ImageInput c_morado = new ImageInput(cuadro6);
        
        Image cuadro7 = new Image(getClass().getResourceAsStream("/imagenes/paint/c_blanco.png"));
        ImageInput c_blanco = new ImageInput(cuadro7);
        
     @FXML
    private void dibujar(MouseEvent event) {
       trazar(posx,posy,event.getX(),event.getY());
       posx=event.getX();
       posy=event.getY();
    }
    public void trazar(double x, double y, double x2, double y2){
        gc.setStroke(color);
        gc.setLineWidth(trazo);
        gc.strokeLine(x,y,x2,y2); 
    }
     @FXML
    private void actualizar(MouseEvent event) {
       posx=event.getX();
       posy=event.getY();
    }
@FXML
    private void borrar(ActionEvent event) {
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,papel.getWidth(),papel.getHeight());
    }
     @FXML
    private void abrir(ActionEvent event) {
       //  Image image = new Image(getClass().getResourceAsStream("/imagenes/paint/azul.png"));
       //  gc.drawImage(image, 0, 0);
    }
    
     @FXML
    private void px(ActionEvent event) {
        trazo++;
        l_trazo.setText(trazo + " PX");
    }
      @FXML
    private void px2(ActionEvent event) {
        trazo--;
        if(trazo<=1)trazo=1;
        l_trazo.setText(trazo + " PX");
    }
    
   
    
    
    @FXML
    private void guardar(ActionEvent event) {
        Stage stage = new Stage();
        saveImage(stage);
    }
    @FXML
    private void azul(ActionEvent event) {
        coloractual.setEffect(c_azul);
        color = Color.BLUE;  
    }
    @FXML
    private void rojo(ActionEvent event) {
        coloractual.setEffect(c_rojo);
       color = Color.RED;  
    }
    @FXML
    private void amarillo(ActionEvent event) {
        coloractual.setEffect(c_amarillo);
       color = Color.YELLOW;  
    }
    @FXML
    private void negro(ActionEvent event) {
        coloractual.setEffect(c_negro);
       color = Color.BLACK;  
    }
    @FXML
    private void verde(ActionEvent event) {
        coloractual.setEffect(c_verde);
       color = Color.GREEN;  
    }
    @FXML
    private void morado(ActionEvent event) {
        coloractual.setEffect(c_morado);
       color = Color.PURPLE;  
    }
    @FXML
    private void blanco(ActionEvent event) {
        coloractual.setEffect(c_blanco);
       color = Color.WHITE;  
    }
    
    public void saveImage(Stage primaryStage) {
        
        TextInputDialog dialog = new TextInputDialog(" ");
        dialog.setTitle("Guardando");
        dialog.setHeaderText("Nombre del archivo");
        dialog.setContentText("Nombre:");
        // Traditional way to get the response value.
        Optional<String> nombre = dialog.showAndWait();
        if (nombre.isPresent()){
            File file = new File(nombre.get() + ".png");
            if (file != null) {
                try {
                    WritableImage writableImage = new WritableImage((int) papel.getWidth(), (int) papel.getHeight());
                    papel.snapshot(null, writableImage);
                    RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
                    ImageIO.write(renderedImage, "png", file);
                } catch (IOException ex) {
                   // Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        color = Color.BLACK;
        this.gc = papel.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,papel.getWidth(),papel.getHeight());
    }   
    
}
