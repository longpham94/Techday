package common.functions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.specification.RequestSpecification;

public class UploadResult {
	protected final static String URL = "http://11.11.254.69:9090/rest/raven/1.0/import/execution/cucumber";
	protected final static String userName = "pttlong";
	protected final static String password = "1";
	public static void UploadCucumber(String resultFolder) {
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName(userName);
        authScheme.setPassword(password);
        RestAssured.authentication = authScheme;
		RequestSpecification request = RestAssured.given();//.relaxedHTTPSValidation();
		JSONArray jsonArray = new JSONArray(readText(resultFolder));
		request.contentType("application/json");
		request.body(jsonArray.toString());
		io.restassured.response.Response response = response = request.post(URL);
		System.out.println("STATUS CODE --- " + response.getStatusCode());
		System.out.println("BODY --- " + response.getBody().asString());
	}
	
    private static String readText(String resultFolder) {
    	String data = "";
        try {
            FileReader reader = new FileReader(System.getProperty("user.dir")+ File.separator + "Cucumber_Output" + File.separator + resultFolder + File.separator + "cucumber.json");
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line;
 
            while ((line = bufferedReader.readLine()) != null) {
                data = data + line + "\n";
            }
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

}