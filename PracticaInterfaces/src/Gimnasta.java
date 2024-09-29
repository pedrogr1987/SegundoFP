/*Author: Pedro García Rodríguez
 * Date: 2024/04/06
 * Proposal: PracticaInterfaces Gimnasta, Class where the methods for Gimnasta are given
 * */
public class Gimnasta implements Persona, Comparable<Gimnasta>, Cloneable{
    private String nombre;
    private String apellidos;
    private Integer edad;
    private Float puntMedia;
    private String DNI;
//CONSTRUCTOR
    public Gimnasta(String nombre, String apellidos, Integer edad, Float puntMedia, String DNI) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.puntMedia = puntMedia;
        this.DNI = DNI;
    }
    //CLONE METHOD (IntelliJ suggested this as a less redundant way to build the clone method)
    public Gimnasta clone(){
        return new Gimnasta(this.nombre, this.apellidos, this.edad, this.puntMedia, this.DNI);
    }
    //GETTERS
    @Override
    public String getNombre(){
        return this.nombre;
    }
    @Override
    public String getApellidos(){
        return this.apellidos;
    }
    @Override
    public Integer getEdad(){
        return this.edad;
    }
    @Override
    public Float getpuntMedia(){
        return this.puntMedia;
    }
    @Override
    public String getDNI(){
        return this.DNI;
    }
    //SETTERS
    @Override
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    @Override
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }

    @Override
    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    @Override
    public void setPuntMedia(Float puntMedia){
        this.puntMedia = puntMedia;
    }
    @Override
    public void setDNI(String dni){
        this.DNI = dni;
    }
    //COMPARABLE
    public int compareTo(Gimnasta g){
        //I start defining the variable resultado so it will vary depending on the situation
        int resultado;
        //We compare the name first
        if (this.getNombre().compareTo(g.getNombre())== 0) {
            //If the name it is the same we continue comparing the surname
            if (this.getApellidos().compareTo(g.getApellidos())== 0){
                resultado = this.edad - g.edad;
            }
            else{
                //If the name is the same but not the surname, the method gives the difference between them
                resultado = (this.getApellidos().compareTo(g.getApellidos()));}
        }
        //
        else{
            //If the names are different the method gives the difference between names
            resultado = (this.getNombre().compareTo(g.getNombre()));
        }
        //The return is the resultado variable with the value obtained
        return resultado;
    }
}
