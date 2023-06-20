package com.empolyee.testCases;

import com.empolyee.BaseClass;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GetSingleEmpolyee extends BaseClass {

    @Test
    public void getSingleEmpolyeeTest() {
        Response response = getSingleEmpolyee();

        assertThat(response.getStatusCode(), is(HttpStatus.SC_OK));

        JSONObject jsonObject = new JSONObject(response.asString());

        assertThat(jsonObject.getString("status"), is("success"));

        JSONObject jsonObjectData = jsonObject.getJSONObject("data");

        assertThat(jsonObjectData.getString("employee_name"), is("Tiger Nixon"));
        assertThat(jsonObjectData.getString("profile_image"), notNullValue());
        assertThat(jsonObjectData.getInt("id"), is(1));
        assertThat(jsonObjectData.getInt("employee_salary"), is(320800));
        assertThat(jsonObjectData.getInt("employee_age"), is(61));
        assertThat(jsonObject.getString("message"), is("Successfully! Record has been fetched."));
    }

    //Get Single Empolyees Method
    public Response getSingleEmpolyee() {
        Response response = given()
                .request(Method.GET, "/employee/1");
        return response;
    }
}