package rmi.utilities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;



public class RestUtils {


Response response;

String baseURL="https://usaqadocker03.cotiviti.com:8081/rmi/subrules";

/**
 * GET Request
 */


public Response getRequest(String request) throws Exception {
	
	response = SerenityRest.given().baseUri(baseURL).contentType(ContentType.JSON).when().get(request);	
	
	return response;
	
	
	
}

/**
 * Verify Status Code
 */

public boolean responseStatusCode(Response response) {
	
	if(response.statusCode()==200) {
		return true;
	} else {
		return false;
	}
}
	

/**
 * Parsing JSON Array
 */

public JSONArray parseJSONArray(Response response) throws Exception {
	
	JSONParser parse = new JSONParser();
	JSONArray jsonarray = (JSONArray) parse.parse(response.asString());
	return jsonarray;
	
}

/**
 * Parsing JSON Object
 */

public JSONObject parseJSONObject(Response response) throws Exception {
	
	JSONParser parse = new JSONParser();
	JSONObject jobject = (JSONObject) parse.parse(response.asString());
	return jobject;
	
}
}
