package com.empresa.patrones.factory;

import com.empresa.patrones.builder.Empleado;
import com.empresa.patrones.builder.EmpleadoBuilder;
import com.empresa.patrones.strategy.PagoCriptomonedas;

/**
 * Patrón Factory Method - Fábrica Concreta
 * Rol: Instancia especificamente a un Gerente.
 */
public class CreadorGerente extends EmpleadoFactory {

    @Override
    protected Empleado crearEmpleadoEspecifico(String id, String nombre) {
        return new EmpleadoBuilder()
                .conId(id)
                .conNombre(nombre)
                .conRol("Gerente")
                .conDepartamento("Dirección General")
                // Implementa distinta estrategia de pago por contrato para directores
                .conEstrategiaPago(new PagoCriptomonedas()) 
                .build();
    }
}
