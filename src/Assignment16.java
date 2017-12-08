/*
   Author: Camila Arbaiza

   Professor: Tanes Kanchanawanchai

   Problem 16.3

    (Traffic lights) Write a program that simulates a traffic light. The program lets
    the user select one of three lights: red, yellow, or green. When a radio button
    is selected, the light is turned on. Only one light can be on at a time (see
    Figure 16.37a). No light is on when the program starts.

 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Assignment16 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {


        //Create three circles
        Circle c1 = getCircle();
        Circle c2 = getCircle();
        Circle c3 = getCircle();

        // Create a vbox to place circles
        VBox vBox = new VBox(12);
        vBox.setAlignment(Pos.CENTER);

        // Place circles in vbox
        vBox.getChildren().addAll(c1, c2, c3);

        // Create a rectangle
        Rectangle rectangle = new Rectangle();
        rectangle.setFill(Color.WHITE);
        rectangle.setWidth(30);
        rectangle.setHeight(100);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(2);
        StackPane stackPane = new StackPane(rectangle, vBox);

        // Create radio buttons
        RadioButton red = new RadioButton("Red");
        RadioButton yellow = new RadioButton("Yellow");
        RadioButton green = new RadioButton("Green");

        // Create a hbox to place radio buttons
        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);

        // Create toggle group
        ToggleGroup tGroup = new ToggleGroup();
        red.setToggleGroup(tGroup);
        yellow.setToggleGroup(tGroup);
        green.setToggleGroup(tGroup);
        red.setSelected(true);
        hBox.getChildren().addAll(red, yellow, green);

        // Create a border pane
        BorderPane pane = new BorderPane();
        pane.setCenter(stackPane);
        pane.setBottom(hBox);

        // Create and register handlers
        red.setOnAction(e -> {
            if (red.isSelected()) {
                c1.setFill(Color.RED);
                c2.setFill(Color.WHITE);
                c3.setFill(Color.WHITE);
            }
        });

        yellow.setOnAction(e -> {
            if (yellow.isSelected()) {
                c1.setFill(Color.WHITE);
                c2.setFill(Color.YELLOW);
                c3.setFill(Color.WHITE);
            }
        });

        green.setOnAction(e -> {
            if (green.isSelected()) {
                c1.setFill(Color.WHITE);
                c2.setFill(Color.WHITE);
                c3.setFill(Color.GREEN);
            }
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 200, 150);
        primaryStage.setTitle("Exercise_16_03");   // Set the stage title
        primaryStage.setScene(scene);              // Place the scene in the stage
        primaryStage.show();                       // Display the stage

    }

    /**
     * The getCircle method returns a circle with default properties
     *
     * @return   c
     */
    private Circle getCircle(){
        Circle c = new Circle(10);
        c.setFill(Color.WHITE);
        c.setStroke(Color.BLACK);
        return c;

    }
}
