package com.company;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ColorsTest {

    static Colors colors;
    static int count;

    @BeforeAll
    static void setUp() {
        System.out.println("running");
        String[] arr = {"orange", "blue", "black", "green", "violet", "lilac", "purple"};
        colors = new Colors(arr);
    }

    @Test
    @DisplayName("Turning Array to List")
    void testArrayToList() {
        assertTrue(this.colors.turnArrayIntoList() instanceof ArrayList, "it is turned to List");
    }

    @Test
    @DisplayName("Removing element")
    void removeElement() {
        this.colors.turnArrayIntoList();
        this.colors.removeColor("blue");
        assertEquals(6, this.colors.getList().size());
    }

    @RepeatedTest(5)
    @DisplayName("Removing 5 times")
    void removingElements() {
        this.colors.turnArrayIntoList();
        this.colors.removeFirst();
        count++;
        if(count==5) {
            assertEquals(30, this.colors.getList().size());
        }
    }
}