/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleso;

import java.beans.EventHandler;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author Vaio
 */
public class FXMLcmdController implements Initializable {
    @FXML
    private TextArea texto;
    private KeyCode Enter = KeyCode.ENTER;
    private String user;
    
    private String leer(String cad){
        String temp = "";
        for(int i=0;i<cad.length();i++){
            if(!(cad.charAt(i)=='\n')){
                temp=temp+cad.charAt(i);
            }
            if(cad.charAt(i)=='\n'){
                if(i+4<cad.length()){
                    temp="";
                }
            }
        }
        return temp;
    }
    private String acomodar(String cad){
        texto.setText("");
        String cad1 = cad+"\n"+user;
        return cad1;
    }
    @FXML
    private void met(KeyEvent e){
        if(e.getCode()==Enter){
            if(leer(texto.getText()).equals("root>>Open browser.sp")){
                texto.appendText(acomodar(texto.getText()));
                //System.out.println("Abro el navegador");
                
                try{
                    SimpleSO ss = new SimpleSO();
                    Parent root = FXMLLoader.load(getClass().getResource("FXMLBrowser.fxml"));
                    ss.abrir_ventana(root);
                }catch(IOException error){
                    System.out.println(error);
                }
            }
            if(leer(texto.getText()).equals("root>>Open paint.sp")){
                texto.appendText(acomodar(texto.getText()));
                //System.out.println("Abro el paint");
                
                try{
                    SimpleSO ss = new SimpleSO();
                    Parent root = FXMLLoader.load(getClass().getResource("FXMLPaint.fxml"));
                    ss.abrir_ventana(root);
                }catch(IOException error){
                    System.out.println(error);
                }
            }
            if(leer(texto.getText()).equals("root>>Open reproductor.sp")){
                texto.appendText(acomodar(texto.getText()));
                //System.out.println("Abro el reproductor");
                try{
                    SimpleSO ss = new SimpleSO();
                    Parent root = FXMLLoader.load(getClass().getResource("FXMLReproductor.fxml"));
                    ss.abrir_ventana(root);
                }catch(IOException error){
                    System.out.println(error);
                }
            }
            if(leer(texto.getText()).equals("root>>Open video.sp")){
                texto.appendText(acomodar(texto.getText()));
                //System.out.println("Abro el Visor de video");
                
                try{
                    SimpleSO ss = new SimpleSO();
                    Parent root = FXMLLoader.load(getClass().getResource("FXMLVideo.fxml"));
                    ss.abrir_ventana(root);
                }catch(IOException error){
                    System.out.println(error);
                }
            }
            if(leer(texto.getText()).equals("root>>Kill SO")){
                texto.appendText(acomodar(texto.getText()));
                
                //System.out.println("Cierro el programa");
                
                //Para la función de esta parte necesito ver todo el proyecto para orientar a que mate todas las ventanas
            }
            if(leer(texto.getText()).equals("root>>exit...")){
                texto.appendText(acomodar(texto.getText()));
                
                //System.out.println("Cierro cmd");
                
                //Para la función de esta parte necesito ver todo el proyecto para orientar a que mate solo el cmd
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        user = "root>>";
        texto.setText(user);
        //System.out.println(leer(jaja));
    }    
    
}
