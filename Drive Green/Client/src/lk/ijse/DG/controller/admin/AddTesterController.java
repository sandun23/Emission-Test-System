package lk.ijse.DG.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.DG.dto.TesterDTO;
import lk.ijse.DG.proxy.ProxyHandller;
import lk.ijse.DG.service.ServiceFactory;
import lk.ijse.DG.service.TesterService;


import java.net.URL;
import java.util.ResourceBundle;

public class AddTesterController implements Initializable {
    TesterService testerService = ProxyHandller.getInstance().getSuperService(ProxyHandller.ServiceTypes.TESTER);
    @FXML
    private AnchorPane loadPane;

    @FXML
    private JFXTextField txtTesterID;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXTextField txtTesterName;

    @FXML
    private JFXTextField txtTesterAddress;

    @FXML
    private JFXTextField txtTesterTele;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableView<?> tblTester;

    public AddTesterController() throws Exception {
    }

    @FXML
    void OnDelete(MouseEvent event) {

    }

    @FXML
    void OnSave(MouseEvent event) throws Exception {
        String testerid = txtTesterID.getText();
        String name = txtTesterName.getText();
        String address = txtTesterAddress.getText();
        String tele = txtTesterTele.getText();

        boolean save = testerService.saveTester(new TesterDTO(testerid,name,address,tele));
        if (save){
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Tester Added Sucsessfuly");
            alert.show();
        }else {
            Alert alert=new Alert(Alert.AlertType.ERROR,"Tester Not Added");

        }

    }

    @FXML
    void OnSearch(MouseEvent event) {

    }

    @FXML
    void OnTesterAddressThree(ActionEvent event) {

    }

    @FXML
    void OnTesterIDOne(ActionEvent event) {

    }

    @FXML
    void OnTesterNameTwo(ActionEvent event) {

    }

    @FXML
    void OnTesterTeleFour(ActionEvent event) {

    }

    @FXML
    void OnUpdate(MouseEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
