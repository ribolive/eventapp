package eventapp.controllers;

import eventapp.excecoes.ErroLoginException;
import eventapp.excecoes.sqlExcecao;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import eventapp.util.SceneManager;
import eventapp.util.Seguranca;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javafx.scene.control.Alert;

public class Controller_Login implements Initializable {

    @FXML
    private Button btnLogin;
    @FXML
    private Button btnRegister;
    @FXML
    private Button btnExit;
    @FXML
    private Label lbTeste;    
    @FXML
    private ImageView imgBackGround;  
    @FXML
    private TextField txUser;  
    @FXML
    private PasswordField txPass;  
    
    @FXML
    
    private void getSceneRegister() {
        SceneManager sm = SceneManager.getInstance();
        Scene cena = sm.loadScene("Scene_UserRegister");
        sm.setSecondaryScene(cena);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    public void logar() throws SQLException, ClassNotFoundException, NoSuchAlgorithmException, sqlExcecao, IOException{
        Seguranca chave = Seguranca.getInstance();
        try {
            chave.logar(this.txUser.getText(), this.txPass.getText());
            SceneManager sm = SceneManager.getInstance();
            Scene cena2 = sm.loadScene("Scene_Main");
            //Inicia a cena principal
            sm.setPrimaryScene(cena2);
        } catch(ErroLoginException ex) {
            SceneManager.getInstance().alertMsg("ERRO","Não foi possivel logar!",ex.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    public void sair(){
        boolean confirm = SceneManager.getInstance().alertMsg("Confirmação",
                                                              "Tem certeza que deseja sair?",
                                                              "Clique em cancelar para continuar no EventApp");
        if(confirm){
            SceneManager.getInstance().getPrimaryStage().close();
        }
    }
  
}
