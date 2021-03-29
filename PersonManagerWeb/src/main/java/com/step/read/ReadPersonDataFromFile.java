package edu.step.read;

import edu.step.files.FilePaths;
import edu.step.entity.Person;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;

import static edu.step.connection.Connection.initConnection;

public class ReadPersonDataFromFile {

    private static final String delimiter = ",";//Delimiter used in CSV file

    public static void readPersonFromFile(List<Person> mainPersonsList) {
        boolean exist = false;
        String sql = "";

        try {
            String line = "";
            String filePath = FilePaths.selectFile();

//            BufferedReader readPerson = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\main\\java\\person.csv"));
            BufferedReader readPerson = new BufferedReader(new FileReader(filePath));

            //Read the CSV file header
            readPerson.readLine();

            //Read the file line by line starting from the second line
            while ((line = readPerson.readLine()) != null) {
                String[] attributes = line.split(delimiter);
                if (attributes.length > 0) {
                    /*Simple API for XML*/
                    int personId = 0;
                    for (String person : attributes) {

                        personId = Integer.parseInt(attributes[0]);
                        String idnp = attributes[8];
                        for (int j = 0; j < mainPersonsList.size(); j++) {
                            exist = false;
                            if (personId == mainPersonsList.get(j).getPersonId()|| idnp.trim().equalsIgnoreCase(mainPersonsList.get(j).getIdnp())) {
                                exist = true;
                                break;
                            }
                        }
                    }
                    if (!exist) {

                        String name = attributes[1];
                        String surname = attributes[2];
                        String description = attributes[3];
                        String phone = attributes[4];
                        String mobil = attributes[5];
                        String email = attributes[6];
                        LocalDate regDate = LocalDate.parse(attributes[7]);
                        String idnp = attributes[8];
                        LocalDate birthday= LocalDate.parse(attributes[9]);
//                        System.out.println(name + "/" + surname + "/" + description + "/" + phone + "/" + mobil + "/" + email + "/" + regDate + "/" + idnp);
                        sql = "INSERT INTO step.person(name, surname,description,phone,mobil,email,regdate,idnp,birthday) values(?,?,?,?,?,?,?,?,?)";
                        try (Connection connection = initConnection();

                             PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                            preparedStatement.setString(1, name);
                            preparedStatement.setString(2, surname);
                            preparedStatement.setString(3, description);
                            preparedStatement.setString(4, phone);
                            preparedStatement.setString(5, mobil);
                            preparedStatement.setString(6, email);
                            preparedStatement.setDate(7, Date.valueOf(regDate));
                            preparedStatement.setString(8, idnp);
                            preparedStatement.setDate(9, Date.valueOf(regDate));

                            int rows = preparedStatement.executeUpdate();
                            System.out.println("Rows: " + rows);
                            if (rows == 1) {
                                ResultSet ids = preparedStatement.getGeneratedKeys();
                                while (ids.next()) {
                                    //ids.getLong(1); // 1 este pozitia elementului care il extrageti (generatedKeys returneaza un array de id-uri si de fiecare data next() trece la urmatorul
                                    Person addPerson = new Person(ids.getInt(1), name, surname, description, phone, mobil, email, regDate, idnp, birthday);
                                    System.out.println(addPerson);
                                    mainPersonsList.add(addPerson);
                                }
                            }
                            preparedStatement.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            readPerson.close();
//            savePersonDataToCSV(mainPersonsList);
        } catch (FileNotFoundException ex) {
            System.out.println("Error in read CsvFile !!!");
            ex.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        }
    }
}
