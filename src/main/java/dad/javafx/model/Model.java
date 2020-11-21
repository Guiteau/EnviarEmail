package dad.javafx.model;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {
	
	StringProperty ipServidor = new SimpleStringProperty();
	StringProperty puerto = new SimpleStringProperty();
	StringProperty password = new SimpleStringProperty();
	StringProperty emailRemitente = new SimpleStringProperty();
	StringProperty emailDestinatario = new SimpleStringProperty();
	StringProperty asuntoMensaje = new SimpleStringProperty();
	StringProperty mensaje = new SimpleStringProperty();
	BooleanProperty conexionSSL = new SimpleBooleanProperty();
	ObjectProperty<Email> email = new SimpleObjectProperty<>(new SimpleEmail());
	
	
	public final StringProperty ipServidorProperty() {
		return this.ipServidor;
	}
	
	public final String getIpServidor() {
		return this.ipServidorProperty().get();
	}
	
	public final void setIpServidor(final String ipServidor) {
		this.ipServidorProperty().set(ipServidor);
	}
	
	public final StringProperty puertoProperty() {
		return this.puerto;
	}
	
	public final String getPuerto() {
		return this.puertoProperty().get();
	}
	
	public final void setPuerto(final String puerto) {
		this.puertoProperty().set(puerto);
	}
	
	public final StringProperty passwordProperty() {
		return this.password;
	}
	
	public final String getPassword() {
		return this.passwordProperty().get();
	}
	
	public final void setPassword(final String password) {
		this.passwordProperty().set(password);
	}
	
	public final StringProperty emailRemitenteProperty() {
		return this.emailRemitente;
	}
	
	public final String getEmailRemitente() {
		return this.emailRemitenteProperty().get();
	}
	
	public final void setEmailRemitente(final String emailRemitente) {
		this.emailRemitenteProperty().set(emailRemitente);
	}
	
	public final StringProperty emailDestinatarioProperty() {
		return this.emailDestinatario;
	}
	
	public final String getEmailDestinatario() {
		return this.emailDestinatarioProperty().get();
	}
	
	public final void setEmailDestinatario(final String emailDestinatario) {
		this.emailDestinatarioProperty().set(emailDestinatario);
	}
	
	public final StringProperty asuntoMensajeProperty() {
		return this.asuntoMensaje;
	}
	
	public final String getAsuntoMensaje() {
		return this.asuntoMensajeProperty().get();
	}
	
	public final void setAsuntoMensaje(final String asuntoMensaje) {
		this.asuntoMensajeProperty().set(asuntoMensaje);
	}
	
	public final StringProperty mensajeProperty() {
		return this.mensaje;
	}
	
	public final String getMensaje() {
		return this.mensajeProperty().get();
	}
	
	public final void setMensaje(final String mensaje) {
		this.mensajeProperty().set(mensaje);
	}
	
	public final BooleanProperty conexionSSLProperty() {
		return this.conexionSSL;
	}
	
	public final boolean isConexionSSL() {
		return this.conexionSSLProperty().get();
	}
	
	public final void setConexionSSL(final boolean conexionSSL) {
		this.conexionSSLProperty().set(conexionSSL);
	}

	public final ObjectProperty<Email> emailProperty() {
		return this.email;
	}
	

	public final Email getEmail() {
		return this.emailProperty().get();
	}
	

	public final void setEmail(final Email email) {
		this.emailProperty().set(email);
	}
	


}
