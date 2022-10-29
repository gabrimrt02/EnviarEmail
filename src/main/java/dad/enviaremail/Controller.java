package dad.enviaremail;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Controller implements Initializable {

    // CONTROLLER
    private Model model = new Model();

    // VIEW

    // Gridpane
    @FXML private GridPane view;

    // textos
    @FXML private TextField nombreServidor;
    @FXML private TextField puertoServidor;
    @FXML private TextField emailRemitente;
    @FXML private TextField emailDestinatario;
    @FXML private TextField asuntoEmail;
    @FXML private TextArea mensajeEmail;

    // password
    @FXML private PasswordField passwordRemitente;

    // checkBox
    @FXML private CheckBox usaSSL;

    // buttons
    @FXML private Button enviarButton;
    @FXML private Button vaciarButton;
    @FXML private Button cerrarButton;

    // Constructor -> Inicializa el loader de XML
    public Controller() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/view.fxml"));
        loader.setController(this);
        loader.load();

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        // Bindings entre la vista y los campos del Model
        nombreServidor.textProperty().bindBidirectional(model.nombreServidorProperty());
        puertoServidor.textProperty().bindBidirectional(model.puertoServidorProperty());
        emailRemitente.textProperty().bindBidirectional(model.emailRemitenteProperty()); 
        emailDestinatario.textProperty().bindBidirectional(model.emailDestinatarioProperty());
        asuntoEmail.textProperty().bindBidirectional(model.asuntoEmailProperty());
        mensajeEmail.textProperty().bindBidirectional(model.mensajeEmailProperty());
        
        passwordRemitente.textProperty().bindBidirectional(model.passwordRemitenteProperty());

        usaSSL.selectedProperty().bindBidirectional(model.usaSSLProperty());

        // Funciones que realizan los botones

        cerrarButton.setOnAction(this::onCerrarAction);
        vaciarButton.setOnAction(this::onVaciarAction);
        enviarButton.setOnAction(this::onEnviarAction);

    }

    public GridPane getView() {
        return view;
    }

    private void onCerrarAction(ActionEvent e) {

        Stage stage = App.primaryStage;
        stage.close();

    }

    private void onVaciarAction(ActionEvent e) {
        
        TextField[] textos = {
            nombreServidor, puertoServidor, emailRemitente,
            emailDestinatario, asuntoEmail
        };

        for(TextField texto : textos) {
            texto.textProperty().set("");
        }

        mensajeEmail.textProperty().set("");

        passwordRemitente.textProperty().set("");

        usaSSL.selectedProperty().set(false);

    }

    private void onEnviarAction(ActionEvent e) {
        
        Email email = new SimpleEmail();

        try {
            email.setHostName(model.getNombreServidor());
            email.setSmtpPort(Integer.parseInt(model.getPuertoServidor()));
            email.setAuthenticator(new DefaultAuthenticator(model.getEmailRemitente(), model.getPasswordRemitente()));
            email.setSSLOnConnect(model.getUsaSSL());
            email.setFrom(model.getEmailRemitente());
            email.setSubject(model.getAsuntoEmail());
            email.setMsg(model.getMensajeEmail());
            email.addTo(model.getEmailDestinatario());
            email.send();
        } catch (NumberFormatException | EmailException e1) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No se pudo enviar el email");
            alert.setContentText(e1.getMessage());
            alert.showAndWait();
        }

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Mensaje enviado");
        alert.setHeaderText("Mensaje enviado con exito a '" + model.getEmailDestinatario() + "'");
        alert.showAndWait();

    }

}
