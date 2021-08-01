package ibm.employee.service;



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

import ibm.employee.dao.EmployeeDAO;
import ibm.employee.model.Employee;
import ibm.employee.model.Name;
import ibm.employee.service.EmployeeServiceImpl;

/*
 * The unit test for the service class using junit 5 and mockito
 * 
 */


public class EmployeeServiceImplTest {
	
	@Mock EmployeeDAO myRepository;
	@InjectMocks  EmployeeService employeeService = new EmployeeServiceImpl();
	
	@BeforeEach
	public void initMocks()
	{
		MockitoAnnotations.initMocks(this);
		
	}
	
	@AfterEach
	void tearDown() {
		employeeService = null;
		myRepository = null;
	}
	
	@Test
	public void getAllEmployees_and_return_employees() {
		List<Employee> employees = getAllEmployees();
		Mockito.when(myRepository.findAll()).thenReturn(employees);
		List<Employee> response = employeeService.getAllEmployees();
		assertNotNull(response);
		assertEquals(employees.size(), response.size());
		
	}
	
	@Test
	public void getAllEmployees_and_return_null() {
		
		Mockito.when(myRepository.findAll()).thenReturn(null);
		  //Mockito.doReturn(null).when(myRepository).findAll();
		List<Employee> response = employeeService.getAllEmployees();
		assertNull(response);
	}
	
	
	@Test
	public void getEmployeeById_and_return_Employee() {
		long id = 101;
		Employee employee = getEmployee();
		Mockito.when(myRepository.findEmployeeByEmployeeId(id)).thenReturn(employee);
		Employee response = employeeService.getEmployeeById(id);
		assertNotNull(response);
		assertEquals(employee.getName(), response.getName());
		assertEquals(employee.getJobRole(),response.getJobRole());
	}
	
	@Test
	public void getEmployeeById_and_return_null() {
		long id = 101;
		Mockito.when(myRepository.findEmployeeByEmployeeId(id)).thenReturn(null);
		Employee response = employeeService.getEmployeeById(id);
		assertNull(response);
	}
	
	
	@Test
	public void addEmployee_and_return_employee() {
		Employee firstMockEmployee = new Employee();
		Name firstEmployeeName = new Name();
		firstMockEmployee.setJobRole("Product Owner");
		firstEmployeeName.setFirstName("Brittany");
		firstEmployeeName.setMiddleName("Head");
		firstEmployeeName.setLastName("Eric");
		firstMockEmployee.setName(firstEmployeeName);
		Mockito.when(myRepository.save(firstMockEmployee)).thenReturn(firstMockEmployee);
		Employee response = employeeService.addEmployee(firstMockEmployee);
		Mockito.verify(myRepository).save(firstMockEmployee);
		assertNotNull(response);
		
	}
	
	@Test
	public void updateEmployeeDetails_and_successufl() {
		long id = 101;
		String newName = "Hammed";
		String newJobRole = "Software Developer";
		Employee employee = getEmployee();
		Mockito.when(myRepository.findEmployeeByEmployeeId(id)).thenReturn(employee);
		Employee updatedMockEmployee = new Employee();
		Name updatedEmployeeName = new Name();
		updatedMockEmployee.setEmployeeId(101);
		updatedMockEmployee.setJobRole(newJobRole);
		updatedEmployeeName.setFirstName("Hammed");
		updatedEmployeeName.setMiddleName("Fatai");
		updatedEmployeeName.setLastName("Eric");
		updatedMockEmployee.setName(updatedEmployeeName);
		Mockito.when(myRepository.save(Mockito.any(Employee.class))).thenReturn(updatedMockEmployee);
		Employee response = employeeService.updateEmployeeDetails(updatedMockEmployee);
		assertNotNull(response);
		assertEquals(response.getName(), updatedMockEmployee.getName());
		Mockito.verify(myRepository).save(Mockito.any(Employee.class));
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
