/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventapp.controllers;

import eventapp.DAO.EventoDAO;
import eventapp.DAO.ParticipaDAO;
import eventapp.excecoes.EventoExcecao;
import eventapp.models.Evento;
import eventapp.util.SceneManager;
import eventapp.util.Seguranca;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Gabriel_Note
 */
public class Controller_MyEvents implements Initializable {

    @FXML
    private TextField txNome;
    @FXML
    private DatePicker dpData;
    @FXML
    private Button btnPesqNome;
    @FXML
    private Button btnPesqData;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnDeletar;
    @FXML
    private Button btnVoltar;
    
    @FXML
    private TableView tvEvents;
        //Colunas do table View
        @FXML
        private TableColumn nome_evento;
        @FXML
        private TableColumn dataIni_evento;
        @FXML
        private TableColumn dataFim_evento;
        @FXML
        private TableColumn local_evento;
        @FXML
        private TableColumn responsavel_evento;
        @FXML
        private TableColumn descricao_evento;
        @FXML
        private TableColumn id_evento;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            SceneManager.getInstance().getPrimaryStage().setResizable(false);
            popularTela();
        } catch (Exception ex) {
            SceneManager.getInstance().alertMsg("ERRO", "Algo inesperado aconteceu", "Não foi possivel carregar os eventos", Alert.AlertType.ERROR);
        }
    }   
    
    public void setScene_Main(){
        SceneManager sm = SceneManager.getInstance();
        Scene cena = sm.loadScene("Scene_Main");
        //Inicia a cena de eventos (como primaria)
        sm.setPrimaryScene(cena);  
    }
    
    public void popularTela() throws EventoExcecao, Exception{
        EventoDAO evDao = new EventoDAO();
        ArrayList<Evento> lista = evDao.buscarMeusPorNome((int) Seguranca.getInstance().getUsuarioLogado().getId(), "");
//        for(Evento dado: lista){
//            dado.imprimeEvento();
//        }
        if (lista != null) {
            this.id_evento.setCellValueFactory(new PropertyValueFactory<>("id"));
            this.nome_evento.setCellValueFactory(new PropertyValueFactory<>("nome"));
            this.dataIni_evento.setCellValueFactory(new PropertyValueFactory<>("dataInicio"));
            this.dataFim_evento.setCellValueFactory(new PropertyValueFactory<>("dataFim"));
            this.descricao_evento.setCellValueFactory(new PropertyValueFactory<>("descricao"));
            this.local_evento.setCellValueFactory(new PropertyValueFactory<>("local"));
            this.responsavel_evento.setCellValueFactory(new PropertyValueFactory<>("idUsuario"));
            
            this.tvEvents.setItems(FXCollections.observableArrayList(lista));
        } else {
            SceneManager.getInstance().alertMsg("ERRO", "Algo inesperado aconteceu", "Não foi possivel carregar os eventos", Alert.AlertType.ERROR);
        }    
    }
    
    public void btnNotParticiparOnClick() throws Exception{
        ParticipaDAO partDao = new ParticipaDAO();
        Evento selected = (Evento) tvEvents.getSelectionModel().getSelectedItem();
//        selected.imprimeEvento();
        if (partDao.deletar((int)selected.getIdUsuario(), (int)selected.getId())) {
            SceneManager.getInstance().alertMsg("Sucesso", "Você deixou um evento", "Agora voce não esta mais participando do evento "+selected.getNome(), Alert.AlertType.INFORMATION);
            popularTela();
        } else {
            SceneManager.getInstance().alertMsg("ERRO", "Erro ao deixar evento", "Não foi possivel deixar de participar desse evento", Alert.AlertType.ERROR);
        }
    }
    
    public void btnDeletarOnClick() throws Exception{
        EventoDAO evDao = new EventoDAO();
        Evento selected = (Evento) tvEvents.getSelectionModel().getSelectedItem();
//        selected.imprimeEvento();
        if (evDao.deletar(selected)) {
            SceneManager.getInstance().alertMsg("Sucesso", "Remoção concluida", selected.getNome() + " deletado com sucesso", Alert.AlertType.INFORMATION);
            popularTela();
        } else {
            SceneManager.getInstance().alertMsg("ERRO", "Erro na remoção", "Não foi possivel deletar o evento", Alert.AlertType.ERROR);
        }
    }
    
    public void btnEditarOnCLick(){
        Evento selected = (Evento) tvEvents.getSelectionModel().getSelectedItem();
    }
}
