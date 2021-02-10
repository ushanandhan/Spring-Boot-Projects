package com.example.repository

import com.example.model.Employee
import org.springframework.stereotype.Repository

@Repository
class EmployeeRepository {

    private static List<Employee> employeeList = new ArrayList<>();

    public List<Employee> getAllEmployee(){
        employeeList = Arrays.asList(
                new Employee(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com"),
                new Employee(2, "Alex", "Kolenchiskey", "abc@gmail.com"),
                new Employee(3, "David", "Kameron", "titanic@gmail.com")
        )
        return employeeList
    }
    public void addEmployee(Employee employee){
        employeeList.add(employee)
    }

}
