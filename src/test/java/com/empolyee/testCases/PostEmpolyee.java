package com.empolyee.testCases;

import com.empolyee.BaseClass;
import com.empolyee.models.post.DataPostBody;
import com.empolyee.models.post.PostEmpolyeeResponse;
import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PostEmpolyee extends BaseClass {

    @Test
    public void postEmpolyeeTest() {
        Faker faker = new Faker();
        String name = faker.name().name();
        String salary = "10000";
        String age = "24";

        DataPostBody dataPostBody = new DataPostBody();
        dataPostBody.setName(name);
        dataPostBody.setAge(age);
        dataPostBody.setSalary(salary);

        PostEmpolyeeResponse response = postEmpolyee(dataPostBody);

        assertThat(response.getStatus(), is("success"));
        assertThat(response.getMessage(), is("Successfully! Record has been added."));
        assertThat(response.getData().getName(), is(name));
        assertThat(response.getData().getAge(), is(age));
        assertThat(response.getData().getSalary(), is(salary));
        assertThat(response.getData().getId(), notNullValue());

    }

    //Post Empolyee Method
    public PostEmpolyeeResponse postEmpolyee(DataPostBody body) {
        PostEmpolyeeResponse response = given()
                .contentType(ContentType.JSON)
                .body(body)
                .request(Method.POST, "/create")
                .then()
                .extract()
                .as(PostEmpolyeeResponse.class);
        return response;
    }

}