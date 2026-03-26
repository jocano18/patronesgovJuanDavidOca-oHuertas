package com.empresa.patrones;

import com.empresa.patrones.facade.RecursosHumanosFacade;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RecursosHumanosFacade recursosHumanos = new RecursosHumanosFacade();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        System.out.println("\n=== SISTEMA DE GESTIÓN DE EMPLEADOS (INTERACTIVO) ===");
        
        while (!salir) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Contratar Desarrollador");
            System.out.println("2. Contratar Gerente");
            System.out.println("3. Asignar Tarea a Empleado");
            System.out.println("4. Pagar Nómina Mensual");
            System.out.println("5. Despedir (Borrar) Empleado");
            System.out.println("6. Mostrar Plantilla de Registros");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            
            String input = scanner.nextLine();
            
            try {
                int opcion = Integer.parseInt(input.trim());
                
                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el ID del Desarrollador (ej. DEV-001): ");
                        String idDev = scanner.nextLine();
                        System.out.print("Ingrese el Nombre Completo: ");
                        String nombreDev = scanner.nextLine();
                        recursosHumanos.darDeAltaDesarrollador(idDev, nombreDev);
                        break;
                    case 2:
                        System.out.print("Ingrese el ID del Gerente (ej. GTE-001): ");
                        String idGte = scanner.nextLine();
                        System.out.print("Ingrese el Nombre Completo: ");
                        String nombreGte = scanner.nextLine();
                        recursosHumanos.darDeAltaGerente(idGte, nombreGte);
                        break;
                    case 3:
                        System.out.print("Ingrese el Nombre Exacto del Empleado a asignar: ");
                        String empTarea = scanner.nextLine();
                        System.out.print("Describa la Tarea (ej. 'Revisar la base de datos'): ");
                        String tarea = scanner.nextLine();
                        recursosHumanos.asignarProyectoAEmpleado(empTarea, tarea);
                        break;
                    case 4:
                        System.out.print("Ingrese el Nombre Exacto del Empleado a pagar: ");
                        String empPago = scanner.nextLine();
                        System.out.print("Ingrese el Sueldo Base a calcular: ");
                        double baseSalarial = Double.parseDouble(scanner.nextLine().trim());
                        recursosHumanos.pagarNominaMensual(empPago, baseSalarial);
                        break;
                    case 5:
                        System.out.print("Ingrese el Nombre Exacto del Empleado a Despedir: ");
                        String empDespedir = scanner.nextLine();
                        recursosHumanos.despedirEmpleado(empDespedir);
                        break;
                    case 6:
                        recursosHumanos.imprimirReportePlantilla();
                        break;
                    case 7:
                        salir = true;
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor, ingrese un valor numérico correcto.");
            } catch (RuntimeException e) {
                // Captura controlada de bloqueos de negocio desde el Facade (por ejemplo, "Empleado no encontrado")
                // Permite que el terminal no se caiga ni arroje excepciones gigantes en la consola.
                System.out.println(e.getMessage());
            }
        }
        
        scanner.close();
    }
}
