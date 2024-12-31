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
public class DataEntryGDPController implements Initializable {

    @FXML
    private TextField CodeTF;
    @FXML
    private TextField SubsectorTF;
    @FXML
    private TextField TypeTF;
    @FXML
    private TextField EquipmentTF;
    @FXML
    private TextField QuantityTF;
    @FXML
    private TextField PriceTotalTF;
    @FXML
    private TextField PricePerUnitTF;
    @FXML
    private TextField ProjectPriceTF;
    @FXML
    private TextField IFITF;
    @FXML
    private TextField NameTF;
    @FXML
    private TextField StatusTF;
    @FXML
    private TextField ProjectIDTF;
    @FXML
    private Text Warning;
    private Text Warning1;

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
        callScene("Dashboard.fxml", event);
    }

    @FXML
    private void DataEntryGDP(ActionEvent event) throws IOException {
        callScene("DataEntryGDP.fxml", event);
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
    private void Exit(ActionEvent event) {
    }

    @FXML
    private void AboutUs(ActionEvent event) throws IOException {
        callScene("AboutUs.fxml", event);
    }

    @FXML
    private void SaveButton(ActionEvent event) throws ClassNotFoundException, SQLException {
        int Rcount=0;
        if(CodeTF.getText().equals("") || TypeTF.getText().equals("") || EquipmentTF.getText().equals("") || QuantityTF.getText().equals("") || PriceTotalTF.getText().equals("")
              ||  PricePerUnitTF.getText().equals("") )
        {
            Warning.setText("Entries cannot be empty, please try again."); return;
        }
        else
        {
            String ProjectID = ProjectIDTF.getText();
            String Subsector = SubsectorTF.getText();
            String Code = CodeTF.getText();
            String Type = TypeTF.getText();
            String Equipment = EquipmentTF.getText();
            int Quantity = Integer.parseInt(QuantityTF.getText());
            float PriceTotal = Float.parseFloat(PriceTotalTF.getText());
            float PricePerUnit = Float.parseFloat(PricePerUnitTF.getText());
            float ProjectPrice = Float.parseFloat(ProjectPriceTF.getText());
            String Name = NameTF.getText();
            String IFI = IFITF.getText();
            String Status = StatusTF.getText();
            
            //SQL statements here
            
            String url = "jdbc:mysql://localhost:3306/kyoto";
            String uname= "root";
            String pass= "password";
            String query = "INSERT INTO Data VALUES('"+ProjectID+"','"
                    +Subsector+"','"
                    +Code+"','"
                    +Type+"','"
                    +Equipment+"','"
                    +Quantity+"',"
                    +PriceTotal+","
                    +PricePerUnit+","
                    +ProjectPrice+",'"
                    +Name+"','"
                    +IFI+"','"
                    +Status+"')";
            
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
        CodeTF.setText("");
        SubsectorTF.setText("");
        TypeTF.setText("");
        EquipmentTF.setText("");
        QuantityTF.setText("");
        PriceTotalTF.setText("");
        PricePerUnitTF.setText("");
        ProjectPriceTF.setText("");
        IFITF.setText("");
        NameTF.setText("");
        StatusTF.setText("");
        ProjectIDTF.setText("");
        Warning.setText("");
        Warning1.setText("");
    }

    @FXML
    private void DataEntryInstensity(ActionEvent event) throws IOException {
        callScene("DataEntryIntensity.fxml",event);
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
