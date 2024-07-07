package com.mycompany.movieticketbookingmanagement.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mycompany.movieticketbookingmanagement.repository.database;
import com.mycompany.movieticketbookingmanagement.repository.getData;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class LoginController implements Initializable {

    @FXML
    private Button singin_btn;

    @FXML
    private Button singin_close;

    @FXML
    private Button singin_createAccount;

    @FXML
    private AnchorPane singin_form;

    @FXML
    private Button singin_minimaze;

    @FXML
    private PasswordField singin_password;

    @FXML
    private TextField singin_username;

    @FXML
    private Button singup_btn;

    @FXML
    private Button singup_close;

    @FXML
    private Button singup_createAccaount;

    @FXML
    private TextField singup_email;

    @FXML
    private AnchorPane singup_form;

    @FXML
    private Button singup_minimaze;

    @FXML
    private PasswordField singup_password;

    @FXML
    private TextField singup_username;

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    public boolean validEmail() {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");

        Matcher match = pattern.matcher(singup_email.getText());

        if (match.find() && match.group().matches(singup_email.getText())) {

            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Invalid Email");
            alert.showAndWait();
        }
        return false;
    }

    public void singup() {
        String sql = "INSERT INTO admin (email,username,password) VALUES (?,?,?)";
        String sql1 = "SELECT username FROM admin WHERE username = ?";
        connect = database.connectDb();

        try {
            if (singup_email.getText().isEmpty() || singup_username.getText().isEmpty()
                    || singup_password.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else if (singup_password.getText().length() < 8) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Password should be at least 8 characters");
                alert.showAndWait();
            } else {
                if (validEmail()) {
                    prepare = connect.prepareStatement(sql1);
                    prepare.setString(1, singup_username.getText());
                    result = prepare.executeQuery();

                    if (result.next()) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText(null);
                        alert.setContentText(singup_username.getText() + " already exists!");
                        alert.showAndWait();
                    } else {
                        prepare = connect.prepareStatement(sql);
                        prepare.setString(1, singup_email.getText());
                        prepare.setString(2, singup_username.getText());
                        prepare.setString(3, singup_password.getText());
                        prepare.execute();

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully created a new account");
                        alert.showAndWait();

                        // Clear the text fields after successful account creation
                        singup_email.setText("");
                        singup_username.setText("");
                        singup_password.setText("");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private double x = 0;
    private double y = 0;

    public void sigin() {
        String sql = "SELECT * FROM admin where username=? and password=?";
        connect = database.connectDb();

        if (connect == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Database Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to connect to the database.");
            alert.showAndWait();
            return;
        }

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, singin_username.getText());
            prepare.setString(2, singin_password.getText());
            result = prepare.executeQuery();

            Alert alert;

            if (singin_username.getText().isEmpty() || singin_password.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please Fill All Blank Field");
                alert.showAndWait();
            } else {
                if (result.next()) {

                    getData.username = singin_username.getText();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Login Successful");
                    alert.showAndWait();

                    singin_btn.getScene().getWindow().hide();

                    try {
                        FXMLLoader loader = new FXMLLoader();
                        URL fxmlLocation = getClass().getResource("/com/mycompany/movieticketbookingmanagement/dashboard.fxml");
                        if (fxmlLocation == null) {
                            System.out.println("Dashboard FXML file not found");
                            return;
                        }
                        loader.setLocation(fxmlLocation);
                        Parent root = loader.load();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));

                        root.setOnMousePressed((MouseEvent event) -> {
                            x=event.getSceneX();
                            y=event.getSceneY();
                        });

                        root.setOnMouseDragged((MouseEvent event) -> {
                            stage.setX(event.getScreenX() - x);
                            stage.setY(event.getScreenY() - y);
                        });

                        stage.initStyle(StageStyle.TRANSPARENT);

                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong Username or Password");
                    alert.showAndWait();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void singin_close() {
        System.exit(0);
    }

    public void singin_minimaze() {
        Stage stage = (Stage) singin_form.getScene().getWindow();
        stage.setIconified(true);
    }

    public void singup_close() {
        System.exit(0);
    }

    public void singup_minimaze() {
        Stage stage = (Stage) singup_form.getScene().getWindow();
        stage.setIconified(true);
    }

    public void switchFrom(ActionEvent event) {
        TranslateTransition translateOut = new TranslateTransition(Duration.millis(600));
        translateOut.setFromY(0);
        translateOut.setToY(singin_form.getLayoutY());

        FadeTransition fadeOut = new FadeTransition(Duration.millis(600));
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);

        ParallelTransition parallelOut = new ParallelTransition(translateOut, fadeOut);

        TranslateTransition translateIn = new TranslateTransition(Duration.millis(600));
        translateIn.setFromX(singin_form.getLayoutX());
        translateIn.setToX(0);

        FadeTransition fadeIn = new FadeTransition(Duration.millis(600));
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);

        ParallelTransition parallelIn = new ParallelTransition(translateIn, fadeIn);

        if (event.getSource() == singin_createAccount) {
            parallelOut.setNode(singin_form);
            parallelOut.setOnFinished(e -> {
                singin_form.setVisible(false);
                singup_form.setVisible(true);
                parallelIn.setNode(singup_form);
                parallelIn.play();
            });
            parallelOut.play();
        } else if (event.getSource() == singup_createAccaount) {
            parallelOut.setNode(singup_form);
            parallelOut.setOnFinished(e -> {
                singup_form.setVisible(false);
                singin_form.setVisible(true);
                parallelIn.setNode(singin_form);
                parallelIn.play();
            });
            parallelOut.play();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
