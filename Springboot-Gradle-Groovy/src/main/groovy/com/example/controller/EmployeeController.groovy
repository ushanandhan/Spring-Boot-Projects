package com.example.controller

import com.example.model.Employee
import com.example.repository.EmployeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController
{
    @Autowired
    private EmployeeRepository employeeRepository

    @GetMapping(path="/", produces = "application/json")
    public List<Employee> getEmployees()
    {
        return employeeRepository.getAllEmployee()
    }

    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee)
    {
        Integer id = employeeRepository.getAllEmployee().size() + 1
        employee.setId(id)

        employeeRepository.addEmployee(employee)

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getId())
                .toUri()

        return ResponseEntity.created(location).build()
    }
}