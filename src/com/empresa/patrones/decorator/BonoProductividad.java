package com.empresa.patrones.decorator;

/**
 * Patrón Decorator - Decorador Concreto
 * Rol: Envuelve el salario e incrementa un bono monetario.
 */
public class BonoProductividad extends SalarioDecorator {
    private double montoBono;

    public BonoProductividad(ComponenteSalario componente, double montoBono) {
        super(componente);
        this.montoBono = montoBono;
    }

    @Override
    public double calcularSalario() {
        // Se suma el bono a lo que resulte del cálculo original o anterior en la cadena
        return super.calcularSalario() + montoBono;
    }

    @Override
    public String obtenerDescripcion() {
        return super.obtenerDescripcion() + " + Bono Productividad ($" + montoBono + ")";
    }
}
