package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForestController {

    @Autowired
    ForestService forestService;

    @GetMapping("/forest")
    public String mainForest(@RequestParam(value= "tree", defaultValue = "oak")String name) {
        return this.forestService.serveForest(name);
    }
}
