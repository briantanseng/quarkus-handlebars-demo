package com.a98labs.demos.quarkus.thymeleaf;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class TemplateResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/resource")
          .then()
             .statusCode(200)
             .body(is("hello"));
    }

}