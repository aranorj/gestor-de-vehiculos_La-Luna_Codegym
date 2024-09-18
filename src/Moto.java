import java.util.Scanner;

public class Moto extends Vehiculo {
    private int cilindrada;
    private String tipoFrenos;

    public Moto(String marca, String modelo, int año, String color, int cilindrada, String tipoFrenos) {
        super(marca, modelo, año, color);
        this.cilindrada = cilindrada;
        this.tipoFrenos = tipoFrenos;
    }

    @Override
    public String detalles() {
        return "Moto: " + getMarca() + " " + getModelo() + ", Año: " + getAño() + ", Color: " + getColor() +
                ", Cilindrada: " + cilindrada + "cc, Frenos: " + tipoFrenos;
    }

    public static Moto crearDesdeConsola() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Marca: ");
        String marca = scanner.next();
        System.out.print("Modelo: ");
        String modelo = scanner.next();
        System.out.print("Año: ");
        int año = scanner.nextInt();
        System.out.print("Color: ");
        String color = scanner.next();
        System.out.print("Cilindrada (cc): ");
        int cilindrada = scanner.nextInt();
        System.out.print("Tipo de frenos: ");
        String frenos = scanner.next();

        return new Moto(marca, modelo, año, color, cilindrada, frenos);
    }

    @Override
    public TipoVehiculo getTipoVehiculo() {
        return  TipoVehiculo.MOTO;
    }
}
