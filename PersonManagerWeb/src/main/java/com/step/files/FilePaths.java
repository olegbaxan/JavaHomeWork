package edu.step.files;

import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class FilePaths {
    private static String fileAsString;

    public static String selectFile() {

        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            fileAsString = file.toString();
        }
        return fileAsString;
    }

    public static String selectDirectory() {
        Stage stage = new Stage();
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(new File(System.getProperty("user.dir")+ "\\src\\main\\java"));

        return directoryChooser.showDialog(stage).toString();
    }
}
