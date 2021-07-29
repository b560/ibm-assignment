package ibm.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="employee_id")
	private long employeeId;
	private String name;
	private String jobRole;
	
	
   public Employee() {
		
	}
	
	public Employee(String name, String jobRole) {
		super();
		this.name = name;
		this.jobRole = jobRole;
	}
	
	
	
	public Employee(long employeeId, String name, String jobRole) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.jobRole = jobRole;
	}
	
	
	
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJobRole() {
		return jobRole;
	}
	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}
	
}
