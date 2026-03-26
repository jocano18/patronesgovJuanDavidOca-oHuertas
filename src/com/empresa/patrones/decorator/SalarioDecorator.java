package com.empresa.patrones.decorator;

/**
 * Patrón Decorator - Decorador Abstracto Base
 * Rol: Envuelve a un ComponenteSalario para añadirle comportamiento u operaciones adicionales antes o después.
 * 
 * SOLID:
 * - Dependency Inversion Principle (DIP): Depende de la interfaz ComponenteSalario (abstracción) para realizar la decoración, no de SalarioBase o clases concretas.
 */
public abstract class SalarioDecorator implements ComponenteSalario {
    // Composición: El decorador contiene el objeto al que va a "envolver"
    protected ComponenteSalario salarioEnvoltorio;

    public SalarioDecorator(ComponenteSalario componente) {
        this.salarioEnvoltorio = componente;
    }

    @Override
    public double calcularSalario() {
        // Delega la operación por defecto, las subclases le añadirán o restarán valores
        return salarioEnvoltorio.calcularSalario();
    }

    @Override
    public String obtenerDescripcion() {
        return salarioEnvoltorio.obtenerDescripcion();
    }
}
