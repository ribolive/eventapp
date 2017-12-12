/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventapp.controllers;

import eventapp.models.Usuario;
import eventapp.util.SceneManager;
import eventapp.util.Seguranca;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Gabriel_Note
 */
public class Controller_eventRegister implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SceneManager.getInstance().getPrimaryStage().setResizable(false);
    }    
    
    public void btnCadastrarClick(){
        Usuario userLogado = Seguranca.getInstance().getUsuarioLogado();
        userLogado.imprimeUsuario();
    }
}
