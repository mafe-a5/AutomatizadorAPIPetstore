package com.nttdata.glue;

import com.nttdata.steps.ConsultarOrdenStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ConsultarOrdenStepDef {
    ConsultarOrdenStep consultarOrdenStep = new ConsultarOrdenStep();

    @When("consulto la orden con id {int}")
    public void consultoLaOrdenConId(int idOrden) {
        consultarOrdenStep.consultarOrdenPorId(idOrden);
    }

    @Then("el código de respuesta de la consulta es {int}")
    public void elCodigoDeRespuestaDeLaConsultaEs(int statusCode) {
        consultarOrdenStep.validarCodigoRespuesta(statusCode);
    }

    @And("muestro el estado de la orden")
    public void muestroElEstadoDeLaOrden() {
        consultarOrdenStep.imprimirEstadoOrden();
    }
}