package ibm.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import ibm.employee.dao.EmployeeDAO;
import ibm.employee.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDao;
	
	/*
	 * The service to get all employees from the database
	 *
	 */
	public List<Employee> getAllEmployees(){
		List<Employee> employees = employeeDao.findAll();
		if(employees != null)
			return employees;
		return null;
	}
	
	/*
	 * service to get an employee given a employee id
	 *
	 */
	public Employee getEmployeeById(long id) {
		Employee employee = employeeDao.findEmployeeByEmployeeId(id);
		if(employee != null)
			return employee;
		return null;
	}
	
	/*
	 * 
	 * service to add new employee to the  database
	 */
	public Employee addEmployee(Employee employee) {
		if(employee != null) {
			return employeeDao.save(employee);
		}
		return null;
	}
	
	/*
	 * 
	 * service to update employee in the  database
	 */
	public Employee updateEmployeeDetails(Employee employee) {
		    long requestObjectEmployeeId = employee.getEmployeeId();
		    Employee existedEmployee = employeeDao.findEmployeeByEmployeeId(requestObjectEmployeeId);
		    if(employee != null) {
			 return  employeeDao.save(employee);
		    }
			return null;	
	}

}
