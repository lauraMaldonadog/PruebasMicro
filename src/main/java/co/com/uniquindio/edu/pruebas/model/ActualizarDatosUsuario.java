package co.com.uniquindio.edu.pruebas.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
        import com.fasterxml.jackson.annotation.JsonInclude;
        import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActualizarDatosUsuario {

    @JsonProperty("id")
    private int id;
    @JsonProperty("nombre") private String nombre;
    @JsonProperty("email") private String correo;
    public ActualizarDatosUsuario(int id){
        this.id=id;
    }

    public ActualizarDatosUsuario(String nombre, String correo){
        this.nombre=nombre;
        this.correo=correo;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getCorreo(){
        return correo;
    }

    public void setCorreo(String correo){
        this.correo=correo;
    }

    public String toString(){
        return "el id del usuario es:"+id;
    }

    public String toString2(){
        return "el nombre el usuario es "+ nombre+ " y el correo es: "+correo;
    }
}