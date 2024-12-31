/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseproject;

import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.LineChart;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author Khond
 */
public class DashboardController implements Initializable {

    @FXML
    private Text NumberOfProjectsT;
    @FXML
    private Text ProjectsCostT;
    @FXML
    private Text NumberOfNocT;
    @FXML
    private Text NocCostT;
    @FXML
    private Text NumberOfPipelineT;
    @FXML
    private Text PipelineCostT;
    @FXML
    private Text NumberOfTechnologyT;
    @FXML
    private Text TechnologyCostT;
    
    private String UserId;
    @FXML
    private LineChart<String, Number> IntensityTrendLineChart;
    @FXML
    private AreaChart<String, Number> EnergySupplyAreaChart;
    @FXML
    private NumberAxis intensityYAxis;
    @FXML
    private NumberAxis intensityXAxis;
    @FXML
    private AreaChart<String, Number> EnergyConsumtionAreaChart;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       //----------Intensity TREND Chart----------------------------------------
        intensityYAxis.setAutoRanging(false);
        intensityYAxis.setLowerBound(3.3000);
        intensityYAxis.setUpperBound(3.7500);
        intensityYAxis.setTickUnit(0.0625);

        intensityXAxis.setAutoRanging(false);
        intensityXAxis.setLowerBound(2010);
        intensityXAxis.setUpperBound(2020);
        intensityXAxis.setTickUnit(1000);
        
        try {
            getIntensityChart();
            getNumberOfProjectsData();
            getEnergySupplyData();
            getEnergyConsumptionDetails();
            // TODO
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //----------------------------------------------------------------------
        
        
        
        
        
        
        //--------------------------Energy Supply ------------------------------
        
        
        //write the function name here to initialize the graph/chart whenevver you press the dashboard
        
        
        //----------------------------------------------------------------------
        //--------------------------Energy Comsumtion---------------------------
        
        
        
        //write the function name here to initialize the graph/chart whenevver you press the dashboard
        
        
        //----------------------------------------------------------------------
        
    }    
    
    //--------------------Intensity Trend function----------------------------------------
    private void getIntensityChart() throws ClassNotFoundException, SQLException
    {
        IntensityTrendLineChart.getData().clear();
        String url = "jdbc:mysql://localhost:3306/kyoto";
        String uname= "root";
        String pass= "password";
        String query = " SELECT yearFrom FROM Intensity ";
        
        Class.forName("com.mysql.jdbc.Driver"); //class forname kyoto
        Connection con = DriverManager.getConnection(url,uname,pass);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);     
        Vector<String> Y = new Vector<>();
    while(rs.next())
    {
        String ET = rs.getString("YearFrom");
        Y.addElement(ET);
    }
        st.close();
        con.close();
    
        query = " SELECT EnergyIntensity FROM Intensity ";
        con = DriverManager.getConnection(url,uname,pass);
        st = con.createStatement();
        rs = st.executeQuery(query);   
        int size=Y.size();
        float[] X= new float [size];
        int i=0;
    while(rs.next())
    {
        float ET = rs.getFloat("EnergyIntensity");
        X[i]=ET;
        i++;
    }
        st.close();
        con.close();
    
        XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
    for(i=0;i<size;i++)
    {
        series.getData().add(new XYChart.Data<String, Number>(Y.get(i),X[i]));
    }
    series.setName("Intensity Trend");
    IntensityTrendLineChart.getData().add(series);
    
    }
    
    void getNumberOfProjectsData() throws ClassNotFoundException, SQLException
    {
        String url = "jdbc:mysql://localhost:3306/kyoto";
        String uname= "root";
        String pass= "password";
        
        Class.forName("com.mysql.jdbc.Driver"); //class forname kyoto
        Connection con = DriverManager.getConnection(url,uname,pass);
        Statement st = con.createStatement();
        //--------------Project
        String query = " SELECT COUNT(*) ID FROM Data ";
        ResultSet rs = st.executeQuery(query);
        rs.next();
        NumberOfProjectsT.setText(rs.getString("ID"));
        
        query = " SELECT SUM(Price) FROM Data ";
        rs = st.executeQuery(query);
        rs.next();
        ProjectsCostT.setText(rs.getString("SUM(Price)")+" Taka ( in Billions).");
        //--------------------------
        
        //-----------------NOC
        query =" SELECT COUNT(*) Status FROM Data WHERE Status='NOC'";
        rs = st.executeQuery(query);
        rs.next();
        NumberOfNocT.setText(rs.getString("Status"));
        
        query = " SELECT SUM(Price) FROM Data WHERE  Status='NOC' ";
        rs = st.executeQuery(query);
        rs.next();
        NocCostT.setText(rs.getString("SUM(Price)")+" Taka ( in Billions).");
        //-------------------------------
        
        //------------------------Pipeline
        query =" SELECT COUNT(*) Status FROM Data WHERE Status='Pipeline'";
        rs = st.executeQuery(query);
        rs.next();
        NumberOfPipelineT.setText(rs.getString("Status"));
        
        query = " SELECT SUM(Price) FROM Data WHERE  Status='Pipeline' ";
        rs = st.executeQuery(query);
        rs.next();
        PipelineCostT.setText(rs.getString("SUM(Price)")+" Taka ( in Billions).");
        //----------------------------------
        
        //------------------Technology
        query ="SELECT COUNT(*) Type FROM Data WHERE Type='LED' OR Type='Air Conditioner' OR Type='De-inking Plant' OR Type='Lift' OR Type='Spinning'";
        rs = st.executeQuery(query);
        rs.next();
        NumberOfTechnologyT.setText(rs.getString("Type"));
        
        query = "SELECT SUM(Price) FROM Data WHERE Type='LED' OR Type='Air Conditioner' OR Type='De-inking Plant' OR Type='Lift' OR Type='Spinning'";
        rs = st.executeQuery(query);
        rs.next();
        TechnologyCostT.setText(rs.getString("SUM(Price)")+" Taka ( in Billions).");
        
        //----------------------------
        
        
        st.close();
        con.close();
    }
    
    //----------------------------------------------------------------------------------
    
    
    
    //--------------------------Energy Supply function-----------------------------------------
        
    void getEnergySupplyData() throws ClassNotFoundException, SQLException{
        String url = "jdbc:mysql://localhost:3306/kyoto";
        String uname= "root";
        String pass= "password";
        
        Class.forName("com.mysql.jdbc.Driver"); //class forname kyoto
        Connection con = DriverManager.getConnection(url,uname,pass);
        Statement st = con.createStatement();
        
        
        String query = " SELECT yearFrom FROM EnSOURCE ";
        ResultSet yearData = st.executeQuery(query);
        
//        while(yearData.next())
//        {
//            System.out.println(yearData.getString("yearFrom"));
//        }

        XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
        
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
            //-----------------
            
            //-----------------Coal
            query = " SELECT coal FROM EnSOURCE WHERE yearFrom="+Year;
            ResultSet coal = st.executeQuery(query);
            coal.next();
            int Coal=Integer.parseInt(coal.getString("coal"));
            //-----------------
            
            //-----------------Oil
            query = " SELECT oil FROM EnSOURCE WHERE yearFrom="+Year;
            ResultSet oil = st.executeQuery(query);
            oil.next();
            int Oil=Integer.parseInt(oil.getString("oil"));
            //-----------------
            
            //-----------------Gas
            query = " SELECT gas FROM EnSOURCE WHERE yearFrom="+Year;
            ResultSet gas = st.executeQuery(query);
            gas.next();
            int Gas=Integer.parseInt(gas.getString("gas"));
            
            //-----------------
            
            
            //-----------------Hydro
            
            query = " SELECT hydro FROM EnSOURCE WHERE yearFrom="+Year;
            ResultSet hydro = st.executeQuery(query);
            hydro.next();
            int Hydro=Integer.parseInt(hydro.getString("hydro"));
            
            //-----------------
            
            
            //-----------------imports
            query = " SELECT import FROM EnSOURCE WHERE yearFrom="+Year;
            ResultSet importT = st.executeQuery(query);
            
            importT.next();
            int Import=Integer.parseInt(importT.getString("import"));
            
            //-----------------
            
            
            int totalEnergy=Coal+Oil+Gas+Hydro+Import; 
            
            series.getData().add(new XYChart.Data<String, Number>(Integer.toString(Year),totalEnergy));
            
            st.close();
            con.close();
        }
        
        
        series.setName("Energy Supply");
        EnergySupplyAreaChart.getData().add(series);
        
        st.close();
        con.close();
    }
        
    //---------------------------------------------------------------------------------
    
    
    //--------------------------Energy Comsumtion function--------------------------------------
     
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
            //-----------------
            //main industry,transport,residential,commerical,agriculture
            
            int totalIndustry=ICoal+IOil+IGas+IPow;
            int totalTransport=TOil+TGas;
            int totalResidence = ROil+RGas;
            int totalBuilding = BOil+ BGas;
            int totalAgricuture = AOil + AGas + APow;
            int totalCommercial = CPow;
            
            Iseries.getData().add(new XYChart.Data<String, Number>(Integer.toString(Year),totalIndustry));
            Tseries.getData().add(new XYChart.Data<String, Number>(Integer.toString(Year),totalTransport));
            Rseries.getData().add(new XYChart.Data<String, Number>(Integer.toString(Year),totalResidence));
            Cseries.getData().add(new XYChart.Data<String, Number>(Integer.toString(Year),totalCommercial));
            Aseries.getData().add(new XYChart.Data<String, Number>(Integer.toString(Year),totalAgricuture));
            
            st.close();
            con.close();
        }
        
        Iseries.setName("Industry");
        Tseries.setName("Transport");
        Rseries.setName("Residence");
        Cseries.setName("Commercial");
        Aseries.setName("Agriculture");
        EnergyConsumtionAreaChart.getData().add(Iseries);
        EnergyConsumtionAreaChart.getData().add(Tseries);
        EnergyConsumtionAreaChart.getData().add(Rseries);
        EnergyConsumtionAreaChart.getData().add(Cseries);
        EnergyConsumtionAreaChart.getData().add(Aseries);
        
        st.close();
        con.close();
    }
        
    //---------------------------------------------------------------------------------
    
    
    
    public void getId(String id) throws FileNotFoundException
    {
        UserId = id;
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
    private void AboutUs(ActionEvent event) throws IOException {
        callScene("AboutUs.fxml", event);
    }
    
    @FXML
    private void Exit(ActionEvent event) throws IOException {
        callScene("LogIn.fxml",event);
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
    private void RefreshButton(ActionEvent event) throws ClassNotFoundException, SQLException {
        getIntensityChart();
    
    }

    @FXML
    private void ProponentAndAvgLoanButton(ActionEvent event) throws IOException {
        callScene("ChartProponentsAndLoan.fxml", event);
    }

    @FXML
    private void LoanAmountDistributionButton(ActionEvent event) throws IOException {
        callScene("ChartLoanAmount.fxml", event);
    }

    @FXML
    private void EquipmentWIseDistributionButton(ActionEvent event) throws IOException {
        callScene("ChartEquipment.fxml", event);
    }

    @FXML
    private void EnergyConsumpationButton(ActionEvent event) throws IOException {
        callScene("ChartEnergy.fxml", event);
    }

    private void IndustrialEnergyIntensityButton(ActionEvent event) throws IOException {
        callScene("ChartIndustrialEnergy.fxml", event);
    }

    @FXML
    private void ProfileButton(ActionEvent event) throws IOException {
        callScene("Profile.fxml", event);
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
    private void tab6(ActionEvent event) {
    }

}
