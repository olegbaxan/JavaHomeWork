package com.step;

import com.step.person.Person;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;


import static com.step.connection.Connection.initConnection;
import static com.step.read.ReadPersonDataFromFile.readPersonFromFile;
import static com.step.read.ReadPersonDataFromXML_SAX.readPersonDataFromXML;
import static com.step.write.WritePersonDataToFile.savePersonDataToCSV;
import static com.step.write.WritePersonDataToXML.savePersonDataToXml;
import static javafx.application.Platform.exit;

public class Controller implements Initializable {
    private static ObservableList<Person> personList = FXCollections.observableArrayList(
            (Person personModel) -> new Observable[]{personModel.personIdProperty(), personModel.nameProperty(), personModel.surnameProperty(),
                    personModel.descriptionProperty(), personModel.phoneProperty(), personModel.mobileProperty(), personModel.emailProperty(),
                    personModel.regDateProperty(), personModel.idnpProperty(), personModel.birthdayProperty()});
    LocalDate today = LocalDate.now();
    int index = -1;
    int numberOfTableRows, numberOfTotalRows;
    String operation = "", sql = "";


    @FXML
    private Pane personFormPane;
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
    private Button searchBtn;

    @FXML
    private Button searchResetBtn;

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
    private TableColumn<Person, LocalDate> personBirthday;

    @FXML
    private TableView<Person> personTable;

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
    private DatePicker birthDayPicker;
    @FXML
    private Pane personBtnPane;
    @FXML
    private Pane mainPagePane;

    @FXML
    private Label displayedRows;

    @FXML
    private Label totalRows;
    @FXML
    private Tab mainTab;

    @FXML
    private Tab personTab;
    @FXML
    private TextField searchTextField;
    @FXML
    private AnchorPane personPageAnchorPane;
    @FXML
    private MenuItem newPersonMenuId;

    @FXML
    private MenuItem deletePersonMenuId;

    @FXML
    private MenuItem editPersonMenuId;


    @FXML
    void menuHome(MouseEvent event) {

    }

    @FXML
    void menuPerson(MouseEvent event) {

    }


    @FXML
    void pressNewBtn(ActionEvent event) {
        personFormPane.setDisable(false);
        newBtn.setDisable(true);
        enterBtn.setDisable(false);
        cancelBtn.setDisable(false);
        editBtn.setDisable(true);
        deleteBtn.setDisable(true);
        operation = "N";
        newPersonMenuId.setDisable(true);
        deletePersonMenuId.setDisable(true);
        editPersonMenuId.setDisable(true);
        personFormPane.setVisible(true);
        personTable.setPrefHeight(personTable.getPrefHeight() - personFormPane.getPrefHeight());
        personPageAnchorPane.setBottomAnchor(personTable, personPageAnchorPane.getBottomAnchor(personTable) + personFormPane.getPrefHeight());

    }

    @FXML
    void newPersonMenu(ActionEvent event) {
        personFormPane.setDisable(false);
        newBtn.setDisable(true);
        enterBtn.setDisable(false);
        cancelBtn.setDisable(false);
        editBtn.setDisable(true);
        deleteBtn.setDisable(true);
        operation = "N";
        newPersonMenuId.setDisable(true);
        deletePersonMenuId.setDisable(true);
        editPersonMenuId.setDisable(true);
        personFormPane.setVisible(true);
        personTable.setPrefHeight(personTable.getPrefHeight() - personFormPane.getPrefHeight());
        personPageAnchorPane.setBottomAnchor(personTable, personPageAnchorPane.getBottomAnchor(personTable) + personFormPane.getPrefHeight());
    }

    @FXML
    void pressCancel(ActionEvent event) {
        cancelBtn.setDisable(true);
        enterBtn.setDisable(true);
        newBtn.setDisable(false);
        editBtn.setDisable(false);
        deleteBtn.setDisable(false);

        nameTxtForm.setText("");
        surnameTxtForm.setText("");
        descTxtForm.setText("");
        phoneTxtForm.setText("");
        mobilTxtForm.setText("");
        emailTxtForm.setText("");
        idnpTxtForm.setText("");
        newPersonMenuId.setDisable(false);
        deletePersonMenuId.setDisable(false);
        editPersonMenuId.setDisable(false);
        birthDayPicker.setValue(null);
        personFormPane.setVisible(false);
        personTable.setPrefHeight(personTable.getPrefHeight() + personFormPane.getPrefHeight());
        personPageAnchorPane.setBottomAnchor(personTable, personPageAnchorPane.getBottomAnchor(personTable) - personFormPane.getPrefHeight());

    }

