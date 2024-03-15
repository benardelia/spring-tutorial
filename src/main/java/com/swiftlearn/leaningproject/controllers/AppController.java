package com.swiftlearn.leaningproject.controllers;

import com.swiftlearn.leaningproject.services.CustomeServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Using annotation in spring boot like one below manage the object of this class as we are not
// explicit required to creat the object rather than it going to work outside of box
@RestController
public class AppController {

    final CustomeServices customeServices;

    public AppController(CustomeServices customeServices) {
        this.customeServices = customeServices;
    }

    //    using this mapping annotation allow to use multiple mapping request on the same url
    @RequestMapping({"/home", "/homepage"})
    public String greetings() {
        return "Hello This is Spring Server";
    }

    //    using this mapping allow only get request
    @GetMapping("/get-only")
    public String onlyGet() {
        return "Hello this is only for get request";
    }

    //    This method request get methode and accept two parameter a & b which are all integers
//    the url should contain something like localhost:8080/sum?a=6&b=7
//    NB: if you provide wrong integers the error arise is BAD REQUEST 400
    @GetMapping("/sum")
    public int sum(@RequestParam("a") int a, @RequestParam("b") int b) {
        return customeServices.getSum(a, b);
    }
}
