package sample;

import datamodel.NoteTab;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Optional;

public class Controller {

    @FXML
    TabPane tabPane = new TabPane();

    @FXML
    NoteTab noteTabTest = new NoteTab("This is a note", "Blue");

    @FXML
    Button saveNoteButton = new Button();

    @FXML
    TextArea textArea = new TextArea();

    @FXML
    public void saveNoteToFile() {
        String savePath = "C:\\Java\\ProjectsKas\\NotePadTabbed\\src\\savednotes\\NewNote.txt";
        ObservableList<CharSequence> paragraph = textArea.getParagraphs();
        Iterator<CharSequence> iter = paragraph.iterator();
        try
        {
            BufferedWriter bf = new BufferedWriter(new FileWriter(new File(savePath)));
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
            System.out.println("You deleted the tab!");
        }
    }


}
