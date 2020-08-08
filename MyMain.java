package com.internshala.newjavafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain  extends Application {
	private Controller controller;
	public static void main (String [] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();
		controller=loader.getController();
		MenuBar menuBar =  createMenu();
		rootNode.getChildren().add(0,menuBar);

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Convertor Tool");
		primaryStage.setResizable(false);
		primaryStage.show();

	}
	private MenuBar createMenu(){
		//File Menu
		Menu fileMenu = new Menu("File");
		MenuItem newMenuItem = new MenuItem("New");
		newMenuItem.setOnAction(event ->
            controller.reset());
		MenuItem quitMenuItem = new MenuItem("Quit");
		quitMenuItem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});
		SeparatorMenuItem separatorMenuItem;
		separatorMenuItem = new SeparatorMenuItem();
		fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);

		//Help Menu
		Menu helpMenu = new Menu("Help");
		MenuItem aboutApp = new MenuItem("About");
		aboutApp.setOnAction(event-> aboutApp());
		helpMenu.getItems().addAll(aboutApp);

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu,helpMenu);
		return menuBar;

	}

	public static  void aboutApp() {
		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("My First desktop App");
		alertDialog.setHeaderText(" Temperature Converter Tool");
		alertDialog.setContentText("This application will help to convert a temperature from celsius to fahrenheit and vice - versa.");

		alertDialog.show();

	}


}
