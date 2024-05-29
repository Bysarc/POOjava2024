package Parcial3;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FabricaDeTrajes fabrica = new FabricaDeTrajes();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        try {
            do {
                fabrica.escribirMenu();
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();  // Consumir nueva línea

                try {
                    switch (opcion) {
                        case 1:
                            fabrica.añadirComponenteAAlmacen();
                            break;
                        case 2:
                            fabrica.listarComponentes().forEach(System.out::println);
                            break;
                        case 3:
                            fabrica.añadirTrajeAAlmacen();
                            break;
                        case 4:
                            fabrica.listarTrajes().forEach(System.out::println);
                            break;
                        case 5:
                            System.out.print("Ingrese el ID del componente a actualizar: ");
                            int idActualizar = scanner.nextInt();
                            scanner.nextLine();  // Consumir nueva línea
                            Optional<Componente> componenteActualizar = fabrica.obtenerComponente(c -> c.getId() == idActualizar);
                            if (componenteActualizar.isPresent()) {
                                Componente viejoComponente = componenteActualizar.get();
                                System.out.println("Ingrese los nuevos datos del componente:");
                                System.out.print("Nuevo precio: ");
                                double nuevoPrecio = scanner.nextDouble();
                                scanner.nextLine();  // Consumir nueva línea
                                System.out.print("Nuevo color: ");
                                String nuevoColor = scanner.nextLine();
                                System.out.print("Nueva talla: ");
                                String nuevaTalla = scanner.nextLine();

                                Componente nuevoComponente;
                                if (viejoComponente instanceof Falda) {
                                    Falda viejaFalda = (Falda) viejoComponente;
                                    nuevoComponente = new Falda(viejoComponente.getId(), viejoComponente.getNombre(), nuevaTalla, nuevoColor, viejoComponente.isEsComunitario(), nuevoPrecio, viejaFalda.isConCremallera());
                                } else if (viejoComponente instanceof Pantalon) {
                                    Pantalon viejoPantalon = (Pantalon) viejoComponente;
                                    nuevoComponente = new Pantalon(viejoComponente.getId(), viejoComponente.getNombre(), nuevaTalla, nuevoColor, viejoComponente.isEsComunitario(), nuevoPrecio, viejoPantalon.isConCremallera());
                                } else if (viejoComponente instanceof Blusa) {
                                    Blusa viejaBlusa = (Blusa) viejoComponente;
                                    nuevoComponente = new Blusa(viejoComponente.getId(), viejoComponente.getNombre(), nuevaTalla, nuevoColor, viejoComponente.isEsComunitario(), nuevoPrecio, viejaBlusa.isMangaLarga());
                                } else if (viejoComponente instanceof Chaqueta) {
                                    Chaqueta viejaChaqueta = (Chaqueta) viejoComponente;
                                    nuevoComponente = new Chaqueta(viejoComponente.getId(), viejoComponente.getNombre(), nuevaTalla, nuevoColor, viejoComponente.isEsComunitario(), nuevoPrecio, viejaChaqueta.getNumBotones());
                                } else {
                                    throw new IllegalArgumentException("Tipo de componente desconocido.");
                                }

                                fabrica.actualizarComponente(viejoComponente, nuevoComponente);
                            } else {
                                System.out.println("Componente no encontrado.");
                            }
                            break;
                        case 6:
                            System.out.print("Ingrese el ID del componente a eliminar: ");
                            int idEliminar = scanner.nextInt();
                            scanner.nextLine();  // Consumir nueva línea
                            Optional<Componente> componenteEliminar = fabrica.obtenerComponente(c -> c.getId() == idEliminar);
                            if (componenteEliminar.isPresent()) {
                                fabrica.eliminarComponente(componenteEliminar.get());
                            } else {
                                System.out.println("Componente no encontrado.");
                            }
                            break;
                        case 7:
                            fabrica.activarDesactivarRebajas();
                            System.out.println("Estado de rebajas cambiado exitosamente.");
                            break;
                        case 8:
                            fabrica.crearEnvio();
                            break;
                        case 9:
                            fabrica.crearComponentesDePrueba();
                            break;
                        case 10:
                            fabrica.eliminarTrajeDelAlmacen();
                            break;
                        case 11:
                            fabrica.consultarEnvio();
                            break;
                        case 12:
                            fabrica.limpiarDatos();
                            break;
                        case 0:
                            System.out.println("Saliendo...");
                            break;
                        default:
                            System.out.println("Opción no válida.");
                    }
                } catch (Exception e) {
                    System.err.println("Error: " + e.getMessage());
                    e.printStackTrace();  // Para obtener más información sobre el error
                }

            } while (opcion != 0);
        } finally {
            scanner.close();
        }

        fabrica.cerrarScanner();
    }
}
