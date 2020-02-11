package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller //Let's Spring know this is a Controller Class.
public class HelloController {
    @GetMapping
    @ResponseBody
    public String helloForm() {
        String html = //not really good code

                "<html>" +
                        "<body>" +
                        "<form method = 'POST' action = '/hellogoodbye'>" + //This specifies the type of request and where to send it
                        "<input type = 'text' name = 'name' />" + //The title inside the '' must match the arg in the Controller method.
                        "<input type = 'submit' value = 'Greet Me!' />" +
                        "</form>" +
                        "</body>" +
                        "</html>";
        return html;
    }

    //Handles requests at path /hello
    @ResponseBody //Tells Spring Boot that this method will return a plain text response
    @GetMapping("hello") //Specifies that this method should handle GET requests at path hello
    public String hello (){
        return "hello, Spring! ";
    }

    //Handles POST requests at path goodbye
    @ResponseBody
    @PostMapping("goodbye")
    public String goodbye(){
        return "goodbye, Spring! ";
    }

    @ResponseBody
    @RequestMapping(value="hellogoodbye", method = {RequestMethod.GET, RequestMethod.POST})
    public String hellogoodbye(@RequestParam String name) {
        return "hello and goodbye, " + name +  "! ";
    }

    //Handles requests of the form /hiThere?name=Alajia...
    /////name can equal anything
    @GetMapping("hiThere")
    @ResponseBody
    public String hiThere(@RequestParam String name){ //Tells the Spring Boot that we are expecting a param "name"
        return "Hi There " + name;
    }

    //Handles requests of the form /byeNow/Alajia
    @GetMapping("byeNow/{name}") //{name} is the custom content that varies
    @ResponseBody
    public String byeNow(@PathVariable String name){ //
        return "Bye Now" + name;
    }


}
