package lk.ijse.DG.controller.admin;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminDashboardController implements Initializable {
    @FXML
    private JFXButton btnDashBoard;

    @FXML
    private JFXButton btnAddReception;

    @FXML
    private JFXButton btnAddTester;

    @FXML
    private JFXButton btnAddPayments;

    @FXML
    private JFXButton btnViewTests;

    @FXML
    private JFXButton btnVehicleDetails;

    @FXML
    private JFXButton btnSettings;

    @FXML
    private AnchorPane loadPane;

    @FXML
    private ImageView imgLogout;

    @FXML
    void OnLogout(MouseEvent event) throws IOException {
        AnchorPane load = FXMLLoader.load(this.getClass().getResource("/lk/ijse/DG/view/login/AdminLogin.fxml"));
        Scene scene = new Scene(load);
        Stage stage = (Stage) this.imgLogout.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    @FXML
    void OnPayments(MouseEvent event) throws IOException {
        AnchorPane devicePane =  FXMLLoader.load(this.getClass().getResource("/lk/ijse/DG/view/admin/AddPayments.fxml"));
        loadPane.getChildren().setAll(devicePane);

    }

    @FXML
    void OnReception(MouseEvent event) throws IOException {
        AnchorPane devicePane =  FXMLLoader.load(this.getClass().getResource("/lk/ijse/DG/view/admin/AddReception.fxml"));
        loadPane.getChildren().setAll(devicePane);
    }

    @FXML
    void OnSettings(MouseEvent event) {

    }

    @FXML
    void OnTester(MouseEvent event) throws IOException {
        AnchorPane devicePane =  FXMLLoader.load(this.getClass().getResource("/lk/ijse/DG/view/admin/AddTester.fxml"));
        loadPane.getChildren().setAll(devicePane);
    }

    @FXML
    void OnVehicleDetails(MouseEvent event) {

    }

    @FXML
    void OnViewTests(MouseEvent event) {

    }

    @FXML
    void Ondashboard(MouseEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
