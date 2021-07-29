package ibm.employee.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import ibm.employee.dao.EmployeeDAO;
import ibm.employee.model.Employee;
import ibm.employee.service.EmployeeServiceImpl;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;



@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan({"ibm.employee.dao","ibm.employee.service"})
public class EmployeeServiceTest {
	
	@Autowired
    private EmployeeService employeeService;
	
	@MockBean
	private EmployeeDAO repository;
	
	private AutoCloseable closeable;
	
	@Before
	public void initMocks()
	{
		Mockito.framework().clearInlineMocks();
		closeable= MockitoAnnotations.openMocks(this);
	}
	@Test
	public void getAllEmployees_and_return_employees() {
		List<Employee> employees = getAllEmployees();
		Mockito.when(repository.findAll()).thenReturn(employees);
		List<Employee> response = employeeService.getAllEmployees();
		assertNotNull(response);
		assertEquals(employees.size(), response.size());
		
	}
	
	@Test
	public void getAllEmployees_and_return_null() {
		Mockito.when(repository.findAll()).thenReturn(null);
		List<Employee> response = employeeService.getAllEmployees();
		assertNull(response);
	}
	
	
	@Test
	public void getEmployeeById_and_return_Employee() {
		long id = 101;
		Employee employee = new Employee(101,"Jared","Sales Representative");
		Mockito.when(repository.findEmployeeByEmployeeId(id)).thenReturn(employee);
		Employee response = employeeService.getEmployeeById(id);
		assertNotNull(response);
		assertEquals(employee.getName(), response.getName());
		assertEquals(employee.getJobRole(),response.getJobRole());
	}
	
	@Test
	public void getEmployeeById_and_return_null() {
		long id = 101;
		Mockito.when(repository.findEmployeeByEmployeeId(id)).thenReturn(null);
		Employee response = employeeService.getEmployeeById(id);
		assertNull(response);
	}
	
	
	@Test
	public void addEmployee_and_return_employee() {
		Employee employee = new Employee("Brittany", "Product Owner");
		Mockito.when(repository.save(employee)).thenReturn(employee);
		Employee response = employeeService.addEmployee(employee);
		Mockito.verify(repository).save(employee);
		assertNotNull(response);
		
	}
	
	@Test
	public void updateEmployeeDetails_and_successufl() {
		long id = 101;
		String newName = "Hammed";
		String newJobRole = "Software Developer";
		Employee employee = new Employee(101,"Jared","Sales Representative");
		Mockito.when(repository.findEmployeeByEmployeeId(id)).thenReturn(employee);
		Employee updatedEmployee = new Employee(101,newName,newJobRole);
		Mockito.when(repository.save(Mockito.any(Employee.class))).thenReturn(updatedEmployee);
		Employee response = employeeService.updateEmployeeDetails(updatedEmployee);
		assertNotNull(response);
		assertEquals(response.getName(), updatedEmployee.getName());
		Mockito.verify(repository).save(Mockito.any(Employee.class));
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
