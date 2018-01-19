/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmlsb1;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author hungle
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label setKey; 
    
    @FXML
    private Spinner spinner1; 
    
    @FXML
    private Spinner spinner2; 
    
    @FXML
    private Spinner spinner3; 
    
    @FXML
    private Pane setKeyMatrix; 
    
    @FXML
    private Pane useMatrix; 
    
    @FXML
    private Pane accessMatrix; 
    
    @FXML
    private Pane aaMatrix; 
    
    @FXML
    private Pane caMatrix; 
    
    @FXML
    private TextArea textArea; 
    
    @FXML
    private Button quitButton;
    
    private data savedData; 
    
    public void attributeChanged() {
        System.out.println("User changed the attributes: " + spinner1.getValue()); 
        
        savedData.setAttrs(Integer.parseInt(spinner1.getValue().toString())); 
        if (savedData.getQueries() != 0) {
            useMatrix();
        }
        
        
        System.out.println("In saved data: " + savedData.getAttrs());  
    }
    
    public void queryChanged() {
        System.out.println("User changed the queries: " + spinner2.getValue()); 
        
        savedData.setQueries(Integer.parseInt(spinner2.getValue().toString())); 
        accessMatrix();
        
        System.out.println("In saved query: " + savedData.getQueries());  
    }
    
    public void siteChanged() {
        System.out.println("User changed the sites: " + spinner3.getValue()); 
        
        savedData.setSites(Integer.parseInt(spinner3.getValue().toString())); 
        
        System.out.println("In saved sites: " + savedData.getSites());  
    }
    
    public void addAttrLabel() {
        int x = 20; 
        setKeyMatrix.getChildren().clear(); 
        TextField textField[] = new TextField[15];
        
        for (int i = 1; i < savedData.getAttrs() + 1; i++) {
            //Adding dynamic labels to the GUI
            Label label1 = new Label();
            label1.relocate(x, 30);
            label1.setText("A" + i);
            setKeyMatrix.getChildren().add(label1); 
            
            textField[i] = new TextField();
            textField[i].relocate(x - 5, 55);
            textField[i].setPrefWidth(30);
            
            //Set j to final to put it in textField in the lambda function
            final int j = i; 
            
            textField[i].textProperty().addListener((observable, oldValue, newValue) -> {
                int value = Integer.parseInt(newValue);
                savedData.setAttrsKey(j, value);  
            });
            
            System.out.println("Textfield value in saved: " + savedData.getAttrsKey(j)); 
            
            setKeyMatrix.getChildren().add(textField[i]); 
            
            x = x + 30; 
        }
    }
    
    public void useMatrix() {
        int y = 30; 
        useMatrix.getChildren().clear(); 
        TextField textField[] = new TextField[15];
        
        for (int k = 1; k < savedData.getQueries() + 1; k++) {
            //Adding dynamic labels to the GUI
            Label label1 = new Label();
            label1.relocate(5, y);
            label1.setText("Q" + k);
            useMatrix.getChildren().add(label1); 
            
            int x = 40; 
            
            for (int i = 1; i < savedData.getAttrs() + 1; i++) {
                textField[i] = new TextField();
                textField[i].relocate(x - 5, y);
                textField[i].setPrefWidth(30);
                textField[i].setPrefHeight(27);

                useMatrix.getChildren().add(textField[i]); 
                
                //Save matrix row by row
                final int kfi = k; 
                final int ifi = i; 
                
                textField[i].textProperty().addListener((observable, oldValue, newValue) -> {
                    savedData.useMatrix[kfi][ifi] = Integer.parseInt(newValue);
                });

                x = x + 30; 
            }
            
            y = y + 25; 
        }
        
        int x = 40; 
        for (int i = 1; i < savedData.getAttrs() + 1; i++) {
            //Adding dynamic labels to the GUI
            Label label2 = new Label();
            label2.relocate(x, 0);
            label2.setText("A" + i);
            useMatrix.getChildren().add(label2);

            x = x + 30; 
        }
    }
    
    public void accessMatrix() {
        
        if (savedData.getAttrs() != 0) {
            
        int y = 30; 
        accessMatrix.getChildren().clear(); 
        TextField textField[] = new TextField[15];
        
        for (int k = 1; k < savedData.getQueries() + 1; k++) {
            //Adding dynamic labels to the GUI
            Label label1 = new Label();
            label1.relocate(5, y);
            label1.setText("Q" + k);
            accessMatrix.getChildren().add(label1); 
            
            int x = 40; 
            
            for (int i = 1; i < savedData.getSites() + 1; i++) {
                textField[i] = new TextField();
                textField[i].relocate(x - 5, y);
                textField[i].setPrefWidth(40);
                textField[i].setPrefHeight(27);

                accessMatrix.getChildren().add(textField[i]); 
                
                //Save matrix row by row
                final int kfi = k; 
                final int ifi = i; 
                
                textField[i].textProperty().addListener((observable, oldValue, newValue) -> {
                    System.out.println(kfi + " <==> " + ifi); 
                    savedData.accessMatrix[kfi][ifi] = Integer.parseInt(newValue);
                });

                x = x + 40; 
            }
            
            y = y + 25; 
        }
        
        int x = 40; 
        for (int i = 1; i < savedData.getSites() + 1; i++) {
            //Adding dynamic labels to the GUI
            Label label2 = new Label();
            label2.relocate(x, 0);
            label2.setText("S" + i);
            accessMatrix.getChildren().add(label2);

            textField[i] = new TextField();
            textField[i].relocate(x - 5, 55);
            textField[i].setPrefWidth(30);

            //accessMatrix.getChildren().add(textField[i]); 

            x = x + 40; 
        }
        
        }
    }
    
    public void aaMatrix() {
            
        int y = 30; 
        aaMatrix.getChildren().clear(); 
        TextField textField[] = new TextField[15];
        
        for (int k = 1; k < savedData.getAttrs() + 1; k++) {
            //Adding dynamic labels to the GUI
            Label label1 = new Label();
            label1.relocate(5, y);
            label1.setText("A" + k);
            aaMatrix.getChildren().add(label1); 
            
            int x = 40; 
            
            for (int i = 1; i < savedData.getAttrs() + 1; i++) {
                textField[i] = new TextField();
                textField[i].relocate(x - 5, y);
                textField[i].setPrefWidth(40);
                textField[i].setPrefHeight(27);
                textField[i].setText(Integer.toString(savedData.aaMatrix[k][i])); 
                aaMatrix.getChildren().add(textField[i]); 
                
                x = x + 40; 
            }
            
            y = y + 25; 
        }
        
        int x = 40; 
        for (int i = 1; i < savedData.getAttrs() + 1; i++) {
            //Adding dynamic labels to the GUI
            Label label2 = new Label();
            label2.relocate(x, 0);
            label2.setText("A" + i);
            aaMatrix.getChildren().add(label2);

            x = x + 40; 
        }
        
    }
    
    public void caMatrix() {
            
        int y = 30; 
        caMatrix.getChildren().clear(); 
        TextField textField[] = new TextField[15];
        
        for (int k = 1; k < savedData.getAttrs() + 1; k++) {
            //Adding dynamic labels to the GUI
            Label label1 = new Label();
            label1.relocate(5, y);
            label1.setText("A" + savedData.ca[k-1]);
            caMatrix.getChildren().add(label1); 
            
            int x = 40; 
            
            for (int i = 1; i < savedData.getAttrs() + 1; i++) {
                textField[i] = new TextField();
                textField[i].relocate(x - 5, y);
                textField[i].setPrefWidth(40);
                textField[i].setPrefHeight(27);
                textField[i].setText(Integer.toString(savedData.caMatrix[k][i])); 
                caMatrix.getChildren().add(textField[i]); 
                
                x = x + 40; 
            }
            
            y = y + 25; 
        }
        
        int x = 40; 
        for (int i = 1; i < savedData.getAttrs() + 1; i++) {
            //Adding dynamic labels to the GUI
            Label label2 = new Label();
            label2.relocate(x, 0);
            label2.setText("A" + savedData.ca[i-1]);
            caMatrix.getChildren().add(label2);

            x = x + 40; 
        }
    }
    
    public void process() {
        textArea.clear(); 
        textArea.setText(savedData.processing);
    }
    
    public void calculateClicked() {

        savedData.running(); 
        
        aaMatrix();
        caMatrix(); 
        
        process();
        
    }
    
    public void quitClicked() {
        // get a handle to the stage
        Stage stage = (Stage) quitButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        savedData = new data(); 
        
    }
}
