package com.steven.webappdemo1.hello;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SayHelloController {

    @RequestMapping("sayhello")
    @ResponseBody
    public String sayHello() {
        return "Hello World!";
    }

    @RequestMapping("sayhello-html")
    @ResponseBody
    public String sayHelloHtml() {
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> This is a title </title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("this is a body");
        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();
    }

    @RequestMapping("sayhello-jsp")
    public String sayHelloJSP() {
        return "sayHello";
    }
}
