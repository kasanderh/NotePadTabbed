package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * This is a Notepad application where one can open multiple note at the same time using tabs.
 * Built 20-25. September 2020
 * @author Kasanderh
 *
 * Application icon made by srip perfect from www.flaticon.com
 */

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../Views/mainwindow.fxml"));
        primaryStage.setTitle("Tabulator");
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.show();
        primaryStage.getIcons().add(new Image("/graphic/note.png"));

        primaryStage.setOnCloseRequest(evt -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you really want to close the application?", ButtonType.YES, ButtonType.NO);
            ButtonType result = alert.showAndWait().orElse(ButtonType.NO);
            if(ButtonType.NO.equals(result)) {
                evt.consume();
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }


}
