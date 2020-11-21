package dad.javafx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;

import dad.javafx.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Controller implements Initializable{
	
	private Model modelo = new Model();
	
	private Alert alert;

    @FXML
    private GridPane view;

    @FXML
    private Button button_enviar;

    @FXML
    private Button button_vaciar;

    @FXML
    private Button button_cerrar;

    @FXML
    private TextArea textArea;

    @FXML
    private CheckBox checkBox;

    @FXML
    private TextField textField_ip;

    @FXML
    private TextField textField_email_remitente;

    @FXML
    private PasswordField passwordField;

	@FXML
    private TextField textField_email_destinatario;

    @FXML
    private TextField textField_asunto;

    @FXML
    private TextField textField_puerto;

    
    public Controller() throws IOException{
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
		loader.setController(this);
		loader.load();
		
		modelo.ipServidorProperty().bind(textField_ip.textProperty());
		modelo.puertoProperty().bind(textField_puerto.textProperty());
		modelo.conexionSSLProperty().bind(checkBox.selectedProperty());
		modelo.emailRemitenteProperty().bind(textField_email_remitente.textProperty());
		modelo.passwordProperty().bind(passwordField.textProperty());
		modelo.emailDestinatarioProperty().bind(textField_email_destinatario.textProperty());
		modelo.asuntoMensajeProperty().bind(textField_asunto.textProperty());
		modelo.mensajeProperty().bind(textArea.textProperty());
		
		
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
	}

    @FXML
    void button_enviar(ActionEvent event) {
    	
    	ButtonType button_aceptar = new ButtonType("Aceptar");
    	Stage stage;
    	
		if(modelo.getEmailDestinatario().matches("") | modelo.getEmailRemitente().matches("") | modelo.getIpServidor().matches("") | modelo.getPassword().matches("")
				| modelo.getPuerto().matches("") | modelo.getAsuntoMensaje().matches("")) {
			
			alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Faltan datos");
			alert.setHeaderText(null);
			alert.setContentText("No pueden quedar campos de escritura vacíos");
			
			stage = (Stage) alert.getDialogPane().getScene().getWindow();
	    	stage.getIcons().add(new Image("email-send-icon-32x32.png"));
			
			stage.showAndWait();
			
		}else {
			
		
			modelo.getEmail().setHostName(modelo.getIpServidor());
			modelo.getEmail().setSmtpPort(Integer.parseInt(modelo.getPuerto()));
			modelo.getEmail().setAuthenticator(new DefaultAuthenticator("", modelo.getPassword()));		
			modelo.getEmail().setSSLOnConnect(modelo.isConexionSSL());
			modelo.getEmail().setSubject(modelo.getAsuntoMensaje());
			
			try {
				modelo.getEmail().setFrom(modelo.getEmailRemitente());
				modelo.getEmail().setMsg(modelo.getMensaje());
				modelo.getEmail().addTo(modelo.getEmailDestinatario());	
					
				modelo.getEmail().send();
							
		    	alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Mensaje enviado");
				alert.setHeaderText("Mensaje enviado con éxito a "+modelo.getEmailDestinatario());
				alert.getButtonTypes().setAll(button_aceptar);
			
				stage = (Stage) alert.getDialogPane().getScene().getWindow();
		    	stage.getIcons().add(new Image("email-send-icon-32x32.png"));
				
				stage.showAndWait();

			} catch (EmailException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("No se pudo enviar el email.");
				alert.setContentText("Invalid message supplied");
				alert.getButtonTypes().setAll(button_aceptar);	

				stage = (Stage) alert.getDialogPane().getScene().getWindow();
		    	stage.getIcons().add(new Image("email-send-icon-32x32.png"));
		    	
				stage.showAndWait();

				
			}
			
		}   	

    }

    @FXML
    void button_vaciar(ActionEvent event) {
    	
    	textArea.clear();

    }

	public GridPane getView() {
		return view;
	}
	
    public Button getButton_cerrar() {
		return button_cerrar;
	}

}
