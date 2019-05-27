package demo.controller;

import demo.model.Greeting;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {
    // default
    @RequestMapping("/hello")
    public Greeting hello() {
        return new Greeting(1, "John");
    }
    // get params
    @RequestMapping("/hello2")
    public Greeting hello2(@RequestParam(value="id", defaultValue="1") int id) {
        return new Greeting(id, "John");
    }
    // get restful
    @RequestMapping("/hello3/{id}")
    public Greeting hello3(@PathVariable int id) {
        return new Greeting(id, "John");
    }
    // post json
    @PostMapping("/hello4")
    public Greeting hello4(@RequestBody Greeting greeting) {
        return greeting;
    }
    // put restful
    @PutMapping("/hello5/{id}")
    public String hello5(@PathVariable int id) {
        return String.format("update id:%s",id);
    }
    // delete restful
    @DeleteMapping("/hello6/{id}")
    public String hello6(@PathVariable int id) {
        return String.format("delete id:%s",id);
    }
}
