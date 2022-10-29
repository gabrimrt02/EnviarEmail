package dad.enviaremail;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application{
    
    private Controller controller;
    static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        App.primaryStage = primaryStage;

        controller = new Controller();

        primaryStage.setTitle("Enviar email");
        primaryStage.setScene(new Scene(controller.getView()));
        primaryStage.getIcons().add(new Image(App.class.getResourceAsStream("/images/email-send-icon-32x32.png")));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
