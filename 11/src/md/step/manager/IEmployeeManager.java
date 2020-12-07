package md.step.manager;

import md.step.Employee;

import java.util.List;

public interface IEmployeeManager {
    public int insert(Employee employee);
    public int update(Employee employee);
    public List<Employee> read();
    public int delete(Employee employee);
}
