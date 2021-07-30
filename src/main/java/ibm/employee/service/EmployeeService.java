package ibm.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ibm.employee.model.Employee;

@Service
public interface EmployeeService {

	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(long id);
	public Employee addEmployee(Employee employee);
	public Employee updateEmployeeDetails(Employee employee);
}
