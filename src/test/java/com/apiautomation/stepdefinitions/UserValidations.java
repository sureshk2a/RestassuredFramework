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

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;

public class UserValidations extends Utils {

    RequestSpecification res;
    Response response;
    TestDataBuild data = new TestDataBuild();

    @Given("Add CreateUser payload with name {string}")
    public void add_create_user_payload_with_name(String name) throws FileNotFoundException {
        // Write code here that turns the phrase above into concrete actions
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
        // Write code here that turns the phrase above into concrete actions
        System.out.println(response.getStatusCode());

    }

    @Then("{string} in response is {string}")
    public void in_response_is(String string, String string2) {
        // Write code here that turns the phrase above into concrete a ctions
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        System.out.println(js.prettify());
    }

}
