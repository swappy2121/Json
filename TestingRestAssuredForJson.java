package com.bridgelabz.json;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class TestingRestAssuredForJson {

    @Test
    public void postRequestForPosts() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("[\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"title\": \"json-server\",\n" +
                        "        \"author\": \"typicode\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"title\": \"json-server\",\n" +
                        "        \"author\": \"Swapnil\"\n" +
                        "    }\n" +
                        "]")
                .when()
                .post("http://localhost:3000/posts");
        response.prettyPrint();
        Assertions.assertEquals(201, response.statusCode());
    }
    @Test
    public void getRequestForPosts() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/posts");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
    @Test
    public void putRequestForPosts() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("[\n" +
                        "    {\n" +
                        "        \"id\": 1,\n" +
                        "        \"title\": \"json-server\",\n" +
                        "        \"author\": \"typicode\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"title\": \"json-server\",\n" +
                        "        \"author\": \"manish\"\n" +
                        "    }\n" +
                        "]")
                .when()
                .put("http://localhost:3000/posts/2");
        response.prettyPrint();
        Assertions.assertEquals(200, response.statusCode());
    }
    @Test
    public void postRequestForComments() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("[\n" +
                        "    {\n" +
                        "    \"id\": 2,\n" +
                        "    \"body\": \"some comment\",\n" +
                        "    \"postId\": 1\n" +
                        "\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\": 10,\n" +
                        "    \"body\": \"some comment\",\n" +
                        "    \"postId\": 1\n" +
                        "}\n" +
                        "]")
                .when()
                .post("http://localhost:3000/comments");
        response.prettyPrint();
        Assertions.assertEquals(201, response.statusCode());
    }
    @Test
    public void getRequestForComments() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/comments");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
    @Test
    public void putRequestForComments() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("[\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"body\": \"This is me swapnil\",\n" +
                        "        \"postId\": 1\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 3,\n" +
                        "        \"body\": \"My name is rakesh ramu pawar\",\n" +
                        "        \"postId\": 1\n" +
                        "    }\n" +
                        "]")
                .when()
                .put("http://localhost:3000/comments/2");
        response.prettyPrint();
        Assertions.assertEquals(200, response.statusCode());
    }
    @Test
    public void postRequestForProfile() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"id\" : 18,\n" +
                        "    \"name\": \"Swapnil ramu pawar\",\n" +
                        "    \"Address\" : \"Hastinagar , plot no. 381\",\n" +
                        "    \"Email\" : \"sopiswarrinku77@gmail.com\"\n" +
                        "\n" +
                        "}")
                .when()
                .post("http://localhost:3000/profile");
        response.prettyPrint();
        Assertions.assertEquals(201, response.statusCode());
    }
    @Test
    public void getRequestForProfile() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/profile");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
    @Test
    public void putRequestForProfile() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"id\" : 101,\n" +
                        "    \"name\": \"Swapnil ramu pawar\",\n" +
                        "    \"Address\" : \"Hastinagar ,Kokani hill , plot no. 381\",\n" +
                        "    \"Email\" : \"sopiswarrinku77@gmail.com\"\n" +
                        "\n" +
                        "}")
                .when()
                .put("http://localhost:3000/profile/101");
        response.prettyPrint();
        Assertions.assertEquals(200, response.statusCode());
    }
    @Test
    public void deleteRequestForProfile() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when()
                .delete("http://localhost:3000/profile/17");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
}
