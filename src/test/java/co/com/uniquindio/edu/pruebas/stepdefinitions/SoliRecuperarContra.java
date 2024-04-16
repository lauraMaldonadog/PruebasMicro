package co.com.uniquindio.edu.pruebas.stepdefinitions;

import co.com.uniquindio.edu.pruebas.model.UsuarioReestaContra;
import com.github.javafaker.Faker;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.core.StringContains.containsString;
public class SoliRecuperarContra {


    public static EnvironmentVariables environmentVariables;
    private String url;
    private UsuarioReestaContra usuario;
    private String token;
    private Faker faker = new Faker();


    @Before
    public void setStage() {
        setTheStage(Cast.whereEveryoneCan(CallAnApi.at(environmentVariables.getProperty
                ("restapi.baseurl"))));
    }

    @Dado("que existe un usuario con email {string} registrado en la base de datos")
    public void existeUsuarioRegistrado(String email) {
        theActorCalled(email).entersTheScene();
        usuario = new UsuarioReestaContra(email);
    }

    @Cuando("se realiza una solicitud POST a {string} con el email del usuario")
    public void solicitudRecuperacionContrasena(String url) {
        theActorInTheSpotlight().attemptsTo(Post.to(url).with(request -> request.body(usuario)));
        token = SerenityRest.lastResponse().path("token");
    }

    @Cuando("realiza el cambio de contrasena con un POST a {string}")
    public void solicitudCambioContrasena(String url) {
            UsuarioReestaContra newUser= new UsuarioReestaContra(
                    usuario.getEmail(),
                    faker.internet().password(),
                    token);
        theActorInTheSpotlight().attemptsTo(Post.to(url).with(request -> request.body(newUser)));
    }


    @Entonces("la respuesta debe contener un codigo de estado {int}")
    public void verificarCodigoEstado(int statusCode) {
        theActorInTheSpotlight().should(seeThatResponse(
                "el estatus es " + statusCode, response -> response.statusCode(statusCode)));
    }

    @Entonces("la respuesta es un mensaje de exito {string}")
    public void verificarMensajeExito(String mensajeExito) {
        theActorInTheSpotlight().should(seeThatResponse(
                "Verifica el mensaje en la respuesta",
                response -> response.body(containsString(mensajeExito))));
    }
    Response miRespuesta;

    @Entonces("la respuesta debe incluir un token de recuperacion")
    public void verificarTokenRecuperacion() {
        theActorInTheSpotlight().should(seeThatResponse(
                "Verifica el token en la respuesta",

                response -> response.body(containsString("token"))));

    }
}
