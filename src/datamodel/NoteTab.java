package datamodel;

import javafx.scene.paint.Color;

public class NoteTab {
    private String name;
    private Color color;

    public NoteTab(String name, Color color) {
        this.name = name;
        this.color = color;
    }


    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
