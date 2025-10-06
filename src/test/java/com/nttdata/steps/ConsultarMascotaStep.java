package com.nttdata.steps;

import com.nttdata.model.Mascota;
import io.restassured.response.Response;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConsultarMascotaStep {
    private String URL_BASE = "https://petstore3.swagger.io/api/v3/";

    public Mascota mascota;

    public void consultarMascota(int idMascota){
        Response response = given()
                .baseUri(URL_BASE)
                .log()
                .all()
                .when()
                .get("pet/" + idMascota);
        if (response.statusCode() == 200){
            mascota = response.as(Mascota.class);
            listarMascota(mascota);
        } else if (response.statusCode() == 404) {
            String message = response.toString();
            System.out.println(message);
        }
    }

    public void listarMascota(Mascota mascota){
        System.out.println("@@@@@@@@@@@@@@@");
        System.out.println("Id Mascota: " + mascota.getId());
        System.out.println("Category: " + mascota.getCategory());
        System.out.println("Nombre Mascota: " + mascota.getName());
        System.out.println("Lista de fotos: " + mascota.getPhotoUrls());
        System.out.println("Tags: " + mascota.getTags());
        System.out.println("Estatus: " + mascota.getStatus());
        System.out.println("@@@@@@@@@@@@@@@");
    }

    public void validarCodigoRespuesta(int statusCode) {
        assertThat(lastResponse().statusCode(),is(statusCode));
    }
}