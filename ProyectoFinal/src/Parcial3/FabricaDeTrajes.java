package Parcial3;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;

public class FabricaDeTrajes implements IFabricaDeTrajes, Serializable {
    private static final long serialVersionUID = 1L;
    private List<Componente> componentesEnAlmacen;
    private TreeSet<Traje> trajesEnAlmacen;
    private List<List<Traje>> envios;
    
    
    private boolean sonRebajas;
    private transient Scanner scanner;

    public FabricaDeTrajes() {
        this.componentesEnAlmacen = cargarComponentes();
        this.trajesEnAlmacen = cargarTrajes();
        this.envios = new ArrayList<>(); // Inicialización de la lista de envíos
        this.sonRebajas = false;
        this.scanner = new Scanner(System.in);
    }

    private List<Componente> cargarComponentes() { // Se uso objeinputstream para deserializar los datos ya que me daba
                                                   // un error y esa fue la solucion

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("componentes.dat"))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                List<?> lista = (List<?>) obj;
                List<Componente> componentes = new ArrayList<>();
                for (Object item : lista) {
                    if (item instanceof Componente) {
                        componentes.add((Componente) item);
                    } else {
                        throw new ClassNotFoundException("El archivo contiene elementos que no son componentes.");
                    }
                }
                return componentes; 
            }
            throw new ClassNotFoundException("El archivo no contiene una lista de componentes.");
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    private TreeSet<Traje> cargarTrajes() { //Declara un método privado llamado cargarTrajes que no toma parámetros y devuelve un TreeSet de objetos Traje.
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("trajes.dat"))) { //ObjectInputStream Garantiza que los tipos de todos los objetos creados a partir de la secuencia
            //coincidan con las clases presentes como los datos se guardaron en bytes se utiliza 'FileinputStream' que Es la clase que se utiliza para leer bytes desde un archivo de "trajes.dat"
            Object obj = ois.readObject(); //Lee un objeto desde el flujo de entrada y lo asigna a la variable obj.
            if (obj instanceof TreeSet<?>) { //Verifica si el objeto leído es una instancia de TreeSet de cualquier tipo (<?>).
                TreeSet<?> set = (TreeSet<?>) obj; //Convierte el objeto a un TreeSet de tipo genérico.
                TreeSet<Traje> trajes = new TreeSet<>(new TrajeComparator()); //Crea un nuevo TreeSet de Traje usando un comparador personalizado TrajeComparator.
                for (Object item : set) { //Itera sobre cada elemento en el conjunto genérico.  Verifica si cada elemento es una instancia de Traje.   Si es un Traje, lo agrega al nuevo conjunto trajes.
                    if (item instanceof Traje) {
                        trajes.add((Traje) item);
                    } else {
                        throw new ClassNotFoundException("El archivo contiene elementos que no son trajes.");
                    }
                }
                return trajes;
            }
            throw new ClassNotFoundException("El archivo no contiene un conjunto de trajes.");
        } catch (IOException | ClassNotFoundException e) {
            return new TreeSet<>(new TrajeComparator());
        }
    }

    private static class TrajeComparator implements Comparator<Traje>, Serializable {
        @Override
        public int compare(Traje t1, Traje t2) {
            return t1.getNombre().compareTo(t2.getNombre());
        }
    }

    @Override
    public void añadirComponenteAAlmacen()
            throws IdException, MuchoExtracomunitarioException, MangaException, IOException {
        System.out.println("Seleccione el tipo de componente a añadir:");
        System.out.println("1. Falda");
        System.out.println("2. Pantalón");
        System.out.println("3. Blusa");
        System.out.println("4. Chaqueta");
        System.out.print("Opción: ");
        int tipoComponente = scanner.nextInt();
        scanner.nextLine(); // Consumir nueva línea

        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir nueva línea

        // Validar si el ID ya existe
        if (componentesEnAlmacen.stream().anyMatch(c -> c.getId() == id)) { //componentesEnAlmacen.stream() convierte la colección componentesEnAlmacen en un flujo de objetos Componente.
            //.anyMatch es una operación de terminal del stream que toma un predicado (una función que devuelve un booleano) y devuelve true si al menos un elemento en el flujo cumple con la condición especificada por el predicado.
            //c representa cada elemento del flujo a medida que se itera sobre él.   c.getId() obtiene el identificador (ID) del objeto c.
            throw new IdException("El ID ya existe.");
        }

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Talla: ");
        String talla = scanner.nextLine();
        System.out.print("Color: ");
        String color = scanner.nextLine();
        System.out.print("Es comunitario (true/false): ");
        boolean esComunitario = scanner.nextBoolean();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Consumir nueva línea

        // Validar número de componentes extracomunitarios
        long numComunitarios = componentesEnAlmacen.stream().filter(Componente::isEsComunitario).count();
        //es lo mismo que usar esto "componente -> componente.isEsComunitario()" donde isEsComunitario() devuelve cada elemento que filtre en true y count cuenta el numero de elementos en el flujo luego de aplicar los filtros"
        if (esComunitario && numComunitarios >= componentesEnAlmacen.size() / 2.0) {
            throw new MuchoExtracomunitarioException("Más del 50% de los componentes son comunitarios.");
        }

        Componente componente = null;
        switch (tipoComponente) {
            case 1: // Falda
                System.out.print("Tiene cremallera (true/false): ");
                boolean conCremalleraFalda = scanner.nextBoolean();
                if (conCremalleraFalda) {
                    precio += 1;
                }
                componente = new Falda(id, nombre, talla, color, esComunitario, precio, conCremalleraFalda);
                break;
            case 2: // Pantalón
                System.out.print("Tiene cremallera (true/false): ");
                boolean conCremalleraPantalon = scanner.nextBoolean();
                if (conCremalleraPantalon) {
                    precio += 1;
                }
                componente = new Pantalon(id, nombre, talla, color, esComunitario, precio, conCremalleraPantalon);
                break;
            case 3: // Blusa
                System.out.print("Manga larga (true/false): ");
                boolean mangaLarga = scanner.nextBoolean();
                scanner.nextLine(); // Consumir nueva línea
                componente = new Blusa(id, nombre, talla, color, esComunitario, precio, mangaLarga);

                // Validar blusa de manga larga y corta
                boolean existeContraparte = componentesEnAlmacen.stream()
                        .filter(c -> c instanceof Blusa)
                        .filter(c -> c.getColor().equalsIgnoreCase(color))
                        .anyMatch(c -> ((Blusa) c).isMangaLarga() != mangaLarga);

                if (!existeContraparte) {
                    throw new MangaException("No existe una blusa del mismo color con la otra longitud de manga.");
                }
                break;
            case 4: // Chaqueta
                System.out.print("Número de botones: ");
                int numBotones = scanner.nextInt();
                precio += 2 * numBotones;
                scanner.nextLine(); // Consumir nueva línea
                componente = new Chaqueta(id, nombre, talla, color, esComunitario, precio, numBotones);
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        componentesEnAlmacen.add(componente);
        guardarTodosLosComponentes();
    }

    @Override
    public List<Componente> listarComponentes() {
        return new ArrayList<>(componentesEnAlmacen);
    }

    @Override
    public Optional<Componente> obtenerComponente(Predicate<Componente> criterio){ //Optional es una clase contenedora en Java que puede o no contener un valor no nulo. Se utiliza para evitar valores nulos y posibles excepciones NullPointerException
        //Optional<Componente> significa que el método devolverá un Optional que puede contener un objeto de tipo Componente, o estar vacío si no se encuentra ningún componente que coincida con el criterio.
        //Predicate<Componente> significa que el predicado toma un objeto de tipo Componente como entrada y devuelve true o false.
        for (Componente componente : componentesEnAlmacen) {
            if (criterio.test(componente)) {
                return Optional.of(componente);
            }
        }
        return Optional.empty();
    }

    @Override
    public void actualizarComponente(Componente componenteAntiguo, Componente componenteNuevo)
            throws IdException, MuchoExtracomunitarioException, MangaException, IOException {
        int index = componentesEnAlmacen.indexOf(componenteAntiguo);
        if (index != -1) {
            Componente componenteExistente = componentesEnAlmacen.get(index);
            componenteExistente.setPrecio(componenteNuevo.getPrecio());
            componenteExistente.setColor(componenteNuevo.getColor());
            componenteExistente.setTalla(componenteNuevo.getTalla());
            guardarTodosLosComponentes();
        } else {
            throw new NoSuchElementException("Componente no encontrado.");
        }
    }

    @Override
    public void eliminarComponente(Componente componente) throws IOException {
        componentesEnAlmacen.removeIf(c -> c.equals(componente)); //c es una variable que representa cada elemento de la colección componentesEnAlmacen a medida que se itera sobre ella.
        //c.equals(componente) es la condición del predicado. Aquí, se llama al método equals en c para comprobar si c es igual a componente.
        //Si c.equals(componente) devuelve true, significa que c es igual al objeto componente, y dicho elemento será eliminado de la colección.
        guardarTodosLosComponentes();
    }

    @Override
    public void añadirTrajeAAlmacen() throws ColoresException, TallaException, TrajeYaExisteException, IOException {
        System.out.print("Nombre del traje: ");
        String nombre = scanner.nextLine();

        // Verificar si el traje ya existe
        for (Traje traje : trajesEnAlmacen) { //Esta es la sintaxis específica del bucle for-each
            //Traje : Es el tipo de elementos en la colección trajesEnAlmacen. Esto indica que trajesEnAlmacen es una colección (por ejemplo, una lista o un conjunto) de objetos de tipo Traje.
            //traje: Es el nombre de la variable que se usará dentro del cuerpo del bucle para referirse a cada elemento individual de la colección trajesEnAlmacen. Cada vez que el bucle itera, traje representa el siguiente elemento en la colección.
            // : trajes almacen: es decir para traje : "en" trajesEnAlmacen
            if (traje.getNombre().equalsIgnoreCase(nombre)) {
                throw new TrajeYaExisteException("El traje ya existe en el almacén.");
            }
        }

        System.out.println("Elija una chaqueta:");
        listarComponentesPorTipo("chaqueta");
        Componente chaqueta = seleccionarComponente();

        System.out.println("Elija una blusa:");
        listarComponentesPorTipo("blusa");
        Componente blusa = seleccionarComponente();

        System.out.println("Elija una falda o pantalón:");
        listarComponentesPorTipo("falda", "pantalon");
        Componente faldaPantalon = seleccionarComponente();

        // Validar colores y tallas
        if (!sonColoresCompatibles(chaqueta.getColor(), blusa.getColor(), faldaPantalon.getColor())) {
            throw new ColoresException("Los colores no son compatibles.");
        }
        if (!chaqueta.getTalla().equals(blusa.getTalla()) || !chaqueta.getTalla().equals(faldaPantalon.getTalla())) {
            throw new TallaException("Las tallas no coinciden.");
        }

        // Crear y añadir traje
        Traje traje = new Traje(nombre);
        traje.getPiezas().add(chaqueta);
        traje.getPiezas().add(blusa);
        traje.getPiezas().add(faldaPantalon);
        trajesEnAlmacen.add(traje);

        // Remover componentes usados
        componentesEnAlmacen.remove(chaqueta);
        componentesEnAlmacen.remove(blusa);
        componentesEnAlmacen.remove(faldaPantalon);

        guardarTodosLosComponentes();
        guardarTodosLosTrajes();
    }

    private void listarComponentesPorTipo(String... tipos) {
        for (Componente componente : componentesEnAlmacen) {
            for (String tipo : tipos) {
                if (componente.getNombre().toLowerCase().contains(tipo.toLowerCase())) {
                    System.out.println(componente);
                }
            }
        }
    }

    private Componente seleccionarComponente() {
        System.out.print("Ingrese el ID del componente seleccionado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir nueva línea

        for (Componente componente : componentesEnAlmacen) {
            if (componente.getId() == id) {
                return componente;
            }
        }
        throw new NoSuchElementException("Componente no encontrado.");
    }

    private boolean sonColoresCompatibles(String... colores) {
        String primerColor = colores[0].toLowerCase();
        for (String color : colores) {
            if (!color.toLowerCase().equals(primerColor)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<Traje> listarTrajes() {
        return new ArrayList<>(trajesEnAlmacen);
    }

    @Override
    public Optional<Traje> obtenerTraje(Predicate<Traje> criterio) {
        for (Traje traje : trajesEnAlmacen) {
            if (criterio.test(traje)) {
                return Optional.of(traje);
            }
        }
        return Optional.empty();
    }

    // @Override
    // public void actualizarTraje(Traje trajeAntiguo, Traje trajeNuevo)
    // throws ColoresException, TallaException, TrajeYaExisteException, IOException
    // {
    // eliminarTraje(trajeAntiguo);
    // añadirTrajeAAlmacen();
    // }

    @Override
    public void eliminarTraje(Traje traje) throws IOException {
        trajesEnAlmacen.removeIf(t -> t.equals(traje));
        guardarTodosLosTrajes();
    }

    @Override
    public void activarDesactivarRebajas() throws IOException {
        sonRebajas = !sonRebajas;
        System.out.println("Rebajas activadas: " + sonRebajas); // Debugging info
        for (Componente componente : componentesEnAlmacen) {
            System.out.println("Precio original de " + componente.getNombre() + ": " + componente.getPrecio());
            if (sonRebajas) {
                componente.setPrecio(componente.getPrecio() * 0.9); // 10% de descuento
            } else {
                componente.setPrecio(componente.getPrecio() / 0.9); // Revertir descuento
            }
            System.out.println("Nuevo precio de " + componente.getNombre() + ": " + componente.getPrecio());
        }
        for (Traje traje : trajesEnAlmacen) {
            for (Componente componente : traje.getPiezas()) {
                System.out.println("Precio original de " + componente.getNombre() + " en el traje " + traje.getNombre()
                        + ": " + componente.getPrecio());
                if (sonRebajas) {
                    componente.setPrecio(componente.getPrecio() * 0.9);
                } else {
                    componente.setPrecio(componente.getPrecio() / 0.9);
                }
                System.out.println("Nuevo precio de " + componente.getNombre() + " en el traje " + traje.getNombre()
                        + ": " + componente.getPrecio());
            }
        }
        guardarTodosLosComponentes();
        guardarTodosLosTrajes();
    }

    @Override
    public void crearEnvio() throws IOException {
        List<Traje> envio = new ArrayList<>();

        System.out.println("Crear Envío:");
        listarNombresDeTrajes();

        while (true) {
            System.out.print("Ingrese el nombre del traje a añadir al envío (o 'fin' para terminar): ");
            String nombre = scanner.nextLine();
            if (nombre.equalsIgnoreCase("fin")) {
                break;
            }
            Optional<Traje> traje = obtenerTraje(t -> t.getNombre().equalsIgnoreCase(nombre));
            if (traje.isPresent()) {
                envio.add(traje.get());
                trajesEnAlmacen.remove(traje.get());
            } else {
                System.out.println("Traje no encontrado.");
            }
        }

        // Validar que al menos un traje se incluya en el envío
        if (envio.isEmpty()) {
            System.out.println("Error: No se puede crear un envío sin trajes.");
            return;
        }

        // Agregar el envío a la lista de envíos
        envios.add(envio);

        // Guardar trajes restantes
        guardarTodosLosTrajes();

        System.out.println("Envío creado exitosamente con " + envio.size() + " trajes.");
    }

    @Override
    public void consultarEnvio() {
        if (envios.isEmpty()) {
            System.out.println("No hay envíos creados.");
            return;
        }

        for (int i = 0; i < envios.size(); i++) {
            System.out.println("Envío " + (i + 1) + ":");
            for (Traje traje : envios.get(i)) {
                System.out.println(traje);
            }
        }
    }

    @Override
    public void eliminarTrajeDelAlmacen() throws IOException {
        System.out.println("Eliminar Traje del Almacén:");
        listarNombresDeTrajes();

        System.out.print("Ingrese el nombre del traje a eliminar: ");
        String nombre = scanner.nextLine();

        Optional<Traje> traje = obtenerTraje(t -> t.getNombre().equalsIgnoreCase(nombre));
        if (traje.isPresent()) {
            trajesEnAlmacen.remove(traje.get());
            guardarTodosLosTrajes();
            System.out.println("Traje eliminado exitosamente.");
        } else {
            System.out.println("Traje no encontrado.");
        }
    }

    private void listarNombresDeTrajes() {
        if (trajesEnAlmacen.isEmpty()) {
            System.out.println("No hay trajes en el almacén.");
        } else {
            System.out.println("Trajes disponibles en el almacén:");
            for (Traje traje : trajesEnAlmacen) {
                System.out.println("- " + traje.getNombre());
            }
        }
    }

    private void guardarTodosLosComponentes() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("componentes.dat"))) {
            oos.writeObject(componentesEnAlmacen);
        }
    }

    private void guardarTodosLosTrajes() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("trajes.dat"))) {
            oos.writeObject(trajesEnAlmacen);
        }
    }

    public void escribirMenu() {
        System.out.println("MENU FABRICA TRAJES");
        System.out.println("1.- Añadir Componente a almacén");
        System.out.println("2.- Listar Componentes del almacén");
        System.out.println("3.- Crear traje y añadir al almacén");
        System.out.println("4.- Listar trajes del almacén");
        System.out.println("5.- Actualizar componente");
        System.out.println("6.- Eliminar componente");
        System.out.println("7.- Activar/Desactivar las rebajas");
        System.out.println("8.- Crear envío");
        System.out.println("9.- Crear componentes de prueba");
        System.out.println("10.- Eliminar traje del almacén");
        System.out.println("11.- Consultar envíos");
        System.out.println("12.- Limpiar datos en memoria"); // Nueva opción para limpiar datos
        System.out.println("0.- Salir");
    }

    public void limpiarDatos() {
        componentesEnAlmacen.clear();
        trajesEnAlmacen.clear();
        envios.clear();

        // Eliminar los archivos de datos
        File componentesFile = new File("componentes.dat");
        File trajesFile = new File("trajes.dat");

        if (componentesFile.exists()) {
            componentesFile.delete();
        }
        if (trajesFile.exists()) {
            trajesFile.delete();
        }

        System.out.println("Datos En Memoria limpiados exitosamente.");
    }

    public void crearComponentesDePrueba() {
        try {
            // Limpiar componentes existentes
            componentesEnAlmacen.clear();

            // Crear componentes de prueba
            Componente falda1 = new Falda(1, "Falda", "M", "Blanco", false, 25.0, true);
            Componente falda2 = new Falda(2, "Falda", "L", "Negro", true, 26.0, false);
            Componente pantalon1 = new Pantalon(3, "Pantalón", "M", "Blanco", false, 30.0, true);
            Componente pantalon2 = new Pantalon(4, "Pantalón", "S", "Negro", true, 32.0, false);
            Componente blusa1 = new Blusa(5, "Blusa", "M", "Blanco", false, 20.0, true);
            Componente blusa2 = new Blusa(6, "Blusa", "L", "Blanco", true, 22.0, false);
            Componente chaqueta1 = new Chaqueta(7, "Chaqueta", "M", "Blanco", false, 50.0, 3);
            Componente chaqueta2 = new Chaqueta(8, "Chaqueta", "L", "Negro", true, 55.0, 4);

            // Añadir componentes al almacén
            componentesEnAlmacen.add(falda1);
            componentesEnAlmacen.add(falda2);
            componentesEnAlmacen.add(pantalon1);
            componentesEnAlmacen.add(pantalon2);
            componentesEnAlmacen.add(blusa1);
            componentesEnAlmacen.add(blusa2);
            componentesEnAlmacen.add(chaqueta1);
            componentesEnAlmacen.add(chaqueta2);

            guardarTodosLosComponentes();

            System.out.println("Componentes de prueba creados exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar componentes de prueba: " + e.getMessage());
        }
    }

    public void cerrarScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}