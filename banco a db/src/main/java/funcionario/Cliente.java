package funcionario;

public class Cliente {
    //atributos
    private String nombre;
    private  String no_documento;
    private String telefono;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNo_documento() {
        return no_documento;

    }

    public void setNo_documento(String no_documento) {
        this.no_documento = no_documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}


//para la insercion de dadtos se creau metodo en la clase
//public void insertar(){}
//aqui se pograma la coneccion a bd

