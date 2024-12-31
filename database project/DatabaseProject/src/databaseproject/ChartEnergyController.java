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
public class ChartEnergyController implements Initializable {

    @FXML
    private BarChart<String, Number> EnergyConsumtionAreaChart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            //--------------------------Energy Consumption---------------------------
            
            
            getEnergyConsumptionDetails();
            //write the function name here to initialize the graph/chart whenevver you press the loan amount dis. button
            
            
            //----------------------------------------------------------------------
            // TODO
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChartEnergyController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ChartEnergyController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //--------------------------Energy Consumption function-----------------------------------------
        
    void getEnergyConsumptionDetails() throws ClassNotFoundException, SQLException
    {
        String url = "jdbc:mysql://localhost:3306/kyoto";
        String uname= "root";
        String pass= "password";
        
        Class.forName("com.mysql.jdbc.Driver"); //class forname kyoto
        Connection con = DriverManager.getConnection(url,uname,pass);
        Statement st = con.createStatement();
        
        
        String query = " SELECT yearFrom FROM coalConsumption ";
        ResultSet yearData = st.executeQuery(query);
        
        
        XYChart.Series<String, Number> Iseries = new XYChart.Series<String, Number>();
        
        XYChart.Series<String, Number> Tseries = new XYChart.Series<String, Number>();
        
        XYChart.Series<String, Number> Rseries = new XYChart.Series<String, Number>();
        
        
        XYChart.Series<String, Number> Cseries = new XYChart.Series<String, Number>();
        
        XYChart.Series<String, Number> Aseries = new XYChart.Series<String, Number>();
        XYChart.Series<String, Number> Oseries = new XYChart.Series<String, Number>();
        
        
        while(yearData.next())
        {
            url = "jdbc:mysql://localhost:3306/kyoto";
            uname= "root";
            pass= "password";
        
            Class.forName("com.mysql.jdbc.Driver"); //class forname kyoto
            con = DriverManager.getConnection(url,uname,pass);
            st = con.createStatement();
            //-----------------Year
            int Year = Integer.parseInt(yearData.getString("yearFrom"));
            
            //-----------------Coal
            query = " SELECT coalIndustry FROM coalConsumption WHERE yearFrom="+Year;
            ResultSet coal = st.executeQuery(query);
            coal.next();
            int ICoal=Integer.parseInt(coal.getString("coalIndustry"));
            //System.out.println("coal");
            //-----------------
            //-----------------Oil
            query = " SELECT oilIndustry FROM oilConsumption WHERE yearFrom="+Year;
            ResultSet oil = st.executeQuery(query);
            oil.next();
            int IOil=Integer.parseInt(oil.getString("oilIndustry"));
            
            query = " SELECT oilTransport FROM oilConsumption WHERE yearFrom="+Year;
            oil = st.executeQuery(query);
            oil.next();
            int TOil=Integer.parseInt(oil.getString("oilTransport"));
            
            query = " SELECT oilResidence FROM oilConsumption WHERE yearFrom="+Year;
            oil = st.executeQuery(query);
            oil.next();
            int ROil=Integer.parseInt(oil.getString("oilResidence"));
            
            query = " SELECT oilBuilding FROM oilConsumption WHERE yearFrom="+Year;
            oil = st.executeQuery(query);
            oil.next();
            int BOil=Integer.parseInt(oil.getString("oilBuilding"));
            
            query = " SELECT oilAgriculture FROM oilConsumption WHERE yearFrom="+Year;
            oil = st.executeQuery(query);
            oil.next();
            int AOil=Integer.parseInt(oil.getString("oilAgriculture"));
            
            //System.out.println("oil");
            //-----------------
            //-----------------Gas
            query = " SELECT gasIntrustry FROM gasConsumption WHERE yearFrom="+Year;
            ResultSet gas = st.executeQuery(query);
            gas.next();
            int IGas=Integer.parseInt(gas.getString("gasIntrustry"));
            
            query = " SELECT gasTransport FROM gasConsumption WHERE yearFrom="+Year;
            gas = st.executeQuery(query);
            gas.next();
            int TGas=Integer.parseInt(gas.getString("gasTransport"));
            
            query = " SELECT gasResidence FROM gasConsumption WHERE yearFrom="+Year;
            gas = st.executeQuery(query);
            gas.next();
            int RGas=Integer.parseInt(gas.getString("gasResidence"));
            
            query = " SELECT gasBuilding FROM gasConsumption WHERE yearFrom="+Year;
            gas = st.executeQuery(query);
            gas.next();
            int BGas=Integer.parseInt(gas.getString("gasBuilding"));
            
            query = " SELECT gasAgriculture FROM gasConsumption WHERE yearFrom="+Year;
            gas = st.executeQuery(query);
            gas.next();
            int AGas=Integer.parseInt(gas.getString("gasAgriculture"));
            
            //System.out.println("gas");
            
            
            //-----------------
            //-----------------Power
            query = " SELECT powIntrustry FROM powerConsumption WHERE yearFrom="+Year;
            ResultSet pow = st.executeQuery(query);
            pow.next();
            int IPow=Integer.parseInt(pow.getString("powIntrustry"));
            
            
            //System.out.println("pow1");
            
            query = " SELECT powAgriculture FROM powerConsumption WHERE yearFrom="+Year;
            pow = st.executeQuery(query);
            pow.next();
            int APow=Integer.parseInt(pow.getString("powAgriculture"));
            
            //System.out.println("pow2");
            
            query = " SELECT powCommercial FROM powerConsumption WHERE yearFrom="+Year;
            pow = st.executeQuery(query);
            pow.next();
            int CPow=Integer.parseInt(pow.getString("powCommercial"));
            
            //System.out.println("pow3");
            
            
            query = " SELECT powDomestic FROM powerConsumption WHERE yearFrom="+Year;
            pow = st.executeQuery(query);
            pow.next();
            int RPow=Integer.parseInt(pow.getString("powDomestic"));
            
            query = " SELECT powOthers FROM powerConsumption WHERE yearFrom="+Year;
            pow = st.executeQuery(query);
            pow.next();
            int OPow=Integer.parseInt(pow.getString("powOthers"));
            
            
            //-----------------
            //main industry,transport,residential,commerical,agriculture
            
            int totalIndustry=ICoal+IOil+IGas+IPow;
            int totalTransport=TOil+TGas;
            int totalResidence = ROil+RGas+RPow;
            int totalBuilding = BOil+ BGas;
            int totalAgricuture = AOil + AGas + APow;
            int totalCommercial = CPow;
            int totalOther=OPow;
            
            Iseries.getData().add(new XYChart.Data<String, Number>(Integer.toString(Year),totalIndustry));
            Tseries.getData().add(new XYChart.Data<String, Number>(Integer.toString(Year),totalTransport));
            Rseries.getData().add(new XYChart.Data<String, Number>(Integer.toString(Year),totalResidence));
            Cseries.getData().add(new XYChart.Data<String, Number>(Integer.toString(Year),totalCommercial));
            Aseries.getData().add(new XYChart.Data<String, Number>(Integer.toString(Year),totalAgricuture));
            Oseries.getData().add(new XYChart.Data<String, Number>(Integer.toString(Year),totalOther));
            
            st.close();
            con.close();
        }
        
        Iseries.setName("Industry");
        Tseries.setName("Transport");
        Rseries.setName("Residence");
        Cseries.setName("Commercial");
        Aseries.setName("Agriculture");
        Oseries.setName("Other");
        EnergyConsumtionAreaChart.getData().add(Iseries);
        EnergyConsumtionAreaChart.getData().add(Tseries);
        EnergyConsumtionAreaChart.getData().add(Rseries);
        EnergyConsumtionAreaChart.getData().add(Cseries);
        EnergyConsumtionAreaChart.getData().add(Aseries);
        EnergyConsumtionAreaChart.getData().add(Oseries);
        
        st.close();
        con.close();
    }
        
    //---------------------------------------------------------------------------------
    
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
