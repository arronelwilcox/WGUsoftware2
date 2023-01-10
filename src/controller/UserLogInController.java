package controller;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.sql.Time;
import java.util.*;

import DAO.Query;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Appointments;
import model.Customer;
import model.User;
import javafx.fxml.FXML;
import model.User;
import static DAO.Query.getUserList;
/**
 * This is the main Controller class that will control the functionality of the User Login form.
 * The desired functionality is for a User to log into a form thst allows the user access
 * to a database with numerous tables that all work together to create this scheduling GUI.
 */
public class UserLogInController implements Serializable {
    /**
     * The following are variables created for all of the buttons,labels,and text fields that are used
     * for the integration of external information. Specifically for the Username, Password,
     * preferred language, cancel, or submission into the form.
     */
    private Stage currentWindow = new Stage();
    @FXML
    private  PasswordField userNameField = new PasswordField();
    @FXML
    private PasswordField passWordField = new PasswordField();
    @FXML
    private RadioButton englishRadio = new RadioButton();
    @FXML
    private RadioButton frenchRadio = new RadioButton();
    @FXML
    private Button logInButton = new Button();
    @FXML
    private Button cancelButton = new Button();
    /**
    Variables for the integration of userList,customerList,and appointmentList.
     */
    private ObservableList<User> userList = getUserList();
    private ObservableList<Customer> customerList;
    private ObservableList<Appointments> appointmentList;
    /**
     * Function to tell if user speaks english.
     * @param user
     * @return
     */
    private static Boolean isLanguageUs(User user){
        if(user.getTimeZone().getDisplayName().equals("Europe/Paris")){
            return false;
        }
        else
            return true;
    }
    /**
     * This FXML Function will take the information supplied by the user in the text fields
     * and match them up with the a mayching User's username and password from the data base.
     * If both Username and Password do not match the Correct Users information
     * A warning will be displayed.
     */
    @FXML
   private void onLogIn(ActionEvent event) throws IOException {
        /**
         * Locale.setDefault(new Locale("fr"));
         * Locale.setDefault(new Locale("en"));
         */


        if(userList == null || userList.isEmpty() ){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("There are no User Accounts Loaded");
            alert.show();
            userList = Query.queryUserSelect();
            alert.setContentText(String.valueOf(userList));

        }
        for(User user: userList){
            //getSelectionModel().getSelectedItem()
            //getResource(user.getPassWord())
            if(userNameField.getText().equals(userList.getClass().getResource(user.getUserName())))
            {
                if(passWordField.getText().equals(userList.getClass().getResource(user.getUserName())))
                    {
                    if(user.getLanguageUS() == false){
                        Locale.setDefault(new Locale("fr"));

                        // log in to next form.Appointments Form?

                    }
                    else{
                        Locale.setDefault(new Locale("en"));
                        // log in to next form.Appointments Form?
                    }
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("Success!!!");
                    alert.show();
                    // log in to next form.Appointments Form?
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/model/appointmentForm.fxml"));
                    Parent root = (Parent)fxmlLoader.load();
                    Scene scene = new Scene(root);
                    currentWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
                    currentWindow.setTitle("Appointments");
                    currentWindow.setScene(scene);
                    currentWindow.show();
                }
                else{
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("The username or password was not correct");
                    alert.show();
                }
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("The Username and Password did not match any account");
                alert.show();
            }

        }

    }
    @FXML
    private RadioButton allApp = new RadioButton();
    @FXML
    private RadioButton monApp = new RadioButton();
    @FXML
    private RadioButton weekApp = new RadioButton();
    @FXML
    TableView<Appointments> appointmentsTableView = new TableView<Appointments>(Query.appointmentList.sorted());
    @FXML
    private void appointmentView(){
        if(appointmentList.isEmpty() || appointmentList.equals(null)){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("There are no appointments");
            appointmentList = Query.getAppointmentList();
        }
        else{
            ToggleGroup toggle = new ToggleGroup();
            allApp.setToggleGroup(toggle);
            monApp.setToggleGroup(toggle);
            weekApp.setToggleGroup(toggle);

        }
    }

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle){
//        /*
//        This Automatically sets the inHouse radio button when adding a new Part.
//                   ****PLEASE READ*****
//        In order to change to outSourced Part the outSourced Radio button must be hit twice.
//         */
//        inHouseRadio.setSelected(true);
//        /*
//       setting the columns to specific Part values
//        */
//        partIdSet.setCellValueFactory(new PropertyValueFactory<>("id"));
//        partNameSet.setCellValueFactory(new PropertyValueFactory<>("name"));
//        partInvSet.setCellValueFactory(new PropertyValueFactory<>("stock"));
//        partPriceSet.setCellValueFactory(new PropertyValueFactory<>("price"));
//        /*
//        setting all the Parts added so far to the table view
//         */
//        partListView.setItems(Inventory.getAllParts());
//        /*
//       setting the columns to specific Product values
//        */
//        productIdSet.setCellValueFactory(new PropertyValueFactory<>("id"));
//        productNameSet.setCellValueFactory(new PropertyValueFactory<>("name"));
//        productInvSet.setCellValueFactory(new PropertyValueFactory<>("stock"));
//        productPriceSet.setCellValueFactory(new PropertyValueFactory<>("price"));
//        productListView.setItems(Inventory.getAllProducts());
//         /*
//        setting all the Products added so far to the table view
//         */
//        partsProductIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
//        partsProductNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
//        partsProductInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
//        partsProductPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
//        partsTableProduct.setItems(Inventory.getAllParts());
//          /*
//        setting all the associated Parts added so far to the table view
//         */
//        assocProductPartIDCol.setCellValueFactory(new PropertyValueFactory<>("id"));
//        assocProductNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
//        assocProductInvCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
//        assocProductPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
//
//
//        /*
//        These functions are called to populate the modified Part and Product Forms with
//        The selected Items.
//         */
//        modifyPartView();
//        modifyProductView();
//
//    }
}
