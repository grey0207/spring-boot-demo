package demo.controller;

import demo.services.MyService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @Autowired
    MyService myService;
    @GetMapping("/hello")
    public String hello () throws JSONException {
        String detail = myService.fetchDetail();
        JSONObject jsonObject = new JSONObject(detail);
        JSONObject valueData = jsonObject.getJSONObject("value");
        String quote = valueData.getString("quote");
        return quote;
    }
}
