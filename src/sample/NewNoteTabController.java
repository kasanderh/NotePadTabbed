package sample;

import datamodel.NoteTab;
import datamodel.NoteTabPane;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

import java.awt.*;

public class NewNoteTabController {

    @FXML
    private TextField nameInsertField;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    public NoteTab processResults() {
        String nameOfTab = nameInsertField.getText().trim();
        Color colorOfTab = colorPicker.getValue();

        NoteTab newNoteTab = new NoteTab(nameOfTab, colorOfTab);
        NoteTabPane.getInstance().addNoteTab(newNoteTab);
        return newNoteTab;



    }
}
