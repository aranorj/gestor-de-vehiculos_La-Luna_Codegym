import java.util.Scanner;

public class Camion extends Vehiculo {
    private double capacidadCarga;
    private String tipoCarroceria;

    public Camion(String marca, String modelo, int año, String color, double capacidadCarga, String tipoCarroceria) {
        super(marca, modelo, año, color);
        this.capacidadCarga = capacidadCarga;
        this.tipoCarroceria = tipoCarroceria;
    }

    @Override
    public String detalles() {
        return "Camión: " + getMarca() + " " + getModelo() + ", Año: " + getAño() + ", Color: " + getColor() +
                ", Carga: " + capacidadCarga + " toneladas, Carrocería: " + tipoCarroceria;
    }

    // Método estático para crear un camión
    public static Camion crearDesdeConsola() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Marca: ");
        String marca = scanner.next();
        System.out.print("Modelo: ");
        String modelo = scanner.next();
        System.out.print("Año: ");
        int año = scanner.nextInt();
        System.out.print("Color: ");
        String color = scanner.next();
        System.out.print("Capacidad de carga (toneladas): ");
        double capacidadCarga = scanner.nextDouble();
        System.out.print("Tipo de carrocería: ");
        String carroceria = scanner.next();

        return new Camion(marca, modelo, año, color, capacidadCarga, carroceria);
    }

    @Override
    public TipoVehiculo getTipoVehiculo() {
        return  TipoVehiculo.CAMION;
    }
}