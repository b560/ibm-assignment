package ibm.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;


//@ComponentScan({"ibm.employee.service","ibm.employee.controller"})
//@EntityScan("ibm.employee.model")
//@EnableJpaRepositories("ibm.employee.dao")
@SpringBootApplication
public class IbmEmployeeMainProgram {
	
	public static void main(String[] args) {
	      SpringApplication.run(IbmEmployeeMainProgram.class, args);
		}

}
