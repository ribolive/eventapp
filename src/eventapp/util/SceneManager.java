package eventapp.util;

import java.io.IOException;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.WindowEvent;

public class SceneManager {
    
    private static SceneManager instance;
    
    private Stage primaryStage;
    private Stage secondaryStage;
    
    public SceneManager(){
        primaryStage = new Stage();
        //primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/recursos/eta_icon.png")));
        
        secondaryStage = new Stage();
        //secondaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/recursos/eta_icon.png")));
        
        //Setando p/ que ao fechar o pai, iremos finalizar o filho(father = primary, sun = secondary)
        primaryStage.setOnCloseRequest((WindowEvent event) -> {
            secondaryStage.close();
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
            //System.out.println("URL: " + getClass().getResource("viewers/scenes/" + nomeCena + ".fxml"));
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
    
    public void alertMsg(String titulo, String conteudo, Alert.AlertType type){
        Alert info = new Alert(type);
        info.setTitle(titulo);
        info.setContentText(conteudo);
        info.showAndWait();
    }
}
