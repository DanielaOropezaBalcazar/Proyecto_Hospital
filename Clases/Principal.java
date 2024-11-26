package Clases;

import BD.*;

import java.time.LocalDate;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
    	crudPaciente();
    	//crudEmpleado();
    	//crudConsulta();
    	//crudReceta();
    	//crudMedicacion();
    }
    
    public static void crudPaciente() {
    	pacienteBD db = new pacienteBD(); 
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n--- Menu de Pacientes ---");
            System.out.println("1. Agregar paciente");
            System.out.println("2. Mostrar todos los pacientes");
            System.out.println("3. Buscar paciente por codigo");
            System.out.println("4. Editar paciente");
            System.out.println("5. Eliminar paciente");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            
            switch (opcion) {
                case 1: // Agregar paciente
                    System.out.print("CI: ");
                    int ci = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Fecha de nacimiento (yyyy-mm-dd): ");
                    String fecha = scanner.nextLine();
                    LocalDate fechaNacimiento = LocalDate.parse(fecha);
                    System.out.print("Tipo de sangre: ");
                    String tipoSangre = scanner.nextLine();
                    System.out.print("Genero (true = Masculino, false = Femenino): ");
                    boolean Genero = scanner.nextBoolean();
                    
                    paciente nuevoPaciente = new paciente(ci, nombre, apellido, fechaNacimiento, tipoSangre, Genero);
                    db.agregarPaciente(nuevoPaciente);
                    System.out.println("Paciente agregado exitosamente.");
                    break;
                
                case 2: // Mostrar todos los pacientes
                    System.out.println("\n--- Lista de Pacientes ---");
                    db.obtenerTodos().forEach(p -> {
                        System.out.println("Codigo: " + p.getCi() + ", Nombre: " + p.getNombre() +
                                           ", Apellido: " + p.getApellido() + ", Fecha de Nacimiento: " +
                                           p.getFechaNacimiento() + ", Tipo de Sangre: " + p.getTipoSangre() +
                                           ", Genero: " + (p.isGenero() ? "Masculino" : "Femenino"));
                    });
                    break;
                
                case 3: // Buscar paciente por codigo
                    System.out.print("Ingresa el codigo del paciente: ");
                    int codigoBuscar = scanner.nextInt();
                    paciente encontrado = db.obtenerPaciente(codigoBuscar);
                    if (encontrado != null) {
                        System.out.println("Paciente encontrado: " + encontrado.getNombre() + " " + encontrado.getApellido());
                    } else {
                        System.out.println("Paciente no encontrado.");
                    }
                    break;
                
                case 4: // Editar paciente
                    System.out.print("Ingresa el codigo del paciente a editar: ");
                    int codigoEditar = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    
                    System.out.print("Nuevo CI: ");
                    int nuevoCi = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nuevo Nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Nuevo Apellido: ");
                    String nuevoApellido = scanner.nextLine();
                    System.out.print("Nueva Fecha de nacimiento (yyyy-mm-dd): ");
                    String nuevaFecha = scanner.nextLine();
                    LocalDate nuevaFechaNacimiento = LocalDate.parse(nuevaFecha);
                    System.out.print("Nuevo Tipo de sangre: ");
                    String nuevoTipoSangre = scanner.nextLine();
                    System.out.print("Nuevo Genero (true = Masculino, false = Femenino): ");
                    boolean nuevoGenero = scanner.nextBoolean();
                    
                    paciente pacienteEditado = new paciente(nuevoCi, nuevoNombre, nuevoApellido, nuevaFechaNacimiento, nuevoTipoSangre, nuevoGenero);
                    db.editarPaciente(pacienteEditado, codigoEditar);
                    System.out.println("Paciente editado exitosamente.");
                    break;
                
                case 5: // Eliminar paciente
                    System.out.print("Ingresa el codigo del paciente a eliminar: ");
                    int codigoEliminar = scanner.nextInt();
                    db.eliminarPaciente(codigoEliminar);
                    System.out.println("Paciente eliminado exitosamente.");
                    break;
                
                case 6: // Salir
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    System.exit(0);
                    break;
                
                default:
                    System.out.println("Opcion no valida. Intentalo de nuevo.");
            }
        }
    }
}