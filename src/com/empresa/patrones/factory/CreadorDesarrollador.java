package com.empresa.patrones.factory;

import com.empresa.patrones.builder.Empleado;
import com.empresa.patrones.builder.EmpleadoBuilder;
import com.empresa.patrones.strategy.PagoTransferenciaBancaria;

/**
 * Patrón Factory Method - Fábrica Concreta
 * Rol: Instancia especificamente a un desarrollador mediante el Builder.
 */
public class CreadorDesarrollador extends EmpleadoFactory {

    @Override
    protected Empleado crearEmpleadoEspecifico(String id, String nombre) {
        // Emplea el Builder para configurar automáticamente al desarrollador
        return new EmpleadoBuilder()
                .conId(id)
                .conNombre(nombre)
                .conRol("Desarrollador")
                .conDepartamento("Software e Ingeniería")
                .conEstrategiaPago(new PagoTransferenciaBancaria()) // Devs cobran por transferencia por defecto
                .build();
    }
}
