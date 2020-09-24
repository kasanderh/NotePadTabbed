package Controllers;

import datamodel.NoteTabData;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
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
    Button saveNoteButton;

    @FXML
    TextArea textArea;

    @FXML
    BorderPane mainBorderpane;

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
        if(file != null) {
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
        alert.setTitle("Delete current note");
        alert.setHeaderText("Delete item: " + selectedTab.getText());
        alert.setContentText("Are you sure? Press OK to confirm, or cancel to back out.");
        Optional<ButtonType> result = alert.showAndWait();

        if(result.isPresent() && (result.get() == ButtonType.OK)) {
            NoteTabData.getInstance().deleteNoteTab(tabPane.getSelectionModel().getSelectedItem());
            tabPane.getTabs().remove(tabPane.getSelectionModel().getSelectedItem());
            System.out.println("You deleted the tab!");
        }
    }

    public Tab newTab(String name) {
        Tab tab = new Tab(name, new TextArea());
        tabPane.getTabs().add(tab);
        tabPane.getSelectionModel().selectLast();
        return tab;
    }

    public void showInfoDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About this application");
        alert.setHeaderText("This is a notepad application where you can open multiple notes at the same time using tabs. \nYou can create, open, save and delete notes." );
        alert.setContentText("\nAuthor: Kasander Hanssen" + "\nSeptember 2020");
        alert.showAndWait();
    }

//    public void openExistingNote() {
//        FileChooser fileChooser = new FileChooser();
//        fileChooser.setTitle("Open an existing Note");
//        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
//        File file = fileChooser.showOpenDialog(new Stage());
//        if(file != null) {
////        String savePath = "C:\\Java\\ProjectsKas\\NotePadTabbed\\src\\savednotes\\NewNote.txt";
////            ObservableList<CharSequence> paragraph = textArea.getParagraphs();
////            Iterator<CharSequence> iter = paragraph.iterator();
//            String input;
//            try {
//                BufferedReader br = new BufferedReader(new FileReader(file));
//                NoteTab newTab = new NoteTab(file.getName(), "");
//                while ((input = br.readLine()) != null) {
//
//                    String lol = br.toString();
//                    textArea.setText(lol);
//                    System.out.println(lol);
//                }
//
//                br.close();
//                System.out.println("File successfully opened!");
//            } catch (IOException e) {
//                System.out.println("Could not open file");
//                e.printStackTrace();
//            }
//        } else {
//            System.out.println("No file selected");
//        }
//    }



//        try(BufferedReader fileToOpen = new BufferedReader(new FileReader(file))) {
//            String input;
////            Tab newTab = newTab(file.getAbsolutePath());
//            NoteTab newTab = new NoteTab(file.getName(), "");
//            String output = "";
//
//            while((input = fileToOpen.readLine()) != null) {
////                textArea.setText(input);
//                input.concat(fileToOpen.next);
//                System.out.println(input);
//            }
//
////            newTab.getTextArea().setText(input);
//
//
//            tabPane.getTabs().add(newTab);
//            tabPane.getSelectionModel().selectLast();
//
//        } catch (IOException e) {
//            System.out.println("Error opening existing note.");
//            e.printStackTrace();
//        }

    }


