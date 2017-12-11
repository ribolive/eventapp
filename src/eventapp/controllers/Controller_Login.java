package eventapp.controllers;

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
        //sm.getPrimaryStage().setMaximized(true);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void logar(){
        Seguranca chave = new Seguranca();
        if(chave.logar(this.txUser.getText(), this.txPass.getText())){
            SceneManager sm = SceneManager.getInstance();
            Scene cena2 = sm.loadScene("Scene_Main");
            sm.getPrimaryStage().centerOnScreen();
            sm.getPrimaryStage().setResizable(true);
            //Inicia a cena principal
            sm.setPrimaryScene(cena2);
            
        } else {
            SceneManager.getInstance().alertMsg("ERRO","Não foi possivel logar!","Usuario ou senha incorretos", Alert.AlertType.ERROR);
        }
    }
    
    public void sair(){
        boolean confirm = SceneManager.getInstance().alertMsg("Confirmação",
                                                              "Tem certeza que deseja sair?",
                                                              "Clique em cancelar para continuar no EventApp");
        if(confirm){
            SceneManager.getInstance().getSecondaryStage().close();
        }
    }
  
}
