package lk.ijse.DG.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.DG.dto.PaymentDTO;
import lk.ijse.DG.proxy.ProxyHandller;
import lk.ijse.DG.service.PaymentService;
import lk.ijse.DG.service.ServiceFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class AddPaymentsController implements Initializable {

    @FXML
    private AnchorPane loadPane;

    @FXML
    private JFXTextField txtPayID;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXTextField txtPayCategory;

    @FXML
    private JFXTextField txtPayPrice;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    public AddPaymentsController() throws Exception {
    }

    @FXML
    void OnDelete(MouseEvent event) {

    }

    @FXML
    void OnPayCateTwo(ActionEvent event) {

    }

    @FXML
    void OnPayOne(ActionEvent event) {

    }

    @FXML
    void OnPayThree(ActionEvent event) {

    }
    PaymentService paymentService = ProxyHandller.getInstance().getSuperService(ProxyHandller.ServiceTypes.PAYMENT);
    @FXML
    void OnSave(MouseEvent event) throws Exception {

        String paymentID = txtPayID.getText();
        String catogary = txtPayCategory.getText();
        double prize = Double.parseDouble(txtPayPrice.getText());



        boolean responce = paymentService.savePayment(new PaymentDTO(paymentID, catogary, prize));
        if (responce){
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Payment Added Sucsessfuly");
            alert.show();
        }else {
            Alert alert=new Alert(Alert.AlertType.ERROR,"Payment Not Added");

        }
        System.out.println(responce);

    }

    @FXML
    void OnSearch(MouseEvent event) {

    }

    @FXML
    void OnUpdate(MouseEvent event) {

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
