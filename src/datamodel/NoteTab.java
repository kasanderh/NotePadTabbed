package datamodel;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;

public class NoteTab extends Tab {

    @FXML
    private TextArea textArea = new TextArea();

    public NoteTab(String name, String textAreaContent) {
        super(name);
        setClosable(false);
        textArea.setText(textAreaContent);
        setContent(textArea);


    }

    public TextArea getTextArea() {
        return textArea;
    }

    public void setTextAreaStyle(Color color) {
        System.out.println(color);
        textArea.setStyle("-fx-control-inner-background: "+color.toString().replace("0x","#"));


//        double red = color.getRed();
//        double green = color.getGreen();
//        double blue = color.getBlue();
//        System.out.println("Red =" + red);
//        System.out.println("green =" + green);
//        System.out.println("blue =" + blue);
//        textArea.setStyle("-fx-control-inner-background: rgb(" +color.getRed()+ "," +color.getGreen()+ "," + color.getBlue() +")");
//        textArea.setStyle("-fx-control-inner-background: "+color);
//        textArea.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));

    }
}

