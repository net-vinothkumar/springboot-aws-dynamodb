package com.interviewdot.AWSDynamoDB.model

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument
import java.io.Serializable

@DynamoDBDocument
class Address : Serializable {
    private val serialVersionUID = 1L

    private var addressLine1: String? = null
    private var addressLine2: String? = null
    private var state: String? = null
    private var city: String? = null
    private var zipCode: String? = null

    @DynamoDBAttribute
    fun getAddressLine1(): String? {
        return addressLine1
    }

    fun setAddressLine1(addressLine1: String) {
        this.addressLine1 = addressLine1
    }

    @DynamoDBAttribute
    fun getAddressLine2(): String? {
        return addressLine2
    }

    fun setAddressLine2(addressLine2: String) {
        this.addressLine2 = addressLine2
    }

    @DynamoDBAttribute
    fun getState(): String? {
        return state
    }

    fun setState(state: String) {
        this.state = state
    }

    @DynamoDBAttribute
    fun getCity(): String? {
        return city
    }

    fun setCity(city: String) {
        this.city = city
    }

    @DynamoDBAttribute
    fun getZipCode(): String? {
        return zipCode
    }

    fun setZipCode(zipCode: String) {
        this.zipCode = zipCode
    }
}