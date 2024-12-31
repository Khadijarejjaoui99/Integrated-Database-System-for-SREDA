/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseproject;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Khond
 */
public class DataEntrySupplyController implements Initializable {

    @FXML
    private Text Warning;
    @FXML
    private TextField YearFromTF;
    @FXML
    private TextField yearToTF;
    @FXML
    private TextField CoalTF;
    @FXML
    private TextField ImportedCoalTF;
    @FXML
    private TextField OilTF;
    @FXML
    private TextField GasTF;
    @FXML
    private TextField ImportedLPGTF;
    @FXML
    private TextField HydroTF;
    @FXML
    private TextField RenewableTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void UIIcons(ActionEvent event) {
    }


    @FXML
    private void Settings(ActionEvent event) {
    }

    @FXML
    private void Faqs(ActionEvent event) {
    }

    @FXML
    private void Exit(ActionEvent event) throws IOException {
        callScene("LogIn.fxml",event);
    }

    @FXML
    private void AboutUs(ActionEvent event) throws IOException {
        callScene("AboutUs.fxml", event);
    }

    @FXML
    private void DataEntrySupply(ActionEvent event) throws IOException {
        callScene("DataEntrySupply.fxml", event);
    }

    @FXML
    private void SaveButton(ActionEvent event) throws ClassNotFoundException, SQLException {
        
        if(YearFromTF.getText().equals("") || yearToTF.getText().equals("")|| CoalTF.getText().equals("")|| ImportedCoalTF.getText().equals("") || OilTF.getText().equals("") 
                || GasTF.getText().equals("") || ImportedLPGTF.getText().equals("") || HydroTF.getText().equals("") || RenewableTF.getText().equals("") )
        {
            Warning.setText("Entries cannot be emptry.");
        }
        else
        {
            int yearFrom=Integer.parseInt(YearFromTF.getText());
            int yearTo=Integer.parseInt(yearToTF.getText());
            int impCoal=Integer.parseInt(ImportedCoalTF.getText());
            int Coal=Integer.parseInt(CoalTF.getText())+impCoal;
            int Oil=Integer.parseInt(OilTF.getText());
            int Gas=Integer.parseInt(GasTF.getText());
            int Hydro=Integer.parseInt(HydroTF.getText());
            int rewnewable=Integer.parseInt(RenewableTF.getText());
            int ImportedLPG=Integer.parseInt(ImportedLPGTF.getText())+rewnewable;
            
            String url = "jdbc:mysql://localhost:3306/kyoto";
            String uname= "root";
            String pass= "password";
            String query = "INSERT INTO EnSOURCE VALUES("
                    +yearFrom+","
                    +yearTo+","
                    +Coal+","
                    +Oil+","
                    +Gas+","
                    +Hydro+","
                    +ImportedLPG+")";
            
            System.out.println(query);
        
            Class.forName("com.mysql.jdbc.Driver"); //class forname kyoto
            Connection con = DriverManager.getConnection(url,uname,pass);
            Statement st = con.createStatement();
            
            int rs = st.executeUpdate(query);
            
            st.close();
            con.close();
            Warning.setText("Data saved");
            
        }
        
    }

    @FXML
    private void ResetButton(ActionEvent event) {
        Warning.setText(" ");
        YearFromTF.setText("");
        yearToTF.setText("");
        CoalTF.setText("");
        ImportedCoalTF.setText("");
         OilTF.setText("");
        GasTF.setText("");
        ImportedLPGTF.setText("");
        HydroTF.setText("");
        RenewableTF.setText("");
    }

    
    @FXML
    private void tab1(ActionEvent event) throws IOException {
        callScene("DataEntryConsumption.fxml", event);
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
