package dad.enviaremail;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {

    /* DECLARACIÓN DE LOS DATOS */
    
    // Datos del servidor al que se conecta
    private StringProperty nombreServidor = new SimpleStringProperty();
    private StringProperty puertoServidor = new SimpleStringProperty();

    // Usa o no conexión SSL
    private BooleanProperty usaSSL = new SimpleBooleanProperty();

    // Datos del remitente
    private StringProperty emailRemitente = new SimpleStringProperty();
    private StringProperty passwordRemitente = new SimpleStringProperty();

    // Datos Destinatario
    private StringProperty emailDestinatario = new SimpleStringProperty();

    // Datos asunto
    private StringProperty asuntoEmail = new SimpleStringProperty();

    // Texto del mensaje
    private StringProperty mensajeEmail = new SimpleStringProperty();

    //////////////////////////////////////////////////////////////////////////

    /* GETTERS DE LAS PROPERTIES */

    public StringProperty nombreServidorProperty() {
        return nombreServidor;
    }

    public StringProperty puertoServidorProperty() {
        return puertoServidor;
    }

    public StringProperty emailRemitenteProperty() {
        return emailRemitente;
    }

    public StringProperty passwordRemitenteProperty() {
        return passwordRemitente;
    }

    public StringProperty emailDestinatarioProperty() {
        return emailDestinatario;
    }

    public StringProperty asuntoEmailProperty() {
        return asuntoEmail;
    }

    public StringProperty mensajeEmailProperty() {
        return mensajeEmail;
    }

    public BooleanProperty usaSSLProperty() {
        return usaSSL;
    }

    //////////////////////////////////////////////////////////////////////////

    /* GETTERS Y SETTERS DE LOS VALORES DE LAS PROPERTIES */

    // nombreServidor
    public void setNombreServidor(String nombre) {
        nombreServidor.set(nombre);
    }

    public String getNombreServidor() {
        return nombreServidor.get();
    }

    // puertoServidor
    public void setPuertoServidor(String nombre) {
        puertoServidor.set(nombre);
    }

    public String getPuertoServidor() {
        return puertoServidor.get();
    }

    // emailRemitente
    public void setEmailRemitente(String nombre) {
        emailRemitente.set(nombre);
    }

    public String getEmailRemitente() {
        return emailRemitente.get();
    }

    // passwordRemitente
    public void setPasswordRemitente(String nombre) {
        passwordRemitente.set(nombre);
    }

    public String getPasswordRemitente() {
        return passwordRemitente.get();
    }

    // emailDestinatario
    public void setEmailDestinatario(String nombre) {
        emailDestinatario.set(nombre);
    }

    public String getEmailDestinatario() {
        return emailDestinatario.get();
    }

    // asuntoEmail
    public void setAsuntoEmail(String nombre) {
        asuntoEmail.set(nombre);
    }

    public String getAsuntoEmail() {
        return asuntoEmail.get();
    }

    // mensajeEmail
    public void setMensajeEmail(String nombre) {
        mensajeEmail.set(nombre);
    }

    public String getMensajeEmail() {
        return mensajeEmail.get();
    }

    // usaSSL
    public void setUsaSSL(boolean opcion) {
        usaSSL.set(opcion);
    }

    public Boolean getUsaSSL() {
        return usaSSL.get();
    }

}
