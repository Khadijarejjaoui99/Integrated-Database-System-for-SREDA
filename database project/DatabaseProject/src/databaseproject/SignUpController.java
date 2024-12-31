/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseproject;

import Users.Person;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Khond
 */
public class SignUpController implements Initializable {

    @FXML
    private TextField EATextField;
    @FXML
    private TextField PWTextField;
    @FXML
    private TextField UTextField;
    @FXML
    private TextField DOBTextField;
    @FXML
    private TextField WTextField;
    @FXML
    private TextField BGTextField;
    @FXML
    private Label UIDLabel;
    
    private int UID;
    @FXML
    private Label SignUpLabel;

    /**
     * Initializes the controller class.
     */
    
    private void callScene(String source, ActionEvent event) throws IOException
    {
        Parent LogInParent = FXMLLoader.load(getClass().getResource(source));
        Scene LogInScene = new Scene(LogInParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(LogInScene);
        window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void ResetData(ActionEvent event) {
        SignUpLabel.setText("Sign Up");
        UIDLabel.setText("Auto generated...");
        EATextField.setText("");
        PWTextField.setText("");
        UTextField.setText("");
        DOBTextField.setText("");
        WTextField.setText("");
        BGTextField.setText("");
    }

    private void setValues()
    {
        SignUpLabel.setText("User Created. :)"); 
        EATextField.setText("");
        PWTextField.setText("");
        UTextField.setText("");
        DOBTextField.setText("");
        WTextField.setText("");
        BGTextField.setText("");
    }
    
    @FXML
    private void SignUp(ActionEvent event) throws IOException {
        if(EATextField.getText().equals(""))
        {
            EATextField.setText("Please enter valid Email Address...");
            return;
        }
        if(PWTextField.getText().equals(""))
        {
            PWTextField.setText("Please enter valid Password...");
            return;
        }
        if(UTextField.getText().equals(""))
        {
            UTextField.setText("Please enter valid User Name...");
            return;
        }
        if(DOBTextField.getText().equals(""))
        {
            DOBTextField.setText("Please enter valid DOB...");
            return;
        }
        if(WTextField.getText().equals(""))
        {
            WTextField.setText("Please enter valid Weight...");
            return;
        }
        if(BGTextField.getText().equals(""))
        {
            BGTextField.setText("Please enter valid Blood Group...");
            return;
        }
        
        Person temp = new Person();
        temp.setDetails(EATextField.getText(), PWTextField.getText(), UTextField.getText(), DOBTextField.getText(), WTextField.getText(), BGTextField.getText() );
        setValues();
    }

    @FXML
    private void Back(ActionEvent event) throws IOException {
        callScene("LogIn.fxml", event);
    }
    
}
