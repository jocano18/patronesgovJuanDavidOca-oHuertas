package com.empresa.patrones.command;

/**
 * Patrón Command
 * Rol: Interfaz que establece cómo se debe ejecutar cualquier acción de alto nivel de manera uniforme.
 * Por qué: Trata una instrucción (solicitud) como un objeto. Esto permite posponer su ejecución, meterla en una cola, auditarla, o incluso deshacerla si implementáramos 'undo()'.
 * 
 * SOLID:
 * - Single Responsibility Principle (SRP): Cada operación (AsignarTarea, PagarSalario) tendrá su propia clase donde aislar su lógica de ejecución.
 */
public interface Comando {
    void ejecutar();
}
