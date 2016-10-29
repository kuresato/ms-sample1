package sample1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class App 
{
    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hello, Spring Boot!";
    }

    public static void main( String[] args )
    {
        System.out.println("starting...");
        SpringApplication.run(App.class, args);
    }
}
