package tests;

import helpers.GenerateTestData;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import models.DeletePurchasingThePetResponseBody;
import models.OrderPurchasingThePetRequestBody;
import models.OrderPurchasingThePetResponseBody;
import org.junit.jupiter.api.*;
import servicemethods.ServiceMethodsForPetstoreTests;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

@Feature("Petstore")
@Tags({@Tag("API"), @Tag("Store")})
@DisplayName("Тестирование методов покупки питомцев сервиса Petstore")
public class StoreTests {

    ServiceMethodsForPetstoreTests serviceMethodsForPetstoreTests = new ServiceMethodsForPetstoreTests();
    GenerateTestData generateTestData = new GenerateTestData();

    @Test
    @Severity(BLOCKER)
    @DisplayName("Позитивный сценарий на добавление питомца к заказу")
    void orderPurchasingThePetTest() {

        String shipDate = generateTestData.getRandomDate();
        String status = generateTestData.getRandomStatus();
        int id = generateTestData.getRandomId();
        int petId = generateTestData.getRandomId();
        int quantity = generateTestData.getRandomInt(0,4);
        boolean complete = generateTestData.getRandomBoolean();

        OrderPurchasingThePetRequestBody requestBody = OrderPurchasingThePetRequestBody.builder().shipDate(shipDate).status(status).id(id).petId(petId).quantity(quantity).complete(complete).build();
        OrderPurchasingThePetResponseBody response =
                step("Отправка валидного POST запроса на создание заказа питомца", () ->
                        serviceMethodsForPetstoreTests.createOrderForAPet(requestBody));

        step("Проверка тела ответа", () ->

                Assertions.assertAll(() -> {
                    assertThat(response.getStatus()).isEqualTo(status);
                    assertThat(response.getShipDate()).isEqualTo(shipDate);
                    assertThat(response.getId()).isEqualTo(id);
                    assertThat(response.getPetId()).isEqualTo(petId);
                    assertThat(response.getQuantity()).isEqualTo(quantity);
                    assertThat(response.getComplete()).isEqualTo(complete);
                })
        );
    }

    @Test
    @Severity(CRITICAL)
    @DisplayName("Позитивный сценарий на удаление заказа питомца")
    void deletePurchasingThePetByIdTest() {

        String shipDate = generateTestData.getRandomDate();
        String status = generateTestData.getRandomStatus();
        int id = generateTestData.getRandomId();
        int petId = generateTestData.getRandomId();
        int quantity = generateTestData.getRandomInt(0, 4);
        boolean complete = generateTestData.getRandomBoolean();
        int orderId = id;
        String type = "unknown";

        OrderPurchasingThePetRequestBody requestBody = OrderPurchasingThePetRequestBody.builder().shipDate(shipDate).status(status).id(id).petId(petId).quantity(quantity).complete(complete).build();
        step("Отправка валидного POST запроса на создание заказа питомца", () ->
                serviceMethodsForPetstoreTests.createOrderForAPet(requestBody));
        DeletePurchasingThePetResponseBody response =
                step("Отправка валидного DELETE запроса на удаление существующего заказа питомца", () ->
                        serviceMethodsForPetstoreTests.deleteExistingPurchasingThePetById(orderId));

        step("Проверка тела ответа", () ->

                Assertions.assertAll(() -> {
                    assertThat(response.getCode()).isEqualTo(200);
                    assertThat(response.getType()).isEqualTo(type);
                    assertThat(response.getMessage()).isEqualTo(String.valueOf(orderId));
                })
        );
    }

    @Test
    @Severity(CRITICAL)
    @DisplayName("Негативный сценарий на удаление заказа питомца по несуществующему orderId")
    void deletePurchasingThePetByIdNegativeTest() {

        int orderId = generateTestData.getRandomId();
        String message = "Order Not Found";
        String type = "unknown";

        DeletePurchasingThePetResponseBody response =
                step("Отправка валидного DELETE запроса на удаление не существующего заказа питомца", () ->
                        serviceMethodsForPetstoreTests.deleteNotExistingPurchasingThePetById(orderId));

        step("Проверка тела ответа", () ->

                Assertions.assertAll(() -> {
                    assertThat(response.getCode()).isEqualTo(200);
                    assertThat(response.getType()).isEqualTo(type);
                })
        );
    }
}
