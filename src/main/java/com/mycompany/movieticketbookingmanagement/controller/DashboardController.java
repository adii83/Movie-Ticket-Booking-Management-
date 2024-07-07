/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.movieticketbookingmanagement.controller;

import java.beans.Statement;
import java.io.File;
import java.net.URL;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import com.mycompany.movieticketbookingmanagement.model.CustomerData;
import com.mycompany.movieticketbookingmanagement.model.moviesData;
import com.mycompany.movieticketbookingmanagement.repository.database;
import com.mycompany.movieticketbookingmanagement.repository.getData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;


/**
 * FXML Controller class
 *
 * @author match
 */
public class DashboardController implements Initializable {

    @FXML
    private AnchorPane topForm;
    @FXML
    private Label username;
    @FXML
    private Button close;
    @FXML
    private Button minimaze;
    @FXML
    private Button dasboard_btn;
    @FXML
    private Button addMovies_btn;
    @FXML
    private Button avaibleMovies_btn;
    @FXML
    private Button editScreening_btn;
    @FXML
    private Button customers_btn;
    @FXML
    private Button signOut;
    @FXML
    private AnchorPane dashboard_form;
    @FXML
    private Label dashboard_totalSoldTicked;
    @FXML
    private Label dashboard_totalAvaibleMovies;
    @FXML
    private Label dashboard_totalEarnToday;
    @FXML
    private AnchorPane addMovies_form;
    @FXML
    private ImageView addMovies_imageView;
    @FXML
    private Button addMovies_import;
    @FXML
    private TextField addMovies_movieTitle;
    @FXML
    private TextField addMovies_genre;
    @FXML
    private TextField addMovies_duration;
    @FXML
    private DatePicker addMovies_publishedDate;
    @FXML
    private Button addMovies_insertBtn;
    @FXML
    private Button addMovies_updateBtn;
    @FXML
    private Button addMovies_deleteBtn;
    @FXML
    private Button addMovies_clearBtn;
    @FXML
    private TableView<moviesData> addMovies_tableView;
    @FXML
    private TableColumn<moviesData, String> addMovies_col_movieTitle;
    @FXML
    private TableColumn<moviesData, String> addMovies_col_genre;
    @FXML
    private TableColumn<moviesData, String> addMovies_col_duration;
    @FXML
    private TableColumn<moviesData, Date> addMovies_col_publishedDate;
    @FXML
    private TextField addMovies_search;
    @FXML
    private AnchorPane avaibleMovies_form;
    @FXML
    private Label avaibleMovie_movieTitle;
    @FXML
    private Label avaibleMovie_genre;
    @FXML
    private Label avaibleMovie_date;
    @FXML
    private Button avaibleMovie_selecMovieBtn;
    @FXML
    private TableView<moviesData> avaibleMovie_tableView;
    @FXML
    private TableColumn<moviesData, String> avaibleMovie_col_movieTitle;
    @FXML
    private TableColumn<moviesData, String> avaibleMovie_col_genre;
    @FXML
    private TableColumn<moviesData, String> avaibleMovie_col_ShowingDate;
    @FXML
    private ImageView avaibleMovie_imageView;
    @FXML
    private Label avaibleMovie_title;
    @FXML
    private Spinner<Integer> avaibleMovie_specialClass_quantity;
    @FXML
    private Spinner<Integer> avaibleMovie_normalClass_quantity;
    @FXML
    private Label avaibleMovie_specialClass_price;
    @FXML
    private Label avaibleMovie_normalClass_price;
    @FXML
    private Label avaibleMovie_total;
    @FXML
    private Button avaibleMovie_buyBtn;
    @FXML
    private Button avaibleMovie_receiptBtn;
    @FXML
    private Button avaibleMovie_clearBtn;
    @FXML
    private AnchorPane editScreaning_form;
    @FXML
    private ImageView editScreaning_imageView;
    @FXML
    private Label editScreaning_title;
    @FXML
    private ComboBox<?> editScreaning_current;
    @FXML
    private Button editScreaning_updateBtn;
    @FXML
    private Button editScreaning_deleteBtn;
    @FXML
    private TextField editScreaning_search;
    @FXML
    private TableView<moviesData> editScreaning_tableView;
    @FXML
    private TableColumn<moviesData, String> editScreaning_col_movieTitle;
    @FXML
    private TableColumn<moviesData, String> editScreaning_col_genre;
    @FXML
    private TableColumn<moviesData, String> editScreaning_col_duration;
    @FXML
    private TableColumn<moviesData, String> editScreaning_col_current;
    @FXML
    private AnchorPane customers_form;
    @FXML
    private Label customers_ticketNumber;
    @FXML
    private Label customers_movieTitle;
    @FXML
    private Label customers_genre;
    @FXML
    private Label customers_dateChecked;
    @FXML
    private Label customers_timeChecked;
    @FXML
    private Button customers_clearBtn;
    @FXML
    private Button customers_deleteBtn;
    @FXML
    private TextField customers_search;
    @FXML
    private TableView<CustomerData> customers_tableView;
    @FXML
    private TableColumn<CustomerData, String> customers_col_tickedNumber;
    @FXML
    private TableColumn<CustomerData, String> customers_col_movieTitle;
    @FXML
    private TableColumn<CustomerData, String> customers_col_genre;
    @FXML
    private TableColumn<CustomerData, String> customers_col_dateChecked;
    @FXML
    private TableColumn<CustomerData, String> customers_col_timeChecked;

