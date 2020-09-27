package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;


public class NewNoteTabController {

    @FXML
    private TextField nameInsertField;

    @FXML
    private final ColorPicker colorPicker = new ColorPicker();

    @FXML
    public String getNameOfResults() {
        return nameInsertField.getText().trim();
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
