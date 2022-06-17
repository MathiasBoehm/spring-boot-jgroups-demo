package de.struktuhr.jgroupsdemo.boundary;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    
    @GetMapping("/info")
    public String getInfo() {
        return "hello";
    }
}
