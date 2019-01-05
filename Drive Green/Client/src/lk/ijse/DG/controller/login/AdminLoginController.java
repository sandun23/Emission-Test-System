package lk.ijse.DG.controller.login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminLoginController implements Initializable {



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

        AnchorPane load = FXMLLoader.load(this.getClass().getResource("/lk/ijse/DG/view/admin/admindashboard.fxml"));
        Scene scene = new Scene(load);
        Stage stage = (Stage) this.btnLogin.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
