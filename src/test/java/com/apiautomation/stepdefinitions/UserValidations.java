package com.apiautomation.stepdefinitions;

import com.apiautomation.constants.ApplicationConstants;
import com.apiautomation.resources.TouristApiResources;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.TestDataBuild;
import resources.Utils;
import static org.junit.Assert.*;
import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;

public class UserValidations extends Utils {

    RequestSpecification res;
    Response response;
    TestDataBuild data = new TestDataBuild();
    static String dataFromResponse;

    @Given("Add CreateTourist payload with name {string} and mail {string}")
    public void add_create_tourist_payload_with_name_and_mail(String name, String mail) throws FileNotFoundException {
        res = given().spec(requestSpecification()).body(data.createTouristPayload(name,mail));
    }

    @When("User calls {string} api with {string} request")
    public void user_calls_api_with_request(String apiResource, String method) {

        TouristApiResources resource = TouristApiResources.valueOf(apiResource);
        if(method.equalsIgnoreCase("post")){
            response = res.when().post(resource.getResource());
        }else if(method.equalsIgnoreCase("get")){
            response = res.when().get(resource.getResource());
        }
        System.out.println(response.asString());

    }

    @Then("the api call is with status code {string}")
    public void the_api_call_is_with_status_code(String expectedStatusCode) {
        int actualStatusCodeResponse = response.getStatusCode();
        assertEquals(String.format("Verifying if the response status code is "+expectedStatusCode),Integer.parseInt(expectedStatusCode),actualStatusCodeResponse );
    }

    @Then("{string} in response is {string}")
    public void in_response_is(String responseKey, String expectedResponseValue) {
        String actualValueFromResponse = GetValueFromResponse(response,responseKey);
        assertEquals(String.format("Verifying %s in response has the value %s", responseKey,expectedResponseValue),actualValueFromResponse,expectedResponseValue);
    }

    @Then("map {string} to {string}")
    public void map_to(String dataToMap, String resourceName) throws FileNotFoundException {
        dataFromResponse = GetValueFromResponse(response,dataToMap);
        System.out.println(dataFromResponse);
        Response newRes = given().spec(requestSpecification()).pathParam(dataToMap,dataFromResponse)
                .when().get(ApplicationConstants.getBaseurl()+ TouristApiResources.valueOf(resourceName).getResource()+"{"+dataToMap+"}");
        System.out.println(newRes.asString());
    }

    @Given("Get {string} of the employee {string}")
    public void get_of_the_employee(String dataToFind, String name) throws FileNotFoundException {
        //Get all employees


        RequestSpecification pageResponse = given().spec(requestSpecification()).queryParam("page","");

        //Loop and find the name, then find id

    }


}
