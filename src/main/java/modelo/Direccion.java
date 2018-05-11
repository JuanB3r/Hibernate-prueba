package modelo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name = "direcciones", schema = "public")
public class Direccion {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column (name = "id")
    private int id;

    @Column (name = "direccion")
    private String direccion;

    @Column (name = "ciudad")
    private String ciudad;

    @Column (name = "departamento")
    private String departamento;

    @Column (name = "pais")
    private String pais;

    public Direccion() {}

    public Direccion(String direccion, String ciudad, String departamento, String pais) {
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.pais = pais;
    }

    public Direccion(int id, String direccion, String ciudad, String departamento, String pais) {
        this.id = id;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.pais = pais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "id=" + id +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", departamento='" + departamento + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direccion direccion1 = (Direccion) o;
        return getId() == direccion1.getId() &&
                Objects.equals(getDireccion(), direccion1.getDireccion()) &&
                Objects.equals(getCiudad(), direccion1.getCiudad()) &&
                Objects.equals(getDepartamento(), direccion1.getDepartamento()) &&
                Objects.equals(getPais(), direccion1.getPais());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getDireccion(), getCiudad(), getDepartamento(), getPais());
    }
}
