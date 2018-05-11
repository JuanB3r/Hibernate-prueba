package pruebas;

import modelo.Direccion;
import modelo.Empleado;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class Main {

    private static EntityManager manager;
    private static EntityManagerFactory managerFactory;

    public static void main(String[] args) {
        //Obtiene la configuración de persistence.xml y crea el gestor de persistencia
        managerFactory = Persistence.createEntityManagerFactory("Persistencia");
        manager = managerFactory.createEntityManager();

        Empleado empleado = new Empleado("Celedon Mendoza", "Danna", LocalDate.now());
        empleado.setDireccion(new Direccion("Calle 20 # 32", "Barranquilla", "Atlantico", "Colombia"));

        Empleado empleado2 = new Empleado("Bermudez Celedon", "Juan David", LocalDate.of(1993, 12, 03));
        empleado.setDireccion(new Direccion("Calle 2 # 32", "Valledupar", "Cesar", "Colombia"));

        manager.getTransaction().begin(); //Inicia la transacción
        manager.persist(empleado);
        manager.persist(empleado2);
        manager.getTransaction().commit(); // Finaliza la transacción

        List<Empleado> empleados = null;
        try {
            empleados = manager.createQuery("FROM Empleado").getResultList(); //Obtener todos los empleados usando JPQL
            System.out.println("Hay " + empleados.size() + " empleados");
            //Obtener todos los empleados usando SQL
            empleados = manager.createNativeQuery("SELECT * FROM empleados", Empleado.class).getResultList();
            System.out.println("Hay " + empleados.size() + " empleados");
            for (Empleado e: empleados) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        } finally {
            //Cerrar los gestores y liberar los recursos
            manager.close();
            managerFactory.close();
            //System.exit(0);
        }
    }
}
