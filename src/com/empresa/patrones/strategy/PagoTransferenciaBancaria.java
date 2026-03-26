package com.empresa.patrones.strategy;

/**
 * Patrón Strategy - Estrategia Concreta
 * Rol: Lógica que emula el pago por banco tradicional.
 */
public class PagoTransferenciaBancaria implements EstrategiaPago {
    @Override
    public void pagar(String nombre, double cantidad) {
        System.out.println("[Pasarela Banco] Transfiriendo monto de $" + cantidad + " a la cuenta CTS de " + nombre);
    }
}
