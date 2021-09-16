package com.example.demo11;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class IndexM {
    @RequestMapping("/")
    String index() {
        return "IndexM";
    }
}
