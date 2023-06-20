package com.empolyee.testCases;

import com.empolyee.BaseClass;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class GetAllEmpolyee extends BaseClass {
    @Test
    public void getAllEmpolyeesTest() {
        Response response = getAllEmpolyees();

        assertThat(response.getStatusCode(), is(HttpStatus.SC_OK));

        JSONObject jsonObject = new JSONObject(response.asString());

        assertThat(jsonObject.getString("status"), is("success"));

        JSONArray jsonArray = jsonObject.getJSONArray("data");

        JSONObject jsonObjectData = jsonArray.getJSONObject(0);

        assertThat(jsonObjectData.getString("employee_name"), is("Tiger Nixon"));
        assertThat(jsonObjectData.getString("profile_image"), notNullValue());
        assertThat(jsonObjectData.getInt("employee_salary"), is(320800));
        assertThat(jsonObjectData.getInt("employee_age"), is(61));
        assertThat(jsonObjectData.getInt("id"), is(1));
        assertThat(jsonObject.getString("message"), is("Successfully! All records has been fetched."));
    }

    //Get All Empolyees Method
    public Response getAllEmpolyees() {
        Response response = given()
                .request(Method.GET, "/employees");
        return response;
    }

}
