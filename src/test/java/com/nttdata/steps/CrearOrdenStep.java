package com.nttdata.steps;

import com.nttdata.model.Orden;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class CrearOrdenStep {
    private static final String BASE_URL = "https://petstore.swagger.io/v2/store/order";
    private Orden orden;

    @Step("Crear orden {0} en Petstore")
    public void crearOrden(int id, int petId, int quantity, String status) {
        String shipDate = ZonedDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));

        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"id\": " + id + ",\n" +
                        "  \"petId\": " + petId + ",\n" +
                        "  \"quantity\": " + quantity + ",\n" +
                        "  \"shipDate\": \"" + shipDate + "\",\n" +
                        "  \"status\": \"" + status + "\",\n" +
                        "  \"complete\": true\n" +
                        "}")
                .log().all()
                .post(BASE_URL)
                .then()
                .log().all();
    }

    public void validarCodigoRespuesta(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }

    public void validarStatus(String status) {
        restAssuredThat(response -> response.body("status", equalTo(status)));
        System.out.println("Estado: " + SerenityRest.lastResponse().body().path("status").toString());
        System.out.println(SerenityRest.lastResponse().print());
    }
}
