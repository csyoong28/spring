package com.javainuse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.javainuse.model.Employee;
import com.javainuse.model.EmployeeHealthInsurance;
import com.javainuse.service.EmployeeService;
import com.javainuse.service.OrganizationService;
import com.javainuse.service.impl.InvalidInsuranceAmountException;

@SpringBootApplication
public class SpringBootJdbcApplication {

	@Autowired
    EmployeeService employeeService;

	public static void main(String[] args) throws InvalidInsuranceAmountException {
	    SpringBootJdbcApplication springBootJdbcApplication = new SpringBootJdbcApplication();
	    springBootJdbcApplication.useCase1(args);
	}
	
	public void useCase1(String[] args) throws InvalidInsuranceAmountException {
	    ApplicationContext context = SpringApplication.run(SpringBootJdbcApplication.class, args);
        OrganizationService organizationService = context.getBean(OrganizationService.class);
        
        EmployeeService employeeService = context.getBean(EmployeeService.class);

        Employee emp = new Employee();
        emp.setEmpId("emp1");
        emp.setEmpName("emp1");

        EmployeeHealthInsurance employeeHealthInsurance = new EmployeeHealthInsurance();
        employeeHealthInsurance.setEmpId("emp1");
        employeeHealthInsurance.setHealthInsuranceSchemeName("premium");
        employeeHealthInsurance.setCoverageAmount(-20000);
        
        //employeeService.insertEmployee(emp);

        organizationService.joinOrganization(emp, employeeHealthInsurance);

	}
}