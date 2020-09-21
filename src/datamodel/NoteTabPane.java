package datamodel;

import javafx.collections.ObservableList;
import javafx.scene.control.Tab;

public class NoteTabPane {
    private static NoteTabPane instance = new NoteTabPane();

    private ObservableList<NoteTab> noteTabsList;

    public static NoteTabPane getInstance() {
        return instance;
    }

    public ObservableList<NoteTab> getNoteTabs() {
        return noteTabsList;
    }

    public void addNoteTab(NoteTab noteTab) {
        noteTabsList.add(noteTab);
    }

    public void deleteNoteTab(Tab noteTab) {
        noteTabsList.remove(noteTab);
    }

//    private FileChooser fileChooser;
//    private final Map<NoteTab, Controller> fileTabControllerMap;
//
//    public NoteTabPane(FileChooser fileChooser, Map<NoteTab, Controller> fileTabControllerMap) {
//        this.fileChooser = fileChooser;
//        this.fileTabControllerMap = fileTabControllerMap;
//        // Set the file extension filter on the Filechooser
//        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Txt Files (*.txt)", "*.txt"));
//    }
//
//    public FileChooser getFileChooser() {
//        return fileChooser;
//    }
//
//    public void addTab(NoteTab noteTab, Controller controller) {
//        fileTabControllerMap.put(noteTab, controller);
//    }
//
//    public void removeTab(NoteTab noteTab) {
//        fileTabControllerMap.remove(noteTab);
//    }
}
