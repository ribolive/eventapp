package eventapp;

import javafx.application.Application;
import javafx.scene.Scene;
//import javafx.scene.control.Alert;
import javafx.stage.Stage;
import eventapp.util.SceneManager;
import eventapp.util.Conn;
import eventapp.util.Seguranca;
import eventapp.DAO.UsuarioDAO;
import eventapp.DAO.EventoDAO;
import eventapp.DAO.ParticipaDAO;
import eventapp.models.Usuario;
import eventapp.models.Evento;
import eventapp.models.Participa;
import java.util.ArrayList;

public class EventApp extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        SceneManager sManager = SceneManager.getInstance();
        Scene cena = sManager.loadScene("Scene_Login");
        if (cena != null) {
            sManager.setPrimaryScene(cena);
        }
    }
    
    /*### Participar de um evento ### */
    public static void main(String[] args) {
        
        Conn con = new Conn();
        con.conectar();
        
//        Participa part = new Participa(2,1);
        ParticipaDAO daoParticipa = new ParticipaDAO();
        ArrayList<Evento> eventos = new ArrayList();
        eventos = daoParticipa.listaEventosParticipante(1);
        for (Evento evento : eventos){
            evento.imprimeEvento();
        }
        
        

//        daoParticipa.insere(part); 
//        
//        daoParticipa.insereAvaliacao(2, 1, 1);
//        daoParticipa.insereComentario(2, 1, "Esse evento tá uma porra")

    }
        
}