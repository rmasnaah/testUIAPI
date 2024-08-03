package com.example;

import com.fasterxml.jackson.databind.JsonNode;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.microsoft.playwright.APIRequest;

import com.microsoft.playwright.APIRequestContext;

import com.microsoft.playwright.APIResponse;

import com.microsoft.playwright.Playwright;

import com.microsoft.playwright.options.RequestOptions;

import java.io.IOException;

import java.util.HashMap;

import java.util.Map;

import java.util.Random;

import org.junit.Assert;

//import org.junit.Before;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

public class getAPI {

        Playwright playwright;

        APIRequest request;

        APIRequestContext requestContext;

        @BeforeTest

        public void setUp() throws IOException {

                playwright = Playwright.create();

                request = playwright.request();

                requestContext = request.newContext();

        }

        @AfterTest

        public void tearDown() {

                playwright.close();

        }

        @Test

        public void createUserTest() throws IOException {

                Random rand = new Random();

                int n = rand.nextInt(50);

                n += 7;

                Map<String, Object> data = new HashMap<String, Object>();

                data.put("name", "Rawan");

                data.put("email", "test12" + n + "@gmail.com"); // user is not able to create new account with same
                                                                // email id, adding random number to email id to create
                                                                // new email id

                data.put("gender", "female");

                data.put("status", "active");

                APIResponse apiPostCallResponse = requestContext.post("https://gorest.co.in/public/v2/users",

                                RequestOptions.create()

                                                .setHeader("Content-Type", "application/json")

                                                .setHeader("Authorization",
                                                                "Bearer 76017b7159bfe03753641741dee8c829fa9d16d412e86c685533c81d241dc1c6")

                                                .setData(data));

                System.out.println(apiPostCallResponse.status());

                Assert.assertEquals(apiPostCallResponse.status(), 201);

                System.out.println(apiPostCallResponse.text());

                ObjectMapper objectMapper = new ObjectMapper();

                JsonNode jsonResponse = objectMapper.readTree(apiPostCallResponse.body());

                System.out.println(jsonResponse.toPrettyString());

                String userId = jsonResponse.get("id").asText();

                APIResponse apiGetCallResponse = requestContext.get("https://gorest.co.in/public/v2/users/" + userId,

                                RequestOptions.create()

                                                .setHeader("Authorization",
                                                                "Bearer 76017b7159bfe03753641741dee8c829fa9d16d412e86c685533c81d241dc1c6")

                );

                Assert.assertEquals(apiGetCallResponse.status(), 200);

                Assert.assertTrue(apiGetCallResponse.text().contains("Rawan"));

                Assert.assertTrue(apiGetCallResponse.text().contains(userId));

                Assert.assertTrue(apiGetCallResponse.text().contains("active"));

        }

}
