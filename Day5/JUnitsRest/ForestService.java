package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service

public class ForestService {

    public String serveForest(String tree) {
        return "a tall "+tree + " has grown";
    }

    public List<Tree> getAllTrees() {
        Tree tree1 = new Tree("birch", 23);
        Tree tree2 = new Tree("oak", 120);
        Tree tree3 = new Tree("ashtree", 5);
        return new ArrayList<>(Arrays.asList(tree1, tree2, tree3));
    }
}
