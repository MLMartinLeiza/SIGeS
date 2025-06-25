package siges;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class SIGeS {

    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Servicio> servicios = new ArrayList<>();
    ArrayList<Registro> registros = new ArrayList<>();

    //Metodo Agregar Cliente
    public void agregarCliente(Scanner sc) {
        System.out.println("Ingrese el nombre del cliente");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el DNI");
        String dni = sc.nextLine();

        Cliente c = buscarClientePorDni(dni);
        if (c != null) {
            System.out.println("Ya existe un cliente con ese DNI");
            return;
        } else {
            Cliente cliente = new Cliente(nombre, dni);
            clientes.add(cliente);
            System.out.println("Cliente agregado correctamente!");
        }
    }

    //Metodo Agregar Servicio
    public void agregarServicio(Scanner sc) {
        System.out.println("Ingrese la descripción del servicio:");
        String descripcion = sc.nextLine();
        System.out.println("Ingrese el costo del servicio:");
        double costo = sc.nextDouble();
        sc.nextLine();
        Servicio servicio = new Servicio(descripcion, costo);
        servicios.add(servicio);
        System.out.println("Servicio agregado correctamente");
    }

    //Metodo Registrar Atencion
    public void registrarAtencion(Scanner sc) {
        System.out.println("Ingrese el DNI del cliente:");
        String dni = sc.nextLine();
        Cliente cliente = buscarClientePorDni(dni);
        if (cliente == null) {
            System.out.println("No se encontró el cliente");
            return;
        }

        System.out.println("Ingrese la descripción del servicio:");
        String descripcion = sc.nextLine();
        Servicio servicio = buscarServicioPorDescripcion(descripcion);
        if (servicio == null) {
            System.out.println("No hay servicios con esa descripción");
            return;
        }

        LocalDate fecha = LocalDate.now();
        Registro registro = new Registro(cliente, servicio, fecha);
        registros.add(registro);
        System.out.println("Atención registrada correctamente");

    }

    public Cliente buscarClientePorDni(String dni) {
        for (Cliente c : clientes) {
            if (c.getDni().equalsIgnoreCase(dni)) {
                return c;
            }
        }
        return null;
    }

    public Servicio buscarServicioPorDescripcion(String descripcion) {
        for (Servicio s : servicios) {
            if (s.getDescripcion().toLowerCase().contains(descripcion.toLowerCase())) {
                return s;
            }
        }
        return null;
    }

    public void verHistorialPorCliente(Scanner sc) {
        boolean encontrados = false;
        System.out.println("Ingrese el DNI del cliente:");
        String dni = sc.nextLine();
        for (Registro r : registros) {
            if (r.getCliente().getDni().equals(dni)) {
                encontrados = true;
                System.out.println("Atención: " + r);
            }

        }
        if (!encontrados) {
            System.out.println("No hay atenciones registradas para este cliente");
        }
    }

    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados");
            return;
        }
        for (Cliente c : clientes) {
            System.out.println(c);
        }

    }

    public void listarServicios() {
        if (servicios.isEmpty()) {
            System.out.println("No hay servicios registrados");
            return;
        }
        for (Servicio s : servicios) {
            System.out.println(s);
        }

    }

    public void buscarServPorPalabra(Scanner sc) {
        boolean servicioEncontrado = false;
        System.out.println("Ingrese una palabra para buscar servicio:");
        String palabraServicio = sc.nextLine();
        for (Servicio s : servicios) {
            if (s.getDescripcion().toLowerCase().contains(palabraServicio.toLowerCase())) {
                servicioEncontrado = true;
                System.out.println(s);
            }

        }
        if (!servicioEncontrado) {
            System.out.println("No se encontraron servicios");
        }
    }

    public void eliminarCliente(Scanner sc) {
        Cliente clienteAEliminar = null;
        System.out.println("Ingrese el DNI para eliminar:");
        String dni = sc.nextLine();
        for (Cliente c : clientes) {
            if (c.getDni().equalsIgnoreCase(dni)) {
                clienteAEliminar = c;
            }
        }
        if (clienteAEliminar != null) {
            clientes.remove(clienteAEliminar);
            System.out.println("Cliente eliminado!");
        } else {
            System.out.println("No existe el cliente");
        }

    }

    public void filtrarPorCostoMaximo(Scanner sc) {
        boolean encontrado = false;
        System.out.println("Ingrese el costo del servicio");
        double costo = sc.nextDouble();
        sc.nextLine();
        for (Servicio s : servicios) {
            if (s.getCosto() <= costo) {
                encontrado = true;
                System.out.println(s);
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró costo menor");
        }
    }

    public static void main(String[] args) {
        SIGeS siges = new SIGeS();
        Scanner sc = new Scanner(System.in);

        //Menu principal
        int opcion;
        do {
            System.out.println("\n- - SIGeS Menú Principal - - "
                    + "\n 1. Agregar Cliente"
                    + "\n 2. Agregar Servicio"
                    + "\n 3. Registrar Atención"
                    + "\n 4. Ver Historial por Cliente"
                    + "\n 5. Listar Clientes"
                    + "\n 6. Listar Servicios"
                    + "\n 7. Buscar Servicios"
                    + "\n 8. Eliminar Cliente"
                    + "\n 9. Filtrar por costo máximo"
                    + "\n 0. Salir"
                    + "\n Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    siges.agregarCliente(sc);
                    break;
                case 2:
                    siges.agregarServicio(sc);
                    break;
                case 3:
                    siges.registrarAtencion(sc);
                    break;
                case 4:
                    siges.verHistorialPorCliente(sc);
                    break;
                case 5:
                    siges.listarClientes();
                    break;
                case 6:
                    siges.listarServicios();
                    break;
                case 7:
                    siges.buscarServPorPalabra(sc);
                    break;
                case 8:
                    siges.eliminarCliente(sc);
                    break;
                case 9:
                    siges.filtrarPorCostoMaximo(sc);
                    break;
                case 0:
                    System.out.println("Saliendo, que tenga buen dia...");
                    break;
                default:
                    System.out.println("Opción inexistente");
            }

        } while (opcion != 0);

    }

}
