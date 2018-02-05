/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventapp.controllers;

import eventapp.DAO.EventoDAO;
import eventapp.models.Evento;
import eventapp.util.SceneManager;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Gabriel_Note
 */
public class Controle_EditaEvento implements Initializable {

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
    @FXML
    private Button btnEditar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        preencheTela();
    }    
    
    public void preencheTela(){
        SceneManager.getInstance().getPrimaryStage().setResizable(false);
        Evento evAtual = Controle_singletonEdicaoEvento.getInstance().getObjEvento();
        txNome.setText(evAtual.getNome());
        txLocal.setText(evAtual.getLocal());
        dpDataIni.setValue(LocalDate.parse(evAtual.getDataInicio().toString()));
        dpDataFim.setValue(LocalDate.parse(evAtual.getDataFim().toString()));
        txDescricao.setText(evAtual.getDescricao());
    }
    
    public void btnCancelarOnClick(){
        boolean confirm = SceneManager.getInstance().alertMsg("Confirmação",
                                                              "Deseja cancelar o cadastro?",
                                                              "Clique em cancelar para continuar cadastrando");
        if(confirm){
            SceneManager.getInstance().getSecondaryStage().close();
        }
    }
    
    public void btnEditarOnClick(){        
        Evento evAtual = Controle_singletonEdicaoEvento.getInstance().getObjEvento();
        try{        
            Evento newEvent = new Evento(   evAtual.getId(),
                                            this.txNome.getText(),
                                            this.txDescricao.getText(),
                                            java.sql.Date.valueOf(this.dpDataIni.getValue()),
                                            java.sql.Date.valueOf(this.dpDataFim.getValue()),
                                            evAtual.getIdUsuario(),
                                            this.txLocal.getText());
            EventoDAO eventDAO = new EventoDAO();
            eventDAO.atualizar(newEvent);
            SceneManager.getInstance().alertMsg("Editor","Editado com Sucesso!","Evento editado com sucesso", Alert.AlertType.INFORMATION);
            SceneManager.getInstance().getSecondaryStage().close();
        } catch (Exception e){
            SceneManager.getInstance().alertMsg("Erro","Erro ao Editar Eveto!", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
}
