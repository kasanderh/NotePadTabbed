package sample;

import datamodel.NoteTab;
import datamodel.NoteTabData;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;



public class NewNoteTabController {

    @FXML
    private TextField nameInsertField;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    public NoteTab processResults() {
        String nameOfTab = nameInsertField.getText();
        Color colorOfTab = colorPicker.getValue();

        NoteTab newNoteTab = new NoteTab(nameOfTab, colorOfTab);
        NoteTabData.getInstance().addNoteTab(newNoteTab);
        return newNoteTab;

    }
    @FXML
    public String getNameOfResults() {
        String nameOfTab = nameInsertField.getText().trim();
        return nameOfTab;
    }
}
