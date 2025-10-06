package com.nttdata.glue;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import com.nttdata.steps.CrearOrdenStep;

public class CrearOrdenStepDef {

    @Steps
    CrearOrdenStep crearOrden;

    @When("creo la orden con id {int}, petId {int}, cantidad {int} y estado {string}")
    public void crearOrden(int id, int petId, int quantity, String status) {
        crearOrden.crearOrden(id, petId, quantity, status);
    }

    @Then("el código de respuesta de la orden es {int}")
    public void CodigoRespuesta(int statusCode) {
        crearOrden.validarCodigoRespuesta(statusCode);
    }

    @And("el estado de la orden es {string}")
    public void EstadoOrden(String status) {
        crearOrden.validarStatus(status);
    }
}