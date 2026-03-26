package com.empresa.patrones.command;

import com.empresa.patrones.builder.Empleado;
import com.empresa.patrones.decorator.ComponenteSalario;

/**
 * Patrón Command - Comando Concreto
 * Rol: Acopla la ejecución formal de un pago mensual con toda la estructura de Salario (Decorator) y la Entidad misma (que tiene el Strategy de cómo pagarlo).
 */
public class PagarSalarioCommand implements Comando {
    private Empleado empleado;
    private ComponenteSalario estructuraSalarial;

    public PagarSalarioCommand(Empleado empleado, ComponenteSalario estructuraSalarial) {
        this.empleado = empleado;
        this.estructuraSalarial = estructuraSalarial;
    }

    @Override
    public void ejecutar() {
        double montoFinal = estructuraSalarial.calcularSalario();
        System.out.println(">>> [Comando Ejecutado] Procesando pago para " + empleado.getNombre());
        System.out.println("    Estructura Salarial: " + estructuraSalarial.obtenerDescripcion() + " = Total: $" + montoFinal);
        
        // Se ejecuta el pago de la Entidad (la cual usa Strategy internamente)
        empleado.recibirPago(montoFinal);
    }
}
