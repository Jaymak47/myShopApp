package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.control.Button;

import java.awt.*;


public class ConfirmBox {
            static boolean answer;
            public static boolean Display(String Title, String Message) {
                Stage Window = new Stage();
                Window.initModality(Modality.APPLICATION_MODAL);
                Window.setTitle(Title);

                Button yesButton = new Button("Yes");
                Button noButton = new Button("No");


                yesButton.setOnAction(e -> {
                    answer = true;
                    Window.close();
                });
                noButton.setOnAction(e -> {
                    answer = false;
                    Window.close();
                });

                HBox HB = new HBox(25);
                HB.getChildren().addAll(yesButton,noButton);

                Scene scene = new Scene(HB,200, 400);
                Window.setScene(scene);
                Window.showAndWait();

            return answer;
        }
    }

