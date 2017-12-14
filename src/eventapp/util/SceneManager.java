package eventapp.util;

import java.io.IOException;
import java.util.Optional;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class SceneManager {
    
    private static SceneManager instance;

    public static Object getInstace() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private Stage primaryStage;
    private Stage secondaryStage;
    
    public SceneManager(){
        primaryStage = new Stage();
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();              
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/eventapp/recursos/eta_icon200.png")));
        
        secondaryStage = new Stage();
        secondaryStage.setResizable(false);
        secondaryStage.centerOnScreen();   
        secondaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/eventapp/recursos/eta_icon200.png")));
        
        //Setando p/ que ao fechar o pai, iremos finalizar o filho(father = primary, sun = secondary)
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                boolean confirm = SceneManager.getInstance().alertMsg("Confirmação",
                                                              "Deseja fechar o EventApp",
                                                              "Clique em cancelar para continuar no sistema");
                if(confirm){
                    secondaryStage.close();
                } else {
                    event.consume();
                }
            }               
        });
        
        secondaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                boolean confirm = SceneManager.getInstance().alertMsg("Confirmação",
                                                              "Realmente deseja fechar",
                                                              "Clique em cancelar para continuar");
                if(confirm){
                    secondaryStage.close();
                } else {
                    event.consume();
                }
            }               
        });
    }
    
    /* Caso ja tenha uma instancia criada, nao criamos outra
       Mas sim retornamos a ja criada, estando ela na primaryStage ou na SecondaryStage */
    public static SceneManager getInstance(){
        if(instance == null){
            instance = new SceneManager();
        }
        return instance;
    }
    
    public FXMLLoader loadFXML(String nomeCena) {
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(getClass().getResource("/eventapp/viewers/scenes/" + nomeCena + ".fxml"));
            loader.load();  
        } catch (IOException e) {
            System.err.println("Erro ao carregar cena ( " + nomeCena + " )");
            System.err.println("Erro: " + e.getLocalizedMessage());
            return null;
        }
        return loader;
    }
    
    public Scene loadScene(String nomeCena){
        Parent fxml = loadFXML(nomeCena).getRoot();
        if (fxml != null){
            return new Scene(fxml);
        }
        return null;
    }
    
    // Cena primaria (pai) - Get and sets - 
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
    public void setPrimaryScene(Scene cena) {
        this.primaryStage.setScene(cena);
        primaryStage.show();
    }
    
    // Cena secundaria (filho) - Get and sets - 
    public Stage getSecondaryStage() {
        return secondaryStage;
    }
    
    public void setSecondaryScene(Scene cena) {
        this.secondaryStage.setScene(cena);
        secondaryStage.show();
    }
    
    // Set stage de inicio
    public void setPrimaryStage(Stage primaryStage){
        this.primaryStage = primaryStage;
    }
    
    public void alertMsg(String titulo,String header, String conteudo, Alert.AlertType type){
        Alert info = new Alert(type);
        info.setTitle(titulo);
        info.setHeaderText(header);
        info.setContentText(conteudo);
        
        //Pegando o stage da tela
        Stage stage = (Stage) info.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(this.getClass().getResource("/eventapp/recursos/eta_icon64.png").toString()));
                                                                 
        info.showAndWait();
    }
    
    public boolean alertMsg(String titulo, String header, String conteudo){
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(conteudo);
        
        //Pegando o stage da tela & setando um icone a tela
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(this.getClass().getResource("/eventapp/recursos/eta_icon64.png").toString()));

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            return true;
        } else {
            return false;
        }
    }
}
