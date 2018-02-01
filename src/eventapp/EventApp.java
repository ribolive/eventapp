package eventapp;

import javafx.application.Application;
import javafx.scene.Scene;
//import javafx.scene.control.Alert;
import javafx.stage.Stage;
import eventapp.util.SceneManager;
//import eventapp.util.Conn;
//import eventapp.util.Seguranca;
//import eventapp.DAO.UsuarioDAO;
//import eventapp.DAO.EventoDAO;
//import eventapp.DAO.ParticipaDAO;
//import eventapp.models.Usuario;
//import eventapp.models.Evento;
//import eventapp.models.Participa;
//import java.util.ArrayList;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
 
//import eventapp.org.json.JSONArray;
//import eventapp.org.json.JSONObject;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.IOUtils;

public class EventApp extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Scene cena = SceneManager.getInstance().loadScene("Cena_Login");     
        if (cena != null) {
            SceneManager.getInstance().getPrimaryStage().centerOnScreen();
            SceneManager.getInstance().getPrimaryStage().setResizable(true);
            SceneManager.getInstance().setPrimaryScene(cena);
        }
    }
    
    /*### Participar de um evento ### */
    public static void main(String[] args) {
        launch(args);
    }
        
}