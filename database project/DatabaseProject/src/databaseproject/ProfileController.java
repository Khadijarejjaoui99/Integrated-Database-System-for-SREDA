/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Khond
 */
public class ProfileController implements Initializable {

    @FXML
    private Text userNameTF;
    @FXML
    private Text userIDTF;
    @FXML
    private Text userEmailTF;
    @FXML
    private Text userBGTF;
    @FXML
    private Text userDOBTF;
    @FXML
    private Text userWeightTF;
    @FXML
    private Text userIDTF1;

    /**
     * Initializes the controller class.
     */
    
    private void setInfo() throws FileNotFoundException
    {
        
        File file1 = new File("LogInID.txt");
        Scanner x = new Scanner(file1);
        String userID = x.nextLine();
        
        File file = new File(userID+".txt");
        x = new Scanner(file);
        String Email = x.nextLine();
        String Password = x.nextLine();
        String garbage = x.nextLine();
        String UserName = x.nextLine();
        String DOB = x.nextLine();
        String Weight = x.nextLine();
        String BG = x.nextLine();
        x.close();
        userEmailTF.setText(Email);
        userIDTF.setText(userID);
        userNameTF.setText(UserName);
        userIDTF1.setText(userID);
        userDOBTF.setText(DOB);
        userWeightTF.setText(Weight);
        userBGTF.setText(BG);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            setInfo();
            
            // TODO
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    private void callScene(String source, ActionEvent event) throws IOException
    {
        Parent DashboardParent = FXMLLoader.load(getClass().getResource(source));
        Scene LogInScene = new Scene(DashboardParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(LogInScene);
        window.show();
    }

    @FXML
    private void Dashboard(ActionEvent event) throws IOException {
        callScene("Dashboard.fxml",event);
    }

    @FXML
    private void DataEntryGDP(ActionEvent event) throws IOException {
        callScene("DataEntryGDP.fxml", event);
    }


    @FXML
    private void DataEntryIntensity(ActionEvent event) throws IOException {
        callScene("DataEntryIntensity.fxml",event);
    }
    @FXML
    private void DataEntrySupply(ActionEvent event) throws IOException {
        callScene("DataEntrySupply.fxml", event);
    }


    @FXML
    private void UIIcons(ActionEvent event) {
    }


    @FXML
    private void Settings(ActionEvent event) {
    }

    @FXML
    private void Faqs(ActionEvent event) {
    }

    @FXML
    private void AboutUs(ActionEvent event) throws IOException {
        callScene("AboutUs.fxml", event);
    }
    
    @FXML
    private void Exit(ActionEvent event) throws IOException {
        callScene("LogIn.fxml",event);
    }

    @FXML
    private void RequestUpdateButton(ActionEvent event) {
    }

    @FXML
    private void DeleteUserDataButton(ActionEvent event) {
    }

    @FXML
    private void BackButton(ActionEvent event) throws IOException {
        callScene("Dashboard.fxml",event);
    }

    @FXML
    private void tab1(ActionEvent event) {
    }

    @FXML
    private void tab2(ActionEvent event) {
    }

    @FXML
    private void tab3(ActionEvent event) {
    }

    @FXML
    private void tab4(ActionEvent event) {
    }

    @FXML
    private void tab6(ActionEvent event) {
    }

}
