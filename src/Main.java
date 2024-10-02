//Estudiante: Juan David Jimenez Jimenez

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear un HashMap que almacenará los nombres de los contactos (clave) y sus objetos Contacto (valor).
        HashMap<String, Contacto> agenda = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("+------------------------------------------------------+");
            System.out.println("|              Gestión de Agenda de Contactos          |");
            System.out.println("+------------------------------------------------------+");
            System.out.println("|                      Opciones                        |");
            System.out.println("+------------------------------------------------------+");
            System.out.println("| 1. Añadir contacto                                   |");
            System.out.println("| 2. Mostrar todos los contactos                       |");
            System.out.println("| 3. Buscar número de teléfono de un contacto          |");
            System.out.println("| 4. Actualizar número de teléfono de un contacto      |");
            System.out.println("| 5. Eliminar contacto                                 |");
            System.out.println("| 6. Salir                                            |");
            System.out.println("+------------------------------------------------------+");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el nombre del contacto: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Introduce el número de teléfono del contacto: ");
                    String telefono = scanner.nextLine();

                    Contacto nuevoContacto = new Contacto(nombre, telefono); // Crear el contacto con los datos ingresados
                    agenda.put(nuevoContacto.getNombre(), nuevoContacto);
                    System.out.println("Contacto añadido correctamente.");
                    break;

                case 2:
                    if (agenda.isEmpty()) {
                        System.out.println("No hay contactos registrados. Primero añade un contacto.");
                    } else {
                        System.out.println("\n--- Lista de Contactos ---");
                        for (Contacto contacto : agenda.values()) {
                            System.out.println(contacto);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Introduce el nombre del contacto que deseas buscar: ");
                    String buscarNombre = scanner.nextLine();

                    if (agenda.containsKey(buscarNombre)) {
                        System.out.println("Número de teléfono de " + buscarNombre + ": " + agenda.get(buscarNombre).getTelefono());
                    } else {
                        System.out.println("El contacto no está registrado.");
                    }
                    break;

                case 4:
                    System.out.print("Introduce el nombre del contacto cuyo número deseas actualizar: ");
                    String actualizarNombre = scanner.nextLine();

                    if (agenda.containsKey(actualizarNombre)) {
                        System.out.print("Introduce el nuevo número de teléfono: ");
                        String nuevoTelefono = scanner.nextLine();

                        agenda.get(actualizarNombre).setTelefono(nuevoTelefono);
                        System.out.println("Número de teléfono actualizado correctamente.");
                    } else {
                        System.out.println("El contacto no está registrado.");
                    }
                    break;

                case 5:
                    System.out.print("Introduce el nombre del contacto que deseas eliminar: ");
                    String eliminarNombre = scanner.nextLine();

                    if (agenda.containsKey(eliminarNombre)) {
                        agenda.remove(eliminarNombre);
                        System.out.println("Contacto eliminado correctamente.");
                    } else {
                        System.out.println("El contacto no está registrado.");
                    }
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        } while (opcion != 6);
    }
}
