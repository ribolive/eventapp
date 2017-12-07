
package eventapp.controllers;

import eventapp.util.SceneManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller_UserRegister implements Initializable {

    @FXML
    private Button btnCancelar;   
    @FXML
    private Button btnRegistra;    
    @FXML
    private TextField txName;
    @FXML
    private TextField txUser;
    @FXML
    private TextField txEmail;
    @FXML
    private TextField txPass;
    @FXML
    private TextField txConfirmPass;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void cancelar(){
        boolean confirm = SceneManager.getInstance().alertMsg("Confirmação",
                                                              "Deseja mesmo cancelar o cadastro?",
                                                              "Clique em cancelar para continuar cadastrando",
                                                              Alert.AlertType.CONFIRMATION);
        if(confirm){
            SceneManager.getInstance().getSecondaryStage().close();
        }
    }
}
