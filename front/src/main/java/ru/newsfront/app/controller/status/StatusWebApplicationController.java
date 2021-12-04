package ru.newsfront.app.controller.status;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusWebApplicationController {

    @GetMapping("/actuator/info")
    public String getInfo() {
        return "app is alive!!";
    }
}
