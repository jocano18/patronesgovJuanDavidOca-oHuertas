package com.empresa.patrones.command;

import com.empresa.patrones.builder.Empleado;

/**
 * Patrón Command - Comando Concreto
 * Rol: Encapsula toda la información necesaria para que se pueda asignar una tarea.
 */
public class AsignarTareaCommand implements Comando {
    private Empleado empleado;
    private String tarea;

    public AsignarTareaCommand(Empleado empleado, String tarea) {
        this.empleado = empleado;
        this.tarea = tarea;
    }

    @Override
    public void ejecutar() {
        // Aquí interactuamos con el dominio para llevar a cabo la lógica encapsulada por el comando
        System.out.println(">>> [Comando Ejecutado] Tarea asignada: '" + tarea + "' para el empleado(a): " + empleado.getNombre());
    }
}
