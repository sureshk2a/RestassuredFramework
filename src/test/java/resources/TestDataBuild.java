package resources;

import com.apiautomation.pojo.tourist.CreateTourist;

public class TestDataBuild {

    public CreateTourist createTouristPayload(String name,String email){

        CreateTourist createTouristPayload = new CreateTourist();
        createTouristPayload.setTourist_name(name);
        createTouristPayload.setTourist_email(email);
        createTouristPayload.setTourist_location("India");
        return createTouristPayload;

    }

}
