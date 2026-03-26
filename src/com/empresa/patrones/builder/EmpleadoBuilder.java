package com.empresa.patrones.builder;

import com.empresa.patrones.strategy.EstrategiaPago;

/**
 * Patrón Builder
 * Rol: Construye paso a paso la instancia de Empleado y la retorna configurada.
 * Por qué: Un Empleado puede tener múltiples atributos, muchos de ellos opcionales (por ejemplo un rol por defecto).
 * En lugar de tener múltiples constructores confusos (anti-patrón constructor telescopio), usamos objetos de construcción fluída.
 * 
 * SOLID: 
 * - Single Responsibility Principle (SRP): El Builder separa la lógica de ensamblaje (qué se requiere, cómo inicializarlo) retirando ese peso a la entidad Empleado propiamente dicha.
 */
public class EmpleadoBuilder {
    private String id;
    private String nombre;
    private String rol = "Sin Asignar"; // Valor por defecto
    private String departamento = "General"; // Valor por defecto
    private EstrategiaPago estrategiaPago;

    public EmpleadoBuilder conId(String id) {
        this.id = id;
        return this; // Permite concatenar .conNombre().conRol()...
    }

    public EmpleadoBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public EmpleadoBuilder conRol(String rol) {
        this.rol = rol;
        return this;
    }

    public EmpleadoBuilder conDepartamento(String departamento) {
        this.departamento = departamento;
        return this;
    }
    
    public EmpleadoBuilder conEstrategiaPago(EstrategiaPago estrategia) {
        this.estrategiaPago = estrategia;
        return this;
    }

    /**
     * Paso final: Ensambla y valida el objeto.
     */
    public Empleado build() {
        if(id == null || nombre == null) {
            throw new IllegalStateException("El ID y Nombre son obligatorios para construir un Empleado.");
        }
        return new Empleado(id, nombre, rol, departamento, estrategiaPago);
    }
}
