package com.nttdata.glue;

import com.nttdata.steps.ConsultarMascotaStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ConsultarMascotaStepDef {
    @Steps
    ConsultarMascotaStep consultarMascotaStep;

    @Given("estoy en la pagina de mascotas")
    public void estoyEnLaPaginaDeMascotas() {
    }

    @When("hago la consulta de la mascota con el id {int}")
    public void hagoLaConsultaDeLaMascotaConElId(int idMascota) {
        consultarMascotaStep.consultarMascota(idMascota);
    }

    @Then("el código de la respuesta de mascota es {int}")
    public void elCódigoDeLaRespuestaDeMascotaEs(int statusCode) {
        consultarMascotaStep.validarCodigoRespuesta(statusCode);
    }
}