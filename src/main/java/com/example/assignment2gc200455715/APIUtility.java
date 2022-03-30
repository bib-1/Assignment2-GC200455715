package com.example.assignment2gc200455715;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIUtility {
    public static BookDetails getBookDetails(String searchLetter)
    {
        String uri = "https://www.googleapis.com/books/v1/volumes?q=" + searchLetter + "&key=AIzaSyAj-_A4gXH7P2a2-f32mkuRn-gGYWNzicg";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        try {
            //this will call the API and write the result to the file "javaApiFeteched.json"
            HttpResponse<String> response = client.send(httpRequest, HttpResponse
                    .BodyHandlers.ofString());
            Gson gson = new Gson();
            return gson.fromJson(response.body(), BookDetails.class);

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getBookDetails("Father"));

    }
}
