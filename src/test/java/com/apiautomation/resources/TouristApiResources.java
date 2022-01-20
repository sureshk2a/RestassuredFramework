package com.apiautomation.resources;

public enum TouristApiResources {

    CreateTourist("/Tourist"),
    GetTourist("/Tourist/"),
    GetPageOfTourist("/Tourist"),
    DeleteEmployee("/Tourist/");

    String _resource;

    TouristApiResources(String resource){
        _resource = resource;
    }

    public String getResource(){
        return _resource;
    }

}
