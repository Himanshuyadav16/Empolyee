package com.empolyee.testCases;

import com.empolyee.BaseClass;
import com.empolyee.models.put.PutDataBody;
import com.empolyee.models.put.PutEmpolyeeResponse;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class PutEmpolyee extends BaseClass {
    @Test
    public void putEmpolyee() {
        Faker faker = new Faker();

        String name = faker.name().name();
        String salary = "100080";
        String age = "31";

        PutDataBody putDataBody=new PutDataBody();
        putDataBody.setName(name);
        putDataBody.setSalary(salary);
        putDataBody.setAge(age);

        PutEmpolyeeResponse response = putEmpolyee(putDataBody);


        assertThat(response.getStatus(), is("success"));
        assertThat(response.getMessage(), is("Successfully! Record has been updated."));

        assertThat(response.getData().getName(), is(name));
        assertThat(response.getData().getSalary(), is(salary));
        assertThat(response.getData().getAge(), is(age));
    }

    //Put Empolyee Method
    public PutEmpolyeeResponse putEmpolyee(PutDataBody body) {
        PutEmpolyeeResponse response = given()
                .contentType(ContentType.JSON)
                .body(body)
                .request(Method.PUT, "/update/21")
                .then()
                .extract()
                .as(PutEmpolyeeResponse.class);
        return response;
    }
}