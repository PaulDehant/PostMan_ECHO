package ru.netology.rest;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class PostmanTest {
    @Test
    void PostToPostman() {
        given()
                .baseUri("https://postman-echo.com")
                .body("some data")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data", equalTo("some data"))
        ;
    }

    @Test
    void ReturnIdToPostman() {
        given()
                .baseUri("https://postman-echo.com")
                .body("id:3")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data", equalTo("id:3"));
    }

    @Test
    void ReturnCurrencyToPostman() {
        given()
                .baseUri("https://postman-echo.com")
                .body("currency:RUB")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data", equalTo("currency:RUB"));
    }

}
