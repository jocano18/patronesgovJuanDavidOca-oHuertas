package com.empresa.patrones.singleton;

import com.empresa.patrones.builder.Empleado;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * Patrón Singleton
 * Rol: Contiene la única instancia global del registro de empleados en la empresa.
 * Por qué: Evita que existan múltiples listas de empleados desincronizadas a lo largo del sistema. Garantiza una única fuente de verdad conteniendo el estado de la aplicación.
 * 
 * SOLID: 
 * - Single Responsibility Principle (SRP): Su única responsabilidad es mantener y proveer acceso a la lista global de empleados.
 */
public class RegistroEmpleados {
    // 1. Instancia única estática privada
    private static RegistroEmpleados instancia;
    
    // Estado del Singleton
    private List<Empleado> empleados;

    // 2. Constructor privado para evitar instanciación externa (new RegistroEmpleados)
    private RegistroEmpleados() {
        this.empleados = new ArrayList<>();
    }

    // 3. Método estático de acceso global (Lazy initialization)
    public static RegistroEmpleados getInstancia() {
        if (instancia == null) {
            instancia = new RegistroEmpleados();
        }
        return instancia;
    }

    public void registrarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void eliminarEmpleado(Empleado empleado) {
        empleados.remove(empleado);
    }

    public List<Empleado> obtenerTodos() {
        // Se devuelve una vista inmodificable para proteger la estructura interna (Demostración de encapsulamiento estricto)
        return Collections.unmodifiableList(empleados);
    }
}
