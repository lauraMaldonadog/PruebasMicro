package co.com.uniquindio.edu.pruebas.stepdefinitions;
import co.com.uniquindio.edu.pruebas.model.ActualizarDatosUsuario;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Put;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.UUID;

import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.core.StringContains.containsString;

@ExtendWith(SerenityJUnit5Extension.class)
public class ActualizarDatos {

    public static EnvironmentVariables environmentVariables;
    public ActualizarDatosUsuario usuario;

    private String nombre, email;



    @Before
    public void setStage() {
        setTheStage(Cast.whereEveryoneCan(CallAnApi.at(environmentVariables.getProperty("restapi.baseurl"))));
    }

    @Dado("que existe un usuario con ID {int} que desea actualizar")
    public void queExisteUnUsuarioConIDQueDeseaActualizar(int id) {
        theActorCalled(String.valueOf(id)).entersTheScene();
        usuario = new ActualizarDatosUsuario(id);
        //System.out.println(usuario.toString()+"\n");
    }

    /*@Cuando("se realiza una solicitud PUT a {string} con los datos actualizados: nombre {string} y email {string}")
    public void seRealizaUnaSolicitudPUTAConLosDatosActualizadosNombreYEmail(String url, String nombre, String email) {
        usuario = new ActualizarDatosUsuario(nombre, email);
        theActorInTheSpotlight().attemptsTo(Put.to(url).with(request -> request.body(usuario)));
        //System.out.println("La URL es: "+ url + " el usuario es: "+usuario.toString2()+"\n");
    }*/

    @Cuando("se realiza una solicitud PUT a {string} con los datos actualizados: nombre aleatorio y email aleatorio")
    public void seRealizaUnaSolicitudPUTAConLosDatosActualizadosNombreAleatorioYEmailAleatorio(String url) {
        nombre = generarStringAleatorio();
        email = nombre+"example.com";
        usuario = new ActualizarDatosUsuario(nombre, email);
        theActorInTheSpotlight().attemptsTo(Put.to(url).with(request -> request.body(usuario)));
        System.out.println("La URL es: "+ url + " el usuario es: "+usuario.toString2()+"\n");
    }

    @Entonces("la respuesta debe tener un codigo de estado {int} de salida al actualizar")
    public void laRespuestaDebeTenerUnCodigoDeEstadoDeSalidaAlActualizar(int codigo) {
        theActorInTheSpotlight().should(seeThatResponse(
                "el estatus es "+codigo, response -> response.statusCode(codigo)));
        //System.out.println(codigo+"\n");
    }



    private String generarStringAleatorio() {
        return UUID.randomUUID().toString().substring(0, 8); // Tomar solo los primeros 8 caracteres del UUID
    }

    @Y("la respuesta debe incluir un mensaje de exito {string}")
    public void laRespuestaDebeIncluirUnMensajeDeExito(String mensaje) {
        theActorInTheSpotlight().should(seeThatResponse(
                "Verifica el mensaje en la respuesta",
                response -> response.body(containsString(mensaje))));
        //System.out.println(mensaje);
    }
}
