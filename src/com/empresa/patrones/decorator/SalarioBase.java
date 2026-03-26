package com.empresa.patrones.decorator;

/**
 * Patrón Decorator - Componente Concreto Base
 * Rol: Retorna el salario base de un empleado, sin ningún cálculo extra.
 */
public class SalarioBase implements ComponenteSalario {
    private double sueldoBase;

    public SalarioBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    @Override
    public double calcularSalario() {
        return sueldoBase;
    }

    @Override
    public String obtenerDescripcion() {
        return "Sueldo Base ($" + sueldoBase + ")";
    }
}