    /**
     * Initializes the controller class.
     */
    public void close() {
        System.exit(0);
    }

    public void setMinimaze() {
        Stage stage = (Stage) topForm.getScene().getWindow();
        stage.setIconified(true);
    }

    public void displayUsername() {
        username.setText(getData.username);
    }

    private Image image;
    private double x = 0;
    private double y = 0;

    public void logOut() {
        signOut.getScene().getWindow().hide();
        try {
            Parent root = FXMLLoader
                    .load(getClass().getResource("/com/mycompany/movieticketbookingmanagement/login.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);

            root.setOnMousePressed((javafx.scene.input.MouseEvent event) -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });

            root.setOnMouseDragged((javafx.scene.input.MouseEvent event) -> {
                stage.setX(event.getScreenX() - x);
                stage.setY(event.getScreenY() - y);
            });
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // SWITCH FORM CONTROLLER
    public void switchForm(ActionEvent event) {
        if (event.getSource() == dasboard_btn) {
            dashboard_form.setVisible(true);
            addMovies_form.setVisible(false);
            avaibleMovies_form.setVisible(false);
            editScreaning_form.setVisible(false);
            customers_form.setVisible(false);

            dasboard_btn.setStyle("-fx-background-color: #3271d0");
            addMovies_btn.setStyle("-fx-background-color: transparent");
            avaibleMovies_btn.setStyle("-fx-background-color: transparent");
            editScreening_btn.setStyle("-fx-background-color: transparent");
            customers_btn.setStyle("-fx-background-color: transparent");

            displaysTotalSoldTicket();
            displaysTotalIncomeToday();
            displaysTotalAvailableMovies();
        } else if (event.getSource() == addMovies_btn) {

            dashboard_form.setVisible(false);
            addMovies_form.setVisible(true);
            avaibleMovies_form.setVisible(false);
            editScreaning_form.setVisible(false);
            customers_form.setVisible(false);

            addMovies_btn.setStyle("-fx-background-color: #3271d0");
            dasboard_btn.setStyle("-fx-background-color: transparent");
            avaibleMovies_btn.setStyle("-fx-background-color: transparent");
            editScreening_btn.setStyle("-fx-background-color: transparent");
            customers_btn.setStyle("-fx-background-color: transparent");
        } else if (event.getSource() == avaibleMovies_btn) {
            dashboard_form.setVisible(false);
            addMovies_form.setVisible(false);
            avaibleMovies_form.setVisible(true);
            editScreaning_form.setVisible(false);
            customers_form.setVisible(false);

            avaibleMovies_btn.setStyle("-fx-background-color: #3271d0");
            dasboard_btn.setStyle("-fx-background-color: transparent");
            addMovies_btn.setStyle("-fx-background-color: transparent");
            editScreening_btn.setStyle("-fx-background-color: transparent");
            customers_btn.setStyle("-fx-background-color: transparent");

            showAvailableMovies();
        } else if (event.getSource() == editScreening_btn) {
            dashboard_form.setVisible(false);
            addMovies_form.setVisible(false);
            avaibleMovies_form.setVisible(false);
            editScreaning_form.setVisible(true);
            customers_form.setVisible(false);

            editScreening_btn.setStyle("-fx-background-color: #3271d0");
            dasboard_btn.setStyle("-fx-background-color: transparent");
            addMovies_btn.setStyle("-fx-background-color: transparent");
            avaibleMovies_btn.setStyle("-fx-background-color: transparent");
            customers_btn.setStyle("-fx-background-color: transparent");

            showEditScreening();
        } else if (event.getSource() == customers_btn) {
            dashboard_form.setVisible(false);
            addMovies_form.setVisible(false);
            avaibleMovies_form.setVisible(false);
            editScreaning_form.setVisible(false);
            customers_form.setVisible(true);

            customers_btn.setStyle("-fx-background-color: #3271d0");
            dasboard_btn.setStyle("-fx-background-color: transparent");
            addMovies_btn.setStyle("-fx-background-color: transparent");
            avaibleMovies_btn.setStyle("-fx-background-color: transparent");
            editScreening_btn.setStyle("-fx-background-color: transparent");

            showCustomerList();
        }
    }


    //ADD MOVIES CONTROLLER

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;

    private ObservableList<moviesData> listAddMovies;

    public ObservableList<moviesData> addMovieList() {
        ObservableList<moviesData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM movie";
        Connection connect = database.connectDb();

        try {
            PreparedStatement prepare = connect.prepareStatement(sql);
            ResultSet result = prepare.executeQuery();

            while (result.next()) {
                moviesData movD = new moviesData(result.getInt("id"), result.getString("movieTitle"),
                        result.getString("genre"), result.getString("duration"),
                        result.getString("image"), result.getDate("date"),result.getString("current"));

                listData.add(movD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }
    public void showAddMoviesList() {
        listAddMovies = addMovieList();
        addMovies_col_movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        addMovies_col_genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        addMovies_col_duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        addMovies_col_publishedDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        addMovies_tableView.setItems(listAddMovies);
    }


    public void selectAddMoviesList() {
        moviesData movD = addMovies_tableView.getSelectionModel().getSelectedItem();
        int num = addMovies_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        getData.path = movD.getImage();

        addMovies_movieTitle.setText(movD.getTitle());
        addMovies_genre.setText(movD.getGenre());
        addMovies_duration.setText(movD.getDuration());

        if (movD.getDate() != null) {
            // Konversi java.sql.Date ke LocalDate
            addMovies_publishedDate.setValue(movD.getDate().toLocalDate());
        } else {
            addMovies_publishedDate.setValue(null);
        }

        String url = "file:" + movD.getImage();
        image = new Image(url, 127, 161, false, true);
        addMovies_imageView.setImage(image);
    }

    public void importImage() {

        FileChooser open = new FileChooser();
        open.setTitle("Open Image File");
        open.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image File", "*.png", "*.jpg", "*.gif"));

        Stage stage = (Stage) addMovies_form.getScene().getWindow();
        File file = open.showOpenDialog(stage);

        if (file != null) {
            image = new Image(file.toURI().toString(), 127, 161, false, true);
            addMovies_imageView.setImage(image);

            getData.path = file.getAbsolutePath();
        }
    }

    public void insertAddMovies() {
        String sqlCheck = "SELECT movieTitle FROM movie WHERE movieTitle = ?";
        String sqlInsert = "INSERT INTO movie (id, movieTitle, genre, duration, image, date, current) VALUES (?, ?, ?, ?, ?, ?, ?)";

        Connection connect = database.connectDb();
        Alert alert;

        try {
            PreparedStatement checkStmt = connect.prepareStatement(sqlCheck);
            checkStmt.setString(1, addMovies_movieTitle.getText());
            ResultSet result = checkStmt.executeQuery();

            if (result.next()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText(addMovies_movieTitle.getText() + " The title of the film is already there!");
                alert.showAndWait();

            } else {
                if (addMovies_movieTitle.getText().isEmpty()
                        || addMovies_genre.getText().isEmpty()
                        || addMovies_duration.getText().isEmpty()
                        || addMovies_imageView.getImage() == null
                        || addMovies_publishedDate.getValue() == null) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Please fill all blank fields!");
                    alert.showAndWait();
                } else {
                    PreparedStatement insertStmt = connect.prepareStatement(sqlInsert);

                    String url = getData.path.replace("\\", "\\\\");

                    int newMovieId = getNewMovieId(connect);

                    insertStmt.setInt(1, newMovieId);
                    insertStmt.setString(2, addMovies_movieTitle.getText());
                    insertStmt.setString(3, addMovies_genre.getText());
                    insertStmt.setString(4, addMovies_duration.getText());
                    insertStmt.setString(5, url);
                    insertStmt.setDate(6, java.sql.Date.valueOf(addMovies_publishedDate.getValue()));
                    insertStmt.setString(7, "Showing"); // Set current ke "Showing"

                    int rowsAffected = insertStmt.executeUpdate();
                    if (rowsAffected > 0) {
                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Massage");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully Added New Movies");
                        alert.showAndWait();

                        clearAddMovies();
                        showAddMoviesList();
                        showEditScreening();
                        showAvailableMovies(); // Tambahkan ini untuk memperbarui tabel available movies
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Database Error");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred while inserting the movie details.");
            alert.showAndWait();
        } finally {
            try {
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


    // Generate new movie ID (assumes movie IDs are sequential)
    private int getNewMovieId(Connection connect) {
        String sqlCount = "SELECT MAX(id) AS max_id FROM movie";
        try {
            PreparedStatement countStmt = connect.prepareStatement(sqlCount);
            ResultSet result = countStmt.executeQuery();
            if (result.next()) {
                return result.getInt("max_id") + 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1; // Default to 1 if no movies exist
    }

    public void updateAddMovies() {
        // Mengambil jalur gambar
        String url = getData.path;
        url = url.replace("\\", "\\\\");

        // Query SQL untuk update data
        String sql = "UPDATE movie SET movieTitle = ?, genre = ?, duration = ?, image = ?, date = ? WHERE id = ?";

        // Koneksi ke database
        connect = database.connectDb();

        try {
            PreparedStatement preparedStatement = connect.prepareStatement(sql);

            // Memeriksa apakah semua field telah diisi
            if (addMovies_movieTitle.getText().isEmpty()
                    || addMovies_genre.getText().isEmpty()
                    || addMovies_duration.getText().isEmpty()
                    || addMovies_imageView.getImage() == null
                    || addMovies_publishedDate.getValue() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields!");
                alert.showAndWait();
            } else {
                // Mengambil data dari item yang dipilih di tabel
                moviesData selectedMovie = addMovies_tableView.getSelectionModel().getSelectedItem();
                if (selectedMovie == null) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Please select the movie first!");
                    alert.showAndWait();
                    return;
                }

                int movieId = selectedMovie.getId();

                // Menetapkan nilai parameter untuk prepared statement
                preparedStatement.setString(1, addMovies_movieTitle.getText());
                preparedStatement.setString(2, addMovies_genre.getText());
                preparedStatement.setString(3, addMovies_duration.getText());
                preparedStatement.setString(4, url);
                preparedStatement.setDate(5, java.sql.Date.valueOf(addMovies_publishedDate.getValue()));
                preparedStatement.setInt(6, movieId);

                // Menjalankan update
                preparedStatement.executeUpdate();

                // Menampilkan alert informasi
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Succesfully Update " + addMovies_movieTitle.getText());
                alert.showAndWait();

                // Membersihkan field setelah update
                clearAddMovies();
                showAddMoviesList();
            }

        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Database Error");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred while updating the movie details.");
            alert.showAndWait();
        } finally {
            try {
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void clearAddMovies() {
        addMovies_movieTitle.setText("");
        addMovies_genre.setText("");
        addMovies_duration.setText("");
        addMovies_imageView.setImage(null);
        addMovies_publishedDate.setValue(null);
    }


    private int countId;
    private int movieId() {
        String sql = "SELECT count(id) FROM movie";
        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                getData.movieId = result.getInt("count(id)");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    public void deleteAddMovies() {
        String sql = "DELETE FROM movie WHERE movieTitle = ?";
        connect = database.connectDb();

        try {
            if (addMovies_movieTitle.getText().isEmpty()
                    || addMovies_genre.getText().isEmpty()
                    || addMovies_duration.getText().isEmpty()
                    || addMovies_imageView.getImage() == null
                    || addMovies_publishedDate.getValue() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please select the movie to delete!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to delete " + addMovies_movieTitle.getText() + "?");

                Optional<ButtonType> optional = alert.showAndWait();

                if (ButtonType.OK == optional.get()) {
                    PreparedStatement preparedStatement = connect.prepareStatement(sql);
                    preparedStatement.setString(1, addMovies_movieTitle.getText());
                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        showAddMoviesList();
                        clearAddMovies();

                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully deleted!");
                        alert.showAndWait();
                    } else {
                        alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText(null);
                        alert.setContentText("Movie not found!");
                        alert.showAndWait();
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Database Error");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred while deleting the movie.");
            alert.showAndWait();
        } finally {
            try {
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //TEST SEARCH
//    public void loadMoviesFromDatabase() {
//        listAddMovies = FXCollections.observableArrayList();
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//
//        try {
//            // Pastikan koneksi database benar
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviebook", "root", "");
//
//            // Menggunakan PreparedStatement
//            String sql = "SELECT id, movieTitle, genre, duration, image, date FROM movie";
//            pstmt = conn.prepareStatement(sql);
//            rs = pstmt.executeQuery();
//
//            while (rs.next()) {
//                Integer id = rs.getInt("id");
//                String title = rs.getString("movieTitle");
//                String genre = rs.getString("genre");
//                String duration = rs.getString("duration");
//                String image = rs.getString("image");
//                Date date = rs.getDate("date");
//
//                listAddMovies.add(new moviesData(id, title, genre, duration, image, (java.sql.Date) date));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (rs != null) rs.close();
//                if (pstmt != null) pstmt.close();
//                if (conn != null) conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    public void searchAddMovies() {
        if (listAddMovies == null || addMovies_search == null || addMovies_tableView == null) {
            return;
        }

        FilteredList<moviesData> filteredData = new FilteredList<>(listAddMovies, b -> true);
        addMovies_search.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(movie -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (movie.getTitle().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (movie.getGenre().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (movie.getDuration().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (movie.getDate().toString().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });

            SortedList<moviesData> sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(addMovies_tableView.comparatorProperty());
            addMovies_tableView.setItems(sortedData);
        });
    }

    //EDIT SCREENING CONTROLLER

    private String[] currrentList = {"Showing", "End Showing"};

    public void  comboBox(){

        List<String> listCurrent = new ArrayList<>();

        for (String data : currrentList) {
            listCurrent.add(data);
        }

        ObservableList listC = FXCollections.observableArrayList(listCurrent);
        editScreaning_current.setItems(listC);
    }

    public void updateEditScreening() {
        String sql = "UPDATE movie SET current = ? WHERE movieTitle = ?";

        connect = database.connectDb();
        Alert alert;

        try {
            if (editScreaning_title.getText().isEmpty()
                    || editScreaning_imageView.getImage() == null
                    || editScreaning_current.getSelectionModel().isEmpty()) {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please select the movie to update!");
                alert.showAndWait();

            } else {
                String selectedCurrent = String.valueOf(editScreaning_current.getSelectionModel().getSelectedItem());

                PreparedStatement preparedStatement = connect.prepareStatement(sql);
                preparedStatement.setString(1, selectedCurrent);
                preparedStatement.setString(2, editScreaning_title.getText());

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully updated!");
                    alert.showAndWait();

                    showEditScreening();
                    showAvailableMovies(); // Refresh available movies list
                    clearEditScreaning();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Database Error");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred while updating the movie details.");
            alert.showAndWait();
        } finally {
            try {
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


    public void clearEditScreaning(){

        editScreaning_title.setText("");
        editScreaning_imageView.setImage(null);
//        editScreaning_current.setSelectionModel(null);

    }

    public void selectEditScreening() {
        moviesData movD = editScreaning_tableView.getSelectionModel().getSelectedItem();
        int num = editScreaning_tableView.getSelectionModel().getFocusedIndex();

        if ((num - 1) < -1) {
            return;
        }

        String imagePath = movD.getImage();
        File imageFile = new File(imagePath);
        if (!imageFile.exists()) {
            System.err.println("Error: Invalid URL or resource not found - " + imagePath);
            return;
        }

        String url = imageFile.toURI().toString();
        Image image = new Image(url, 143, 194, false, true);
        editScreaning_imageView.setImage(image);

        editScreaning_title.setText(movD.getTitle());
    }

    public ObservableList<moviesData> editScreeningList() {
        ObservableList<moviesData> editSList = FXCollections.observableArrayList();
        String sql = "SELECT * FROM movie";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                String currentStatus = result.getString("current"); // Read as string

                moviesData movD = new moviesData(
                        result.getInt("id"),
                        result.getString("movieTitle"),
                        result.getString("genre"),
                        result.getString("duration"),
                        result.getString("image"),
                        result.getDate("date"),
                        currentStatus
                );

                editSList.add(movD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return editSList;
    }

    public void searchEditScreening() {
        if (editScreeningL == null || editScreaning_search == null || editScreaning_tableView == null) {
            return;
        }

        FilteredList<moviesData> filteredData = new FilteredList<>(editScreeningL, b -> true);
        editScreaning_search.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(movie -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (movie.getTitle().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (movie.getGenre().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (movie.getDuration().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (movie.getCurrent().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (movie.getDate().toString().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });

            SortedList<moviesData> sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(editScreaning_tableView.comparatorProperty());
            editScreaning_tableView.setItems(sortedData);
        });
    }

    private ObservableList<moviesData> editScreeningL;
    public void showEditScreening() {
        editScreeningL = editScreeningList();

        editScreaning_col_movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        editScreaning_col_genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        editScreaning_col_duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        editScreaning_col_current.setCellValueFactory(new PropertyValueFactory<>("current"));

        editScreaning_tableView.setItems(editScreeningL);
    }




    // AVAILABLE MOVIES CONTROLLER
    public ObservableList<moviesData> availableMoviesList() {
        ObservableList<moviesData> listAvMovies = FXCollections.observableArrayList();
        String sql = "SELECT * FROM movie WHERE current = 'Showing'"; // Periksa apakah kondisi boolean benar

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                moviesData movd = new moviesData(
                        result.getInt("id"),
                        result.getString("movieTitle"),
                        result.getString("genre"),
                        result.getString("duration"),
                        result.getString("image"),
                        result.getDate("date"),
                        result.getString("current")
                );

                listAvMovies.add(movd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listAvMovies;
    }



    private ObservableList<moviesData> availableMoviesList;
    public void showAvailableMovies() {
        availableMoviesList = availableMoviesList();

        avaibleMovie_col_movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        avaibleMovie_col_genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        avaibleMovie_col_ShowingDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        avaibleMovie_tableView.setItems(availableMoviesList);
    }







    public void selectAvailableMovies() {
        moviesData movD = avaibleMovie_tableView.getSelectionModel().getSelectedItem();
        int num = avaibleMovie_tableView.getSelectionModel().getSelectedIndex();

        if (num < 0) {
            return;
        }

        avaibleMovie_movieTitle.setText(movD.getTitle());
        avaibleMovie_genre.setText(movD.getGenre());
        avaibleMovie_date.setText(String.valueOf(movD.getDate()));

        getData.path = movD.getImage();
        getData.title = movD.getTitle();

    }

    public void selectMovie() {
        String url = "file:" + getData.path.replace("\\", "/");

        try {
            if(avaibleMovie_movieTitle.getText().isEmpty()
                    || avaibleMovie_genre.getText().isEmpty()
                    || avaibleMovie_date.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please enter a movie title");
                alert.showAndWait();
            } else {
                image = new Image(url, 136, 180, false, true);
                avaibleMovie_imageView.setImage(image);

                avaibleMovie_title.setText(getData.title);

            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid URL: " + url);
            e.printStackTrace();
        }
    }


    private SpinnerValueFactory<Integer> spinner1;
    private SpinnerValueFactory<Integer> spinner2;
    private float price1 =0;
    private float price2 =0;
    private float total = 0;
    private int qty1 = 0;
    private int qty2 = 0;

    public void showSpinnerValue(){

        spinner1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,0);
        spinner2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,0);

        avaibleMovie_specialClass_quantity.setValueFactory(spinner1);
        avaibleMovie_normalClass_quantity.setValueFactory(spinner2);
    }

    public void getSpinnerValue() {
        qty1 = (int) avaibleMovie_specialClass_quantity.getValue();
        qty2 = (int) avaibleMovie_normalClass_quantity.getValue();

        price1 = qty1 * 45000;
        price2 = qty2 * 30000;

        total = price1 + price2;

        // Pastikan Anda memiliki Label untuk menampilkan harga
        avaibleMovie_specialClass_price.setText("Rp " + String.valueOf(price1));
        avaibleMovie_normalClass_price.setText("Rp " + String.valueOf(price2));

        // Menampilkan total harga pada Label
        avaibleMovie_total.setText("Rp " + String.valueOf(total));
    }

    private int num;
    //TABLE CUSTOMER DAN CUSTOMER INFO
    public void buy() {
        String sql = "INSERT INTO customer (type, movieTitle, quantity, total, date, time) VALUES (?, ?, ?, ?, ?, ?)";
        connect = database.connectDb();

        String type = "";
        if (price1 > 0 && price2 == 0) {
            type = "Special Class";
        } else if (price2 > 0 && price1 == 0) {
            type = "Normal Class";
        } else if (price2 > 0 && price1 > 0) {
            type = "Special Class & Normal Class";
        }

        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());

        try {
            LocalTime localeTime = LocalTime.now();
            Time time = Time.valueOf(localeTime);

            int qty = qty1 + qty2;

            prepare = connect.prepareStatement(sql);
            prepare.setString(1, type);
            prepare.setString(2, avaibleMovie_title.getText());
            prepare.setInt(3, qty);  // Pastikan kolom 'quantity' disetel dengan tipe data yang benar
            prepare.setInt(4, (int) total);
            prepare.setDate(5, sqlDate);
            prepare.setTime(6, time);

            if (avaibleMovie_imageView.getImage() == null || avaibleMovie_movieTitle.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please enter a movie title");
                alert.showAndWait();
            } else if (price1 == 0 && price2 == 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please indicate the quantity of ticket you want to purchase");
                alert.showAndWait();
            } else {
                prepare.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully purchased");
                alert.showAndWait();

                String sql1 = "SELECT * FROM customer";

                prepare = connect.prepareStatement(sql1);
                result = prepare.executeQuery();

                num = 0;
                while (result.next()) {
                    num = result.getInt("id");
                }

                String sql2 = "INSERT INTO customer_info (customer_id, type, total, movieTitle, quantity) VALUES (?, ?, ?, ?, ?)";

                prepare = connect.prepareStatement(sql2);
                prepare.setInt(1, num);
                prepare.setString(2, type);
                prepare.setInt(3, (int) total);
                prepare.setString(4, avaibleMovie_title.getText());
                prepare.setInt(5, qty);

                prepare.execute();

                clearPurchaseTicketInfo();
                showAvailableMovies();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void clearPurchaseTicketInfo(){

        spinner1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,0);
        spinner2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,0);

        avaibleMovie_specialClass_quantity.setValueFactory(spinner1);
        avaibleMovie_normalClass_quantity.setValueFactory(spinner2);

        avaibleMovie_specialClass_price.setText("Rp 0");
        avaibleMovie_normalClass_price.setText("Rp 0");
        avaibleMovie_total.setText("Rp 0");

        avaibleMovie_imageView.setImage(null);
        avaibleMovie_title.setText("");

    }



        public void receipt() {

            if (total > 0) {
                HashMap hash = new HashMap();
                hash.put("receipt", num);

            try {
                JasperDesign jDesign = JRXmlLoader.load("src/main/resources/com/mycompany/movieticketbookingmanagement/report/report.jrxml");
                JasperReport jReport = JasperCompileManager.compileReport(jDesign);

                JasperPrint jasperPrint = JasperFillManager.fillReport(jReport,hash,database.connectDb());
                JasperViewer.viewReport(jasperPrint, false);
            } catch (JRException e) {

            }
        }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Invalid");
                alert.showAndWait();
            }
        }

    // CUSTOMER CONTROLLER
    public ObservableList<CustomerData> customerlist(){

        ObservableList<CustomerData> customerL = FXCollections.observableArrayList();

        String sql = "SELECT * FROM customer";

        connect = database.connectDb();

        try {

            CustomerData customerD;

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                customerD = new CustomerData(result.getInt("id"),
                        result.getString("movieTitle"),
                        result.getString("type"),
                        result.getInt("quantity"),
                        result.getDouble("total"),
                        result.getDate("date"),
                                result.getTime("time"));

                customerL.add(customerD);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return customerL;
    }

    private ObservableList<CustomerData> custList;
    public void showCustomerList(){

        custList = customerlist();

        customers_col_tickedNumber.setCellValueFactory(new PropertyValueFactory<>("id"));
        customers_col_movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        customers_col_dateChecked.setCellValueFactory(new PropertyValueFactory<>("date"));
        customers_col_timeChecked.setCellValueFactory(new PropertyValueFactory<>("time"));

        customers_tableView.setItems(custList);
    }

    public void selectCustomerList() {
        CustomerData custD = customers_tableView.getSelectionModel().getSelectedItem();
        int num = customers_tableView.getSelectionModel().getSelectedIndex();

        if (custD == null || num < 0) {
            return;
        }

        customers_ticketNumber.setText(String.valueOf(custD.getId()));
        customers_movieTitle.setText(custD.getTitle());
        customers_dateChecked.setText(String.valueOf(custD.getDate()));
        customers_timeChecked.setText(String.valueOf(custD.getTime()));
    }

    public void clearCustomer(){
        customers_ticketNumber.setText("");
        customers_movieTitle.setText("");
        customers_dateChecked.setText("");
        customers_timeChecked.setText("");
    }

    public void deleteCustomer() {
        String sql = "DELETE FROM customer WHERE id = ?";
        connect = database.connectDb();
        try {
            if (customers_ticketNumber.getText().isEmpty()
                    || customers_movieTitle.getText().isEmpty()
                    || customers_dateChecked.getText().isEmpty()
                    || customers_timeChecked.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please select the customer to delete!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to delete " + customers_movieTitle.getText() + "?");

                Optional<ButtonType> optional = alert.showAndWait();

                if (ButtonType.OK == optional.get()) {
                    PreparedStatement preparedStatement = connect.prepareStatement(sql);
                    preparedStatement.setInt(1, Integer.parseInt(customers_ticketNumber.getText()));
                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        showCustomerList();
                        clearCustomer();

                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully deleted!");
                        alert.showAndWait();
                    } else {
                        alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText(null);
                        alert.setContentText("Customer not found!");
                        alert.showAndWait();
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Database Error");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred while deleting the customer.");
            alert.showAndWait();
        } finally {
            try {
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public void searchCustomer() {
        if (custList == null || customers_search == null || customers_tableView == null) {
            return;
        }

        FilteredList<CustomerData> filteredData = new FilteredList<>(custList, b -> true);
        customers_search.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(customer -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (customer.getTitle().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (customer.getType().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (String.valueOf(customer.getTotal()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (customer.getDate().toString().contains(lowerCaseFilter)) {
                    return true;
                } else if (customer.getTime().toString().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });

            SortedList<CustomerData> sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(customers_tableView.comparatorProperty());
            customers_tableView.setItems(sortedData);
        });
    }

    // DASHBORD CONTROLLER

    private int soldTicket;
    private float totalIncome;
    private int totalMovies;

    public void totalAvailableMovies(){
        String sql = "SELECT count(id) FROM movie WHERE current = 'Showing'";
        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()){
                totalMovies = result.getInt(1);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void totalIncomeToday() {
        LocalDate today = LocalDate.now();
        String sql = "SELECT SUM(total) FROM customer WHERE date = ?";

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setDate(1, Date.valueOf(today));
            result = prepare.executeQuery();

            if (result.next()) {
                totalIncome = result.getFloat(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }




    public void countTicket(){

        String sql = "SELECT count(id) FROM customer";
        connect = database.connectDb();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()){
                soldTicket = result.getInt("count(id)");
            }


        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void displaysTotalSoldTicket(){
        countTicket();
        dashboard_totalSoldTicked.setText(String.valueOf(soldTicket));
    }

    public void displaysTotalIncomeToday(){
        totalIncomeToday();
        dashboard_totalEarnToday.setText("Rp " + String.valueOf(totalIncome));
    }

    public void displaysTotalAvailableMovies(){
        totalAvailableMovies();
        dashboard_totalAvaibleMovies.setText(String.valueOf(totalMovies));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // ADD MOVIES INITIALIZE
        displayUsername();
        //loadMoviesFromDatabase();
        showAddMoviesList();
        searchAddMovies();

        // EDIT SCREENING INITIALIZE
        showEditScreening();
        comboBox();
        searchEditScreening();

        // AVAILABLE MOVIES INITIALIZE
        showAvailableMovies();
        showSpinnerValue();

        //CUSTOMER INITIALIZE
        showCustomerList();

        //DASHBOARD INITIALIZE
        displaysTotalSoldTicket();
        displaysTotalIncomeToday();
        displaysTotalAvailableMovies();
    }
}

