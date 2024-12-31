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
import java.sql.ResultSet;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Khond
 */
public class DataEntryIntensityController implements Initializable {

    @FXML
    private TextField YearFromTF;
    @FXML
    private TextField yearToTF;
    @FXML
    private TextField OilIntensityTF;
    @FXML
    private TextField OilIntensityETTF;
    @FXML
    private TextField GDPTF;
    @FXML
    private Text EnergyIntensityTF;
    @FXML
    private Text EnergyIntensityETTF;
    @FXML
    private Text Warning;
    @FXML
    private TextField GasIntensityTF;
    @FXML
    private TextField GasIntensityETTF;
    @FXML
    private TextField PowerAndHydroTF;
    @FXML
    private TextField CoalTF;
    @FXML
    private Text TPESTF;
    @FXML
    private Text TPESETTF;
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
    private void UIIcons(ActionEvent event) {
    }


    @FXML
    private void Settings(ActionEvent event) {
    }

    @FXML
    private void Faqs(ActionEvent event) {
    }

    @FXML
    private void Exit(ActionEvent event) {
    }

    @FXML
    private void AboutUs(ActionEvent event) {
    }

    @FXML
    private void DataEntryIntensity(ActionEvent event) throws IOException {
        callScene("DataEntryIntensity.fxml",event);
    }
    

    @FXML
    private void SaveButton(ActionEvent event) throws ClassNotFoundException, SQLException {
        
        if(YearFromTF.getText().equals("") || yearToTF.getText().equals("") || OilIntensityTF.getText().equals("") || OilIntensityETTF.getText().equals("") ||
            GasIntensityTF.getText().equals("") || GasIntensityETTF.getText().equals("") || GDPTF.getText().equals("") || CoalTF.getText().equals("")
            || PowerAndHydroTF.getText().equals(""))
        {
            Warning.setText("Warning: Invalid input.");
            return;
        }
        int yearFrom = Integer.parseInt(YearFromTF.getText());
        int yearTo = Integer.parseInt(yearToTF.getText());
        int Oil = Integer.parseInt(OilIntensityTF.getText());
        int OilET = Integer.parseInt(OilIntensityETTF.getText());
        int Gas = Integer.parseInt(GasIntensityTF.getText());
        int GasET = Integer.parseInt(GasIntensityETTF.getText());
        int Coal = Integer.parseInt(CoalTF.getText());
        int PowerAndHydro = Integer.parseInt(PowerAndHydroTF.getText());
        
        
        int TPES = Oil+Gas+PowerAndHydro+Coal;
        int TPESET = OilET+GasET+PowerAndHydro+Coal;
        
        int GDP = Integer.parseInt(GDPTF.getText());
        
        float EnergyIntensity = (float)TPES/GDP;
        float EnergyIntensityET = (float)TPESET/GDP;
        
        TPESTF.setText("Total Primary Enery Supply: "+String.valueOf(TPES));
        TPESETTF.setText("Total Primary Enery Supply excluding transport: "+String.valueOf(TPESET));
        EnergyIntensityTF.setText("Energy Intensity: "+String.valueOf(EnergyIntensity));
        EnergyIntensityETTF.setText("Energy Intensity excluding transport: "+String.valueOf(EnergyIntensityET));
        
        //-------------------------------------------------
        
        String url = "jdbc:mysql://localhost:3306/kyoto";
        String uname= "root";
        String pass= "password";
        String query = "INSERT INTO Intensity VALUES("+yearFrom+","+yearTo+","
                                                      +Oil+","+OilET+","
                                                      +Gas+","+GasET+","
                                                      +Coal+","
                                                      +PowerAndHydro+","
                                                      +TPES+","
                                                      +TPESET+","
                                                      +GDP+","
                                                      +EnergyIntensity+","
                                                      +EnergyIntensityET+","
                                                      + 1 + ")";
        System.out.println(query);
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        Statement st = con.createStatement();
        
        int rs = st.executeUpdate(query); 
        
        
        st.close();
        con.close();
        
        //-------------------------------------------------
        
    }

    @FXML
    private void ResetButton(ActionEvent event) {
        TPESTF.setText("");
        TPESETTF.setText("");
        EnergyIntensityTF.setText("");
        EnergyIntensityETTF.setText("");
        YearFromTF.setText("");
        yearToTF.setText("");
        OilIntensityTF.setText("");
        OilIntensityETTF.setText("");
        GasIntensityTF.setText("");
        GasIntensityETTF.setText("");
        GDPTF.setText("");
        PowerAndHydroTF.setText("");
        CoalTF.setText("");
    }

    @FXML
    private void DataEntrySupply(ActionEvent event) throws IOException {
        callScene("DataEntrySupply.fxml", event);
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
