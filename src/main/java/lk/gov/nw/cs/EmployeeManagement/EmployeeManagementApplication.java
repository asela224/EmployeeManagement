package lk.gov.nw.cs.EmployeeManagement;

import lk.gov.nw.cs.EmployeeManagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class EmployeeManagementApplication {



	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);


	}

}