    @FXML
    void pressDelete(ActionEvent event) {
        if (!personTable.getSelectionModel().isEmpty()) {
            index = personTable.getSelectionModel().getSelectedIndex();

            sql = "UPDATE step.person SET disabled=true where personid=?";
            try (Connection connection = initConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, personID.getCellData(index));

                int rows = preparedStatement.executeUpdate();
                preparedStatement.close();
                this.personList.remove(index);
                connection.close();
//            return rows;
            } catch (SQLException e) {
                e.printStackTrace();
//            return 0;
            }

            personFormPane.setDisable(false);
            setTotalValuesInTable();
            newPersonMenuId.setDisable(true);
            deletePersonMenuId.setDisable(true);
            editPersonMenuId.setDisable(true);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "");
            alert.setTitle("Warning error");
            alert.setContentText("Please select an item from Table to continue");
            Optional<ButtonType> result = alert.showAndWait();
        }

    }

    @FXML
    void deletePersonMenu(ActionEvent event) {
        if (!personTable.getSelectionModel().isEmpty()) {
            index = personTable.getSelectionModel().getSelectedIndex();

            sql = "UPDATE step.person SET disabled=true where personid=?";
            try (Connection connection = initConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, personID.getCellData(index));

                int rows = preparedStatement.executeUpdate();
                preparedStatement.close();
                this.personList.remove(index);
                connection.close();
//            return rows;
            } catch (SQLException e) {
                e.printStackTrace();
//            return 0;
            }

            personFormPane.setDisable(false);
            setTotalValuesInTable();
            newPersonMenuId.setDisable(true);
            deletePersonMenuId.setDisable(true);
            editPersonMenuId.setDisable(true);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "");
            alert.setTitle("Warning error");
            alert.setContentText("Please select an item from Table to continue");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }


    @FXML
    void pressEdit(ActionEvent event) {
        if (!personTable.getSelectionModel().isEmpty()) {
            operation = "M";

            index = personTable.getSelectionModel().getSelectedIndex();
            nameTxtForm.setText(personName.getCellData(index));
            surnameTxtForm.setText(personSurname.getCellData(index));
            descTxtForm.setText(personDescription.getCellData(index));
            phoneTxtForm.setText(personPhone.getCellData(index));
            mobilTxtForm.setText(personMobile.getCellData(index));
            emailTxtForm.setText(personEmail.getCellData(index));
            idnpTxtForm.setText(personIDNP.getCellData(index));
            birthDayPicker.setValue((LocalDate) personBirthday.getCellData(index));
            personFormPane.setDisable(false);
            newBtn.setDisable(true);
            enterBtn.setDisable(false);
            cancelBtn.setDisable(false);
            editBtn.setDisable(true);
            deleteBtn.setDisable(true);
            newPersonMenuId.setDisable(true);
            deletePersonMenuId.setDisable(true);
            editPersonMenuId.setDisable(true);
            personFormPane.setVisible(true);
            personTable.setPrefHeight(personTable.getPrefHeight() - personFormPane.getPrefHeight());
            personPageAnchorPane.setBottomAnchor(personTable, personPageAnchorPane.getBottomAnchor(personTable) + personFormPane.getPrefHeight());
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "");
            alert.setTitle("Warning error");
            alert.setContentText("Please select an item from Table to continue");
            Optional<ButtonType> result = alert.showAndWait();
        }

    }

    @FXML
    void editPersonMenu(ActionEvent event) {
        if (!personTable.getSelectionModel().isEmpty()) {
            operation = "M";

            index = personTable.getSelectionModel().getSelectedIndex();
            nameTxtForm.setText(personName.getCellData(index));
            surnameTxtForm.setText(personSurname.getCellData(index));
            descTxtForm.setText(personDescription.getCellData(index));
            phoneTxtForm.setText(personPhone.getCellData(index));
            mobilTxtForm.setText(personMobile.getCellData(index));
            emailTxtForm.setText(personEmail.getCellData(index));
            idnpTxtForm.setText(personIDNP.getCellData(index));
            birthDayPicker.setValue((LocalDate) personBirthday.getCellData(index));
            personFormPane.setDisable(false);
            newBtn.setDisable(true);
            enterBtn.setDisable(false);
            cancelBtn.setDisable(false);
            editBtn.setDisable(true);
            deleteBtn.setDisable(true);
            newPersonMenuId.setDisable(true);
            deletePersonMenuId.setDisable(true);
            editPersonMenuId.setDisable(true);
            personFormPane.setVisible(true);
            personTable.setPrefHeight(personTable.getPrefHeight() - personFormPane.getPrefHeight());
            personPageAnchorPane.setBottomAnchor(personTable, personPageAnchorPane.getBottomAnchor(personTable) + personFormPane.getPrefHeight());
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "");
            alert.setTitle("Warning error");
            alert.setContentText("Please select an item from Table to continue");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }

    @FXML
    void pressEnter(ActionEvent event) {
        if (!nameTxtForm.getText().equals("") && !surnameTxtForm.getText().equals("") && !emailTxtForm.getText().equals("") && !idnpTxtForm.getText().equals("")) {
            cancelBtn.setDisable(true);
            enterBtn.setDisable(true);
            newBtn.setDisable(false);
            editBtn.setDisable(false);
            deleteBtn.setDisable(false);
            newPersonMenuId.setDisable(false);
            deletePersonMenuId.setDisable(false);
            editPersonMenuId.setDisable(false);
            personFormPane.setVisible(false);
            personTable.setPrefHeight(personTable.getPrefHeight() + personFormPane.getPrefHeight());
            personPageAnchorPane.setBottomAnchor(personTable, personPageAnchorPane.getBottomAnchor(personTable) - personFormPane.getPrefHeight());

            switch (operation) {

                case "N":
                    sql = "INSERT INTO step.person(name, surname,description,phone,mobil,email,regdate,idnp,birthday) values(?,?,?,?,?,?,?,?,?)";
                    try (Connection connection = initConnection();

                         PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                        preparedStatement.setString(1, nameTxtForm.getText());
                        preparedStatement.setString(2, surnameTxtForm.getText());
                        preparedStatement.setString(3, descTxtForm.getText());
                        preparedStatement.setString(4, phoneTxtForm.getText());
                        preparedStatement.setString(5, mobilTxtForm.getText());
                        preparedStatement.setString(6, emailTxtForm.getText());
                        preparedStatement.setString(8, idnpTxtForm.getText());
                        preparedStatement.setDate(7, Date.valueOf(today));
                        preparedStatement.setDate(9, Date.valueOf(birthDayPicker.getValue()));

                        int rows = preparedStatement.executeUpdate();
//                        System.out.println("Rows: " + rows);
                        if (rows == 1) {
                            ResultSet ids = preparedStatement.getGeneratedKeys();
                            while (ids.next()) {
                                //ids.getLong(1); // 1 este pozitia elementului care il extrageti (generatedKeys returneaza un array de id-uri si de fiecare data next() trece la urmatorul
                                Person addPerson = new Person(ids.getInt(1), nameTxtForm.getText(), surnameTxtForm.getText(), descTxtForm.getText(), phoneTxtForm.getText(), mobilTxtForm.getText(), emailTxtForm.getText(), LocalDate.now(), idnpTxtForm.getText(), birthDayPicker.getValue());
                                personList.add(addPerson);
                            }
                        }
                        preparedStatement.close();
                        connection.close();
//            return rows;
                    } catch (SQLException e) {
                        e.printStackTrace();

                    }
                    nameTxtForm.setText("");
                    surnameTxtForm.setText("");
                    descTxtForm.setText("");
                    phoneTxtForm.setText("");
                    mobilTxtForm.setText("");
                    emailTxtForm.setText("");
                    idnpTxtForm.setText("");
                    birthDayPicker.setValue(null);
                    personFormPane.setDisable(false);
                    setTotalValuesInTable();
                    break;
                case "M":
                    index = this.personTable.getSelectionModel().getSelectedIndex();

                    sql = "UPDATE step.person SET name=?, surname=?,description=?,phone=?,mobil=?,email=?,idnp=?,birthday=? where personid=? ";
                    try (Connection connection = initConnection();
                         //DB Table update
                         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                        preparedStatement.setString(1, nameTxtForm.getText());
                        preparedStatement.setString(2, surnameTxtForm.getText());
                        preparedStatement.setString(3, descTxtForm.getText());
                        preparedStatement.setString(4, phoneTxtForm.getText());
                        preparedStatement.setString(5, mobilTxtForm.getText());
                        preparedStatement.setString(6, emailTxtForm.getText());
                        preparedStatement.setString(7, idnpTxtForm.getText());
                        preparedStatement.setInt(9, personID.getCellData(index));
                        preparedStatement.setDate(8, Date.valueOf(birthDayPicker.getValue()));

                        int rows = preparedStatement.executeUpdate();
                        preparedStatement.close();

                        //TableView update
                        personList.get(index).setPersonId(Integer.valueOf(personID.getCellData(index)));
                        personList.get(index).setName(nameTxtForm.getText());
                        personList.get(index).setSurname(surnameTxtForm.getText());
                        personList.get(index).setDescription(descTxtForm.getText());
                        personList.get(index).setPhone(phoneTxtForm.getText());
                        personList.get(index).setMobile(mobilTxtForm.getText());
                        personList.get(index).setEmail(emailTxtForm.getText());
                        personList.get(index).setRegDate(personRegDate.getCellData(index));
                        personList.get(index).setIdnp(idnpTxtForm.getText());
                        personList.get(index).setBirthday(birthDayPicker.getValue());


                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();

                    }
                    nameTxtForm.setText("");
                    surnameTxtForm.setText("");
                    descTxtForm.setText("");
                    phoneTxtForm.setText("");
                    mobilTxtForm.setText("");
                    emailTxtForm.setText("");
                    idnpTxtForm.setText("");
                    birthDayPicker.setValue(null);
                    personFormPane.setDisable(true);
                    break;
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter data for Person");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }


    @FXML

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        personID.setCellValueFactory(new PropertyValueFactory<>("personId"));//name of the attribute on Person level
        personName.setCellValueFactory(new PropertyValueFactory<>("name"));
        personSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        personDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        personPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        personMobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        personEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        personRegDate.setCellValueFactory(new PropertyValueFactory<>("regDate"));
        personIDNP.setCellValueFactory(new PropertyValueFactory<>("idnp"));
        personBirthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));

        personList = getAllActiveUsers();
        personTable.setItems(personList);
        personTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        numberOfTableRows = personTable.getItems().size();
//        displayedRows.setText(String.valueOf(numberOfTableRows));
//        totalRows.setText(String.valueOf(numberOfTotalRows));
        setTotalValuesInTable();
        personFormPane.setVisible(false);


        personList.addListener((ListChangeListener<Person>) change -> {
            while (change.next()) {
                if (change.wasPermutated()) {
                    for (int i = change.getFrom(); i < change.getTo(); ++i) {
                        System.out.println("Permuted: " + i + " " + personList.get(i));
                    }
                } else if (change.wasUpdated()) {
                    for (int i = change.getFrom(); i < change.getTo(); ++i) {
                        System.out.println("Updated: " + i + " " + personList.get(i));
                    }
                } else {
                    change.getRemoved().forEach((removedItem) -> {
                        System.out.println("Removed: " + removedItem);
                    });
                    change.getAddedSubList().forEach((addedItem) -> {
                        System.out.println("Added: " + addedItem);
                    });
                }
            }
        });
    }

    public static ObservableList<Person> getAllActiveUsers() {
        try {
            java.sql.Connection conn = initConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT personid, name, surname,description,phone,mobil,email,regdate,idnp,birthday FROM step.person where disabled=false ORDER BY personid");
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                personList.add(new Person(Integer.parseInt(rs.getString("personid")), rs.getString("name"),
                        rs.getString("surname"), rs.getString("description"), rs.getString("phone"),
                        rs.getString("mobil"), rs.getString("email"), rs.getDate("regdate").toLocalDate(),
                        rs.getString("idnp"), rs.getDate("birthday").toLocalDate()));

            }
//            PreparedStatement ps1 = conn.prepareStatement("select count(*) as count FROM step.person where disabled=false");
//            ResultSet rs1 = ps1.executeQuery();
//            while (rs1.next()) {
//                numberOfTotalRows = Integer.parseInt(rs1.getString("count"));
//                System.out.println("Number of total:" + numberOfTotalRows);
//            }
        } catch (Exception e) {
        }
        return personList;
    }

    //Section Menu Data
    @FXML
    void exportToCSV(ActionEvent event) {
        savePersonDataToCSV(personList);
    }

    @FXML
    void exportToXML(ActionEvent event) {
        savePersonDataToXml(personList);
    }

    @FXML
    void importFromCSV(ActionEvent event) {
        readPersonFromFile(personList);
    }

    @FXML
    void importFromXML(ActionEvent event) {
        readPersonDataFromXML(personList);
    }

    //Search
    @FXML
    void searchByString(ActionEvent event) {
        String valueToSearch = searchTextField.getText();

        System.out.println("Search " + valueToSearch);
        String sql = "SELECT personid, name, surname,description,phone,mobil,email,regdate,idnp,birthday FROM step.person where disabled=false and " +
                "(name like '%" + valueToSearch + "%' or surname like '%" + valueToSearch + "%' or description like '%" + valueToSearch + "%' or phone like '%" + valueToSearch + "%' or mobil like '%" + valueToSearch + "%' or email like '%" + valueToSearch + "%' or idnp like '%" + valueToSearch + "%')" +
                "ORDER BY personid";
        personList = searchBy(sql);
        personTable.setItems(personList);
        personTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        searchBtn.setDisable(true);
        searchResetBtn.setDisable(false);
    }

    @FXML
    void searchByStringReset(ActionEvent event) {
        personList.clear();
        personList = getAllActiveUsers();
        personTable.setItems(personList);
        personTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        setTotalValuesInTable();
        searchTextField.setText("");
        searchResetBtn.setDisable(true);
    }

    @FXML
    void searchBoxType(InputMethodEvent event) {
        searchBtn.setDisable(false);
    }

    @FXML
    void searchBoxClick(MouseEvent event) {
        searchBtn.setDisable(false);

    }

    public ObservableList<Person> searchBy(String sql) {

        try {
            Connection conn = initConnection();
            personList.clear();

            PreparedStatement ps = conn.prepareStatement(sql);
            System.out.println("sql =" + sql);
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                personList.add(new Person(Integer.parseInt(rs.getString("personid")), rs.getString("name"),
                        rs.getString("surname"), rs.getString("description"), rs.getString("phone"),
                        rs.getString("mobil"), rs.getString("email"), rs.getDate("regdate").toLocalDate(),
                        rs.getString("idnp"), rs.getDate("birthday").toLocalDate()));

            }

            setTotalValuesInTable();
        } catch (Exception e) {
        }
        return personList;
    }

    void setTotalValuesInTable() {
        try {
            Connection conn = initConnection();
            numberOfTableRows = personTable.getItems().size();
            displayedRows.setText(String.valueOf(numberOfTableRows));
            PreparedStatement ps1 = conn.prepareStatement("select count(*) as count FROM step.person where disabled=false");
            ResultSet rs1 = ps1.executeQuery();
            while (rs1.next()) {
                numberOfTotalRows = Integer.parseInt(rs1.getString("count"));
                System.out.println("Number of total:" + numberOfTotalRows);
                totalRows.setText(String.valueOf(numberOfTotalRows));
            }
        } catch (
                Exception e) {
        }

    }

    @FXML
    void closeAppMenu(ActionEvent event) {
        exit();
    }

    @FXML
    void menuHelpAbout(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "");
        alert.setTitle("About");
        alert.setHeaderText("MyBloc Admin");

        alert.setContentText("Version 0.0.1 Dev\n(c) 2021 \nThis application was developed by Oleg Baxan.");

        Optional<ButtonType> result = alert.showAndWait();
    }
}
