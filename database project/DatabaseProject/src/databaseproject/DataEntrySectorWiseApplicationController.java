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
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class DataEntrySectorWiseApplicationController implements Initializable {

    @FXML
    private Text Warning;
    @FXML
    private Text Cement;
    @FXML
    private Text Garments;
    @FXML
    private Text Spinning;
    @FXML
    private Text NumberOfProjectsT1;
    @FXML
    private Text paper;
    @FXML
    private TextField CementPerProject;
    @FXML
    private TextField GarmentPerProject;
    @FXML
    private TextField SpinnignPerProject;
    @FXML
    private TextField PaperPerProject;
    @FXML
    private Text CementTotal;
    @FXML
    private Text GarmentTotal;
    @FXML
    private Text SpinnigTotal;
    @FXML
    private Text PaperTotal;
    int numberOfCement;
    int numberOfGarment;
    int numberOfSpinning;
    int numberOfPaper;
    @FXML
    private Text warning;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            getNumberOfProjectDetails();
            // TODO
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataEntrySectorWiseApplicationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DataEntrySectorWiseApplicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    
    void getNumberOfProjectDetails() throws ClassNotFoundException, SQLException{
        String url = "jdbc:mysql://localhost:3306/kyoto";
        String uname= "root";
        String pass= "password";
        
        Class.forName("com.mysql.jdbc.Driver"); //class forname kyoto
        Connection con = DriverManager.getConnection(url,uname,pass);
        Statement st = con.createStatement();
        
        String query = " SELECT COUNT(*) cement FROM Data WHERE subSector='Cement' ";
        
        ResultSet rs = st.executeQuery(query); 
        rs.next();
        numberOfCement = Integer.parseInt(rs.getString("cement"));
        Cement.setText(Integer.toString(numberOfCement));
        
        query = " SELECT COUNT(*) garment FROM Data WHERE subSector='Garments' ";
        rs = st.executeQuery(query); 
        rs.next();
        numberOfGarment = Integer.parseInt(rs.getString("garment"));
        Garments.setText(Integer.toString(numberOfGarment));
        
        query = " SELECT COUNT(*) spinning FROM Data WHERE subSector='Spinning' ";
        rs = st.executeQuery(query); 
        rs.next();
        numberOfSpinning = Integer.parseInt(rs.getString("spinning"));
        Spinning.setText(Integer.toString(numberOfSpinning));
        
        query = " SELECT COUNT(*) paper FROM Data WHERE subSector='Paper' ";
        rs = st.executeQuery(query); 
        rs.next();
        numberOfPaper = Integer.parseInt(rs.getString("paper"));
        paper.setText(Integer.toString(numberOfPaper));
        
        System.out.println(numberOfCement+" "+numberOfGarment+" "+ numberOfSpinning+" "+ numberOfPaper);
        
        st.close();
        con.close();
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
    private void tab1(ActionEvent event) throws IOException {
        callScene("DataEntryConsumption.fxml", event);
    }

    @FXML
    private void tab2(ActionEvent event) throws IOException {
        callScene("DataEntrySectorWiseApplication.fxml", event);
    }

    @FXML
    private void tab3(ActionEvent event) {
    }

    @FXML
    private void tab4(ActionEvent event) {
    }

    @FXML
    private void UIIcons(ActionEvent event) {
    }

    @FXML
    private void tab6(ActionEvent event) {
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
    private void SaveButton(ActionEvent event) throws ClassNotFoundException, SQLException {
        if(CementPerProject.getText().equals("") || GarmentPerProject.getText().equals("") ||SpinnignPerProject.getText().equals("") 
                     ||  PaperPerProject.getText().equals("") )
                {
                    warning.setText("Entries cannot be empty");
                }
                else
                {
                    String url = "jdbc:mysql://localhost:3306/kyoto";
        String uname= "root";
        String pass= "password";
        String query = "INSERT INTO ApplicationLoan VALUES ("+Integer.parseInt(CementPerProject.getText())*numberOfCement+","
                                                        +Integer.parseInt(GarmentPerProject.getText())*numberOfGarment+","
                                                        +Integer.parseInt(SpinnignPerProject.getText())*numberOfSpinning+","
                                                        + Integer.parseInt(PaperPerProject.getText())*numberOfPaper+")";
        
        Class.forName("com.mysql.jdbc.Driver"); //class forname kyoto
        Connection con = DriverManager.getConnection(url,uname,pass);
        Statement st = con.createStatement();
        int rs = st.executeUpdate(query); 
        
        query = "INSERT INTO Application VALUES ("+numberOfCement+","
                                                        +numberOfGarment+","
                                                        +numberOfSpinning+","
                                                        + numberOfSpinning+")";
         rs = st.executeUpdate(query); 
         
         warning.setText("DataSaved!");
        
        st.close();
        con.close();
                        
                        }
                
                
                
                
    }

    @FXML
    private void ResetButton(ActionEvent event) throws IOException {
        callScene("DataEntrySectorWiseApplication.fxml", event);
    }
}
