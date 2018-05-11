package modelo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "empleados", schema = "public")
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column (name = "codigo")
    private int codigo;

    @Column (name = "apellidos")
    private String apellidos;

    @Column (name = "nombre")
    private String nombre;

    @Column (name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "id_direccion")
    private Direccion direccion;

    public Empleado() {}

    public Empleado(String apellidos, String nombre, LocalDate fechaNacimiento) {
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    public Empleado(int codigo, String apellidos, String nombre, LocalDate fechaNacimiento) {
        this.codigo = codigo;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "codigo=" + codigo +
                ", apellidos='" + apellidos + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return getCodigo() == empleado.getCodigo() &&
                Objects.equals(getApellidos(), empleado.getApellidos()) &&
                Objects.equals(getNombre(), empleado.getNombre()) &&
                Objects.equals(getFechaNacimiento(), empleado.getFechaNacimiento());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getCodigo(), getApellidos(), getNombre(), getFechaNacimiento());
    }
}