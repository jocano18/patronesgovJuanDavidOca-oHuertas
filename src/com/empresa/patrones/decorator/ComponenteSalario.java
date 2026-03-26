package com.empresa.patrones.decorator;

/**
 * Patrón Decorator
 * Rol: Proveer una interfaz de la que tanto el caso central (Salario Base) como los decoradores deriven.
 * Por qué: El salario de un empleado sufre múltiples variaciones dinámicas en su ciclo de vida mensual (descuentos por EPS/Seguro, Bonos extra, penalizaciones). Modificar un enum o la base requeriría infinidad de variaciones codificadas.
 * 
 * SOLID:
 * - Liskov Substitution Principle (LSP): Cualquier objeto que defina ComponenteSalario podrá ser utilizado de forma intercambiable y transparente.
 */
public interface ComponenteSalario {
    double calcularSalario();
    String obtenerDescripcion();
}
