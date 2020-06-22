package com.internshala.connect;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Optional;

public class mymain extends Application {
    private controller control;

    public static void main(String[] args) {
        launch(args);
    }
    public void init() throws Exception{
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("connection.fxml"));
        GridPane rootgrid=loader.load();
        control=loader.getController();
        control.createPlayground();

        MenuBar menui = creatmenu();
        menui.prefWidthProperty().bind(primaryStage.widthProperty());
        Pane menupane=(Pane)rootgrid.getChildren().get(0);
        menupane.getChildren().add(menui);

        Scene scene=new Scene(rootgrid);
        primaryStage.setScene(scene);
        primaryStage.setTitle("CONNECT 4 GAME");
        primaryStage.setResizable(true);
        primaryStage.show();

    }
    public MenuBar creatmenu(){
        Menu filemenu=new Menu("File");
        MenuItem newmenu=new MenuItem("new game");
        MenuItem resetmenu=new MenuItem("reset game");
        SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
        newmenu.setOnAction(event -> {
            control.resetgame();
        });
        resetmenu.setOnAction(event -> {
            control.resetgame();
        });
        MenuItem quit=new MenuItem("quit game");
        quit.setOnAction(event -> {
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("are you sure to want to exit");
            alert.setContentText("confirm?");
            ButtonType yesbtn=new ButtonType("yes");
            ButtonType nobtn=new ButtonType("no");
            alert.getButtonTypes().setAll(yesbtn,nobtn);
            Optional<ButtonType> clickbutton=alert.showAndWait();
            if (clickbutton.isPresent()&&clickbutton.get()==yesbtn)
            {
                Platform.exit();
                System.exit(0);
            }

        });
        filemenu.getItems().addAll(newmenu,resetmenu,quit);

        Menu helpmenu=new Menu("help");
        MenuItem aboutgame=new MenuItem("about connect 4");
        SeparatorMenuItem separator=new SeparatorMenuItem();
        MenuItem aboutme=new MenuItem("about me");

        aboutgame.setOnAction(event -> aboutconnect4());
        aboutme.setOnAction(event -> about());
        helpmenu.getItems().addAll(aboutgame,separator,aboutme);
        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(filemenu,helpmenu);
        return menuBar;
    }

    private void aboutconnect4() {
        Alert alertdialogue=new Alert(Alert.AlertType.INFORMATION);
        alertdialogue.setTitle("About connect Four");
        alertdialogue.setHeaderText("How to play?");
        alertdialogue.setContentText("Connect Four is a two-player connection game in which the"+
                "players first choose a color and then take turns dropping color discs"+
                "from the top into a seven-column,six-row vertically suspended grid"+
                "The pieces fall straight down,occupying the next available space within the column. " +
                "The objective of the game is to be first to form a horizental verticle" +
                "or diagonal line of four of one's own discs.Connect Four is a solved game." +
                "The first player can always win by playing the right moves.");
        alertdialogue.show();
    }

    private void resetGame() {
        System.out.print("bye");
    }

    public void about() {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About the developer");
        alert.setHeaderText("Tanuka Dhar");
        alert.setContentText("I love to play around with code and create games"
        +"Connect Four is one of them. In free time" +
                "I like to spend times with nears and dears");
        alert.show();
    }

    public void stop() throws Exception{
        System.out.println("stop");
        super.stop();


    }
}
