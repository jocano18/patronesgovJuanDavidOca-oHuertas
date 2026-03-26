package com.empresa.patrones.strategy;

/**
 * Patrón Strategy
 * Rol: Interfaz común y polimórfica para realizar pagos.
 * Por qué: Existen varias formas de pagar la nómina a un colaborador. A futuro la empresa podría adoptar nuevas pasarelas (ej. Paypal, Binance).
 * 
 * SOLID:
 * - Open/Closed Principle (OCP): El sistema de pago es ampliable inyectando nuevas estrategias que implementen esta interfaz sin tocar el código donde se hace el pago en la entidad.
 */
public interface EstrategiaPago {
    void pagar(String nombre, double cantidad);
}
