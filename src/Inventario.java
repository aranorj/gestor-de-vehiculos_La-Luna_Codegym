import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Inventario {
    private List<Vehiculo> vehiculos = new ArrayList<>();

    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    public Vehiculo buscarVehiculo(String modelo) {
        return vehiculos.stream()
                .filter(v -> v.getModelo().equalsIgnoreCase(modelo))
                .findFirst()
                .orElse(null);
    }

    public void filtrarPorTipo(TipoVehiculo tipo) {
        List<Vehiculo> vehiculosFiltrados = vehiculos.stream()
                .filter(vehiculo -> vehiculo.getTipoVehiculo() == tipo)
                .collect(Collectors.toList());

        if (vehiculosFiltrados.isEmpty()) {
            System.out.println("No hay vehículos de este tipo.");
        } else {
            vehiculosFiltrados.forEach(vehiculo -> System.out.println(vehiculo.detalles()));
        }
    }

    public List<Vehiculo> filtrarPorMarca(String marca) {
        List<Vehiculo> resultado = new ArrayList<>();
        for (Vehiculo v : vehiculos) {
            if (v.getMarca().equalsIgnoreCase(marca)) {
                resultado.add(v);
            }
        }
        return resultado;
    }

    public double calcularValorTotal() {
        return vehiculos.size() * 10000;
        //TODO: Hacer un calculo del precio.... como podria resolverlo?
    }

    public void mostrarInventario() {
        for (Vehiculo v : vehiculos) {
            System.out.println(v.detalles());
        }
    }
}