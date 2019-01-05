package lk.ijse.DG.controller.login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.EventHandler;
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

public class TesterLoginController implements Initializable {
    private double xOffset = 0;
    private double yOffset = 0;


    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private ImageView imgClose;

    @FXML
    void OnCloseAction(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void OnLoginAction(MouseEvent event) throws IOException {
        AnchorPane load = FXMLLoader.load(this.getClass().getResource("/lk/ijse/DG/view/TestingForm.fxml"));
        Scene scene = new Scene(load);
        Stage stage = (Stage) this.btnLogin.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

        load.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        load.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
