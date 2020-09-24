package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;



public class NewNoteTabController {

    @FXML
    private TextField nameInsertField;

    @FXML
    private ColorPicker colorPicker;

//    @FXML
//    public NoteTab processResults() {
//        String nameOfTab = nameInsertField.getText();
//        Color colorOfTab = colorPicker.getValue();
//
//        NoteTab newNoteTab = new NoteTab(nameOfTab);
//        NoteTabData.getInstance().addNoteTab(newNoteTab);
//        return newNoteTab;
//
//    }
    @FXML
    public String getNameOfResults() {
        String nameOfTab = nameInsertField.getText().trim();
        return nameOfTab;
    }
}
