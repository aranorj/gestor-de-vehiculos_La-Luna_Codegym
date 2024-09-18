public abstract class Vehiculo {
    private String marca;
    private String modelo;
    private int año;
    private String color;

    public Vehiculo(String marca, String modelo, int año, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.color = color;
    }

    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAño() { return año; }
    public String getColor() { return color; }

    public abstract String detalles();

    public abstract TipoVehiculo getTipoVehiculo();

}