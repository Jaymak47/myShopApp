package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.*;
import javafx.scene.control.*;
import  javafx.geometry.*;
import  javafx.scene.layout.*;
import java.awt.*;

public class AlertBox {
    public static void Display(String title ,String Message){

    Stage Window = new Stage();
    Window.setTitle(title);
    Window.initModality(Modality.APPLICATION_MODAL);

    Label Label1 = new Label(Message);
    Button closeButton = new Button("Close me");
    closeButton.setOnAction(e->Window.close());

    VBox Layout1 = new VBox(20);
    Layout1.getChildren().addAll(Label1,closeButton);

    Scene scene = new Scene(Layout1,400,500);
    Window.setScene(scene);
    Window.showAndWait();
    }
}
