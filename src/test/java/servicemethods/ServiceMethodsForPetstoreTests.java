package servicemethods;

import models.*;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static specs.PetstoreSpecs.*;

public class ServiceMethodsForPetstoreTests {

    public CreateUserResponse createUser(CreateUserRequest requestBody) {

        CreateUserResponse response = given(requestSpec)
                .body(requestBody)
                .when()
                .post("/user")
                .then()
                .spec(response200)
                .body(matchesJsonSchemaInClasspath("jsonschemes/create-user-response-json-schema.json"))
                .extract().as(CreateUserResponse.class);
        return response;
    }

    public GetUserByUserNamePositiveResponse getExistingUserByUserName(String userName) {
        GetUserByUserNamePositiveResponse responseBody = given(requestSpec)
                .when()
                .get("/user/" + userName)
                .then()
                .spec(response200)
                .body(matchesJsonSchemaInClasspath("jsonschemes/get-user-positive-response-json-schema.json"))
                .extract().as(GetUserByUserNamePositiveResponse.class);
        return responseBody;
    }

    public GetUserByUserNameNegativeResponse getNotExistingUserByUserName(String userName) {
        GetUserByUserNameNegativeResponse responseBody = given(requestSpec)
                .when()
                .get("/user/" + userName)
                .then()
                .spec(response404)
                .body(matchesJsonSchemaInClasspath("jsonschemes/get-user-negative-response-json-schema.json"))
                .extract().as(GetUserByUserNameNegativeResponse.class);
        return responseBody;
    }

    public AddANewPetResponseBody addPetToTheStore(AddANewPetRequestBody requestBody) {

        AddANewPetResponseBody responseBody = given(requestSpec)
                .body(requestBody)
                .when()
                .post("/pet")
                .then()
                .spec(response200)
                .body(matchesJsonSchemaInClasspath("jsonschemes/pet-add-to-the-store-response-json-schema.json"))
                .extract().as(AddANewPetResponseBody.class);
        return responseBody;
    }

    public OrderPurchasingThePetResponseBody createOrderForAPet(OrderPurchasingThePetRequestBody requestBody) {
        OrderPurchasingThePetResponseBody response = given(requestSpec)
                .body(requestBody)
                .when()
                .post("store/order")
                .then()
                .spec(response200)
                .extract().as(OrderPurchasingThePetResponseBody.class);
        return response;
    }

    public DeletePurchasingThePetResponseBody deleteExistingPurchasingThePetById(int orderId) {
        DeletePurchasingThePetResponseBody responseBody = given(requestSpec)
                .when()
                .delete("/store/order/" + orderId)
                .then()
                .spec(response200)
                .body(matchesJsonSchemaInClasspath("jsonschemes/delete-purchase-response-json-schema.json"))
                .extract().as(DeletePurchasingThePetResponseBody.class);
        return responseBody;
    }

    public DeletePurchasingThePetResponseBody deleteNotExistingPurchasingThePetById(int orderId) {
        DeletePurchasingThePetResponseBody responseBody = given(requestSpec)
                .when()
                .delete("/store/order/" + orderId)
                .then()
                .spec(response200)
                .body(matchesJsonSchemaInClasspath("jsonschemes/delete-purchase-response-json-schema.json"))
                .extract().as(DeletePurchasingThePetResponseBody.class);
        return responseBody;
    }
}
