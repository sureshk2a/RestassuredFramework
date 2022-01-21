package com.apiautomation.stepdefinitions;


import io.cucumber.java.Before;

public class Hooks {


    @Before("@DeleteTourist")
    public void beforeDeleteTouristScenario(){
        UserValidations steps = new UserValidations();

    }


}
