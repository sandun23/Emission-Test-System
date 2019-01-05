package lk.ijse.DG.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;


import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.DG.db.DBConnection;
import lk.ijse.DG.dto.PaymentDTO;
import lk.ijse.DG.dto.TestDTO;
import lk.ijse.DG.dto.VehicleDTO;
import lk.ijse.DG.observer.Observer;

import lk.ijse.DG.proxy.ProxyHandller;


import lk.ijse.DG.service.PaymentService;
import lk.ijse.DG.service.TestService;
import lk.ijse.DG.service.VehicleService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.*;

public class TestingFormController implements Initializable, Observer {
    private double xOffset = 0;
    private double yOffset = 0;

     VehicleService   vehicleService =ProxyHandller.getInstance().getSuperService(ProxyHandller.ServiceTypes.VEHICLE);
     PaymentService paymentService = ProxyHandller.getInstance().getSuperService(ProxyHandller.ServiceTypes.PAYMENT);




    @FXML
    private JFXTextField txtTestID;

    @FXML
    private JFXTextField txtTesterID;

    @FXML
    private JFXTextField txtVehicleID;

    @FXML
    private JFXTextField txtFee;

    @FXML
    private JFXTextField txtStandardCO2;

    @FXML
    private JFXTextField txtCenter;

    @FXML
    private JFXButton btnSaveTest;

    @FXML
    private JFXButton btnPrintReport;

    @FXML
    private   TableView<VehicleDTO> tblAvailable;

    @FXML
    private JFXButton btnReservation;

    @FXML
    private JFXComboBox<String> cmbCategory;

    @FXML
    private JFXTextField txtIDELCO2;

    @FXML
    private JFXTextField txtRPMCO2;

    @FXML
    private JFXTextField txtTempCO2;

    @FXML
    private JFXTextField txtStandardO2;

    @FXML
    private JFXTextField txtIDELO2;

    @FXML
    private JFXTextField txtRPMO2;

    @FXML
    private JFXTextField txtTempO2;

    @FXML
    private Label lblReport;

    @FXML
    private JFXTextField txtPaymentID;


    @FXML
    private ImageView imgLogout;

    @FXML
    private JFXButton btnUNReservation;

    public TestingFormController() throws Exception {
    }

