package com.nttdata.steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class ConsultarOrdenStep {
    private static final String BASE_URL = "https://petstore.swagger.io/v2/store/order";
    private Response response;

    public void consultarOrdenPorId(int idOrden) {
        response = SerenityRest.given()
                .relaxedHTTPSValidation()
                .log().all()
                .when()
                .get(BASE_URL + idOrden);
        response.then().log().all();
    }

    public void validarCodigoRespuesta(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }

    public void imprimirEstadoOrden() {
        String estado = response.jsonPath().getString("status");
        System.out.println("Estado de la orden: " + estado);
    }
}