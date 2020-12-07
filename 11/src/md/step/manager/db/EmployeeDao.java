package md.step.manager.db;

import md.step.Employee;
import sun.reflect.FieldAccessor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    public Connection initConnection() throws SQLException {
        String url="jdbc:postgresql://127.0.0.1:54321/Test";
        String username = "postgres";
        String password = "POSTGRESSQL";
        Connection connection= DriverManager.getConnection(url,username,password);
        return connection;
    }
    public int insert(String name,String address,String phoneno) throws SQLException {//insert(Employee emp)
        Connection connection=initConnection();
//        Statement statement= connection.createStatement();
//        String sql = "INSERT INTO test.person(name,address,phoneno) VALUES('"+ name+ "','" + address+ "','"+ phoneno+ "')";
//        String sqlFormat = String.format("INSERT INTO test.person(name,address,phoneno) VALUES('%s','%s','%s')",name,address,phoneno);
//        statement.executeUpdate(sql);


        String preparedSql="INSERT INTO test.person(name,address,phoneno) VALUES(?,?,? )";
        PreparedStatement preparedStatement = connection.prepareStatement(preparedSql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,address);
        preparedStatement.setString(3,phoneno);

        int rows= preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return rows;
    }
    public void insert(Employee emp) throws SQLException {//insert(Employee emp)
        Connection connection=initConnection();

        String preparedSql="INSERT INTO test.person(name,address,phoneno) VALUES(?,?,? )";
        PreparedStatement preparedStatement = connection.prepareStatement(preparedSql);
        preparedStatement.setString(1,emp.getName());
        preparedStatement.setString(2,emp.getAddress());
        preparedStatement.setString(3,emp.getPhoneno());

        int rows= preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }

    public void insertTryWithResources(Employee emp) throws SQLException {//insert(Employee emp)
        String preparedSql="INSERT INTO test.person(name,address,phoneno) VALUES(?,?,? )";
        try(Connection connection=initConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(preparedSql);) {
            preparedStatement.setString(1,emp.getName());
            preparedStatement.setString(2,emp.getAddress());
            preparedStatement.setString(3,emp.getPhoneno());

            int rows= preparedStatement.executeUpdate();
        }

//        preparedStatement.close();
//        connection.close();
    }
    public void update(Employee emp) throws SQLException {
        Connection connection=initConnection();
        //TODO: try-with-resourses
        String preparedSql = "UPDATE  test.person set name=?, address=?, phoneno=? where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(preparedSql);
        preparedStatement.setString(1,emp.getName());
        preparedStatement.setString(2,emp.getAddress());
        preparedStatement.setString(3,emp.getPhoneno());
        preparedStatement.setInt(4,emp.getId());
        int rows=preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

    }
    public List<Employee> read() throws SQLException {
        Connection connection=initConnection();
        String sql = "SELECT id,name,address,phoneno FROM test.person";
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(sql);
        List<Employee> emp=new ArrayList<>();
        while(resultSet.next()){
            int id=resultSet.getInt("id");
            String name=resultSet.getString("name");
            String address=resultSet.getString("address");
            String phoneno=resultSet.getString("phoneno");
            emp.add(new Employee(id,name,address,phoneno));

        }
        statement.close();
        connection.close();
        return emp;
        //List<Employee> list = EmployeeDao.read();

    }
    public void delete(Employee emp) throws SQLException {
        Connection connection=initConnection();

        String sql = "DELETE FROM test.person WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(4,emp.getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();

    }

}