     public void loadReception() throws Exception {
        List<VehicleDTO> allVehicle =  vehicleService.getAllVehicle();
        tblAvailable.setItems(FXCollections.observableArrayList(allVehicle));


        tblAvailable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("vid"));
        tblAvailable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("ownerName"));
        tblAvailable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("vehicleRegNo"));
        tblAvailable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("model"));
    }

    @FXML
    void OnCO2Eleven(ActionEvent event) {
        String id=txtTempCO2.getText();
        if(!id.matches("[0-9 .]+" )){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Temp value ",ButtonType.OK);
            a.show();
            txtTempCO2.selectAll();
            txtTempCO2.requestFocus();
        }else {
            txtTempO2.requestFocus();
        }

    }

    @FXML
    void OnCO2Five(ActionEvent event) {
        String id=txtStandardCO2 .getText();
        if(!id.matches("[0-9 .]+" )){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Standard value ",ButtonType.OK);
            a.show();
            txtStandardCO2.selectAll();
            txtStandardCO2.requestFocus();
        }else {
            txtStandardO2.requestFocus();
        }


    }

    @FXML
    void OnCO2Nine(ActionEvent event) {
        String id=txtRPMCO2 .getText();
        if(!id.matches("[0-9 .]+" )){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid IDEL value ",ButtonType.OK);
            a.show();
            txtRPMCO2.selectAll();
            txtRPMCO2.requestFocus();
        }else {
            txtRPMO2.requestFocus();
        }

    }

    @FXML
    void OnCO2Seven(ActionEvent event) {
        String id=txtIDELCO2 .getText();
        if(!id.matches("[0-9 .]+" )){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid IDEL value ",ButtonType.OK);
            a.show();
            txtIDELCO2.selectAll();
            txtIDELCO2.requestFocus();
        }else {
            txtIDELO2.requestFocus();
        }

    }

    @FXML
    void OnCenterThree(ActionEvent event) {
        String id=txtCenter.getText();
        if(!id.matches("[A-Za-z .]+")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Center Name",ButtonType.OK);
            a.show();
            txtCenter.selectAll();
            txtCenter.requestFocus();
        }else {
            txtStandardCO2.requestFocus();
        }


    }

    @FXML
    void OnFeeFour(ActionEvent event) {

    }

    @FXML
    void OnO2Eight(ActionEvent event) {
        String id=txtIDELO2 .getText();
        if(!id.matches("[0-9 .]+" )){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid IDEL value ",ButtonType.OK);
            a.show();
            txtIDELO2.selectAll();
            txtIDELO2.requestFocus();
        }else {
            txtRPMCO2.requestFocus();
        }

    }

    @FXML
    void OnO2Six(ActionEvent event) {
        String id=txtStandardO2 .getText();
        if(!id.matches("[0-9 .]+" )){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Standard value ",ButtonType.OK);
            a.show();
            txtStandardO2.selectAll();
            txtStandardO2.requestFocus();
        }else {
            txtIDELCO2.requestFocus();
        }
    }

    @FXML
    void OnO2Ten(ActionEvent event) {
        String id=txtRPMO2 .getText();
        if(!id.matches("[0-9 .]+" )){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid RPM value ",ButtonType.OK);
            a.show();
            txtRPMO2.selectAll();
            txtRPMO2.requestFocus();
        }else {
            txtTempCO2.requestFocus();
        }


    }

    @FXML
    void OnO2Twel(ActionEvent event) {
        int coStandard = Integer.parseInt(txtStandardCO2.getText());
        int oStandard = Integer.parseInt(txtStandardO2.getText());

        if (!(coStandard <= 50)) {
            lblReport.setText("PASS");

        }else {
            lblReport.setText("FAIL");

        }
    }

    @FXML
    void OnPrintReport(MouseEvent event) throws SQLException, IOException, ClassNotFoundException, JRException {
        InputStream inputStream = getClass().getResourceAsStream("D:\\IJSE\\2nd Sem Final Project\\Drive Green\\Client\\src\\lk\\ijse\\DG\\report\\Cherry_Landscape.jasper");
        HashMap map = new HashMap();
        JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, map, DBConnection.getInstance().getConnection());
        JasperViewer.viewReport(jasperPrint, false);


    }

    @FXML
    void OnReservation(MouseEvent event) {

    }

    TestService testService = ProxyHandller.getInstance().getSuperService(ProxyHandller.ServiceTypes.TEST);
    @FXML
    void OnSaveTest(MouseEvent event) {
        System.out.println(validate());
        if(validate()) {
            String tid = txtTestID.getText();
            String center = txtCenter.getText();
            double fee = Double.parseDouble(txtFee.getText());
            String status = lblReport.getText();
            int coStandard = Integer.parseInt(txtStandardCO2.getText());
            int oStandard = Integer.parseInt(txtStandardO2.getText());
            int coIdel = Integer.parseInt(txtIDELCO2.getText());
            int oIdel = Integer.parseInt(txtIDELO2.getText());
            int coRpm = Integer.parseInt(txtRPMCO2.getText());
            int oRpm = Integer.parseInt(txtRPMO2.getText());
            int coTemp = Integer.parseInt(txtTempCO2.getText());
            int oTemp = Integer.parseInt(txtTempO2.getText());
            String vid = txtVehicleID.getText();
            String testerID = txtTesterID.getText();
            String paymentID = txtPaymentID.getText();

            try {
                boolean respo = testService.saveTest(new TestDTO(tid, center, coIdel, coRpm, coStandard, coTemp, oIdel, oRpm, oStandard, oTemp, status, fee, paymentID, testerID, vid));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    private boolean validate() {
        if (txtRPMO2.getText().trim().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING, "Some Fileds Are Empty", ButtonType.OK);
            a.show();
            return false;
        } else {
            if (txtTempO2.getText().trim().isEmpty()) {
                Alert a = new Alert(Alert.AlertType.WARNING, "Some Fileds Are Empty", ButtonType.OK);
                a.show();
                return false;
            } else {
                if (txtTempCO2.getText().trim().isEmpty()) {
                    Alert a = new Alert(Alert.AlertType.WARNING, "Some Fileds Are Empty", ButtonType.OK);
                    a.show();
                    return false;
                } else {


                   if( txtCenter.getText().trim().isEmpty()){;
                    Alert a = new Alert(Alert.AlertType.WARNING, "Some Fileds Are Empty", ButtonType.OK);
                        a.show();
                        return false;

                    }else {
                        if (txtFee.getText().trim().isEmpty()) {
                            Alert a = new Alert(Alert.AlertType.WARNING, "Some Fileds Are Empty", ButtonType.OK);
                            a.show();
                            return false;
                        }else {
                            if (txtTestID.getText().trim().isEmpty()) {
                                Alert a = new Alert(Alert.AlertType.WARNING, "Some Fileds Are Empty", ButtonType.OK);
                                a.show();
                                return false;
                        }}
                    }

                }
            }
            return true;
        }
    }

    @FXML
    void OnTestTwo(ActionEvent event) {
        String id=txtTestID .getText();
        if(!id.matches("[0-9 .]+" )){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Test ID ",ButtonType.OK);
            a.show();
            txtTestID.selectAll();
            txtTestID.requestFocus();
        }else {
            txtCenter.requestFocus();
        }


    }

    @FXML
    void OnUNReservation(MouseEvent event) {

    }

    @FXML
    void OnVehicleOne(ActionEvent event) {

    }

    @FXML
    void cmbSelectCategory(ActionEvent event) throws Exception {
//        PaymentDTO paymentDTO =paymentService.searchbyCategory(cmbCategory.getSelectionModel().getSelectedItem());
        ArrayList<PaymentDTO>dtos= (ArrayList<PaymentDTO>) paymentService.getAllPayments();
        for (PaymentDTO dto:dtos){
            if (dto.getCategory().equalsIgnoreCase(cmbCategory.getSelectionModel().getSelectedItem())){
                //System.out.println(dto.getPid());
                txtPaymentID.setText(dto.getPid());
                //+System.out.println(dto.getPrice());
                txtFee.setText(Double.toString(dto.getPrice()));
            }
        }
//        if (paymentDTO!=null){
//            txtPaymentID.setText(paymentDTO.getPid());
//            txtFee.setText(String.valueOf(paymentDTO.getPrice()));
//            System.out.println(paymentDTO);
//        }

    }

    @FXML
    void OntblClicked(MouseEvent event) {
        VehicleDTO vehicleDTO = tblAvailable.getSelectionModel().getSelectedItem();
        txtVehicleID.setText(""+vehicleDTO.getVid());
//        tblAvailable.getSelectionModel().clearSelection();

        tblAvailable.getSelectionModel().clearSelection();
    }


    @FXML
    void OnLogout(MouseEvent event) throws IOException {
        AnchorPane load = FXMLLoader.load(this.getClass().getResource("/lk/ijse/DG/view/login/TesterLogin.fxml"));
        Scene scene = new Scene(load);
        Stage stage = (Stage) this.imgLogout.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    loadReception();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        },2000);
        try {
            UnicastRemoteObject.exportObject(this,0);
            testService.register(this);

            loadComboPayment();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadComboPayment() throws Exception {
        ArrayList<String> number=paymentService.getAllCategory();
        cmbCategory.getItems().clear();
        for(String s : number){
            cmbCategory.getItems().add(s);
        }
    }


    public void OnFeeFive(ActionEvent actionEvent) {

        String id = txtFee.getText();
        if(!id.matches("[0-9 .]+")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Ammount ",ButtonType.OK);
            a.show();
            txtFee.selectAll();
            txtFee.requestFocus();
        }else {

        }
    }


    @Override
    public void update(String message) throws Exception {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Platform.runLater(()->{
                    try {
                        Alert a=new Alert(Alert.AlertType.CONFIRMATION,message, ButtonType.OK);
                        a.show();
                        loadReception();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        }).start();
    }

    public void OnTesOneOne(ActionEvent actionEvent) {
        String id=txtTesterID .getText();
        if(!id.matches("[0-9 .]+" )){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Tester ID ",ButtonType.OK);
            a.show();
            txtTesterID.selectAll();
            txtTesterID.requestFocus();
        }else {
            txtTestID.requestFocus();
        }

    }
}

