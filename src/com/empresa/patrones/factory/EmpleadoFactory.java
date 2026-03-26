package com.empresa.patrones.factory;

import com.empresa.patrones.builder.Empleado;

/**
 * Patrón Factory Method
 * Rol: Clase abstracta creadora que establece el contrato base para fabricar diferentes tipos de empleados preconfigurados.
 * Por qué: Permite que las subclases concretas decidan la lógica exacta de inicialización (ej, qué métodos de pago asocian por defecto) de la respectiva creación.
 * 
 * SOLID:
 * - Open/Closed Principle (OCP): Si se requiere crear un "Freelance", simplemente se crea un CreadorFreelance sin tener que modificar esta clase.
 * - Single Responsibility Principle (SRP): Separa el contexto de "dar de alta sistemas en general" del "cómo se instancia el perfil real".
 */
public abstract class EmpleadoFactory {
    
    // Método fábrica (Factory Method) a ser sobreescrito
    protected abstract Empleado crearEmpleadoEspecifico(String id, String nombre);
    
    // Una operación estándar que hace uso interno de la fábrica
    public Empleado registrarNuevoEmpleado(String id, String nombre) {
        Empleado e = crearEmpleadoEspecifico(id, nombre);
        // Lógica aplicable a cualquier empleado, independiente del rol
        System.out.println("Fábrica: Procesando documentación y alta para " + e.getNombre() + "...");
        return e;
    }
}
