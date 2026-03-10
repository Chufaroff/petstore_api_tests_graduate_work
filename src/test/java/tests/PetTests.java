package tests;

import helpers.GenerateTestData;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import models.AddANewPetRequestBody;
import models.AddANewPetResponseBody;
import models.Pet;
import org.junit.jupiter.api.*;
import servicemethods.ServiceMethodsForPetstoreTests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.BLOCKER;
import static org.assertj.core.api.Assertions.assertThat;

@Feature("Petstore")
@Tags({@Tag("API"), @Tag("Pet")})
@DisplayName("Тестирование методов базы сервиса Petstore")
public class PetTests {

    GenerateTestData generateTestData = new GenerateTestData();
    ServiceMethodsForPetstoreTests serviceMethodsForPetstoreTests = new ServiceMethodsForPetstoreTests();

    @Test
    @Severity(BLOCKER)
    @DisplayName("Позитивный сценарий добавления питомца в базу")
    void petAddToTheStoreTest() {

        int id = generateTestData.getRandomId();
        String name = generateTestData.getRandomFirstName();
        String status = generateTestData.getRandomStatus();

        Pet category = new Pet();
        category.setId(generateTestData.getRandomId());
        category.setName(generateTestData.getRandomUserName());
        List<String> photoUrls = Arrays.asList("https://test.qa");

        models.Tags tags = new models.Tags();
        tags.setId(generateTestData.getRandomId());
        tags.setName(generateTestData.getRandomTag());
        List<models.Tags> tagsList = new ArrayList();
        tagsList.add(tags);

        AddANewPetRequestBody requestBody = AddANewPetRequestBody.builder()
                .id(id)
                .name(name)
                .category(category)
                .photoUrls(photoUrls)
                .tags(tagsList)
                .status(status)
                .build();

        AddANewPetResponseBody responseBody =
                step("Отправка валидного POST запроса на добавление питомца в базу", () ->
                        serviceMethodsForPetstoreTests.addPetToTheStore(requestBody));

        step("Проверка тела ответа", () ->

                Assertions.assertAll(() -> {
                    assertThat(responseBody.getId()).isEqualTo(id);
                    assertThat(responseBody.getName()).isEqualTo(name);
                    assertThat(responseBody.getStatus()).isEqualTo(status);
                    assertThat(responseBody.getCategory()).isEqualTo(category);
                    assertThat(responseBody.getTags().get(0).getId()).isEqualTo(tags.getId());
                    assertThat(responseBody.getTags().get(0).getName()).isEqualTo(tags.getName());
                    assertThat(responseBody.getPhotoUrls()).isEqualTo(photoUrls);
                })
        );
    }
}
