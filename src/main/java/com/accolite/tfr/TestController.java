package com.accolite.tfr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tfr")
public class TestController {

    @GetMapping("/testController")
    public String testCtrl()
    {
        return "Working Successfully";
    }
}
