package com.empresa.patrones.strategy;

/**
 * Patrón Strategy - Estrategia Concreta
 * Rol: Lógica de pago alternativo usada por algunos gerentes internacionales.
 */
public class PagoCriptomonedas implements EstrategiaPago {
    @Override
    public void pagar(String nombre, double cantidad) {
        System.out.println("[Pasarela Crypto] Enviando $" + cantidad + " en USDT a la wallet de " + nombre);
    }
}
