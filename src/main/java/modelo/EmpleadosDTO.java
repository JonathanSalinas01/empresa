package modelo;

public class EmpleadosDTO {
    private int id;
    private String nombre;
    private String fechaContratacion;
    private String idDepartamento;

    public String getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(String idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "EmpleadosDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaContratacion='" + fechaContratacion + '\'' +
                ", idDepartamento='" + idDepartamento + '\'' +
                '}';
    }
}
