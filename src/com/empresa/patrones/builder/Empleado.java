package com.empresa.patrones.builder;

import com.empresa.patrones.strategy.EstrategiaPago;

/**
 * Entidad principal: Empleado
 * El Empleado depende de abstracciones para no acoplarse y evitar lógica rígida.
 * 
 * SOLID:
 * - Dependency Inversion Principle (DIP): Depende de la interfaz EstrategiaPago, no de implementaciones concretas como PagoTransferencia.
 */
public class Empleado {
    private String id;
    private String nombre;
    private String rol;
    private String departamento;
    private EstrategiaPago estrategiaPago;

    // Se asume la creación de esta clase preferiblemente a través del Builder o del mismo paquete.
    protected Empleado(String id, String nombre, String rol, String departamento, EstrategiaPago estrategiaPago) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
        this.departamento = departamento;
        this.estrategiaPago = estrategiaPago;
    }

    public String getNombre() { return nombre; }
    public String getRol() { return rol; }
    
    // El Empleado delega (Strategy) la lógica de cómo recibe pagos, en lugar de condicionales con ifs.
    public void recibirPago(double cantidad) {
        if(estrategiaPago != null) {
            estrategiaPago.pagar(nombre, cantidad);
        } else {
            System.out.println("No hay estrategia de pago definida para " + nombre);
        }
    }
    
    @Override
    public String toString() {
        return "Empleado [id=" + id + ", nombre=" + nombre + ", rol=" + rol + ", departamento=" + departamento + "]";
    }
}
