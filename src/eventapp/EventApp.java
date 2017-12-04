package eventapp;

import javafx.application.Application;
import javafx.scene.Scene;
//import javafx.scene.control.Alert;
import javafx.stage.Stage;
import eventapp.util.SceneManager;
import eventapp.util.Conn;
import eventapp.DAO.UsuarioDAO;
import eventapp.models.Usuario;

/**
 *
 * @author Gabriel_Note
 */
public class EventApp extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        SceneManager sManager = SceneManager.getInstance();
        Scene cena = sManager.loadScene("Scene_Login");
        if (cena != null) {
            sManager.setPrimaryScene(cena);
        }
    }

    public static void main(String[] args) {
        //launch(args);
        Conn con = new Conn();
        con.conectar();
        
        UsuarioDAO dao = new UsuarioDAO();
        

        try{
            Usuario usu = new Usuario(1,"João","jobel","jobel@bol.com.br","123","123");
            dao.insert(usu);
        } catch (Exception e){
            System.out.println(e);
        }
        
        System.out.println("djaoisdjoijasoidjoisjad");
        
        
        
        
        
    }
    
}
