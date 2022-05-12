package com.javainuse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.javainuse.model.Employee;
import com.javainuse.model.EmployeeHealthInsurance;
import com.javainuse.service.EmployeeService;
import com.javainuse.service.HealthInsuranceService;
import com.javainuse.service.OrganizationService;

@Service
@Transactional
public class OrganzationServiceImpl implements OrganizationService {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    HealthInsuranceService healthInsuranceService;

    @Override
    @Transactional(rollbackFor = InvalidInsuranceAmountException.class)
    public void joinOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance) throws InvalidInsuranceAmountException {
        boolean active = TransactionSynchronizationManager.isActualTransactionActive();
        employeeService.insertEmployee(employee);
//		if (employee.getEmpId().equals("emp1")) {
//			throw new RuntimeException("thowing exception to test transaction rollback");
//		}
        try {
            healthInsuranceService.registerEmployeeHealthInsurance(employeeHealthInsurance);
        } catch (InvalidInsuranceAmountException e) {
            throw new InvalidInsuranceAmountException("Exception is thrown");
        }
    }

    // healthInsuranceService.registerEmployeeHealthInsurance(employeeHealthInsurance);
    //}

    @Override
    // @Transactional
    public void leaveOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance) {
        employeeService.deleteEmployeeById(employee.getEmpId());
        healthInsuranceService.deleteEmployeeHealthInsuranceById(employeeHealthInsurance.getEmpId());
    }
}