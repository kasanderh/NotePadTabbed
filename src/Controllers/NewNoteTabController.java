package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;


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

    @FXML
    public Color getColorOfResults() {
        colorPicker = new ColorPicker();
        Color colorOfTab = colorPicker.getValue();
        return colorOfTab;
//        Color cssColor = Color.web(colorOfTab.toString());
//        System.out.println(cssColor);
//        return cssColor;

//        EventHandler<ActionEvent> event = new EventHandler<javafx.event.ActionEvent>() {
//            public void handle(ActionEvent e ) {
//                Color c = colorPicker.getValue();
//
//            }
//        }
    }
}
