package com.cersocode.employee_management_webapp.service;

import com.cersocode.employee_management_webapp.model.Employee;
import org.springframework.data.domain.Page;


import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    Employee saveEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    void deleteEmployeeById(Long id);
    Page<Employee> findPaginated(int pageNo, int pageSize);
}
