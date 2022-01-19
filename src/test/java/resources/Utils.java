package resources;

import com.apiautomation.constants.ApplicationConstants;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import javax.print.DocFlavor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Objects;

public class Utils {

    private static RequestSpecification reqSpec;

    public RequestSpecification requestSpecification() throws FileNotFoundException {
        if(reqSpec==null){
            PrintStream log = new PrintStream(new FileOutputStream("Requestlogging.txt"));
            reqSpec = new RequestSpecBuilder().setBaseUri(ApplicationConstants.getBaseurl())
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON)
                    .build();
            return reqSpec;
        }
        return reqSpec;
    }

    public ResponseSpecification responseSpecification(int statusCode){
        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .expectContentType(ContentType.JSON)
                .build();
    }

    public String GetValueFromResponse(Response response, String key){
        String res = response.asString();
        JsonPath js = new JsonPath(res);
        return js.get(key);
    }

}
