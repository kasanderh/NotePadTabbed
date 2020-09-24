package datamodel;

import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;

public class NoteTab extends Tab {
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
}

