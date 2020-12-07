package md.step.manager.db;

import md.step.Employee;
import md.step.manager.IEmployeeManager;

import java.sql.SQLException;

public class EmployeeManagerDB implements IEmployeeManager {
    EmployeeDao employeeDao = new EmployeeDao();
    public int insert(Employee e){
        try {
            employeeDao.insert(e);
        }catch (SQLException E){

        }

    }
    
}
