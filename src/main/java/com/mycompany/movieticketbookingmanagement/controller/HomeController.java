package com.mycompany.movieticketbookingmanagement.controller;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HomeController {

    @FXML
    private Button close;

    @FXML
    private Button getStarted;

    @FXML
    private Button minimaze;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setClose(){
        System.exit(0);
    }

    public void setMinimaze(){
        Stage stage = (Stage) minimaze.getScene().getWindow();
        stage.setIconified(true);
    }

    private double x = 0;
    private double y = 0;

    @FXML
    private void switchLogin() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mycompany/movieticketbookingmanagement/login.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            root.setOnMousePressed((MouseEvent event) -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });

            root.setOnMouseDragged((MouseEvent event) -> {
                stage.setX(event.getScreenX() - x);
                stage.setY(event.getScreenY() - y);
            });

            root.translateYProperty().set(scene.getHeight());

            TranslateTransition translateTransition = new TranslateTransition(Duration.millis(600), root);
            translateTransition.setFromY(scene.getHeight());
            translateTransition.setToY(0);

            stage.setScene(scene);
            translateTransition.play();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
