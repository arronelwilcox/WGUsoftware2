package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;

public class AppointmentController {
    @FXML
    private TableView appointmentTable = new TableView();
    @FXML
    private PasswordField passWordField = new PasswordField();
    @FXML
    private RadioButton englishRadio = new RadioButton();
    @FXML
    private RadioButton frenchRadio = new RadioButton();
    @FXML
    private Button logInButton = new Button();
}
