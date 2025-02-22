package resources;

import java.util.HashMap;
import java.util.Map;

public class DataRequest {

 public Map<String, String> addItem(){
        Map<String, String> payloads = new HashMap<>();

        payloads.put("addItem", "{"
    + "\"name\": \"Handuk Hitam\","
    + "\"data\": {"
    + "   \"year\": 2029,"
    + "   \"price\": 1849,"
    + "   \"CPU model\": \"Intel Core i9\","
    + "   \"Hard disk size\": \"1 TB\""
    + " }"
    + "}");

    payloads.put("addItem2", "{"
    + "\"id\": \"6\","
    + "\"name\": \"Apple AirPods\","
    + "\"data\": {"
    + "\"generation\": \"3rd\","
    + "\"price\": 120"
    + "}"
    + "}");


    return payloads;

    
                          
       
}
}