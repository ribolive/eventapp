/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventapp.controllers;

import eventapp.DAO.EventoDAO;
import eventapp.excecoes.EventoExcecao;
import eventapp.models.Evento;
import eventapp.util.SceneManager;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
public class Controller_Events implements Initializable {

    @FXML
    private TextField txNome;
    @FXML
    private DatePicker dpData;
    @FXML
    private Button btnPesqNome;
    @FXML
    private Button btnPesqData;
    @FXML
    private Button btnCadastrar;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnExcluir;
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
        // TODO
    }    
    
    public void setScene_Main(){
        SceneManager sm = SceneManager.getInstance();
        Scene cena = sm.loadScene("Scene_Main");
        //Inicia a cena de eventos (como primaria)
        sm.setPrimaryScene(cena);  
    }
    
    public void buscarEventosPorData() throws Exception{
        //  estabelecendo um formato para data a ser passada ao banco
//        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateFormat df = new SimpleDateFormat ("yyyy-MM-dd");
        //  convertendo data String para o tipo do banco de dados
        String strData = dpData.getValue().toString();
        java.sql.Date data = new java.sql.Date(df.parse(strData).getTime());
        
        //  puxando dados para construção da tabela
        EventoDAO evDao = new EventoDAO();
        ArrayList<Evento> lista = evDao.buscarPorData(data);
        if (lista != null) {
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
        EventoDAO evDao = new EventoDAO();
        ArrayList<Evento> lista = evDao.buscarPorNome(txNome.getText());
        if (lista != null) {
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
}
