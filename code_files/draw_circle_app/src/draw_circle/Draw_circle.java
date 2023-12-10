/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package draw_circle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author malah
 */
public class Draw_circle extends Application implements Initializable{

    @FXML
    private TextField xAxis;
    @FXML
    private TextField yAxis;
    @FXML
    private Slider rad;
    @FXML
    private Button drw;
    @FXML
    private Button clr;
    @FXML
    private ComboBox<String> combo;
    @FXML
    private Pane panel;
    
    private ObservableList<String> colorList = FXCollections.observableArrayList("White", "Gray", "Blue");
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(Draw_circle.class.getResource("FXML.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 820, 400);
        
        primaryStage.setTitle("Drawing Circles Program");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        panel.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        
        combo.setItems(colorList);
    }
    
    @FXML
    private void onDraw(ActionEvent event) 
    {
        int x = Integer.parseInt(xAxis.getText());
        int y = Integer.parseInt(yAxis.getText());
        int r = (int) rad.getValue();
        
        Circle c = new Circle(x, y, r);
        panel.getChildren().add(c);
    }
    
    @FXML
    private void onClear(ActionEvent event) 
    {
        panel.getChildren().clear();
    }
    
    @FXML
    private void onSelect(ActionEvent event) 
    {
        if(combo.getValue() == "White")
        {
            panel.setStyle("-fx-background-color: White");
        }
        else if(combo.getValue() == "Gray")
        {
            panel.setStyle("-fx-background-color: Gray");
        }
        else if(combo.getValue() == "Blue")
        {
            panel.setStyle("-fx-background-color: Blue");
        }
    }
    
    @FXML
    private void onMouse(MouseEvent event) 
    {
        Circle c = new Circle(event.getX(),event.getY(),20);
        c.setFill(Color.BLUE);
        panel.getChildren().add(c);
    }
}
