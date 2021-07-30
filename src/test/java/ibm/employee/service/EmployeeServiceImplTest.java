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
import ibm.employee.service.EmployeeServiceImpl;


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
		Employee employee = new Employee(101,"Jared","Sales Representative");
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
		Employee employee = new Employee("Brittany", "Product Owner");
		Mockito.when(myRepository.save(employee)).thenReturn(employee);
		Employee response = employeeService.addEmployee(employee);
		Mockito.verify(myRepository).save(employee);
		assertNotNull(response);
		
	}
	
	@Test
	public void updateEmployeeDetails_and_successufl() {
		long id = 101;
		String newName = "Hammed";
		String newJobRole = "Software Developer";
		Employee employee = new Employee(101,"Jared","Sales Representative");
		Mockito.when(myRepository.findEmployeeByEmployeeId(id)).thenReturn(employee);
		Employee updatedEmployee = new Employee(101,newName,newJobRole);
		Mockito.when(myRepository.save(Mockito.any(Employee.class))).thenReturn(updatedEmployee);
		Employee response = employeeService.updateEmployeeDetails(updatedEmployee);
		assertNotNull(response);
		assertEquals(response.getName(), updatedEmployee.getName());
		Mockito.verify(myRepository).save(Mockito.any(Employee.class));
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
