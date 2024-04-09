package co.com.uniquindio.edu.pruebas.stepdefinitions;

import co.com.uniquindio.edu.pruebas.model.Usuario;
import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class EliminarUsuario {


    public static EnvironmentVariables environmentVariables;
    private Usuario usuario;
    @Before
    public void setStage() {
        setTheStage(Cast.whereEveryoneCan(CallAnApi.at(environmentVariables.getProperty("restapi.baseurl"))));
    }

    @Dado("que existe un usuario con ID {string}")
    public void lauraConEmailYContrasenia(String nombre, String email, String contrasena){
        theActorCalled(nombre).entersTheScene();
        usuario = new Usuario(email,contrasena);

    }
}
