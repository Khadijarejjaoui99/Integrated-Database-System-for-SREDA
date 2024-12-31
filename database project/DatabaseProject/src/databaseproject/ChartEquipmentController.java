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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;


public class ChartEquipmentController implements Initializable {
    
    @FXML 
    private PieChart PieChart;
    @FXML 
    private BarChart<String, Double> EquipmentBarChart;
    @FXML
    private CategoryAxis barXAxis;
    @FXML
    private NumberAxis barYAxis;
    private Connection connection; 
    @FXML
    private Label statusLabel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getEquipmentBarChart();
        getEquipmentPieChart();
    } 

    
    private Connection connectDB(){
        try {
            String url = "jdbc:mysql://localhost:3306/kyoto";
            String uname= "root";
            String pass= "password";
            Connection conn = DriverManager.getConnection(url,uname,pass);
            return conn;
        } catch (SQLException ex) {
            Logger.getLogger(ChartEquipmentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //--------------------------Equipment wise dist. function-----------------------------------------
    private void getEquipmentBarChart(){
        String query = "SELECT Equipment, Amount from EquipmentList ORDER BY Amount ASC";
        XYChart.Series<String, Double> series = new XYChart.Series<>();
        try{
            connection=connectDB();
            ResultSet rs = connection.createStatement().executeQuery(query);
            while(rs.next()){
                series.getData().add(new XYChart.Data<>(rs.getString(1),rs.getDouble(2)));
            }
            EquipmentBarChart.getData().add(series);
        } catch(SQLException e) {  
        }
    
    }
     
    public void getEquipmentPieChart() {
    String query = "SELECT Equipment, Amount from EquipmentList ORDER BY Amount ASC";
    ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
    try {
      connection = connectDB();
      ResultSet rs = connection.createStatement().executeQuery(query);
      while (rs.next()){
        list.add(new PieChart.Data(rs.getString(1), rs.getDouble(2)));
        PieChart.setData(list);
      }
      PieChart.setVisible(true);
    } catch (SQLException e){}
    
    PieChart.getData().forEach(data -> {
        data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent event) -> {
        double total = 0;
        for (PieChart.Data d : PieChart.getData()) {
            total += d.getPieValue();
        }
        statusLabel.setText("Value: " + String.valueOf(data.getPieValue()) + "   Percent: " + String.format("%.1f%%", 100*data.getPieValue()/total));
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        });
    });

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
    private void Exit(ActionEvent event) {
    }

    @FXML
    private void AboutUs(ActionEvent event) {
    }

    @FXML
    private void BackButton(ActionEvent event) throws IOException {
        callScene("Dashboard.fxml",event);
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
    private void tabv4(ActionEvent event) {
    }

    @FXML
    private void tab6(ActionEvent event) {
    }
    
}
