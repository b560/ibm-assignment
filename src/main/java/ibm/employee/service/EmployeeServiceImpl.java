package ibm.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import ibm.employee.dao.EmployeeDAO;
import ibm.employee.model.Employee;

@Component
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDao;
	
	public List<Employee> getAllEmployees(){
		List<Employee> employees = employeeDao.findAll();
		if(employees != null)
			return employees;
		return null;
	}
	
	public Employee getEmployeeById(long id) {
		Employee employee = employeeDao.findEmployeeByEmployeeId(id);
		if(employee != null)
			return employee;
		return null;
	}
	
	public Employee addEmployee(Employee employee) {
		if(employee != null) {
			return employeeDao.save(employee);
		}
		return null;
	}
	
	public Employee updateEmployeeDetails(Employee employee) {
			Employee finalEmployee = employeeDao.save(employee);
			return finalEmployee;	
	}

}
