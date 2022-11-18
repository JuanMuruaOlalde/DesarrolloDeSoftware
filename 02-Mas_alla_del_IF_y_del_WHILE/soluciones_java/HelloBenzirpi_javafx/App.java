package es.susosise.ejerciciosJava;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class App extends Application {
    
    
    public static void main(String[] args) {
        launch(args); // esto llama a start(...)
    }
   

    @Override
    public void start(Stage primaryStage) {
        
        try {
            java.net.URL location = getClass().getResource("HelloBenzirpi.fxml");
            Parent pantallaPrincipal = FXMLLoader.load(location);
            Scene scene = new Scene(pantallaPrincipal);
            primaryStage.setScene(scene);
            primaryStage.setTitle("ejerciciosJava");
            primaryStage.show();
        } catch(Exception ex) {
            Alert avisos = new Alert(AlertType.ERROR);
            avisos.setTitle("Error al crear la pantalla principal.");
            avisos.setContentText(ex.getMessage());
            avisos.showAndWait().ifPresent( respuesta -> { 
                if (respuesta == ButtonType.OK) { 
                    Platform.exit(); 
                }
            } );
        }
        
    }

 
}
