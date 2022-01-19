package com.apiautomation.resources;

public enum ApiResources {

    CreateEmployee("/create"),
    GetEmployee("/employee/");

    String _resource;

    ApiResources(String resource){
        _resource = resource;
    }

    public String getResource(){
        return _resource;
    }

}
