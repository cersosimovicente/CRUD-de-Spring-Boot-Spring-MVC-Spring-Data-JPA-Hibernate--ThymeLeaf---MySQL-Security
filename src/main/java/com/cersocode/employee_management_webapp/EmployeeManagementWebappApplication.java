package com.cersocode.employee_management_webapp;

import com.cersocode.employee_management_webapp.model.Employee;
import com.cersocode.employee_management_webapp.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class EmployeeManagementWebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementWebappApplication.class, args);
	}

	@Bean
	public CommandLineRunner sampleData(EmployeeRepository employeeRepository) {
		return (args) -> {
			employeeRepository.save(new Employee(null, "John", "Smith", "john.smith@example.com"));
			employeeRepository.save(new Employee(null,"Jane", "Lopez", "jane.lopez@example.com"));
			employeeRepository.save(new Employee(null, "Ben", "Stone", "ben.stone@example.com"));
		};
	}
}