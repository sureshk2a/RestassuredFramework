package com.apiautomation.stepdefinitions;

import com.apiautomation.resources.ApiResources;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
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
    String employeeId;

    @Given("Add CreateUser payload with name {string}")
    public void add_create_user_payload_with_name(String name) throws FileNotFoundException {
        res = given().spec(requestSpecification()).body(data.addUserPayload(name));
    }

    @When("User calls {string} api with {string} request")
    public void user_calls_api_with_request(String apiResource, String method) {

        ApiResources resource = ApiResources.valueOf(apiResource);
        if(method.equalsIgnoreCase("post")){
            response = res.when().post(resource.getResource());
        }else if(method.equalsIgnoreCase("get")){
            response = res.when().get(resource.getResource());
        }


    }

    @Then("the api call is with status code {string}")
    public void the_api_call_is_with_status_code(String expectedStatusCode) {
        int actualStatusCodeResponse = response.getStatusCode();
        assertEquals(String.format("Verifying if the response status code is "+expectedStatusCode),actualStatusCodeResponse, Integer.parseInt(expectedStatusCode));
    }

    @Then("{string} in response is {string}")
    public void in_response_is(String responseKey, String expectedResponseValue) {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        String actualValueFromResponse = js.get(responseKey);
        assertEquals(String.format("Verifying %s in response has the value %s", responseKey,expectedResponseValue),actualValueFromResponse,expectedResponseValue);
    }

    @Then("verify id created maps to {string} using {string}")
    public void verify_id_created_maps_to_using(String string, String string2) throws FileNotFoundException {
        employeeId = GetValueFromResponse(response,"data.id");

//        res = given().spec(requestSpecification()).pathParam("id","")
//                .

    }

}
