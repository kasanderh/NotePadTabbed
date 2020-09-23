package datamodel;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;

public class NoteTab extends Tab {
    private String name;
    private Color color;

    @FXML
    private Tab tab;

    public NoteTab(String name, Color color) {
       tab = new Tab(name, new TextArea());
//        tab.setText(name);
//        NoteTab.setNewText(name);
        this.color = color;
    }


    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public void setNewText(String name) {
        this.tab.setText(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Node getStyleableNode() {
        return null;
    }
}
