package Controllers;

import datamodel.NoteTab;
import datamodel.NoteTabData;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.Iterator;
import java.util.Optional;

public class Controller {


    @FXML
    TabPane tabPane;

    @FXML
    Button saveNoteButton;

    @FXML
    TextArea textArea;



    @FXML
    public void showNewNoteTabDialog() {
        Dialog<ButtonType> dialog = new Dialog<>();
//        dialog.initOwner(mainBorderpane.getScene().getWindow());
        dialog.setTitle("Add new Note");
        dialog.setHeaderText("Use this dialog to add a new Note");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../Views/newNoteTabDialog.fxml"));
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
        if (result.isPresent() && result.get() == ButtonType.OK) {

            NewNoteTabController controller = fxmlLoader.getController();

            String name = controller.getNameOfResults();
            Color color = controller.getColorOfResults();
//            newTab(name);
            newNoteTab(name, color);
        }
    }

    @FXML
    public void saveNoteToFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Note");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file = fileChooser.showSaveDialog(new Stage());
        if (file != null) {
//        String savePath = "C:\\Java\\ProjectsKas\\NotePadTabbed\\src\\savednotes\\NewNote.txt";
            ObservableList<CharSequence> paragraph = textArea.getParagraphs();
            Iterator<CharSequence> iter = paragraph.iterator();
            try {
                BufferedWriter bf = new BufferedWriter(new FileWriter(file));
                while (iter.hasNext()) {
                    CharSequence seq = iter.next();
                    bf.append(seq);
                    bf.newLine();
                }
                bf.flush();
                bf.close();
                System.out.println("File successfully saved!");
            } catch (IOException e) {
                System.out.println("Could not save file");
                e.printStackTrace();
            }
        } else {
            System.out.println("No file selected");
        }
    }

    @FXML
    public void deleteTabNote() {
        Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Remove current note");
        alert.setHeaderText("Remove item: " + selectedTab.getText());
        alert.setContentText("Are you sure? Unsaved notes will be lost.");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && (result.get() == ButtonType.OK)) {
            NoteTabData.getInstance().deleteNoteTab(tabPane.getSelectionModel().getSelectedItem());
            tabPane.getTabs().remove(tabPane.getSelectionModel().getSelectedItem());
            System.out.println("You removed the note!");
        }
    }

    public Tab newTab(String name) {
        Tab tab = new Tab(name, new TextArea());
        tabPane.getTabs().add(tab);
        tabPane.getSelectionModel().selectLast();

        return tab;
    }

    public NoteTab newNoteTab(String name, Color color) {
        NoteTab newNoteTab = new NoteTab(name, "");
        newNoteTab.setTextAreaStyle(color);
        tabPane.getTabs().add(newNoteTab);
        tabPane.getSelectionModel().selectLast();

        // add eventlistener for ColorPicker here
        // should work with the newly added textAreal.setBackground... code in NoteTab.java

        return newNoteTab;
    }

    public void showInfoDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About this application");
        alert.setHeaderText("This is a notepad application where you can open multiple notes at the same time using tabs. \nYou can create, open, save and delete notes.");
        alert.setContentText("\nAuthor: Kasander Hanssen" + "\nSeptember 2020");
        alert.showAndWait();
    }


    public void openExistingNote() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open an existing Note");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file = fileChooser.showOpenDialog(new Stage());
        try (BufferedReader fileToOpen = new BufferedReader(new FileReader(file))) {
            String input;
            NoteTab newTab = new NoteTab(file.getName(), "");
            String output = "";
            while ((input = fileToOpen.readLine()) != null) {
                output = output.concat(input + "\n");
                newTab.getTextArea().setText(output);
            }
            tabPane.getTabs().add(newTab);
            tabPane.getSelectionModel().selectLast();

        } catch (IOException e) {
            System.out.println("Error opening existing note.");
            e.printStackTrace();
        }

    }

}


