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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Gabriel_Note
 */
public class Controle_Entrada implements Initializable {

    @FXML
    private Button btnEvents;
    @FXML
    private Button btnMyEvents;
    @FXML
    private Button btnAbout;
    @FXML
    private Button btnQuit;
    
    @FXML
    private TableView tableViewEvents;
        //Colunas do table view
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
        SceneManager.getInstance().getPrimaryStage().setResizable(true);
        SceneManager.getInstance().getPrimaryStage().centerOnScreen();
        try {
            buscarEventosDaSemana();
        } catch (ParseException ex) {
            Logger.getLogger(Controle_Entrada.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Controle_Entrada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
 
    public void buscarEventosDaSemana() throws ParseException, Exception{
        //estabelecendo um formato para data a ser passada ao banco
        DateFormat df = new SimpleDateFormat ("yyyy-MM-dd");
        
        //capturando o inicio e o fim da semana
        Calendar cal = Calendar.getInstance();
        String dataStr = df.format(cal.getTime());
        //convertendo data String para o tipo do banco de dados
        java.sql.Date data = new java.sql.Date(df.parse(dataStr).getTime());
        
        //puxando dados para construção da tabela
        EventoDAO evDao = new EventoDAO();
        ArrayList<Evento> lista = evDao.buscarPorData(data);
        
        this.id_evento.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.nome_evento.setCellValueFactory(new PropertyValueFactory<>("nome"));
        this.dataIni_evento.setCellValueFactory(new PropertyValueFactory<>("dataInicio"));
        this.dataFim_evento.setCellValueFactory(new PropertyValueFactory<>("dataFim"));
        this.descricao_evento.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        this.local_evento.setCellValueFactory(new PropertyValueFactory<>("local"));
        this.responsavel_evento.setCellValueFactory(new PropertyValueFactory<>("idUsuario"));

        this.tableViewEvents.setItems(FXCollections.observableArrayList(lista));

    }
    
    public void setScene_Events(){
        SceneManager sm = SceneManager.getInstance();
        Scene cena = sm.loadScene("Cena_Eventos");
        //Inicia a cena de eventos (como primaria)
        sm.setPrimaryScene(cena);   
    }
    
    public void setScene_MyEvents(){
        SceneManager sm = SceneManager.getInstance();
        Scene cena = sm.loadScene("Cena_MeusEventos");
        //Inicia a cena de eventos (como primaria)
        sm.setPrimaryScene(cena);   
    }
    
    public void deslogar(){
        boolean confirm = SceneManager.getInstance().alertMsg("Confirmação",
                                                              "Tem certeza que deseja sair?",
                                                              "Clique em cancelar para continuar no EventApp");
        if(confirm){
            //SceneManager.getInstance().getPrimaryStage().close();
            //Voltando a tela de login
            SceneManager sManager = SceneManager.getInstance();
            Scene cena = sManager.loadScene("Cena_Login");
            if (cena != null) {
                sManager.getSecondaryStage().centerOnScreen();
//                sManager.getSecondaryStage().setResizable(true);
                sManager.setPrimaryScene(cena);
            }
        }
    }}
    