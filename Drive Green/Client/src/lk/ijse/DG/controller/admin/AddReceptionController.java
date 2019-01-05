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
import lk.ijse.DG.dto.ReceptionDTO;
import lk.ijse.DG.proxy.ProxyHandller;
import lk.ijse.DG.service.ReceptionService;
import lk.ijse.DG.service.ServiceFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class AddReceptionController implements Initializable {

    ReceptionService receptionService = ProxyHandller.getInstance().getSuperService(ProxyHandller.ServiceTypes.RECEPTIONN);
    @FXML
    private AnchorPane loadPane;

    @FXML
    private JFXTextField txtReceptionID;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXTextField txtReceptionName;

    @FXML
    private JFXTextField txtReceptionAddress;

    @FXML
    private JFXTextField txtreceptionTele;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableView<?> tblReception;


    @FXML
    void OnRfour(ActionEvent event) {

    }

    @FXML
    void OnRthree(ActionEvent event) {

    }

    @FXML
    void OnRtwo(ActionEvent event) {

    }

    @FXML
    void txtRone(ActionEvent event) {

    }


    @FXML
    void OnSave(MouseEvent event) throws Exception {
        String RID = txtReceptionID.getText();
        String rname = txtReceptionName.getText();
        String address = txtReceptionAddress.getText();
        String tele = txtreceptionTele.getText();

        boolean respo= receptionService.saveReception(new ReceptionDTO(RID,rname,address,tele));

        if (respo){
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Reception Added Sucsessfuly");
            alert.show();
        }else {
            Alert alert=new Alert(Alert.AlertType.ERROR,"Reception Not Added");

        }
    }

    @FXML
    void OnUpdate(MouseEvent event) {

    }

    @FXML
    void Onsearch(MouseEvent event) {

    }
    @FXML
    void OnDelete(MouseEvent event) {

    }

    public AddReceptionController() throws Exception {
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
