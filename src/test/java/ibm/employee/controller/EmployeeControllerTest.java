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
import ibm.employee.model.Name;
import ibm.employee.service.EmployeeService;
import ibm.employee.service.EmployeeServiceImpl;

/*
 * The unit test for 
 * the controller class using junit 5 and mockito
 * 
 */

public class EmployeeControllerTest {
	
	@InjectMocks private EmployeeController employeeController;
	@Mock  private EmployeeService employeeServiceImpl;
	
	@BeforeEach
	public void initMocks()
	{
		MockitoAnnotations.initMocks(this);	
	}
	
	@AfterEach
	public void tearDown() {
		employeeController = null;
		employeeServiceImpl = null;
	}
	
	@Test
	public void getAllEmployees_and_return_employees() {
		
		List<Employee> employees = getAllEmployees();
		Mockito.when(employeeServiceImpl.getAllEmployees()).thenReturn(employees);
		List<Employee> results = employeeController.getAllEmployees();
		assertNotNull(results);
		assertEquals(employees.size(), results.size());
	}
	
	@Test
	public void getAllEmployees_and_return_null() {
		Mockito.when(employeeServiceImpl.getAllEmployees()).thenReturn(null);
		List<Employee> results = employeeController.getAllEmployees();
		assertNull(results);
	}
	
	@Test
	public void getEmployee_given_employeeid_and_return_employee() {
		long employeedId = 101;
		Employee employee = getEmployee();
		Mockito.when(employeeServiceImpl.getEmployeeById(employeedId)).thenReturn(employee);
		Employee result = employeeController.getEmployeeById(employeedId);
		assertNotNull(result);
     	assertEquals(employee,result);	
	}
	
	@Test
	public void getEmployee_given_employeeid_and_return_null() {
		long employeedId = 101;
		Mockito.when(employeeServiceImpl.getEmployeeById(employeedId)).thenReturn(null);
		Employee result = employeeController.getEmployeeById(employeedId);
		assertNull(result);
	}
	
	@Test
	public void addNewEmployee_save_employee_and_return_employee() {
		Employee employee = getEmployee();
		Mockito.when(employeeServiceImpl.addEmployee(employee)).thenReturn(employee);
		Employee result = employeeController.addNewEmployee(employee);
		assertNotNull(result);
     	assertEquals(employee,result);	
	}
	
	@Test
	public void updateEmployeeDetails_and_return_employee() {
		Employee employee = getEmployee();
		Mockito.when(employeeServiceImpl.updateEmployeeDetails(employee)).thenReturn(employee);
		Employee result = employeeController.updateEmployeeDetails(employee);
		assertNotNull(result);
     	assertEquals(employee,result);
	}
	
	
	private List<Employee> getAllEmployees(){
		Employee firstMockEmployee = new Employee();
		Name firstEmployeeName = new Name();
		firstMockEmployee.setEmployeeId(101);
		firstMockEmployee.setJobRole("Sales Representative");
		firstEmployeeName.setFirstName("Jared");
		firstEmployeeName.setMiddleName("Head");
		firstEmployeeName.setLastName("Eric");
		firstMockEmployee.setName(firstEmployeeName);
		Employee secondMockEmployee = new Employee();
		Name secondEmployeeName = new Name();
		secondMockEmployee.setEmployeeId(102);
		secondMockEmployee.setJobRole("Software Engineer");
		secondEmployeeName.setFirstName("Brittany");
		secondEmployeeName.setMiddleName("Philips");
		secondEmployeeName.setLastName("Frank");
		secondMockEmployee.setName(firstEmployeeName);		
		Employee thirdMockEmployee = new Employee();
		Name thirdEmployeeName = new Name();
		thirdMockEmployee.setEmployeeId(103);
		thirdMockEmployee.setJobRole("Financial Analyst");
		thirdEmployeeName.setFirstName("Samson");
		thirdEmployeeName.setMiddleName("Richard");
		thirdEmployeeName.setLastName("Victor");
		thirdMockEmployee.setName(firstEmployeeName);
		List<Employee> employees = new ArrayList<>();
		employees.add(firstMockEmployee);
		employees.add(secondMockEmployee);
		employees.add(thirdMockEmployee);
		return employees;
	}
	
	private Employee getEmployee() {
		Employee firstMockEmployee = new Employee();
		Name firstEmployeeName = new Name();
		firstMockEmployee.setEmployeeId(101);
		firstMockEmployee.setJobRole("Sales Representative");
		firstEmployeeName.setFirstName("Jared");
		firstEmployeeName.setMiddleName("Head");
		firstEmployeeName.setLastName("Eric");
		firstMockEmployee.setName(firstEmployeeName);
		return firstMockEmployee;

	}

}
