/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package project.gr3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SuiteGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(40));

        Text title = new Text("**  Welcome to Hotel System  **");
        title.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 20));
        title.setFill(Color.CRIMSON);
        gridPane.add(title, 0, 0, 8, 1);

        Label descLabel = new Label("Description:");
        TextField descTextField = new TextField();
        
        Label sizeLabel = new Label("Size:");
        TextField sizeTextField = new TextField();

        Label priceLabel = new Label("Price:");
        TextField priceTextField = new TextField();

        Label numOfRoomsLabel = new Label("Number of Rooms:");
        TextField numOfRoomsTextField = new TextField();

        Label maxGuestsLabel = new Label("Max Guests:");
        TextField maxGuestsTextField = new TextField();

        gridPane.add(descLabel, 0, 1);
        gridPane.add(descTextField, 1, 1);
        gridPane.add(sizeLabel, 0, 2);
        gridPane.add(sizeTextField, 1, 2);
        gridPane.add(priceLabel, 0, 3);
        gridPane.add(priceTextField, 1, 3);
        gridPane.add(numOfRoomsLabel, 0, 4);
        gridPane.add(numOfRoomsTextField, 1, 4);
        gridPane.add(maxGuestsLabel, 0, 5);
        gridPane.add(maxGuestsTextField, 1, 5);

        Button addButton = new Button("Add Suite");

        addButton.setTextFill(Color.CRIMSON);

        addButton.setFont(Font.font("FZYaoTi", FontWeight.BOLD, 15));
        gridPane.add(addButton, 1, 6);

        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String desc = descTextField.getText();
                double size = Double.parseDouble(sizeTextField.getText());
                double price = Double.parseDouble(priceTextField.getText());
                int numOfRooms = Integer.parseInt(numOfRoomsTextField.getText());
                int maxGuests = Integer.parseInt(maxGuestsTextField.getText());

                Suite suite = new Suite(desc, size, price, numOfRooms, maxGuests);
                System.out.println("Suite added Successfully");
                Main.rooms.add(suite);
                ;

            }
        });

        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Suite add");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}