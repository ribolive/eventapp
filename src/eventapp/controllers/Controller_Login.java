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
//import util.SceneManager;

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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
