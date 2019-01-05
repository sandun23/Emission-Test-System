package lk.ijse.DG.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.DG.dto.VehicleDTO;
import lk.ijse.DG.observer.Observer;
import lk.ijse.DG.proxy.ProxyHandller;
import lk.ijse.DG.service.ReceptionService;
import lk.ijse.DG.service.ServiceFactory;
import lk.ijse.DG.service.VehicleService;


import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ResourceBundle;

public class VehicleRegController implements Initializable, Observer {
    @FXML
    private JFXTextField txtVID;

    @FXML
    private JFXTextField txtVehicleReg;

    @FXML
    private JFXTextField txtOwnerName;

    @FXML
    private JFXTextField txtVehicleChassisNO;

    @FXML
    private JFXTextField txtVehicleEngineNo;

    @FXML
    private JFXTextField txtVehicleClass;

    @FXML
    private JFXTextField txtMake;

    @FXML
    private JFXTextField txtModel;

    @FXML
    private JFXTextField txtFuelType;

    @FXML
    private JFXTextField txtYearMFG;

    @FXML
    private JFXButton btnVehicleSave;

    @FXML
    private JFXButton btnVehicleCancel;

    @FXML
    private ImageView imgLogout;


    @FXML
    private JFXTextField txtReceptionID;

    public VehicleRegController() throws Exception {

    }


    @FXML
    void OnLogout(MouseEvent event) throws IOException {
        AnchorPane load = FXMLLoader.load(this.getClass().getResource("/lk/ijse/DG/view/login/ReceptionLogin.fxml"));
        Scene scene = new Scene(load);
        Stage stage = (Stage) this.imgLogout.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void OnReceptionID(ActionEvent event) {

    }

    @FXML
    void OnChNoFour(ActionEvent event) {
        txtVehicleEngineNo.requestFocus();
    }

    @FXML
    void OnClassSix(ActionEvent event) {
        txtMake.requestFocus();
    }

    @FXML
    void OnEngNoFive(ActionEvent event) {
        txtVehicleClass.requestFocus();
    }

    @FXML
    void OnIDOne(ActionEvent event) {
        String id=txtVID.getText();
        if(!id.matches("[0-9 .]+" )){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Vehicle ID ",ButtonType.OK);
            a.show();
            txtVID.selectAll();
            txtVID.requestFocus();
        }else {
            txtVehicleReg.requestFocus();
        }
    }

    @FXML
    void OnMakeSeven(ActionEvent event) {
        txtModel.requestFocus();
    }

    @FXML
    void OnModelEight(ActionEvent event) {
        txtFuelType.requestFocus();
    }

    @FXML
    void OnNameThree(ActionEvent event) {
        String id=txtOwnerName.getText();
        if(!id.matches("[A-Za-z .]+")){
            Alert a = new Alert(Alert.AlertType.WARNING,"Invalid Owner Name",ButtonType.OK);
            a.show();
            txtOwnerName.selectAll();
            txtOwnerName.requestFocus();
        }else {
            txtVehicleChassisNO.requestFocus();
        }

    }

    @FXML
    void OnRegTwo(ActionEvent event) {
        txtOwnerName.requestFocus();
    }

    @FXML
    void OnTypeNine(ActionEvent event) {
        txtYearMFG.requestFocus();
    }

    @FXML
    void OnYearTen(ActionEvent event) {

    }

    @FXML
    void OnVehicleCancel(MouseEvent event) {

    }

    VehicleService vehicleService = ProxyHandller.getInstance().getSuperService(ProxyHandller.ServiceTypes.VEHICLE);
    ReceptionService receptionService = ProxyHandller.getInstance().getSuperService(ProxyHandller.ServiceTypes.RECEPTIONN);

    @FXML
    void OnVehicleSave(MouseEvent event) throws Exception {

        if (validate()) {
            String vehicleID = txtVID.getText();
            String regNo = txtVehicleReg.getText();
            String ownerName = txtOwnerName.getText();
            String chassisNo = txtVehicleChassisNO.getText();
            String enginNo = txtVehicleEngineNo.getText();
            String vclass = txtVehicleClass.getText();
            String make = txtMake.getText();
            String model = txtModel.getText();
            String fuel = txtFuelType.getText();
            String mfg = txtYearMFG.getText();

            boolean respo = vehicleService.addVehicle(new VehicleDTO(
                    vehicleID, chassisNo, enginNo, fuel, make, model, ownerName, vclass, regNo, mfg));
            if (respo) {
                txtVID.clear();
                txtYearMFG.clear();
                txtFuelType.clear();
                txtModel.clear();
                txtMake.clear();
                txtVehicleClass.clear();
                txtVehicleEngineNo.clear();
                txtVehicleChassisNO.clear();
                txtOwnerName.clear();
                txtVehicleReg.clear();

            }
        }
//        if (respo){
//            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Vehicle Added Sucsessfuly");
//            alert.show();
//        }else {
//            Alert alert=new Alert(Alert.AlertType.ERROR,"Vehicle Not Added");
//
//        }


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            UnicastRemoteObject.exportObject(this, 0);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            vehicleService.register(this);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    @Override
    public void update(String message) throws Exception {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    try {
                        Alert a = new Alert(Alert.AlertType.CONFIRMATION, message, ButtonType.OK);
                        a.show();
                        // TestingFormController.loadReception();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        }).start();
    }

    private boolean validate() {
        if (txtVehicleReg.getText().trim().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING, "Some Fileds Are Empty", ButtonType.OK);
            a.show();
            return false;
        } else {
            if (txtOwnerName.getText().trim().isEmpty()) {
                Alert a = new Alert(Alert.AlertType.WARNING, "Some Fileds Are Empty", ButtonType.OK);
                a.show();
                return false;
            } else {
                if (txtVehicleChassisNO.getText().trim().isEmpty()) {
                    Alert a = new Alert(Alert.AlertType.WARNING, "Some Fileds Are Empty", ButtonType.OK);
                    a.show();
                    return false;
                } else {


                    if (txtVehicleEngineNo.getText().trim().isEmpty()) {
                        ;
                        Alert a = new Alert(Alert.AlertType.WARNING, "Some Fileds Are Empty", ButtonType.OK);
                        a.show();
                        return false;

                    } else {
                        if (txtVehicleClass.getText().trim().isEmpty()) {
                            Alert a = new Alert(Alert.AlertType.WARNING, "Some Fileds Are Empty", ButtonType.OK);
                            a.show();
                            return false;
                        } else {
                            if (txtMake.getText().trim().isEmpty()) {
                                Alert a = new Alert(Alert.AlertType.WARNING, "Some Fileds Are Empty", ButtonType.OK);
                                a.show();
                                return false;
                            } else {
                                if (txtModel.getText().trim().isEmpty()) {
                                    Alert a = new Alert(Alert.AlertType.WARNING, "Some Fileds Are Empty", ButtonType.OK);
                                    a.show();
                                    return false;
                                }else {
                                    if (txtFuelType.getText().trim().isEmpty()) {
                                        Alert a = new Alert(Alert.AlertType.WARNING, "Some Fileds Are Empty", ButtonType.OK);
                                        a.show();
                                        return false;
                                    } else {
                                        if (txtYearMFG.getText().trim().isEmpty()) {
                                            Alert a = new Alert(Alert.AlertType.WARNING, "Some Fileds Are Empty", ButtonType.OK);
                                            a.show();
                                            return false;
                                        }
                                    }
                                }
                            }
                        }

                    }
                }
                return true;
            }
        }
    }
}

