package com.empolyee;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;
import com.empolyee.utils.ApplicationProperties;

public class BaseClass{

    @BeforeSuite
    public void beforeSuite() {
        RestAssured.baseURI = ApplicationProperties.INSTANCE.getUrl();
    }
}
