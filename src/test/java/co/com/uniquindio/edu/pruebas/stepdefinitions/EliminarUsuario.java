package co.com.uniquindio.edu.pruebas.stepdefinitions;

import co.com.uniquindio.edu.pruebas.model.Usuario;
import co.com.uniquindio.edu.pruebas.model.UsuarioEliminar;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.jupiter.api.extension.ExtendWith;

import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.containsString;

@ExtendWith(SerenityJUnit5Extension.class)
public class EliminarUsuario {

    public static EnvironmentVariables environmentVariables;

    private UsuarioEliminar usuario;

    @Before
    public void setStage() {
        setTheStage(Cast.whereEveryoneCan(CallAnApi.at(environmentVariables.getProperty
                ("restapi.baseurl"))));
    }

    @Dado("que existe un usuario con ID {int}")
    public void existeUsuario(int id) {

        theActorCalled(String.valueOf(id)).entersTheScene();
        usuario = new UsuarioEliminar(id);

    }


    @Cuando("se elimina el usuario con ID {int}")
    public void eliminarUsuario(int id) {
        theActorInTheSpotlight().attemptsTo(Delete.from("/usuarios/" + usuario.getId()));
    }

    @Entonces("la respuesta obtenida debe tener un codigo de estado {int}")
    public void verificarEstadoRespuesta(int statusCode) {
        theActorInTheSpotlight().should(seeThatResponse(
                "el estatus es " + statusCode, response -> response.statusCode(statusCode)));
    }

    @Entonces("la respuesta debe incluir el mensaje {string} ")
    public void verificarMensajeExitoEliminacionUsuario() {
        theActorInTheSpotlight().should(seeThatResponse(
                "Verifica el mensaje en la respuesta",
                response -> response.body(containsString("Usuario eliminado con exito"))));
    }
}