package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ForestControllerTest {


    @Test
    void ensureThatForestAPICallReturnStatusCode200() throws Exception {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/")).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        assertTrue(response.statusCode()==200);
    }

    @Test
    @DisplayName("Ensures that the content type starts with application/json")
    void ensureThatJsonIsReturnedAsContentType() throws Exception {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/")).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Optional<String> firstValue = response.headers().firstValue("Content-Type");
        String string = firstValue.get();
        assert(string).startsWith("application/json");
    }

    @Test
    @DisplayName ("Ensure that response contains JSON response with object property 'name'")
    void ensureJsonContainsTreeName() throws Exception {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/")).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);
        assertTrue(body.contains("name\":\"birch\""));
    }

    @Test
    @DisplayName ("Ensure that String value is returned")
    void ensureStringValueReturned() throws Exception {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/forest")).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Optional<String> responseType = response.headers().firstValue("Content-Type");
        System.out.println("*" +  responseType.get());
        assertTrue(responseType.get().contains("text/plain"));
    }

}