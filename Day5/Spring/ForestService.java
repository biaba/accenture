package com.example.demo;

import org.springframework.stereotype.Service;

@Service

public class ForestService {

    public String serveForest(String tree) {
        return "a tall "+tree + " has grown";
    }
}
