package com.interviewdot.AWSDynamoDB.controller

import com.interviewdot.AWSDynamoDB.model.Employee
import com.interviewdot.AWSDynamoDB.repository.EmployeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/dynamoDb")
class EmployeeController {
    @Autowired
    private val repository: EmployeeRepository? = null

    @PostMapping
    fun insertIntoDynamoDB(@RequestBody employee: Employee): String {
        repository!!.insertIntoDynamoDB(employee)
        return "Successfully inserted into DynamoDB table"
    }

    @GetMapping
    fun getOneEmployeeDetails(@RequestParam employeeId: String, @RequestParam lastName: String): ResponseEntity<Employee> {
        val employee = repository!!.getOneEmployeeDetails(employeeId, lastName)
        return ResponseEntity<Employee>(employee, HttpStatus.OK)
    }

    @PutMapping
    fun updateEmployeeDetails(@RequestBody employee: Employee) {
        repository!!.updateEmployeeDetails(employee)
    }

    @DeleteMapping(value = "{employeeId}/{lastName}")
    fun deleteEmployeeDetails(@PathVariable("employeeId") employeeId: String,
                             @PathVariable("lastName") lastName: String) {
        val employee = Employee()
        employee.setEmployeeId(employeeId)
        employee.setLastName(lastName)
        repository!!.deleteEmployeeDetails(employee)
    }
}