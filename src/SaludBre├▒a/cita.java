package SaludBreña;

public class cita {
    public String dni;
    public String nombre;
    public String apellido;
    public String fecha;
    public String hora;
    public String especialidad;

    public cita(String dni, String nombre, String apellido, String fecha, String hora, String especialidad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        this.hora = hora;
        this.especialidad = especialidad;
    }

    public String getDni() { return dni; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getFecha() { return fecha; }
    public String getHora() { return hora; }
    public String getEspecialidad() { return especialidad; }

    public void setFecha(String fecha) { this.fecha = fecha; }
    public void setHora(String hora) { this.hora = hora; }
}