package com.interviewdot.AWSDynamoDB.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper

@Configuration
class AWSDynamoDBConfig{
    @Value("\${amazon.access.key}")
    private val awsAccessKey: String? = null

    @Value("\${amazon.access.secret-key}")
    private val awsSecretKey: String? = null

    @Value("\${amazon.region}")
    private val awsRegion: String? = null

    @Value("\${amazon.end-point.url}")
    private val awsDynamoDBEndPoint: String? = null

    @Bean
    fun mapper(): DynamoDBMapper {
        return DynamoDBMapper(amazonDynamoDBConfig())
    }

    fun amazonDynamoDBConfig(): AmazonDynamoDB {
        return AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(AwsClientBuilder.EndpointConfiguration(awsDynamoDBEndPoint, awsRegion))
                .withCredentials(AWSStaticCredentialsProvider(BasicAWSCredentials(awsAccessKey, awsSecretKey)))
                .build()
    }
}