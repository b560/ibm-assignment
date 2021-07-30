package ibm.employee.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import ibm.employee.model.Employee;
import ibm.employee.service.EmployeeService;
import ibm.employee.service.EmployeeServiceImpl;

public class EmployeeControllerTest {
	
	@InjectMocks private EmployeeController employeeController;
	@Mock  private EmployeeService employeeServiceImpl;
	
	@BeforeEach
	public void initMocks()
	{
		MockitoAnnotations.initMocks(this);	
	}
	
	@AfterEach
	void tearDown() {
		employeeController = null;
		employeeServiceImpl = null;
	}
	
	@Test
	void getAllEmployees_and_return_employees() {
		
		List<Employee> employees = getAllEmployees();
		Mockito.when(employeeServiceImpl.getAllEmployees()).thenReturn(employees);
		List<Employee> results = employeeController.getAllEmployees();
		assertNotNull(results);
		assertEquals(employees.size(), results.size());
	}
	
	@Test
	void getAllEmployees_and_retyrn_null() {
		Mockito.when(employeeServiceImpl.getAllEmployees()).thenReturn(null);
		List<Employee> results = employeeController.getAllEmployees();
		assertNull(results);
	}
	
	@Test
	void getEmployee_given_employeeid_and_return_employee() {
		long employeedId = 101;
		Employee employee = new Employee(101,"Jared","Sales Representative");
		Mockito.when(employeeServiceImpl.getEmployeeById(employeedId)).thenReturn(employee);
		Employee result = employeeController.getEmployeeById(employeedId);
		assertNotNull(result);
     	assertEquals(employee,result);	
	}
	
	@Test
	void getEmployee_given_employeeid_and_return_null() {
		long employeedId = 101;
		Mockito.when(employeeServiceImpl.getEmployeeById(employeedId)).thenReturn(null);
		Employee result = employeeController.getEmployeeById(employeedId);
		assertNull(result);
	}
	
	@Test
	void addNewEmployee_save_employee_and_return_employee() {
		Employee employee = new Employee(101,"Jared","Sales Representative");
		Mockito.when(employeeServiceImpl.addEmployee(employee)).thenReturn(employee);
		Employee result = employeeController.addNewEmployee(employee);
		assertNotNull(result);
     	assertEquals(employee,result);	
	}
	
	@Test
	void updateEmployeeDetails_and_return_employee() {
		Employee employee = new Employee(101,"Jared","Sales Representative");
		Mockito.when(employeeServiceImpl.updateEmployeeDetails(employee)).thenReturn(employee);
		Employee result = employeeController.updateEmployeeDetails(employee);
		assertNotNull(result);
     	assertEquals(employee,result);
	}
	
	
	private List<Employee> getAllEmployees(){
		Employee firstMockEmployee = new Employee(101,"Jared","Sales Representative");
		Employee secondMockEmployee = new Employee(102,"Ryan","Software Developer");
		Employee thirdMockEmployee = new Employee(103,"Alalade","Financial Analyst");
		List<Employee> employees = new ArrayList<>();
		employees.add(firstMockEmployee);
		employees.add(secondMockEmployee);
		employees.add(thirdMockEmployee);
		return employees;
	}

}
