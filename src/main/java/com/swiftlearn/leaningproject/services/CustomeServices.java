package com.swiftlearn.leaningproject.services;

import org.springframework.stereotype.Component;


// using component annotation this class automatic added to the injection dependencies
// So you don't have to explicit instantiate it from other class only you can use @Autowired and magically
// it will be instantiated
@Component
public class CustomeServices {
    public int getSum(int a, int b) {
        return a + b;
    }
}
