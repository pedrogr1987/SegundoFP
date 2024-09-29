/*Author: Pedro García Rodríguez
* Date: 2024/04/06
* Proposal: PracticaInterfaces Persona, Interface where the methods for Gimnasta are given
* */
public interface Persona {
    String getNombre();
    String getApellidos();
    Integer getEdad();
    Float getpuntMedia();
    String getDNI();
    void setNombre(String nombre);
    void setApellidos(String apellidos);
    void setEdad(Integer edad);
    void setPuntMedia(Float puntmedia);
    void setDNI(String dni);
}
