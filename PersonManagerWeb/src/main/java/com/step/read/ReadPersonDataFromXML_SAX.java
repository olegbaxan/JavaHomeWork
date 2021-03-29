package edu.step.read;

import edu.step.files.FilePaths;
import edu.step.entity.Person;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;

import static edu.step.connection.Connection.initConnection;

public class ReadPersonDataFromXML_SAX {
    public static void readPersonDataFromXML(List<Person> mainPersonsList) {
        boolean exist = false;
        String sql = "";
//        System.out.println("Enter readPersonDataFromXML");
        try {

            String filePath = FilePaths.selectFile();

            /*Simple API for XML*/
            SAXBuilder saxBuilder = new SAXBuilder();
//            Document document = saxBuilder.build(new File(System.getProperty("user.dir") + "\\src\\main\\java\\person.xml"));
            Document document = saxBuilder.build(new File(filePath));
            Element persons = document.getRootElement();
            List<Element> personList = persons.getChildren("person");
            for (Element person : personList) {
                Element personID = person.getChild("personID");
                int personId = Integer.parseInt(personID.getText());
                Element personIDNP = person.getChild("idnp");
                String idnp = personIDNP.getText();

                for (int j = 0; j < mainPersonsList.size(); j++) {
                    exist = false;
                    if (personId == mainPersonsList.get(j).getPersonId() || idnp.trim().equalsIgnoreCase(mainPersonsList.get(j).getIdnp())) {
                        exist = true;
//                        System.out.println("Exist");
                        break;
                    }
                }
//                System.out.println("Exist " + exist + ", person_id " + personId);
                if (!exist) {
                    Element personName = person.getChild("name");
                    String name = personName.getText();
                    Element personSurname = person.getChild("surname");
                    String surname = personSurname.getText();
                    Element personDescription = person.getChild("description");
                    String description = personDescription.getText();
                    Element personPhone = person.getChild("phone");
                    String phone = personPhone.getText();
                    Element personMobil = person.getChild("mobile");
                    String mobil = personMobil.getText();
                    Element personEmail = person.getChild("email");
                    String email = personDescription.getText();
                    Element personRegDate = person.getChild("regDate");
                    LocalDate regDate = LocalDate.parse(personRegDate.getText());

                    Element personBirthDay = person.getChild("birthday");
                    LocalDate birthday = LocalDate.parse(personBirthDay.getText());

                    sql = "INSERT INTO step.person(name, surname,description,phone,mobil,email,regdate,idnp,birthday) values(?,?,?,?,?,?,?,?,?)";
                    try (Connection connection = initConnection();

                         PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                        preparedStatement.setString(1, name);
                        preparedStatement.setString(2, surname);
                        preparedStatement.setString(3, description);
                        preparedStatement.setString(4, phone);
                        preparedStatement.setString(5, mobil);
                        preparedStatement.setString(6, email);
                        preparedStatement.setString(8, idnp);
                        preparedStatement.setDate(7, Date.valueOf(regDate));
                        preparedStatement.setDate(9, Date.valueOf(birthday));

                        int rows = preparedStatement.executeUpdate();
                        System.out.println("Rows: " + rows);
                        if (rows == 1) {
                            ResultSet ids = preparedStatement.getGeneratedKeys();
                            while (ids.next()) {
                                //ids.getLong(1); // 1 este pozitia elementului care il extrageti (generatedKeys returneaza un array de id-uri si de fiecare data next() trece la urmatorul
                                Person addPerson = new Person(ids.getInt(1), name, surname, description, phone, mobil, email, regDate, idnp, birthday);
//                                System.out.println(addPerson);
                                mainPersonsList.add(addPerson);
                            }
                        }
                        preparedStatement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        savePersonDataToXml(mainPersonsList);
    }
}
