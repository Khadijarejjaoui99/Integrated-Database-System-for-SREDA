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
public class DataEntryConsumptionController implements Initializable {

    @FXML
    private TextField YearFromTF;
    @FXML
    private TextField yearToTF;
    @FXML
    private Text Warning;
    @FXML
    private TextField ICoal;
    @FXML
    private TextField IGas;
    @FXML
    private TextField TGas;
    @FXML
    private TextField RGas;
    @FXML
    private TextField BGas;
    @FXML
    private TextField AGas;
    @FXML
    private TextField IOil;
    @FXML
    private TextField TOil;
    @FXML
    private TextField ROil;
    @FXML
    private TextField BOil;
    @FXML
    private TextField AOil;
    @FXML
    private TextField IPower;
    @FXML
    private TextField APower;
    @FXML
    private TextField OPower;
    @FXML
    private TextField DPower;
    @FXML
    private TextField CPower;

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
        String url = "jdbc:mysql://localhost:3306/kyoto";
            String uname= "root";
            String pass= "password";
            Class.forName("com.mysql.jdbc.Driver"); //class forname kyoto
            Connection con = DriverManager.getConnection(url,uname,pass);
            Statement st = con.createStatement();
            
            int yearFrom = Integer.parseInt(YearFromTF.getText());
            int yearTo = Integer.parseInt(yearToTF.getText());
            
            int IC = Integer.parseInt(ICoal.getText());
            String query="INSERT INTO coalConsumption Values ("+yearFrom+", "+yearTo+", "+IC*0.00061+")";
            int rs = st.executeUpdate(query);
            
            int IG = Integer.parseInt(IGas.getText());
            int TG = Integer.parseInt(TGas.getText());
            int RG = Integer.parseInt(RGas.getText());
            int BG = Integer.parseInt(BGas.getText());
            int AG = Integer.parseInt(AGas.getText());
            query="INSERT INTO gasConsumption Values ("+yearFrom+", "+yearTo+", "+IG*0.935 +", "+TG*0.935 +", "+RG*0.935 +", "+BG*0.935 +", "+AG*0.935 +")";
            rs = st.executeUpdate(query);
            
            
            
            int IO = Integer.parseInt(IOil.getText());
            int TO = Integer.parseInt(TOil.getText());
            int RO = Integer.parseInt(ROil.getText());
            int BO = Integer.parseInt(BOil.getText());
            int AO = Integer.parseInt(AOil.getText());
            query="INSERT INTO oilConsumption Values ("+yearFrom+", "+yearTo+", "+IO*0.00111+", "+TO*0.00111+", "+RO*0.00111+", "+BO*0.00111+", "+AO*0.00111+")";
            rs = st.executeUpdate(query);
            
            int IP = Integer.parseInt(IPower.getText());
            int AP = Integer.parseInt(APower.getText());
            int OP = Integer.parseInt(OPower.getText());
            int DP = Integer.parseInt(DPower.getText());
            int CP = Integer.parseInt(CPower.getText());
            query="INSERT INTO powerConsumption Values ("+yearFrom+", "+yearTo+", "+IP*0.283+", "+AP*0.283+", "+OP*0.283+", "+DP*0.283+", "+CP*0.283+")";
            rs = st.executeUpdate(query);
            
            st.close();
            con.close();
            Warning.setText("Data saved");
            
    }

    @FXML
    private void ResetButton(ActionEvent event) throws IOException {
        callScene("DataEntryConsumption.fxml", event);
    }
    
}
