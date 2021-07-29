package ibm.employee.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ibm.employee.model.Employee;

@Repository
public interface EmployeeDAO extends CrudRepository<Employee, Long> {
	@Transactional
	public Employee findEmployeeByEmployeeId(long id);
	@Transactional
	public List<Employee> findAll();

}
