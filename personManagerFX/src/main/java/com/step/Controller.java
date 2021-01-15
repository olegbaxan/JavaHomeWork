package com.step;

import com.step.person.Person;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.sql.*;
import java.time.LocalDate;


import static com.step.connection.Connection.initConnection;
import static com.step.person.PersonManager.getAllActiveUsers;

public class Controller {

    ObservableList<Person> personList;
    LocalDate today = LocalDate.now();
    int index = -1;
    String operation = "", sql = "";


    @FXML
    private Pane formPane;
    @FXML
    private Button newBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private Button editBtn;

    @FXML
    private Button cancelBtn;

    @FXML
    private Button enterBtn;

    @FXML
    private TableColumn<Person, Integer> personID;

    @FXML
    private TableColumn<Person, String> personName;

    @FXML
    private TableColumn<Person, String> personSurname;

    @FXML
    private TableColumn<Person, String> personDescription;

    @FXML
    private TableColumn<Person, String> personPhone;

    @FXML
    private TableColumn<Person, String> personMobile;

    @FXML
    private TableColumn<Person, String> personEmail;

    @FXML
    private TableColumn<Person, LocalDate> personRegDate;

    @FXML
    private TableColumn<Person, String> personIDNP;

    @FXML
    private TableView<Person> person;

    @FXML
    private TextField nameTxtForm;

    @FXML
    private TextField surnameTxtForm;

    @FXML
    private TextField phoneTxtForm;

    @FXML
    private TextField mobilTxtForm;

    @FXML
    private TextField emailTxtForm;

    @FXML
    private TextField idnpTxtForm;

    @FXML
    private TextArea descTxtForm;

    @FXML
    void pressAdd(ActionEvent event) {
        updateUser();
        formPane.setDisable(false);
        newBtn.setDisable(true);
        enterBtn.setDisable(false);
        cancelBtn.setDisable(false);
        editBtn.setDisable(true);
        deleteBtn.setDisable(true);
        operation = "N";

    }

    @FXML
    void pressCancel(ActionEvent event) {
        cancelBtn.setDisable(true);
        enterBtn.setDisable(true);
        newBtn.setDisable(false);
        editBtn.setDisable(false);
        deleteBtn.setDisable(false);
        formPane.setDisable(true);
        nameTxtForm.setText("");
        surnameTxtForm.setText("");
        descTxtForm.setText("");
        phoneTxtForm.setText("");
        mobilTxtForm.setText("");
        emailTxtForm.setText("");
        idnpTxtForm.setText("");
    }

    @FXML
    void pressDelete(ActionEvent event) {
        index = person.getSelectionModel().getSelectedIndex();
        sql = "UPDATE step.person SET disabled=true where personid=? ";
        try (Connection connection = initConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, personID.getCellData(index));

            int rows = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
//            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
//            return 0;
        }
        updateUser();
        formPane.setDisable(true);

    }

    @FXML
    void pressEdit(ActionEvent event) {
        operation = "M";
        index = person.getSelectionModel().getSelectedIndex();
        nameTxtForm.setText(personName.getCellData(index));
        surnameTxtForm.setText(personSurname.getCellData(index));
        descTxtForm.setText(personDescription.getCellData(index));
        phoneTxtForm.setText(personPhone.getCellData(index));
        mobilTxtForm.setText(personMobile.getCellData(index));
        emailTxtForm.setText(personEmail.getCellData(index));
        idnpTxtForm.setText(personIDNP.getCellData(index));
        formPane.setDisable(false);
        newBtn.setDisable(true);
        enterBtn.setDisable(false);
        cancelBtn.setDisable(false);
        editBtn.setDisable(true);
        deleteBtn.setDisable(true);
    }

    @FXML
    void pressEnter(ActionEvent event) {
        if (!nameTxtForm.getText().equals("") && !surnameTxtForm.getText().equals("") && !emailTxtForm.getText().equals("") && !idnpTxtForm.getText().equals("")) {
            cancelBtn.setDisable(true);
            enterBtn.setDisable(true);
            newBtn.setDisable(false);
            editBtn.setDisable(false);
            deleteBtn.setDisable(false);
            formPane.setDisable(true);
            System.out.println(nameTxtForm.getText()+" / "+ surnameTxtForm.getText() + " / "+emailTxtForm.getText() +" / "+idnpTxtForm.getText());
            switch (operation) {

                case "N":
                    sql = "INSERT INTO step.person(name, surname,description,phone,mobil,email,regdate,idnp) values(?,?,?,?,?,?,?,?)";
                    try (Connection connection = initConnection();

                         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                        preparedStatement.setString(1, nameTxtForm.getText());
                        preparedStatement.setString(2, surnameTxtForm.getText());
                        preparedStatement.setString(3, descTxtForm.getText());
                        preparedStatement.setString(4, phoneTxtForm.getText());
                        preparedStatement.setString(5, mobilTxtForm.getText());
                        preparedStatement.setString(6, emailTxtForm.getText());
                        preparedStatement.setString(8, idnpTxtForm.getText());
                        preparedStatement.setDate(7, Date.valueOf(today));

                        int rows = preparedStatement.executeUpdate();
                        preparedStatement.close();
                        connection.close();
//            return rows;
                    } catch (SQLException e) {
                        e.printStackTrace();
//            return 0;
                    }
                    updateUser();
                    nameTxtForm.setText("");
                    surnameTxtForm.setText("");
                    descTxtForm.setText("");
                    phoneTxtForm.setText("");
                    mobilTxtForm.setText("");
                    emailTxtForm.setText("");
                    idnpTxtForm.setText("");
                    formPane.setDisable(true);
                    break;
                case "M":
                    index = person.getSelectionModel().getSelectedIndex();
                    sql = "UPDATE step.person SET name=?, surname=?,description=?,phone=?,mobil=?,email=?,idnp=? where personid=? ";
                    try (Connection connection = initConnection();

                         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                        preparedStatement.setString(1, nameTxtForm.getText());
                        preparedStatement.setString(2, surnameTxtForm.getText());
                        preparedStatement.setString(3, descTxtForm.getText());
                        preparedStatement.setString(4, phoneTxtForm.getText());
                        preparedStatement.setString(5, mobilTxtForm.getText());
                        preparedStatement.setString(6, emailTxtForm.getText());
                        preparedStatement.setString(7, idnpTxtForm.getText());
                        preparedStatement.setInt(8, personID.getCellData(index));

                        int rows = preparedStatement.executeUpdate();
                        preparedStatement.close();
                        connection.close();
//            return rows;
                    } catch (SQLException e) {
                        e.printStackTrace();
//            return 0;
                    }
                    updateUser();
                    nameTxtForm.setText("");
                    surnameTxtForm.setText("");
                    descTxtForm.setText("");
                    phoneTxtForm.setText("");
                    mobilTxtForm.setText("");
                    emailTxtForm.setText("");
                    idnpTxtForm.setText("");
                    formPane.setDisable(true);
                    break;
            }

        } else System.out.println("Please enter some data for Person");
    }


    @FXML


    public void updateUser() {
        personID.setCellValueFactory(new PropertyValueFactory<>("personId"));
        personName.setCellValueFactory(new PropertyValueFactory<>("name"));
        personSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        personDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        personPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        personMobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        personEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        personRegDate.setCellValueFactory(new PropertyValueFactory<>("regDate"));
        personIDNP.setCellValueFactory(new PropertyValueFactory<>("idnp"));
        System.out.println("Person LIST " + personList);
        personList = getAllActiveUsers();
        person.setItems(null);
        person.setItems(personList);
    }


}
