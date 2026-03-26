package com.empresa.patrones.decorator;

/**
 * Patrón Decorator - Decorador Concreto
 * Rol: Resta una cuota mensual por seguro médico al salario.
 */
public class DescuentoSeguroMedico extends SalarioDecorator {
    private double costoSeguro;

    public DescuentoSeguroMedico(ComponenteSalario componente, double costoSeguro) {
        super(componente);
        this.costoSeguro = costoSeguro;
    }

    @Override
    public double calcularSalario() {
        // Se resta el monto a lo que resulte del cálculo original o anterior en la cadena
        return super.calcularSalario() - costoSeguro;
    }

    @Override
    public String obtenerDescripcion() {
        return super.obtenerDescripcion() + " - Seguro Médico ($" + costoSeguro + ")";
    }
}
