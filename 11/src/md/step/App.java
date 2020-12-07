package md.step;

import java.sql.*;

import static md.step.App.getConnection;

public class App {
    public static void main(String[] args) throws SQLException{
        insertData(new Employee("John","Stefan cel Mare","089"));
        insertData(new Employee("Sergiu","Pertr","097"));
        insertData(new Employee("Vasile","Mereuta","0987"));
        insertData(new Employee("Ion","Marin","876"));
        insertData(new Employee("Ghita","Gicu","6789"));



        //get connection
        Connection connection =getConnection();

        //execute sql
        Statement statement=connection.createStatement();
        String insertSql = "INSERT INTO test.person(name,surname) VALUES ('Ion','Smith')";
//        String deleteSql = "DELETE FROM test.person WHERE id=2";
        String selectSql = "SELECT id,name,surname FROM test.person";
        String updateSql = "UPDATE test.person set name='John' WHERE id=3";

        int rows = statement.executeUpdate(insertSql); //update,insert,delete
                             //executeQuary //select
//        int deleteRows= statement.executeUpdate(deleteSql);
        statement.executeUpdate(updateSql);
        ResultSet resultSet = statement.executeQuery(selectSql);
        while(resultSet.next()){
            int id=resultSet.getInt("id");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            System.out.println(id+" name: "+name+ " surname: "+surname);
        }

        System.out.println("Rows inserted "+rows);
//        System.out.println("Rows deleted "+deleteRows);

        //close connection
        statement.close();
        connection.close();
    }
    public static  void insertData(Employee emp) throws SQLException{
        Connection connection = getConnection();
        Statement statement = connection.createStatement();

        String sql = "INSERT INTO test.person(name,surname) VALUES ('" + emp.getName()+"','"+emp.getAddress()+"')";
        int rows = statement.executeUpdate(sql);
        System.out.println("Inserted: " + rows );
    }
    public static Connection getConnection() throws SQLException {
        String url="jdbc:postgresql://127.0.0.1:54321/Test";
        String username = "postgres";
        String password = "POSTGRESSQL";
        Connection connection= DriverManager.getConnection(url,username,password);
        return connection;
    }

    //citim optiunea
    int option=1;
    switch(option){
        //1,2,3, new EmployeeManagerInMemory();
        //InFile();
        //DB();
    }
}
