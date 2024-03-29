package com.sumoit.connectfour;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game_layout.fxml"));

        GridPane rootGridPane = loader.load();
        MenuBar menuBar= createMenu();

        Pane menuPane= (Pane)rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        controller = loader.getController();
        controller.createPlayGround();
        Scene scene = new Scene(rootGridPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect Four");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private MenuBar createMenu() {
        //FileMenu

        Menu fileMenu = new Menu("File");

        MenuItem newGame = new MenuItem("New Game");
        newGame.setOnAction(event -> controller.resetGame());
        MenuItem resetGame = new MenuItem("Reset Game");
        resetGame.setOnAction(event -> controller.resetGame());
        MenuItem exitGame = new MenuItem("Exit Game");
        exitGame.setOnAction(event -> exitGame());
        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        //helpMenu
        Menu helpMenu= new Menu("Help");
        MenuItem aboutGame = new MenuItem("About Connect four");
        aboutGame.setOnAction(event -> aboutConnect4()
        );
        MenuItem aboutMe =new MenuItem("About Me");
        aboutMe.setOnAction(event ->
            aboutMe()
        );
        SeparatorMenuItem separator= new SeparatorMenuItem();
        helpMenu.getItems().addAll(aboutGame,separator ,aboutMe);

        MenuBar menuBar = new MenuBar();
        fileMenu.getItems().addAll(newGame, resetGame, separatorMenuItem, exitGame);

        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return  menuBar;
    }

    private void aboutMe() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Developer !");
        alert.setHeaderText("Sudarshan Damahe");
        alert.setContentText("I love To Play This Game . Whenever You Have Free Time Lets Play Game With Your ChildHood and Neighbour's");
        alert.show();
    }

    private void aboutConnect4() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect Four");
        alert.setHeaderText("How To Play ?");
        alert.setContentText("Connect Four is a two-player connection game in which the players first choose a color and then take turns dropping colored discs from the top into a seven-column, six-row vertically suspended grid. The pieces fall straight down, occupying the next available space within the column. The objective of the game is to be the first to form a horizontal, vertical, or diagonal line of four of one's own discs. Connect Four is a solved game. The first player can always win by playing the right moves.\n" +
                "\n");
        alert.show();
    }

    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }
}




