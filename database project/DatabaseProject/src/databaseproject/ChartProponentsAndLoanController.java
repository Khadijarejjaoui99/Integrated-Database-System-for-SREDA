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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Khond
 */
public class ChartProponentsAndLoanController implements Initializable {

    @FXML
    private BarChart<String, Number> LineChart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            //--------------------------Proponents and avg loan---------------------------
            
            getPnL();
                    
                    
                    //write the function name here to initialize the graph/chart whenevver you press the Proponents and avg loan button
                    
                    
                    //----------------------------------------------------------------------
                    
                    // TODO
                    } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChartProponentsAndLoanController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ChartProponentsAndLoanController.class.getName()).log(Level.SEVERE, null, ex);
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
    
    //--------------------------Proponents and avg loan function-----------------------------------------
        
        void getPnL() throws ClassNotFoundException, SQLException
    {
        String url = "jdbc:mysql://localhost:3306/kyoto";
        String uname= "root";
        String pass= "password";
        
        Class.forName("com.mysql.jdbc.Driver"); //class forname kyoto
        Connection con = DriverManager.getConnection(url,uname,pass);
        Statement st = con.createStatement();
        
        
        String query = " SELECT cement FROM application ";
        ResultSet rs = st.executeQuery(query);
        XYChart.Series<String, Number> Cseries = new XYChart.Series<String, Number>();
        XYChart.Series<String, Number> Gseries = new XYChart.Series<String, Number>();
        XYChart.Series<String, Number> Sseries = new XYChart.Series<String, Number>();
        XYChart.Series<String, Number> Pseries = new XYChart.Series<String, Number>();
        while(rs.next())
        {
            url = "jdbc:mysql://localhost:3306/kyoto";
            uname= "root";
            pass= "password";
        
            Class.forName("com.mysql.jdbc.Driver"); //class forname kyoto
            con = DriverManager.getConnection(url,uname,pass);
            st = con.createStatement();
            
            
            query = " SELECT cement FROM Application";
            ResultSet cem = st.executeQuery(query);
            cem.next();
            int Cem=Integer.parseInt(cem.getString("cement"));
            
            query = " SELECT cement FROM ApplicationLoan";
            cem = st.executeQuery(query);
            cem.next();
            int CemLoan=Integer.parseInt(cem.getString("cement"));
            //--------------------------------------------------------
            query = " SELECT  garment FROM Application";
            ResultSet gar = st.executeQuery(query);
            gar.next();
            int Ger=Integer.parseInt(gar.getString("garment"));
            
            query = " SELECT garment FROM ApplicationLoan";
            gar = st.executeQuery(query);
            gar.next();
            int GerLoan=Integer.parseInt(gar.getString("garment"));
            //--------------------------------------------------------
            
            query = " SELECT  Spinning FROM Application";
            ResultSet spi = st.executeQuery(query);
            spi.next();
            int Spi=Integer.parseInt(spi.getString("Spinning"));
            
            query = " SELECT spinning FROM ApplicationLoan";
            spi = st.executeQuery(query);
            spi.next();
            int SpiLoan=Integer.parseInt(spi.getString("spinning"));
            
            //--------------------------------------------------------
            
            query = " SELECT  Paper FROM Application";
            ResultSet pap = st.executeQuery(query);
            pap.next();
            int Pap=Integer.parseInt(pap.getString("Paper"));
            
            query = " SELECT Paper FROM ApplicationLoan";
            pap = st.executeQuery(query);
            pap.next();
            int PapLoan=Integer.parseInt(pap.getString("Paper"));
            
            System.out.println(Cem+""+CemLoan);
            System.out.println(Ger+""+GerLoan);
            System.out.println(Spi+""+SpiLoan);
            System.out.println(Pap+""+PapLoan);
            
            
            Cseries.getData().add(new XYChart.Data<String, Number>(Integer.toString(Cem),CemLoan));
            Gseries.getData().add(new XYChart.Data<String, Number>(Integer.toString(Ger),GerLoan));
            Sseries.getData().add(new XYChart.Data<String, Number>(Integer.toString(Spi),SpiLoan));
            Pseries.getData().add(new XYChart.Data<String, Number>(Integer.toString(Pap),PapLoan));
            
            st.close();
            con.close();
        }
        Cseries.setName("Cement");
        Gseries.setName("Germents");
        Sseries.setName("Spinning");
        Pseries.setName("Paper");
        
        LineChart.getData().add(Cseries);
        LineChart.getData().add(Gseries);
        LineChart.getData().add(Sseries);
        LineChart.getData().add(Pseries);
        st.close();
        con.close();
        
    }
        
    //---------------------------------------------------------------------------------

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
    private void Exit(ActionEvent event) {
    }

    @FXML
    private void AboutUs(ActionEvent event) {
    }

    @FXML
    private void BackButton(ActionEvent event) {
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
