package com.empresa.patrones.facade;

import com.empresa.patrones.builder.Empleado;
import com.empresa.patrones.command.AsignarTareaCommand;
import com.empresa.patrones.command.Comando;
import com.empresa.patrones.command.PagarSalarioCommand;
import com.empresa.patrones.decorator.BonoProductividad;
import com.empresa.patrones.decorator.ComponenteSalario;
import com.empresa.patrones.decorator.DescuentoSeguroMedico;
import com.empresa.patrones.decorator.SalarioBase;
import com.empresa.patrones.factory.CreadorDesarrollador;
import com.empresa.patrones.factory.CreadorGerente;
import com.empresa.patrones.factory.EmpleadoFactory;
import com.empresa.patrones.singleton.RegistroEmpleados;

import java.util.ArrayList;
import java.util.List;

/**
 * Patrón Facade
 * Rol: Provee una interfaz unificada y simple (métodos limpios) ocultando toda la complejidad de orquestar
 * el Builder, Strategy, Factory, Singleton, Command y Decorator. 
 * Por qué: Los archivos Main/Controladores NO deberían conocer cómo funcionan por dentro estos patrones o el orden de su ensamblaje.
 * 
 * SOLID:
 * - Interface Segregation Principle & Least Knowledge (Law of Demeter): Un cliente externo al paquete "patrones" usa esta fachada para interactuar, aislando el uso complejo de los métodos internos.
 */
public class RecursosHumanosFacade {
    
    // Subsistemas internos
    private final RegistroEmpleados registroBD;
    private final EmpleadoFactory factoryDev;
    private final EmpleadoFactory factoryGte;
    private final List<Comando> historicoComandos;

    public RecursosHumanosFacade() {
        this.registroBD = RegistroEmpleados.getInstancia();
        // Para acatar mejor el DIP, estas fabricas podrían haber sido inyectadas en vez de instanciarse directo.
        this.factoryDev = new CreadorDesarrollador();
        this.factoryGte = new CreadorGerente();
        this.historicoComandos = new ArrayList<>();
    }

    public void darDeAltaDesarrollador(String id, String nombre) {
        Empleado emp = factoryDev.registrarNuevoEmpleado(id, nombre);
        registroBD.registrarEmpleado(emp);
    }

    public void darDeAltaGerente(String id, String nombre) {
        Empleado emp = factoryGte.registrarNuevoEmpleado(id, nombre);
        registroBD.registrarEmpleado(emp);
    }
    
    public void despedirEmpleado(String nombreEmpleado) {
        Empleado emp = buscarEmpleado(nombreEmpleado);
        registroBD.eliminarEmpleado(emp);
        System.out.println("-> OK: El empleado " + nombreEmpleado + " ha sido dado de baja del sistema.");
    }

    private Empleado buscarEmpleado(String nombre) {
        return registroBD.obtenerTodos().stream()
                .filter(e -> e.getNombre().equals(nombre))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Error: Empleado no encontrado: " + nombre));
    }

    public void asignarProyectoAEmpleado(String nombreEmpleado, String tarea) {
        Empleado emp = buscarEmpleado(nombreEmpleado);
        
        Comando comandoAsignacion = new AsignarTareaCommand(emp, tarea);
        comandoAsignacion.ejecutar();
        
        historicoComandos.add(comandoAsignacion);
    }

    public void pagarNominaMensual(String nombreEmpleado, double baseSalarial) {
        Empleado emp = buscarEmpleado(nombreEmpleado);
        
        // Uso del patrón Decorator para armar el salario dinámico y sin violar OCP
        ComponenteSalario estructuraPago = new SalarioBase(baseSalarial);
        
        // A todos se les cobra el seguro médico por normativa de la empresa
        estructuraPago = new DescuentoSeguroMedico(estructuraPago, 50.0);
        
        // Beneficios diferenciados para el ejemplo
        if("Gerente".equals(emp.getRol())) {
             estructuraPago = new BonoProductividad(estructuraPago, 700.0);
        } else {
             estructuraPago = new BonoProductividad(estructuraPago, 250.0);
        }

        // Uso del patrón Command para encapsular el pago y luego guardar en histórico (audit log)
        Comando comandoPago = new PagarSalarioCommand(emp, estructuraPago);
        comandoPago.ejecutar();
        
        historicoComandos.add(comandoPago);
    }

    public void imprimirReportePlantilla() {
        System.out.println("--- LISTA OFICIAL DE EMPLEADOS ---");
        registroBD.obtenerTodos().forEach(e -> {
            System.out.println(" * " + e.toString());
        });
        System.out.println("----------------------------------");
    }
}
