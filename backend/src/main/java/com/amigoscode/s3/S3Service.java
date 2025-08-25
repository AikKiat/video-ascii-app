package com.amigoscode.s3;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;

import static java.rmi.server.LogStream.log;

@Service
public class S3Service {
    private static final Logger log = LoggerFactory.getLogger(S3Service.class);
    //2 methods: One to store objects in the S3 Bucket, and the other to upload
    //"Never create a bucket through code. The Devops team should utilise Infrastructure a Code (all the different tools), to create the bucket for us.
    //For example, just create it in the AWS user portal.

    private final S3Client s3Client;

    public S3Service(S3Client s3Client){
        this.s3Client = s3Client;
    }

    //"This allows us to store a file into a given bucket, with a given key..."
    public void putObject(String s3BucketName, String identifierURIKey, byte[] fileToStore){
        PutObjectRequest objectRequest = PutObjectRequest.builder()
                .bucket(s3BucketName)
                .key(identifierURIKey)
                .build();

        s3Client.putObject(objectRequest, RequestBody.fromBytes(fileToStore)); //here, the fileToStore is in the format of a byte array, like a pbm file.
        //We store this file in the S3 bucket and this file is sent over via a URL Endpoint, which denotes the RequestBody wherein the various params
        //Specify the makeup of this file.
        //fromBytes takes in the byte array and processes this file to be feasible storage in S3.
    }

    //****format will be s3://bucket_name/identifierURIKey***
    public byte[] getObject(String bucketName, String identifierURIKey){
        GetObjectRequest objectToRetrieve = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(identifierURIKey)
                .build();
        ResponseInputStream<GetObjectResponse> res = s3Client.getObject(objectToRetrieve);
        try{
            return res.readAllBytes();
        } catch (IOException e){
            log(e.getMessage());
            throw new RuntimeException(e);
        }

    }





}
