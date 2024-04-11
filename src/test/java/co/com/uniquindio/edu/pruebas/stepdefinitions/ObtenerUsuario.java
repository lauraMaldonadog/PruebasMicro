package co.com.uniquindio.edu.pruebas.stepdefinitions;


import co.com.uniquindio.edu.pruebas.model.UsuarioObtener;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.jupiter.api.extension.ExtendWith;


import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.core.StringContains.containsString;

@ExtendWith(SerenityJUnit5Extension.class)
public class ObtenerUsuario {

    public static EnvironmentVariables environmentVariables;

    private List<UsuarioObtener> usuarios;
    private UsuarioObtener usuario1;
    private UsuarioObtener usuario2;
    private UsuarioObtener usuario3;

    @Before
    public void setStage() {
        setTheStage(Cast.whereEveryoneCan(CallAnApi.at(environmentVariables.getProperty
                ("restapi.baseurl"))));
    }

    @Dado("que {string}, {string} y {string}")
    public void usuariosEnElSistema(String nombreUsuario1, String nombreUsuario2, String nombreUsuario3) {

        theActorCalled(nombreUsuario1).entersTheScene();
        theActorCalled(nombreUsuario2).entersTheScene();
        theActorCalled(nombreUsuario3).entersTheScene();
        usuario1 = new UsuarioObtener(nombreUsuario1);
        usuario2 = new UsuarioObtener(nombreUsuario2);
        usuario3 = new UsuarioObtener(nombreUsuario3);
    }

    @Cuando("se realiza una solicitud GET a {string}")
    public void solicitudGET(String endpoint) {
        theActorInTheSpotlight().attemptsTo(Get.resource(endpoint));
    }

    @Entonces("la respuesta debe incluir un codigo de estado 200")
    public void verificarEstadoRespuestaCorrecta(){
        theActorInTheSpotlight().should(seeThatResponse(
                "el estatus es 200", response -> response.statusCode(200)));
    }

    @Entonces("la respuesta debe incluir la informacion de los usuarios")
    public void verificarInformacionUsuarios() {
        List<UsuarioObtener> usuario = UsuarioObtener.obtenerUsuarios();
        theActorInTheSpotlight().should(seeThatResponse(
                "Verifica la informacion de los usuarios",
                response -> response.body(containsString("Laura")).and().body(containsString("Angie")) .and().body(containsString("Melissa"))));

        //   response -> response.body( hasSize(greaterThan(3)))));


}}
