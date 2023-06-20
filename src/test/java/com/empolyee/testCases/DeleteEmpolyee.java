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


public class DeleteEmpolyee extends BaseClass {
    @Test
    public void deleteEmpolyeeTest() {
        Response response = deleteEmpolyee();

        assertThat(response.getStatusCode(), is(HttpStatus.SC_OK));

        JSONObject jsonObject = new JSONObject(response.asString());

        assertThat(jsonObject.getString("status"), is("success"));
        assertThat(jsonObject.getString("data"), is("2"));
        assertThat(jsonObject.getString("message"), is("Successfully! Record has been deleted"));
    }

    //Delete Empolyee Method
    public Response deleteEmpolyee() {
        Response response = given()
                .request(Method.DELETE, "/delete/2");
        return response;
    }


}
