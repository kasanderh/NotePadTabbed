package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainwindow.fxml"));
        primaryStage.setTitle("Tabulator");
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.show();
        primaryStage.getIcons().add(new Image("/style/icon.png"));
    }


    public static void main(String[] args) {
        launch(args);
    }

    // Event handlers

    @FXML
    public void addNewNote() {

    }

    @FXML
    public void saveNote() {

    }

    @FXML
    public void deleteNote() {

    }

    @FXML
    public void aboutPane() {

    }
}
