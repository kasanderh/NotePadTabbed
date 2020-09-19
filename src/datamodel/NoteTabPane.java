package datamodel;

import javafx.stage.FileChooser;
import sample.Controller;

import java.util.Map;

public class NoteTabPane {
    private FileChooser fileChooser;
    private final Map<NoteTab, Controller> fileTabControllerMap;

    public NoteTabPane(FileChooser fileChooser, Map<NoteTab, Controller> fileTabControllerMap) {
        this.fileChooser = fileChooser;
        this.fileTabControllerMap = fileTabControllerMap;
        // Set the file extension filter on the Filechooser
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Txt Files (*.txt)", "*.txt"));
    }

    public FileChooser getFileChooser() {
        return fileChooser;
    }

    public void addTab(NoteTab noteTab, Controller controller) {
        fileTabControllerMap.put(noteTab, controller);
    }

    public void removeTab(NoteTab noteTab) {
        fileTabControllerMap.remove(noteTab);
    }
}
