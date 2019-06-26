package demo.controller;

import demo.model.BaseModel;
import demo.model.Greeting;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class GreetingController {
    @PostMapping("/hello")
    public BaseModel hello(@Valid Greeting greeting) {
        return new BaseModel(greeting);
    }
}
