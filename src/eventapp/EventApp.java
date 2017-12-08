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

public class EventApp extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        SceneManager sManager = SceneManager.getInstance();
        Scene cena = sManager.loadScene("Scene_Login");     
        if (cena != null) {
            sManager.getSecondaryStage().centerOnScreen();
//            sManager.getSecondaryStage().setResizable(true);
            sManager.setPrimaryScene(cena);
        }
    }
    
    /*### Participar de um evento ### */
    public static void main(String[] args) {
        launch(args);
    }
        
}