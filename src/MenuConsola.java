import java.util.Scanner;

public class MenuConsola {

    private Inventario inventario;
    private Scanner scanner;

    public MenuConsola() {
        this.inventario = new Inventario();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            int opcion = leerOpcion();
            switch (opcion) {
                case 1:
                    agregarVehiculo();
                    break;
                case 2:
                    eliminarVehiculo();
                    break;
                case 3:
                    buscarVehiculo();
                    break;
                case 4:
                    mostrarInventario();
                    break;
                case 5:
                    filtrarVehiculos();
                    break;
                case 6:
                    calcularValorTotal();
                    break;
                case 7:
                    salir = true;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("\n--- Menú de Gestión de Vehículos ---");
        System.out.println("1. Agregar vehículo");
        System.out.println("2. Eliminar vehículo");
        System.out.println("3. Buscar vehículo");
        System.out.println("4. Mostrar inventario completo");
        System.out.println("5. Filtrar vehículos");
        System.out.println("6. Calcular valor total de vehículos");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private int leerOpcion() {
        return scanner.nextInt();
    }

    private void agregarVehiculo() {
        System.out.println("Seleccione el tipo de vehículo:");
        System.out.println("1. Coche");
        System.out.println("2. Moto");
        System.out.println("3. Camión");
        int tipo = scanner.nextInt();

        Vehiculo vehiculo;
        switch (tipo) {
            case 1:
                vehiculo = Coche.crearDesdeConsola();
                break;
            case 2:
                vehiculo = Moto.crearDesdeConsola();
                break;
            case 3:
                vehiculo = Camion.crearDesdeConsola();
                break;
            default:
                System.out.println("Tipo de vehículo no válido.");
                return;
        }
        inventario.agregarVehiculo(vehiculo);
        System.out.println("Vehículo agregado exitosamente.");
    }

    private void eliminarVehiculo() {
        System.out.print("Ingrese el modelo del vehículo a eliminar: ");
        String modelo = scanner.next();
        Vehiculo vehiculo = inventario.buscarVehiculo(modelo);
        if (vehiculo != null) {
            inventario.eliminarVehiculo(vehiculo);
            System.out.println("Vehículo eliminado.");
        } else {
            //TODO: Oigan! Agregar excepciones
            System.out.println("Vehículo no encontrado.");
        }
    }

    private void buscarVehiculo() {
        System.out.print("Ingrese el modelo del vehículo a buscar: ");
        String modelo = scanner.next();
        Vehiculo vehiculo = inventario.buscarVehiculo(modelo);
        if (vehiculo != null) {
            System.out.println("Detalles del vehículo:");
            System.out.println(vehiculo.detalles());
        } else {
            System.out.println("Vehículo no encontrado.");
        }
    }

    private void mostrarInventario() {
        System.out.println("Inventario completo:");
        inventario.mostrarInventario();
    }

    private void filtrarVehiculos() {
        System.out.println("Seleccione el criterio de filtrado:");
        System.out.println("1. Por tipo de vehículo");
        System.out.println("2. Por marca");
        int criterio = scanner.nextInt();

        switch (criterio) {
            case 1:
                System.out.println("Seleccione el tipo de vehículo:");
                System.out.println("1. Coche");
                System.out.println("2. Moto");
                System.out.println("3. Camión");
                int tipo = scanner.nextInt();
                inventario.filtrarPorTipo(TipoVehiculo.obtenerTipoDesdeInt(tipo));
                break;
            case 2:
                System.out.print("Ingrese la marca: ");
                String marca = scanner.next();
                inventario.filtrarPorMarca(marca);
                break;
            default:
                System.out.println("Criterio de filtrado no válido.");
        }
    }

    private void calcularValorTotal() {
        double valorTotal = inventario.calcularValorTotal();
        System.out.println("El valor total de los vehículos es: " + valorTotal);
    }
}
