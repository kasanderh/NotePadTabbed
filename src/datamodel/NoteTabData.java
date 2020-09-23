package datamodel;

import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class NoteTabData {
    private static NoteTabData instance = new NoteTabData();

    private ObservableList<NoteTab> noteTabsList;

    public NoteTabData() {
        noteTabsList = new ObservableList<NoteTab>() {
            @Override
            public void addListener(ListChangeListener<? super NoteTab> listChangeListener) {

            }

            @Override
            public void removeListener(ListChangeListener<? super NoteTab> listChangeListener) {

            }

            @Override
            public boolean addAll(NoteTab... noteTabs) {
                return false;
            }

            @Override
            public boolean setAll(NoteTab... noteTabs) {
                return false;
            }

            @Override
            public boolean setAll(Collection<? extends NoteTab> collection) {
                return false;
            }

            @Override
            public boolean removeAll(NoteTab... noteTabs) {
                return false;
            }

            @Override
            public boolean retainAll(NoteTab... noteTabs) {
                return false;
            }

            @Override
            public void remove(int i, int i1) {

            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<NoteTab> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(NoteTab noteTab) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends NoteTab> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends NoteTab> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public NoteTab get(int index) {
                return null;
            }

            @Override
            public NoteTab set(int index, NoteTab element) {
                return null;
            }

            @Override
            public void add(int index, NoteTab element) {

            }

            @Override
            public NoteTab remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<NoteTab> listIterator() {
                return null;
            }

            @Override
            public ListIterator<NoteTab> listIterator(int index) {
                return null;
            }

            @Override
            public List<NoteTab> subList(int fromIndex, int toIndex) {
                return null;
            }

            @Override
            public void addListener(InvalidationListener invalidationListener) {

            }

            @Override
            public void removeListener(InvalidationListener invalidationListener) {

            }
        };
    }

    public static NoteTabData getInstance() {
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

//    public void createNewNoteTabAndAdd(String name, Color color) {
//        try {
//            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/NoteTab.fxml"));
//            Tab tab = fxmlLoader.load();
//            NoteTab newNoteTab = new NoteTab(name, color);
//            fxmlLoader.getController();
//            Controller.gettabPane.getTabs()
//
//        } catch (IOException e) {
//            System.out.println("Error, could not create new tab.");
//            e.printStackTrace();
//        }
//
//
//
//    }

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
