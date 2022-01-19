package resources;

import com.apiautomation.pojo.AddUser;

public class TestDataBuild {

    public AddUser addUserPayload(String name){
        AddUser newUserPayload = new AddUser();
        newUserPayload.setName(name);
        newUserPayload.setSalary("75000");
        newUserPayload.setAge("24");
        return newUserPayload;
    }

}
