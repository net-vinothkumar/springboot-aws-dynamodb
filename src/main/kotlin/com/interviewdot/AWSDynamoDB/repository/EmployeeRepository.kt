package com.interviewdot.AWSDynamoDB.repository

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression
import com.amazonaws.services.dynamodbv2.model.AttributeValue
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue
import com.interviewdot.AWSDynamoDB.model.Employee
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.util.HashMap

@Repository
class EmployeeRepository {
    private val LOGGER = LoggerFactory.getLogger(EmployeeRepository::class.java)

    @Autowired
    private val mapper: DynamoDBMapper? = null

    fun insertIntoDynamoDB(employee: Employee) {
        mapper!!.save(employee)
    }

    fun getOneEmployeeDetails(employeeId: String, lastName: String): Employee {
        return mapper!!.load(Employee::class.java, employeeId, lastName)
    }

    fun updateEmployeeDetails(employee: Employee) {
        try {
            mapper!!.save(employee, buildDynamoDBSaveExpression(employee))
        } catch (exception: ConditionalCheckFailedException) {
            LOGGER.error("invalid data - " + exception.message)
        }
    }

    fun deleteEmployeeDetails(employee: Employee) {
        mapper!!.delete(employee)
    }

    fun buildDynamoDBSaveExpression(employee: Employee): DynamoDBSaveExpression {
        val saveExpression = DynamoDBSaveExpression()
        val expected = HashMap<String, ExpectedAttributeValue>()
        expected["employeeId"] = ExpectedAttributeValue(AttributeValue(employee.getEmployeeId()))
                .withComparisonOperator(ComparisonOperator.EQ)
        saveExpression.expected = expected
        return saveExpression
    }
}