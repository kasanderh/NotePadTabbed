package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class Controller {

    @FXML
    Button saveNoteButton = new Button();

    @FXML
    TextArea textArea = new TextArea();

    @FXML
    public void saveNoteToFile() {
        String savePath = "C:\\Java\\ProjectsKas\\NotePadTabbed\\src\\savednotes\\NewNote.txt";
        ObservableList<CharSequence> paragraph = textArea.getParagraphs();
        Iterator<CharSequence> iter = paragraph.iterator();
        try
        {
            BufferedWriter bf = new BufferedWriter(new FileWriter(new File(savePath)));
            while(iter.hasNext())
            {
                CharSequence seq = iter.next();
                bf.append(seq);
                bf.newLine();
            }
            bf.flush();
            bf.close();
        }
        catch (IOException e)
        {
            System.out.println("Could not save file");
            e.printStackTrace();
        }
    }

}
