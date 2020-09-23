package sample;

import datamodel.NoteTab;
import datamodel.NoteTabData;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Optional;

public class Controller {


    @FXML
    TabPane tabPane;

    @FXML
    NoteTab noteTabTest = new NoteTab("This is a note", Color.BLUE);

    @FXML
    Button saveNoteButton;

    @FXML
    TextArea textArea;

    @FXML
    BorderPane mainBorderpane;

//    @FXML
//    NoteTabData noteTabPane;

//    @FXML
//    public void initialize() {
//        tabPane.getTabs().set(1, (Tab) NoteTabPane.getInstance().getNoteTabs());
//    }



    @FXML
    public void showNewNoteTabDialog() {
        Dialog<ButtonType> dialog = new Dialog<>();
//        dialog.initOwner(mainBorderpane.getScene().getWindow());
        dialog.setTitle("Add new Note");
        dialog.setHeaderText("Use this dialog to add a new Note");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("newNoteTabDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Could not load the newNoteTabDialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK) {

            NewNoteTabController controller = fxmlLoader.getController();

            String name = controller.getNameOfResults();
            newTab(name);
        }
    }

    @FXML
    public void saveNoteToFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Note");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file = fileChooser.showSaveDialog(new Stage());
//        String savePath = "C:\\Java\\ProjectsKas\\NotePadTabbed\\src\\savednotes\\NewNote.txt";
        ObservableList<CharSequence> paragraph = textArea.getParagraphs();
        Iterator<CharSequence> iter = paragraph.iterator();
        try
        {
            BufferedWriter bf = new BufferedWriter(new FileWriter(file));
            while(iter.hasNext())
            {
                CharSequence seq = iter.next();
                bf.append(seq);
                bf.newLine();
            }
            bf.flush();
            bf.close();
        }
        catch (IOException e)
        {
            System.out.println("Could not save file");
            e.printStackTrace();
        }
    }

    @FXML
    public void deleteTabNote() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete current note");
        alert.setHeaderText("Delete item: " + noteTabTest.getName());
        alert.setContentText("Are you sure? Press OK to confirm, or cancel to back out.");
        Optional<ButtonType> result = alert.showAndWait();

        if(result.isPresent() && (result.get() == ButtonType.OK)) {
            // add the correct code to get the current NoteTab instance.
            NoteTabData.getInstance().deleteNoteTab(tabPane.getSelectionModel().getSelectedItem());
            System.out.println("You deleted the tab!");
        }
    }

    public Tab newTab(String name) {
        Tab tab = new Tab(name, new TextArea());
        tabPane.getTabs().add(tab);
        tabPane.getSelectionModel().selectLast();
        return tab;
    }
}
