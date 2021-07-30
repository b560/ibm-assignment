package ibm.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ibm.employee.model.Employee;
import ibm.employee.service.EmployeeService;
import ibm.employee.service.EmployeeServiceImpl;

@RestController
@ComponentScan({"ibm.employee.service"})
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeeById(@PathVariable long employeeId) {
		
		return employeeService.getEmployeeById(employeeId);
	}
	
	@PostMapping("/employees")
	public Employee addNewEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}
	
	@PutMapping("/employee")
	public Employee updateEmployeeDetails(@RequestBody Employee employee) {
		return employeeService.updateEmployeeDetails(employee);
	}	

}
