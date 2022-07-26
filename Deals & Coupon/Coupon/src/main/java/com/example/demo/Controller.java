package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RestController
public class Controller {
	@GetMapping(path="/hello-world")  
    public String helloWorld() 

    {
        return "HelloWorld";

    }

    @GetMapping(path="/hello-world-bean")
    public HelloWorld helloWorldBean()
    {
        return new HelloWorld("Hello World");
    }


   @GetMapping(path="/hello-world/path-variable/{name}")
    public HelloWorld helloWorldPathVariable(@PathVariable String name) 
    {
        return new HelloWorld(String.format("Hello world,%s", name));
    }
}
