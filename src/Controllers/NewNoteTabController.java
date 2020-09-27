package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;


public class NewNoteTabController {

    @FXML
    private TextField nameInsertField;

    @FXML
    private ColorPicker colorPicker = new ColorPicker();

    @FXML
    public String getNameOfResults() {
        String nameOfTab = nameInsertField.getText().trim();
        return nameOfTab;
    }

    @FXML
    public Color getColorOfResults() {
        Color selectedColor = colorPicker.getValue();
        if(colorPicker.getValue() != null) {
            System.out.println(selectedColor);
            return selectedColor;
        } else {
            System.out.println("No color has been selected");
            return null;
        }
    }
}

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

