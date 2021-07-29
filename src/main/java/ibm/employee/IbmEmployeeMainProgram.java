package ibm.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EntityScan({"ibm.employee.model"})
@ComponentScan({"ibm.employee"})
public class IbmEmployeeMainProgram {
	
	public static void main(String[] args) {
	      SpringApplication.run(IbmEmployeeMainProgram.class, args);
		}

}
