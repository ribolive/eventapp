/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventapp.controllers;

import eventapp.DAO.EventoDAO;
import eventapp.models.Evento;
import eventapp.models.Usuario;
import eventapp.util.SceneManager;
import eventapp.util.Seguranca;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Gabriel_Note
 */
public class Controller_eventRegister implements Initializable {

    
    @FXML
    private TextField txNome;
    @FXML
    private TextField txLocal;
    @FXML
    private DatePicker dpDataIni;
    @FXML
    private DatePicker dpDataFim;
    @FXML
    private TextArea txDescricao;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SceneManager.getInstance().getPrimaryStage().setResizable(false);
    }    
    
    public void btnCadastrarClick(){
        try{
            Usuario userLogado = Seguranca.getInstance().getUsuarioLogado();
    //        System.out.println(userLogado.getId());   Retorna o ide do usuario logado

            Evento newEvent = new Evento(   this.txNome.getText(),
                                            this.txDescricao.getText(),
                                            java.sql.Date.valueOf(this.dpDataIni.getValue()),
                                            java.sql.Date.valueOf(this.dpDataFim.getValue()),
                                            (int) userLogado.getId(),
                                            this.txLocal.getText());
            
            EventoDAO eventDAO = new EventoDAO();
            eventDAO.insere(newEvent);
            SceneManager.getInstance().alertMsg("Cadastro","Cadastrado!","Evento cadastrado com sucesso, gerente do Evento: "+userLogado.getNome(), Alert.AlertType.INFORMATION);
            SceneManager.getInstance().getSecondaryStage().close();
        } catch (Exception e){
            SceneManager.getInstance().alertMsg("Erro","Erro ao cadastrar Eveto!", e.getMessage(), Alert.AlertType.ERROR);
        }   
    }
    
    public void btnCancelarOnClick(){
        boolean confirm = SceneManager.getInstance().alertMsg("Confirmação",
                                                              "Deseja cancelar o cadastro?",
                                                              "Clique em cancelar para continuar cadastrando");
        if(confirm){
            SceneManager.getInstance().getSecondaryStage().close();
        }
    }
}
