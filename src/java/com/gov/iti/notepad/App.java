package com.gov.iti.notepad;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {

        NotepadFXMLBase root = new NotepadFXMLBase();
        stage.setTitle(root.nameFile);

        stage.getIcons().add(new Image(App.class.getResourceAsStream("/notepadIcon.png")));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
