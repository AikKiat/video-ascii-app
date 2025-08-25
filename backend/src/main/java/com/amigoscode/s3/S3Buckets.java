package com.amigoscode.s3;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix = "aws.s3.buckets")
// as per the same subgroup defined in application.yml
//So what is @Configuration and @ConfigurationProperties?? THEY ARE decorators, the way of Spring which is declaratively telling SpringBoot to bind properties
//From our configuration file --> application.yml, to certain variables in our class here!! This is of course defined and set (what variables to bind)
//Through our ConfigurationProperties decorator. The prefix argument tells Spring boot, under what hierarchical tree / nest
// the variables lying within must be set to. In this case, it is: aws.s3.buckets.customer ---> the CUSTOMER VARIABLE!!!
//Therefore, here, the variable customer must be syntatically identical 100% to the configuration parameter bounded to it, which is thus "customer"
//Then, generate the getters and setters through standard camelCase, and it must be get<....Variable name....> & set<....Variable name....>
//If not, this fails as well and we will get the error <...Variable name...> must not be NULL.
//ELse, just add lombok to handle the getters and setters automatically. ;)
public class S3Buckets {
    private String customer;

    public String getCustomer(){
        return customer;
    }

    public void setCustomer(String customer){
        this.customer = customer;
    }
}
