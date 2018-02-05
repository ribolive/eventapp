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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
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
public class Controle_MeusEventos implements Initializable {

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
    private Button btnAtualiza;
    
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
            SceneManager.getInstance().getPrimaryStage().setResizable(true);
            SceneManager.getInstance().getPrimaryStage().centerOnScreen();
            popularTela();
        } catch (Exception ex) {
            SceneManager.getInstance().alertMsg("ERRO", "Algo inesperado aconteceu", "Não foi possivel carregar os eventos \n Erro:" + ex.getMessage(), Alert.AlertType.ERROR);
        }
    }   
    
    public void setScene_Main(){
        SceneManager sm = SceneManager.getInstance();
        Scene cena = sm.loadScene("Cena_Entrada");
        //Inicia a cena de eventos (como primaria)
        sm.setPrimaryScene(cena);  
    }
    
    public void popularTela() throws EventoExcecao, Exception{
        EventoDAO evDao = new EventoDAO();
        ArrayList<Evento> lista = evDao.buscarMeusPorNome((int) Seguranca.getInstance().getUsuarioLogado().getId(), "");
//        for(Evento dado: lista){
//            dado.imprimeEvento();
//        }
        this.id_evento.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.nome_evento.setCellValueFactory(new PropertyValueFactory<>("nome"));
        this.dataIni_evento.setCellValueFactory(new PropertyValueFactory<>("dataInicio"));
        this.dataFim_evento.setCellValueFactory(new PropertyValueFactory<>("dataFim"));
        this.descricao_evento.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        this.local_evento.setCellValueFactory(new PropertyValueFactory<>("local"));
        this.responsavel_evento.setCellValueFactory(new PropertyValueFactory<>("idUsuario"));

        this.tvEvents.setItems(FXCollections.observableArrayList(lista));
    }
    
    public void btnNotParticiparOnClick() throws SQLException, ClassNotFoundException, Exception{
        Evento selected = (Evento) tvEvents.getSelectionModel().getSelectedItem();
        try {
            if(selected != null){
                ParticipaDAO partDao = new ParticipaDAO();
                partDao.deletar((int)selected.getIdUsuario(), (int)selected.getId());
                SceneManager.getInstance().alertMsg("Sucesso", "Você deixou um evento", "Agora voce não esta mais participando do evento "+selected.getNome(), Alert.AlertType.INFORMATION);
                popularTela();
            } else {
                SceneManager.getInstance().alertMsg("ERRO", "Não foi possivel participar", "Verifique se um evento foi selecionado", Alert.AlertType.ERROR);
            }             
        } catch (Exception e){
            SceneManager.getInstance().alertMsg("ERRO", "Erro ao deixar evento", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    public void btnDeletarOnClick() throws Exception{
        Evento selected = (Evento) tvEvents.getSelectionModel().getSelectedItem();
        int id = selected.getId();
        try{
            if(selected != null){
                boolean confirm = SceneManager.getInstance().alertMsg("Confirmação",
                                                                      "Ao deletar o evento, todas informações dele serão perdidas...",
                                                                      "Deseja mesmo deletar o evento?");
                if(confirm){
                    EventoDAO evDao = new EventoDAO();
                    ParticipaDAO partDao = new ParticipaDAO();
                    partDao.deletar(id);
                    evDao.deletar(selected);
                    SceneManager.getInstance().alertMsg("Sucesso", "Remoção concluida", selected.getNome() + " deletado com sucesso", Alert.AlertType.INFORMATION);
                    popularTela();
                }
            } else {
                SceneManager.getInstance().alertMsg("ERRO", "Não foi possivel deletar o evento", "Verifique se um evento foi selecionado", Alert.AlertType.ERROR);
            }
        } catch (Exception e) {
            SceneManager.getInstance().alertMsg("ERRO", "Não foi possivel deletar o evento", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    public void btnEditarOnCLick() throws Exception{
        Evento selected = (Evento) tvEvents.getSelectionModel().getSelectedItem();
        try {
            if (selected != null) {
                Controle_singletonEdicaoEvento.getInstance().setObjEvento(selected);
                SceneManager sm = SceneManager.getInstance();
                Scene cena = sm.loadScene("Cena_EditaEvento");
                //Inicia a cena de eventos (como primaria)
                sm.setSecondaryScene(cena);
            } else {
                SceneManager.getInstance().alertMsg("ERRO", "Não foi possivel editar o evento", "Verifique se um evento foi selecionado", Alert.AlertType.ERROR);
            }
        } catch (Exception e) {
            SceneManager.getInstance().alertMsg("ERRO", "Não foi possivel editar o evento", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    public void btnVerOnCLick() throws Exception{
        Evento selected = (Evento) tvEvents.getSelectionModel().getSelectedItem();
        try {
            if (selected != null) {
                Controle_singletonEdicaoEvento.getInstance().setObjEvento(selected);
                SceneManager sm = SceneManager.getInstance();
                Scene cena = sm.loadScene("Cena_VisualizarEvento");
                //Inicia a cena de eventos (como primaria)
                sm.setSecondaryScene(cena);
            } else {
                SceneManager.getInstance().alertMsg("ERRO", "Não foi possivel editar o evento", "Verifique se um evento foi selecionado", Alert.AlertType.ERROR);
            }
        } catch (Exception e) {
            SceneManager.getInstance().alertMsg("ERRO", "Não foi possivel editar o evento", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    public void btnAtualizaOnClick() throws Exception{
        popularTela();
    }
    
    public void buscarEventosPorData() throws Exception{
        java.sql.Date data;
        if (dpData.getValue() != null) {         
            //  puxando dados para construção da tabela
            data = java.sql.Date.valueOf(dpData.getValue());
        } else {
            data = null;
        }
        EventoDAO evDao = new EventoDAO();
        int idUs = (int) Seguranca.getInstance().getUsuarioLogado().getId();
        ArrayList<Evento> lista = evDao.buscarMeusPorData(idUs, data);
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
    
    public void buscarEventosPorNome() throws EventoExcecao, Exception{
        try{
            EventoDAO evDao = new EventoDAO();
            ArrayList<Evento> lista = evDao.buscarMeusPorNome((int) Seguranca.getInstance().getUsuarioLogado().getId(), txNome.getText());
            this.id_evento.setCellValueFactory(new PropertyValueFactory<>("id"));
            this.nome_evento.setCellValueFactory(new PropertyValueFactory<>("nome"));
            this.dataIni_evento.setCellValueFactory(new PropertyValueFactory<>("dataInicio"));
            this.dataFim_evento.setCellValueFactory(new PropertyValueFactory<>("dataFim"));
            this.descricao_evento.setCellValueFactory(new PropertyValueFactory<>("descricao"));
            this.local_evento.setCellValueFactory(new PropertyValueFactory<>("local"));
            this.responsavel_evento.setCellValueFactory(new PropertyValueFactory<>("idUsuario"));

            this.tvEvents.setItems(FXCollections.observableArrayList(lista));
        }catch(Exception e){
            SceneManager.getInstance().alertMsg("ERRO", "Algo inesperado aconteceu", "Não foi possivel carregar os eventos", Alert.AlertType.ERROR);
        }
    }
}
