package com.gov.iti.notepad;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

public class NotepadFXMLBase extends BorderPane {

    protected final MenuBar menuBar;
    protected final Menu fileMenu;
    protected final MenuItem newFileMenuItem;
    protected final MenuItem openFileMenuItem;
    protected final MenuItem saveFileMenuItem;
    protected final SeparatorMenuItem separatorMenuItem;
    protected final MenuItem exitFileMenuItem;
    protected final Menu editMenu;
    protected final MenuItem undoEditMenuItem;
    protected final SeparatorMenuItem separatorMenuItem0;
    protected final MenuItem cutEditMenuItem;
    protected final MenuItem copyEditMenuItem;
    protected final MenuItem pasteEditMenuItem;
    protected final MenuItem deleteEditMenuItem;
    protected final SeparatorMenuItem separatorMenuItem1;
    protected final MenuItem selectAllEditMenuItem;
    protected final Menu helpMenu;
    protected final MenuItem aboutHelpMenuItem;
    protected final TextArea textArea;
    protected final HBox hBox;
    protected final Label label;

    protected ObservableList<CharSequence> lineList;

    protected String nameFile = "Untitled - Notepad";

    App app = new App();
            
    public NotepadFXMLBase() {

        menuBar = new MenuBar();
        fileMenu = new Menu();
        newFileMenuItem = new MenuItem();
        openFileMenuItem = new MenuItem();
        saveFileMenuItem = new MenuItem();
        separatorMenuItem = new SeparatorMenuItem();
        exitFileMenuItem = new MenuItem();
        editMenu = new Menu();
        undoEditMenuItem = new MenuItem();
        separatorMenuItem0 = new SeparatorMenuItem();
        cutEditMenuItem = new MenuItem();
        copyEditMenuItem = new MenuItem();
        pasteEditMenuItem = new MenuItem();
        deleteEditMenuItem = new MenuItem();
        separatorMenuItem1 = new SeparatorMenuItem();
        selectAllEditMenuItem = new MenuItem();
        helpMenu = new Menu();
        aboutHelpMenuItem = new MenuItem();
        textArea = new TextArea();
        hBox = new HBox();
        label = new Label();

        setId("root");
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(menuBar, javafx.geometry.Pos.CENTER);
        menuBar.setUseSystemMenuBar(true);
        menuBar.setStyle("-fx-background-color: white;");

        fileMenu.setText("_File");
        fileMenu.setMnemonicParsing(true);

        newFileMenuItem.setId("newMenuItem");
        newFileMenuItem.setMnemonicParsing(false);
        newFileMenuItem.setText("New");
        newFileMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
        newFileMenuItem.setOnAction((ActionEvent ActionEvent) -> {
            textArea.clear();
        });

        openFileMenuItem.setId("openMenuItem");
        openFileMenuItem.setMnemonicParsing(false);
        openFileMenuItem.setText("Open...");
        openFileMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
        openFileMenuItem.setOnAction((ActionEvent ActionEvent) -> {
            openFileMenuItemEvent();
        });

        saveFileMenuItem.setId("saveMenuItem");
        saveFileMenuItem.setMnemonicParsing(false);
        saveFileMenuItem.setText("Save");
        saveFileMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
        saveFileMenuItem.setOnAction((ActionEvent ActionEvent) -> {
            saveFileMenuItemEvent();
        });

        separatorMenuItem.setMnemonicParsing(false);

        exitFileMenuItem.setId("exitMenuItem");
        exitFileMenuItem.setMnemonicParsing(false);
        exitFileMenuItem.setText("Exit");
        exitFileMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.W, KeyCombination.CONTROL_DOWN));
        exitFileMenuItem.setOnAction((ActionEvent ActionEvent) -> {
            exitFileMenuItemEvent();
        });

        editMenu.setText("_Edit");
        editMenu.setMnemonicParsing(true);

        undoEditMenuItem.setId("undoMenuItem");
        undoEditMenuItem.setMnemonicParsing(false);
        undoEditMenuItem.setText("Undo");
        undoEditMenuItem.setOnAction((ActionEvent ActionEvent) -> {
            textArea.undo();
        });

        separatorMenuItem0.setMnemonicParsing(false);

        cutEditMenuItem.setId("cutMenuItem");
        cutEditMenuItem.setMnemonicParsing(false);
        cutEditMenuItem.setText("Cut");
        cutEditMenuItem.setOnAction((ActionEvent ActionEvent) -> {
            textArea.cut();
        });

        copyEditMenuItem.setId("copyMenuItem");
        copyEditMenuItem.setMnemonicParsing(false);
        copyEditMenuItem.setText("Copy");
        copyEditMenuItem.setOnAction((ActionEvent ActionEvent) -> {
            textArea.copy();
        });

        pasteEditMenuItem.setId("pasteMenuItem");
        pasteEditMenuItem.setMnemonicParsing(false);
        pasteEditMenuItem.setText("Paste");
        pasteEditMenuItem.setOnAction((ActionEvent ActionEvent) -> {
            textArea.paste();
        });

        deleteEditMenuItem.setId("deleteMenuItem");
        deleteEditMenuItem.setMnemonicParsing(false);
        deleteEditMenuItem.setText("Delete");
        deleteEditMenuItem.setOnAction((ActionEvent ActionEvent) -> {
            textArea.replaceSelection("");
        });

        separatorMenuItem1.setMnemonicParsing(false);

        selectAllEditMenuItem.setId("selectAllMenuItem");
        selectAllEditMenuItem.setMnemonicParsing(false);
        selectAllEditMenuItem.setText("Select All");
        selectAllEditMenuItem.setOnAction((ActionEvent e) -> {
            textArea.selectAll();
        });

        helpMenu.setText("_Help");
        helpMenu.setMnemonicParsing(true);

        aboutHelpMenuItem.setMnemonicParsing(false);
        aboutHelpMenuItem.setText("About");
        aboutHelpMenuItem.setOnAction((ActionEvent ActionEvent) -> {
            aboutHelpMenuItemEvent();
        });

        setTop(menuBar);

        BorderPane.setAlignment(textArea, javafx.geometry.Pos.CENTER);
        textArea.setId("textArea");
        textArea.setPrefHeight(200.0);
        textArea.setPrefWidth(200.0);
        textArea.setWrapText(true);
        textArea.setFont(new Font("Consolas", 18.0));
        textArea.setPadding(new Insets(3.0));
        textArea.setStyle("-fx-background-color: transparent, white, transparent, white;");

        textArea.setOnKeyTyped(KeyEvent -> {
            // ObservableList allows us to add listeners into the list so that we can execute some logic when the contents of the list is changed. 
            lineList = textArea.getParagraphs();
            label.setText("Line " + lineList.size() + ", Col " + (textArea.getLength() + 1));
        });

        setCenter(textArea);

        BorderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(25.0);
        hBox.setPrefWidth(600.0);

        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        HBox.setMargin(label, new Insets(3.0, 0.0, 3.0, 5.0));
        setBottom(hBox);

        fileMenu.getItems().add(newFileMenuItem);
        fileMenu.getItems().add(openFileMenuItem);
        fileMenu.getItems().add(saveFileMenuItem);
        fileMenu.getItems().add(separatorMenuItem);
        fileMenu.getItems().add(exitFileMenuItem);
        menuBar.getMenus().add(fileMenu);
        editMenu.getItems().add(undoEditMenuItem);
        editMenu.getItems().add(separatorMenuItem0);
        editMenu.getItems().add(cutEditMenuItem);
        editMenu.getItems().add(copyEditMenuItem);
        editMenu.getItems().add(pasteEditMenuItem);
        editMenu.getItems().add(deleteEditMenuItem);
        editMenu.getItems().add(separatorMenuItem1);
        editMenu.getItems().add(selectAllEditMenuItem);
        menuBar.getMenus().add(editMenu);
        helpMenu.getItems().add(aboutHelpMenuItem);
        menuBar.getMenus().add(helpMenu);
        hBox.getChildren().add(label);
    }

    public void openFileMenuItemEvent() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt"));
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            try {
                Scanner scanner;
                scanner = new Scanner(selectedFile);
                while (scanner.hasNextLine()) {
                    textArea.setText(scanner.nextLine() + '\n');
                }
                scanner.close();
                
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("name file 'open' -> " + nameFile);
    }

    public void saveFileMenuItemEvent() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt"));
        File saveFile = fileChooser.showSaveDialog(null);

        try {
            FileWriter fileWriter;
            fileWriter = new FileWriter(saveFile);
            fileWriter.write(textArea.getText());
            fileWriter.close();
            nameFile = saveFile.getName();
        } catch (IOException e) {
            System.out.println("Error in FileWriter (Save File) -> " + e.getMessage());
        }
        System.out.println("name file 'save' -> " + nameFile);

    }

    public void exitFileMenuItemEvent() {
        if (textArea.getText().isEmpty()) {
            System.exit(0);
        }
        Alert alert = new Alert(
                Alert.AlertType.CONFIRMATION,
                "Do you want to exit without saving?",
                ButtonType.YES,
                ButtonType.NO,
                ButtonType.CANCEL
        );
        alert.setTitle("Confirm");
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            System.exit(0);
        }
        if (alert.getResult() == ButtonType.NO) {
            saveFileMenuItemEvent();
            System.exit(0);
        }
    }

    public void aboutHelpMenuItemEvent() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Notepad - Version 1.0");
        alert.setContentText("Made By - Karim Taha");
        alert.setTitle("About Notepad");
        alert.showAndWait();
    }
}
