import java.util.Scanner;

public class Coche extends Vehiculo {
    private int numPuertas;
    private String transmision;

    public Coche(String marca, String modelo, int año, String color, int numPuertas, String transmision) {
        super(marca, modelo, año, color);
        this.numPuertas = numPuertas;
        this.transmision = transmision;
    }

    @Override
    public String detalles() {
        return "Coche: " + getMarca() + " " + getModelo() + ", Año: " + getAño() + ", Color: " + getColor() +
                ", Puertas: " + numPuertas + ", Transmisión: " + transmision;
    }

    public static Coche crearDesdeConsola() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Marca: ");
        String marca = scanner.next();
        System.out.print("Modelo: ");
        String modelo = scanner.next();
        System.out.print("Año: ");
        int año = scanner.nextInt();
        System.out.print("Color: ");
        String color = scanner.next();
        System.out.print("Número de puertas: ");
        int puertas = scanner.nextInt();
        System.out.print("Tipo de transmisión: ");
        String transmision = scanner.next();

        return new Coche(marca, modelo, año, color, puertas, transmision);
    }

    @Override
    public TipoVehiculo getTipoVehiculo() {
        return  TipoVehiculo.COCHE;
    }
}
