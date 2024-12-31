/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Khond
 */
public class LogInController implements Initializable {
    
    @FXML
    private TextField EATextField;
    @FXML
    private TextField PTextField;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void callScene(String source, ActionEvent event) throws IOException
    {
        Parent LogInParent = FXMLLoader.load(getClass().getResource(source));
        Scene LogInScene = new Scene(LogInParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(LogInScene);
        window.show();
    }
    
    @FXML
    private void LogIn(ActionEvent event) throws IOException {
        String UN = EATextField.getText();
        String PW = PTextField.getText();
        
        if(UN.equals("admin") && PW.equals("admin"))
        {
            callScene("Dashboard.fxml",event);
        }
        
        if(UN.equals(""))
        {
            EATextField.setText("Plaese enter valid Email Address...");
            return;
        }
        if(PW.equals(""))
        {
            PTextField.setText("Please enter a password...");
            return;
        }
        
        Scanner x;
        File file = new File("Users.txt");
        if(!file.exists())
        {
            EATextField.setText("Please Sign Up First!");
            PTextField.setText("");
            return;
        }
        x = new Scanner(file);
        while(x.hasNextLine())
        {
            String EA = x.nextLine();
            String P = x.nextLine();
            String UId = x.nextLine();
            if(UN.equals(EA))
            {
                if(PW.equals(P))
                {
                    
                    File xz= new File("LogInID.txt");
                    if(!xz.exists())
                    {
                        xz.createNewFile();
                    }
                    
                    FileWriter fw = new FileWriter(xz);
                    BufferedWriter buffer = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(buffer);
                    pw.println(UId);
                    pw.close();
                    
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
                    Parent root = (Parent) loader.load();
                    DashboardController z = loader.getController();
                    z.getId(UId);
                    Scene X = new Scene(root);
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(X);
                    window.show();
                    
                }
                else
                {
                    PTextField.setText("Invalid Password...");
                    break;
                }
            }
        }
        EATextField.setText("Invalid Email Address..");
        PTextField.setText("");
        x.close();
        
        /*
        String UserName = "admin";
        String Password = "admin";
        if(UN.equals(UserName) && PW.equals(Password))
        {
            callScene("HomeScreen.fxml", event);
        }
        else if(UN.equals(UserName) && !PW.equals(Password))
        {
            PTextField.setText("Invalid Password.");
        }
        else if(!UN.equals(UserName) && PW.equals(Password))
        {
            EATextField.setText("Invalid Password.");
        }
        else if(!UN.equals(UserName) && !PW.equals(Password))
        {
            EATextField.setText("Invalid Password.");
            PTextField.setText("Invalid Password.");
        }
        */
    }

    @FXML
    private void ForgotPassword(ActionEvent event) {
    }

    @FXML
    private void SignIn(ActionEvent event) throws IOException {
        callScene("SignUp.fxml", event);
    }


    @FXML
    private void EAOnAction(MouseEvent event) {
        EATextField.setText("");
    }

    @FXML
    private void POnAction(MouseEvent event) {
        PTextField.setText("");
    }
    
}
