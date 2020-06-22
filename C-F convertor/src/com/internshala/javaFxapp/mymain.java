package com.internshala.javaFxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Optional;

public class mymain extends Application {
    public static void main(String[] args) {
        System.out.println("hi");
        launch(args);
    }
    public void init() throws Exception{
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("C-F converter.fxml"));
        Pane rootnode=loader.load();
        MenuBar menu = creatmenu();
        rootnode.getChildren().addAll(menu);
        Scene scene=new Scene(rootnode,300,300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("C-F converter");
        primaryStage.show();

    }
    public MenuBar creatmenu(){
        Menu filemenu=new Menu("File");
        MenuItem newmenu=new MenuItem("new");
        newmenu.setOnAction(event -> {System.out.println("lets start");
        });
        MenuItem quit=new MenuItem("quit");
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
        filemenu.getItems().addAll(newmenu,quit);

        Menu helpmenu=new Menu("help");
        MenuItem about=new MenuItem("about");
        about.setOnAction(event -> about());
        helpmenu.getItems().addAll(about);
        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(filemenu,helpmenu);
        return menuBar;
    }

    public void about() {
        Alert alertdialogue=new Alert(Alert.AlertType.INFORMATION);
        alertdialogue.setTitle("my new application");
        alertdialogue.setHeaderText("C/F converter");
        alertdialogue.setContentText("Hi,I'm Tanuka Dhar,I'm a java developer and develop this project upon C/F converter");
        ButtonType yesbtn=new ButtonType("yes");
        ButtonType nobtn=new ButtonType("no");
        alertdialogue.getButtonTypes().setAll(yesbtn,nobtn);
        Optional<ButtonType> clickbutton=alertdialogue.showAndWait();
        if (clickbutton.isPresent()&&clickbutton.get()==yesbtn)
        {
            System.out.println("you press yes button");
        }
        else if(clickbutton.isPresent()&&clickbutton.get()==nobtn)
        {
            System.out.println("you press no button");
        }


    }

    public void stop() throws Exception{
        System.out.println("stop");
        super.stop();


    }
}
