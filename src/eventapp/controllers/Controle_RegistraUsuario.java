
package eventapp.controllers;

import eventapp.util.SceneManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import eventapp.DAO.UsuarioDAO;
import eventapp.models.Usuario;
import javafx.scene.control.PasswordField;

public class Controle_RegistraUsuario implements Initializable {

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
    private PasswordField txPass;
    @FXML
    private PasswordField txConfirmPass;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void cancelar(){
        boolean confirm = SceneManager.getInstance().alertMsg("Confirmação",
                                                              "Deseja cancelar o cadastro?",
                                                              "Clique em cancelar para continuar cadastrando");
        if(confirm){
            SceneManager.getInstance().getSecondaryStage().close();
        }
    }
    
    public void cadastrar() throws Exception{
        try{
            Usuario newUser = new Usuario(this.txName.getText(),
                                          this.txUser.getText(),
                                          this.txEmail.getText(),
                                          this.txPass.getText(),
                                          this.txConfirmPass.getText());
            UsuarioDAO userDAO = new UsuarioDAO();
            userDAO.insere(newUser);
            SceneManager.getInstance().alertMsg("Cadastro","Cadastrado!","permissão de autentificaçao concedida para "+this.txName.getText(), Alert.AlertType.INFORMATION);
            SceneManager.getInstance().getSecondaryStage().close();
        } catch (Exception e){
            SceneManager.getInstance().alertMsg("Erro","Erro ao cadastrar usuario!", e.getMessage(), Alert.AlertType.ERROR);
        }
        
    }
}
