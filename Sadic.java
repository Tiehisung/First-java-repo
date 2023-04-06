/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sadic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author SosKode
 */
public class Sadic extends Application {
    Connection con;
    String Url ="jdbc:derby://localhost:1527/Sadic_joint";
    String username = "sos", password="sos";
    
    
    @Override
    public void start(Stage primaryStage) {
        try {
            con = DriverManager.getConnection(Url, username, password);
            System.out.println("Connect successfully !");
            con.close();
               
            
        } catch (SQLException ex) {
            System.out.println("Connect failed! ");
        }

        Label name = new Label("Customer name".toUpperCase());
        TextField forName = new TextField();
        
        Label avail = new Label("Available dishes".toUpperCase());
        
        Button fufu = new Button("Fufu");
        Button banku = new Button("Banku");
        Button tz = new Button("TZ");
        Button sub = new Button("Submit");
        
        HBox hb1 = new HBox(12);
        hb1.getChildren().addAll(fufu,banku,tz);
        
        GridPane grid = new GridPane();
        grid.add(name,0,0);
        grid.add(forName,1,0);
        grid.add(avail,0,1);
        grid.add(hb1,1,1);
        grid.add(sub,1,2);
        grid.setVgap(12);
        grid.setHgap(12);
        VBox vbFinal = new VBox(12);
        vbFinal.setAlignment(Pos.CENTER);
        vbFinal.setPadding(new Insets(30,30,30,30));
        vbFinal.getChildren().addAll(grid);
        
        
        Scene scene = new Scene(vbFinal, 400, 250);
        
        primaryStage.setTitle("Order your dish".toUpperCase());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
